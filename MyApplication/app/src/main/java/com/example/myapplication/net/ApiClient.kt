package com.example.myapplication.net

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit


class ApiClient {
    //https://itunes.apple.com/search?term=歌&limit=200&country=HK
    private var BASE_URL = "https://itunes.apple.com/"
    private val DEFAULT_TIMEOUT: Long = 30

    private var retrofit: Retrofit? = null
    init {
        val client = OkHttpClient.Builder()
                .retryOnConnectionFailure(true)
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .build()
        retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build()
    }

    fun getApiService(): IRequest? {
        return retrofit!!.create(IRequest::class.java)
    }
}