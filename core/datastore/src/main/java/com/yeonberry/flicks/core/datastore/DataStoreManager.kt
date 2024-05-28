package com.yeonberry.flicks.core.datastore

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.yeonberry.flicks.core.datastore.DataStoreManager.PreferencesKeys.FAVORITES
import com.yeonberry.flicks.core.model.Movie
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "favorites")

class DataStoreManager @Inject constructor(@ApplicationContext private val context: Context) {
    private object PreferencesKeys {
        val FAVORITES = stringPreferencesKey("favorites")
    }

    val favorites: Flow<List<Movie>> = context.dataStore.data
        .map { preferences ->
            val gson = Gson()
            val typeToken = object : TypeToken<List<Movie>>() {}.type
            gson.fromJson(preferences[FAVORITES], typeToken)
        }

    suspend fun updateFavorites(favorites: List<Movie>) {
        context.dataStore.edit {
            val gson = Gson()
            val json = gson.toJson(favorites)

            it[FAVORITES] = json
        }
    }
}