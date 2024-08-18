package com.trifcdr.storage

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.trifcdr.storage.model.UserData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

/**
 * Created by trifcdr.
 */

private val Context.dataStore by preferencesDataStore("app_preferences")

class AppStorageImpl(context: Context) : AppStorage {

    private val dataStore = context.dataStore

    override suspend fun saveTokens(accessToken: String, refreshToken: String): Boolean {
        val accessTokenKey = stringPreferencesKey(ACCESS_TOKEN)
        val refreshTokenKey = stringPreferencesKey(REFRESH_TOKEN)
        CoroutineScope(Dispatchers.IO).launch {
            dataStore.edit { settings ->
                settings[accessTokenKey] = "Bearer $accessToken"
                settings[refreshTokenKey] = refreshToken
            }
        }.join()
        return true
    }

    override suspend fun getAccessToken(): String {
        var res: String? = null
        CoroutineScope(Dispatchers.IO).launch {
            val accessTokenKey = stringPreferencesKey(ACCESS_TOKEN)
            val prefs = dataStore.data.first()
            res = prefs[accessTokenKey] ?: return@launch
        }.join()
        return res ?: DEFAULT_TOKEN_VALUE
    }

    override suspend fun getRefreshToken(): String {
        var res: String? = null
        CoroutineScope(Dispatchers.IO).launch {
            val refreshTokenKey = stringPreferencesKey(REFRESH_TOKEN)
            val prefs = dataStore.data.first()
            res = prefs[refreshTokenKey] ?: return@launch
        }.join()
        return res ?: DEFAULT_TOKEN_VALUE
    }

    override suspend fun saveUserData(data: UserData): Boolean {
        CoroutineScope(Dispatchers.IO).launch {
            val isAuthorizedKey = stringPreferencesKey(IS_AUTHORIZED)
            val idKey = stringPreferencesKey(ID)
            val nameKey = stringPreferencesKey(NAME)
            val phoneKey = stringPreferencesKey(PHONE)
            val usernameKey = stringPreferencesKey(USERNAME)
            val city = stringPreferencesKey(CITY)
            val birthday = stringPreferencesKey(BIRTHDAY)
            val vk = stringPreferencesKey(VK)
            val inst = stringPreferencesKey(INSTAGRAM)
            val status = stringPreferencesKey(STATUS)
            val avatar = stringPreferencesKey(AVATAR)
            dataStore.edit { settings ->
                if (data.id != null) {
                    settings[idKey] = data.id.toString()
                }
                if (data.name != null)
                    settings[nameKey] = data.name
                if (data.username != null)
                    settings[usernameKey] = data.username
                if (data.phone != null)
                    settings[phoneKey] = data.phone
                if (data.city != null)
                    settings[city] = data.city
                if (data.birthday != null)
                    settings[birthday] = data.birthday
                if (data.vk != null)
                    settings[vk] = data.vk
                if (data.instagram != null)
                    settings[inst] = data.instagram
                if (data.status != null)
                    settings[status] = data.status
                if (data.avatar != null)
                    settings[avatar] = data.avatar
                settings[isAuthorizedKey] = "true"
            }
        }.join()
        return true
    }

    override suspend fun getUserData(): UserData {
        var res: UserData? = null
        CoroutineScope(Dispatchers.IO).launch {
            val id = stringPreferencesKey(ID)
            val name = stringPreferencesKey(NAME)
            val username = stringPreferencesKey(USERNAME)
            val phone = stringPreferencesKey(PHONE)
            val city = stringPreferencesKey(CITY)
            val birthday = stringPreferencesKey(BIRTHDAY)
            val vk = stringPreferencesKey(VK)
            val inst = stringPreferencesKey(INSTAGRAM)
            val status = stringPreferencesKey(STATUS)
            val avatar = stringPreferencesKey(AVATAR)
            val prefs = dataStore.data.first()
            res = UserData(
                id = prefs[id]!!.toLong(),
                name = prefs[name] ?: "",
                username = prefs[username] ?: "",
                phone = prefs[phone] ?: "",
                city = prefs[city] ?: "",
                birthday = prefs[birthday] ?: "",
                vk = prefs[vk] ?: "",
                instagram = prefs[inst] ?: "",
                status = prefs[status] ?: "",
                avatar = prefs[avatar] ?: "",

                )
        }.join()
        return res!!
    }

    override suspend fun isAuthorized(): Boolean {
        var res = false
        CoroutineScope(Dispatchers.IO).launch {
            val isAuthorizedKey = stringPreferencesKey(IS_AUTHORIZED)
            val prefs = dataStore.data.first()
            res = prefs[isAuthorizedKey].toBoolean()
        }.join()
        return res
    }


    companion object {
        private const val IS_AUTHORIZED = "is_authorized"
        private const val ACCESS_TOKEN = "access_token"
        private const val REFRESH_TOKEN = "refresh_token"
        private const val DEFAULT_TOKEN_VALUE = "empty"
        private const val DEFAULT_AUTH_VALUE = false
        private const val ID = "id"
        private const val NAME = "name"
        private const val PHONE = "phone"
        private const val USERNAME = "username"
        private const val CITY = "city"
        private const val BIRTHDAY = "birthday"
        private const val VK = "vk"
        private const val INSTAGRAM = "instagram"
        private const val STATUS = "status"
        private const val AVATAR = "avatar"
    }
}