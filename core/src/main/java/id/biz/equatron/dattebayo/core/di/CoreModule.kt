package id.biz.equatron.dattebayo.core.di

import androidx.room.Room
import id.biz.equatron.dattebayo.core.data.CharacterRepository
import id.biz.equatron.dattebayo.core.data.source.local.LocalDataSource
import id.biz.equatron.dattebayo.core.data.source.local.room.CharacterDatabase
import id.biz.equatron.dattebayo.core.data.source.remote.RemoteDataSource
import id.biz.equatron.dattebayo.core.data.source.remote.network.ApiService
import id.biz.equatron.dattebayo.core.domain.repository.ICharacterRepository
import id.biz.equatron.dattebayo.core.utils.AppExecutors
import net.sqlcipher.database.SQLiteDatabase
import net.sqlcipher.database.SupportFactory
import okhttp3.CertificatePinner
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

val databaseModule = module {
    factory { get<CharacterDatabase>().characterDao() }
    single {
        val passphrase: ByteArray = SQLiteDatabase.getBytes("equatron".toCharArray())
        val factory = SupportFactory(passphrase)
        Room.databaseBuilder(
            androidContext(),
            CharacterDatabase::class.java, "dattebayo.db"
        )
            .openHelperFactory(factory)
            .fallbackToDestructiveMigration()
            .build()
    }
}

val networkModule = module {
    single {
        val hostname = "dattebayo-api.onrender.com"
        val certificatePinner = CertificatePinner.Builder()
            .add(hostname, "sha256/BMh9IOwlOFqSEHbPfWk50LL2QZvldSZ0aTgmlWwTW7g=")
            .add(hostname, "sha256/eG3k7TO7g56kU0xKb7MSIv+mo98h1KHE8Gy0L/HMhMM=")
            .build()
        OkHttpClient.Builder()
            .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(120, TimeUnit.SECONDS)
            .certificatePinner(certificatePinner)
            .build()
    }
    single {
        val retrofit = Retrofit.Builder()
            .baseUrl("https://dattebayo-api.onrender.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(get())
            .build()
        retrofit.create(ApiService::class.java)
    }
}

val repositoryModule = module {
    single { LocalDataSource(get()) }
    single { RemoteDataSource(get()) }
    factory { AppExecutors() }
    single<ICharacterRepository> {
        CharacterRepository(
            get(),
            get(),
            get(),
        )
    }
}