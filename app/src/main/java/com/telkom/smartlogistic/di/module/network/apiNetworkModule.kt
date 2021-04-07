package com.telkom.smartlogistic.di.module.network

import android.annotation.SuppressLint
import com.ashokvarma.gander.GanderInterceptor
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.telkom.smartlogistic.framework.util.helper.Common
import com.telkom.smartlogistic.BuildConfig
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by Isnaeni on 30/03/2021.
 */
@SuppressLint("LogNotTimber")
val apiNetworkModule = module {

    single<Interceptor>(named("InterceptorSetkab")) {
        HttpLoggingInterceptor().also { interceptor ->
            interceptor.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
            else HttpLoggingInterceptor.Level.NONE
        }
    }

    // comment gander interceptor first before start the unit test of api
    factory(named("OkhttpclientSmartLogistic")) {
        OkHttpClient.Builder().apply {
            HttpLoggingInterceptor().also { interceptor ->
                interceptor.level = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY
                else HttpLoggingInterceptor.Level.NONE
                addInterceptor(interceptor)
            }
            addInterceptor(GanderInterceptor(androidContext()).showNotification(true))
            addInterceptor(
                Common.getInterceptorWithHeader(
                        "Content-Type",
                        BuildConfig.CONTENT_TYPE
                )
            )
            connectTimeout(30, TimeUnit.SECONDS)
            readTimeout(30, TimeUnit.SECONDS)
            writeTimeout(30, TimeUnit.SECONDS)
        }.build()
    }

    single<Retrofit>(named("RetrofitSmartLogistic")) {
        Retrofit.Builder().apply {
            client(get(named("OkhttpclientSmartLogistic")))
            baseUrl(BuildConfig.API_BASE_URL)
            addConverterFactory(MoshiConverterFactory.create())
            addCallAdapterFactory(CoroutineCallAdapterFactory())
        }.build()
    }
}