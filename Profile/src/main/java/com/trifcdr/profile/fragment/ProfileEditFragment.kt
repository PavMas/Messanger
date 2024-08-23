package com.trifcdr.profile.fragment

import android.Manifest
import android.app.Activity
import android.app.AlertDialog
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.graphics.ImageDecoder
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.os.Environment
import android.os.Parcelable
import android.provider.MediaStore.Images.Media
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.datepicker.MaterialDatePicker
import com.trifcdr.domain.models.Avatar
import com.trifcdr.domain.models.DomainResource
import com.trifcdr.domain.models.ProfileDataRequest
import com.trifcdr.navigationapi.NavigationApi
import com.trifcdr.profile.R
import com.trifcdr.profile.databinding.FragmentEditProfileBinding
import com.trifcdr.profile.di.ProfileComponentHolder
import com.trifcdr.profile.navigation.ProfileDirections
import com.trifcdr.profile.navigation.ProfileEditArgs
import com.trifcdr.profile.viewmodel.ProfileViewModel
import com.trifcdr.profile.viewmodel.ProfileViewModuleFactory
import java.io.ByteArrayOutputStream
import java.text.SimpleDateFormat
import java.util.Base64
import java.util.Calendar
import java.util.Locale
import java.util.TimeZone
import javax.inject.Inject


/**
 * Created by trifcdr.
 */
class ProfileEditFragment : Fragment() {

    private lateinit var binding: FragmentEditProfileBinding

    private lateinit var uploadAvatar: Button
    private lateinit var save: Button

    private lateinit var name: EditText
    private lateinit var username: EditText
    private lateinit var phone: EditText
    private lateinit var birthday: EditText
    private lateinit var city: EditText
    private lateinit var vk: EditText
    private lateinit var instagram: EditText
    private lateinit var status: EditText


    private lateinit var avatar: ImageView

    private var base64: String = ""


    @Inject
    lateinit var profileViewModelFactory: ProfileViewModuleFactory

    @Inject
    lateinit var navigationApi: NavigationApi<ProfileDirections>

    private lateinit var viewModel: ProfileViewModel

    private val args by getArgs<ProfileEditArgs>()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentEditProfileBinding.inflate(layoutInflater, container, false)
        init()
        setData()
        setClickListeners()
        setUpdateProfileDataObserver()
        return binding.root
    }

    private fun setData() {
        if (args.avatar != "") {
            val decoded = Base64.getDecoder().decode(args.avatar)
            val bitmap = BitmapFactory.decodeByteArray(decoded, 0, decoded.size)
            avatar.setImageBitmap(bitmap)
        }
        name.setText(args.name)
        username.setText(args.username)
        phone.setText(buildString {
            append("+")
            append(args.phone)
        })
        city.setText(args.city)
        vk.setText(args.vk)
        instagram.setText(args.instagram)
        birthday.setText(args.birthday)
        status.setText(args.status)
    }

    private fun setUpdateProfileDataObserver() {
        viewModel.resultUpdateUserData.observe(viewLifecycleOwner) { result ->
            binding.progressIndicator.visibility = View.GONE
            if (result is DomainResource.Success) {
                navigationApi.navigate(ProfileDirections.ToProfile)
            }
            else{
                Toast.makeText(context, getString(R.string.error), Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun setClickListeners() {
        uploadAvatar.setOnClickListener {
            showImagePicDialog()
        }
        birthday.setOnClickListener {
            val materialDatePickerBuilder: MaterialDatePicker.Builder<*> =
                MaterialDatePicker.Builder
                    .datePicker()
                    .setTitleText(getString(R.string.select_birthday_date))
            val materialDatePicker = materialDatePickerBuilder.build()
            materialDatePicker.show(childFragmentManager, "MATERIAL_DATE_PICKER")
            materialDatePicker.addOnPositiveButtonClickListener {
                val utc = Calendar.getInstance(TimeZone.getTimeZone("UTC"))
                utc.timeInMillis = materialDatePicker.selection as Long
                val format = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                birthday.setText(format.format(utc.time))
            }
        }
        save.setOnClickListener {
            binding.progressIndicator.visibility = View.VISIBLE
            var avatar: Avatar? = null
            if (base64 != ""){
                avatar = Avatar(
                    fileName = "${username.text} Avatar",
                    base64
                )
            }
            if(birthday.text.toString() == ""){
                birthday.error = getString(R.string.field_necessarily)
            }
            else {
                viewModel.updateUserData(
                    ProfileDataRequest(
                        name = name.text.toString(),
                        username = username.text.toString(),
                        birthday = birthday.text.toString(),
                        city = city.text.toString(),
                        vk = vk.text.toString(),
                        instagram = instagram.text.toString(),
                        status = status.text.toString(),
                        avatar = avatar
                    )
                )
            }
        }
    }

    private fun showImagePicDialog() {
        val options = arrayOf(
            getString(R.string.take_photo),
            getString(R.string.upload_from_gallery)
        )
        val builder = AlertDialog.Builder(requireActivity())
        builder.setTitle(getString(R.string.upload_from))
        builder.setItems(options) { dialog, which ->
            if (which == 0) {
                if (!checkCameraPermission()) {
                    // requestCameraPermission()
                } else {
                    openGallery()
                }
            } else if (which == 1) {
                if (checkStorageWritePermission() && checkStorageReadPermission()) {
                    requestStoragePermission()
                } else {
                    openGallery()
                }
            }
        }
        builder.create().show()
    }

    private val galleryActivityResultLauncher = registerForActivityResult(
        ActivityResultContracts.StartActivityForResult()
    ) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data = result.data?.data
            if (Build.VERSION.SDK_INT < 28) {

            } else {
                val source = ImageDecoder.createSource(requireActivity().contentResolver, data!!)
                val bitmap = ImageDecoder.decodeBitmap(source) { decoder, _, _ ->
                    decoder.setTargetSampleSize(1)
                    decoder.isMutableRequired = true
                }
                avatar.setImageBitmap(bitmap)
                base64 = convert(bitmap)
            }
        }
    }

    private fun convert(bitmap: Bitmap): String {
        val outputStream = ByteArrayOutputStream()
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, outputStream)
        return Base64.getEncoder().encodeToString(outputStream.toByteArray())
    }


    private val storageReadActivityResultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                if (checkStorageWritePermission() && checkStorageReadPermission()) {
                    openGallery()
                } else {
                    Toast.makeText(context, getString(R.string.storage_denied), Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }
    private val storageWriteActivityResultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
                if (checkStorageWritePermission()) {
                    val intent = Intent()
                    intent.action = Manifest.permission.READ_EXTERNAL_STORAGE
                    val uri = Uri.fromParts("package", requireActivity().packageName, null)
                    intent.data = uri
                    storageReadActivityResultLauncher.launch(intent)
                } else {
                    Toast.makeText(context, getString(R.string.storage_denied), Toast.LENGTH_SHORT)
                        .show()
                }
            }
        }

    private fun checkStorageReadPermission(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            Environment.isExternalStorageManager()
        } else {
            val read = ContextCompat.checkSelfPermission(
                requireActivity(),
                Manifest.permission.READ_EXTERNAL_STORAGE
            )
            read == PackageManager.PERMISSION_GRANTED
        }
    }

    private fun checkStorageWritePermission(): Boolean {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            Environment.isExternalStorageManager()
        } else {
            val write = ContextCompat.checkSelfPermission(
                requireActivity(),
                Manifest.permission.WRITE_EXTERNAL_STORAGE
            )
            write == PackageManager.PERMISSION_GRANTED
        }
    }

    private fun checkCameraPermission(): Boolean {
        val camera = ContextCompat.checkSelfPermission(
            requireActivity(),
            Manifest.permission.CAMERA
        ) == (PackageManager.PERMISSION_GRANTED)
        val write = ContextCompat.checkSelfPermission(
            requireActivity(),
            Manifest.permission.WRITE_EXTERNAL_STORAGE
        ) == (PackageManager.PERMISSION_GRANTED)
        return camera && write
    }


    private fun requestStoragePermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
            val intent = Intent()
            intent.action = Manifest.permission.WRITE_EXTERNAL_STORAGE
            val uri = Uri.fromParts("package", requireActivity().packageName, null)
            intent.data = uri
//                intent.action = Manifest.permission.READ_EXTERNAL_STORAGE
            storageWriteActivityResultLauncher.launch(intent)
        } else {
            ActivityCompat.requestPermissions(
                requireActivity(),
                arrayOf(
                    Manifest.permission.WRITE_EXTERNAL_STORAGE,
                    Manifest.permission.READ_EXTERNAL_STORAGE
                ),
                STORAGE_PERMISSION_CODE
            )
        }
    }

    private fun openGallery() {
        galleryActivityResultLauncher.launch(
            Intent(Intent.ACTION_PICK, Media.INTERNAL_CONTENT_URI)
        )
    }

    private fun init() {
        viewModel = ViewModelProvider(this, profileViewModelFactory)[ProfileViewModel::class]
        uploadAvatar = binding.uploadAvatar
        save = binding.save
        name = binding.name
        username = binding.username
        phone = binding.phone
        city = binding.city
        birthday = binding.birthday
        status = binding.status
        vk = binding.vk
        instagram = binding.inst
        avatar = binding.avatar
    }


    override fun onAttach(context: Context) {
        ProfileComponentHolder.get()
            .inject(this)
        super.onAttach(context)
    }

    override fun onDetach() {
        if (isRemoving) {
            ProfileComponentHolder.clear()
        }
        super.onDetach()
    }


    private companion object {
        private const val STORAGE_PERMISSION_CODE = 100
        private const val ARGS_KEY = "profileData"

        private val noArgsException: IllegalArgumentException
            get() = IllegalArgumentException("No args provided")

        private val invalidArgsException: IllegalArgumentException
            get() = IllegalArgumentException("Invalid args")

        private fun <ARGS : Parcelable> Fragment.getArgs(): Lazy<ARGS> = lazy {
            (arguments?.takeIf { args -> !args.isEmpty } ?: throw noArgsException)
                .getParcelable<ARGS>(ARGS_KEY)
                ?: throw invalidArgsException
        }
    }
}