package com.trifcdr.storage

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
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
                settings[accessTokenKey] = accessToken
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


    companion object {
        private const val ACCESS_TOKEN = "access_token"
        private const val REFRESH_TOKEN = "refresh_token"
        private const val DEFAULT_TOKEN_VALUE = "empty"
    }
}