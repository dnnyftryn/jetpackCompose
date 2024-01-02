package com.example.jetpackcompose.di

import com.example.jetpackcompose.data.Constants
import com.example.jetpackcompose.data.RequestAPI
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideApi(builder: Retrofit.Builder) : RequestAPI {
        return builder
            .build()
            .create(RequestAPI::class.java)
    }

    /**
     * Create retrofit object
     */

    @Provides
    @Singleton
    fun provideRetrofit() : Retrofit.Builder {
        return Retrofit.Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
    }
}