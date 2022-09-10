package br.com.dionataferraz.vendas.login.data.remote

import br.com.dionataferraz.vendas.BuildConfig
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit


object RetrofitNetWorkClient {

    fun createNetworkClient(baseUrl: String = BuildConfig.HTTP_SERVER): Retrofit {
        return retrofitClient(
            baseUrl = baseUrl,
            httpClient = httpClient(),
            moshiConverter = moshi()
        )
    }

    private fun moshi(): MoshiConverterFactory {
        return MoshiConverterFactory.create(
            Moshi
                .Builder()
                .add(KotlinJsonAdapterFactory())
                .build()
        )
    }

    private fun httpClient(): OkHttpClient {
        val DURATION = 60L

        return OkHttpClient.Builder()
            .addInterceptor(logginInterceptor())
            .connectTimeout(DURATION, TimeUnit.SECONDS)
            .readTimeout(DURATION, TimeUnit.SECONDS)
            .writeTimeout(DURATION, TimeUnit.SECONDS)
            .build()
    }

    private fun logginInterceptor() =
        HttpLoggingInterceptor().apply {
            level = if (BuildConfig.DEBUG) {
                HttpLoggingInterceptor.Level.BODY
            } else {
                HttpLoggingInterceptor.Level.NONE
            }
        }

    private fun retrofitClient(
        baseUrl: String,
        httpClient: OkHttpClient,
        moshiConverter: MoshiConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .client(httpClient)
            .addConverterFactory(moshiConverter)
            .build()
    }
}