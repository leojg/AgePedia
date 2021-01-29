package me.lgcode.agepedia.di

import android.content.Context
import androidx.room.Room
import com.squareup.picasso.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import me.lgcode.agepedia.repository.CivRepository
import me.lgcode.agepedia.repository.local.AgeDatabase
import me.lgcode.agepedia.repository.local.CivDao
import me.lgcode.agepedia.repository.remote.AgeService
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideOkHTTPClient() =
        OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().apply {
            setLevel(HttpLoggingInterceptor.Level.BODY)
        }).build()

    @Singleton
    @Provides
    fun provideRetrofit(okHttpClient: OkHttpClient) = Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .baseUrl("https://age-of-empires-2-api.herokuapp.com/api/v1/")
        .client(okHttpClient)
        .build()

    @Provides
    @Singleton
    fun provideDB(@ApplicationContext context: Context) =
        Room.databaseBuilder(context, AgeDatabase::class.java, "ageDB").build()

    @Provides
    @Singleton
    fun provideCivDao(ageDatabase: AgeDatabase) = ageDatabase.civDao()

    @Provides
    @Singleton
    fun provideAgeService(retrofit: Retrofit) = retrofit.create(AgeService::class.java)

    @Provides
    @Singleton
    fun provideCivRepository(civDao: CivDao, ageService: AgeService) = CivRepository(civDao, ageService)


}