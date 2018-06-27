package com.kotlin.invictus.daggerkotlin.di.modules

import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import com.google.gson.Gson
import javax.inject.Singleton
import dagger.Provides
import io.reactivex.schedulers.Schedulers
import okhttp3.logging.HttpLoggingInterceptor
import android.app.Application
import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.kotlin.invictus.daggerkotlin.BuildConfig
import com.kotlin.invictus.daggerkotlin.api.AuthInterceptor
import com.kotlin.invictus.daggerkotlin.utils.AppConstants
import com.kotlin.invictus.daggerkotlin.utils.AppConstants.Companion.CONNECT_TIMEOUT
import com.kotlin.invictus.daggerkotlin.utils.SessionManager
import dagger.Module
import okhttp3.Cache
import okhttp3.Interceptor
import java.util.concurrent.TimeUnit


@Module
class NetworkModule {

    @Provides
    @Singleton
    internal fun providesGson(): Gson {
        val gsonBuilder = GsonBuilder()
        gsonBuilder.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
        return gsonBuilder.create()
    }

    @Provides
    @Singleton
    internal fun providesInterceptor(manager: SessionManager): Interceptor {
        return AuthInterceptor(manager)
    }

    @Provides
    @Singleton
    internal fun providesHttpCache(application: Application): Cache {
        /**
         * Cache size
         */
        val cacheSize: Long = 10 * 1024 * 1024
        return Cache(application.cacheDir, cacheSize)
    }


    @Provides
    @Singleton
    internal fun provideOkHttpInterceptors(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE)
    }

    /**
     * Configure OkHttpClient. This helps us override some of the default configuration. Like the
     * connection timeout.
     *
     * @return OkHttpClient
     */
    @Provides
    @Singleton
    internal fun okHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor,
                              interceptor: Interceptor, cache: Cache): OkHttpClient {

        return OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(AppConstants.CONNECT_TIMEOUT.toLong(), TimeUnit.SECONDS)
                .writeTimeout(AppConstants.WRITE_TIMEOUT, TimeUnit.SECONDS)
                .readTimeout(AppConstants.READ_TIMEOUT, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .cache(cache)
                .build()
    }

    @Provides
    @Singleton
    internal fun providesRxJava2CallAdapterFactory(): RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io())
    }

    @Provides
    @Singleton
    internal fun providesRetrofit(gson: Gson, okHttpClient: OkHttpClient, rxJava2CallAdapterFactory: RxJava2CallAdapterFactory): Retrofit {
        val retrofit = Retrofit.Builder()
        return retrofit.baseUrl(AppConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .client(okHttpClient)
                .build()
    }
}