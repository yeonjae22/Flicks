package com.yeonberry.flicks.data.di

import com.yeonberry.flicks.data.api.SearchService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
internal object NetworkModule {

    @Provides
    @Singleton
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.themoviedb.org/3/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(provideOkHttpClient(AppInterceptor(), httpLoggingInterceptor))
            .build()
    }

    private fun provideOkHttpClient(vararg interceptor: Interceptor): OkHttpClient =
        OkHttpClient.Builder().run {
            interceptor.forEach { addInterceptor(it) }
            build()
        }

    class AppInterceptor : Interceptor {
        override fun intercept(chain: Interceptor.Chain): Response = with(chain) {
            val newRequest = request().newBuilder()
                .addHeader(
                    "Authorization",
                    "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJlYmVlZjFhYzg5NzVjOGYyZDk2ZTE0YWUzNWM0MDAwOCIsInN1YiI6IjY2MjE2YzI4Nzg1NzBlMDE3ZTEwOGNlMSIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.RVEGiZYoRH2gDvLS33dUnUEMo7przvamLp1u2Eh-vso"
                )
                .build()
            proceed(newRequest)
        }
    }

    private val httpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level = HttpLoggingInterceptor.Level.BODY
    }

    @Provides
    @Singleton
    fun provideSearchService(retrofit: Retrofit): SearchService {
        return retrofit.create(SearchService::class.java)
    }
}