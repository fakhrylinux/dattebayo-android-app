package id.biz.equatron.dattebayo

import android.app.Application
import id.biz.equatron.dattebayo.core.di.databaseModule
import id.biz.equatron.dattebayo.core.di.networkModule
import id.biz.equatron.dattebayo.core.di.repositoryModule
import id.biz.equatron.dattebayo.di.useCaseModule
import id.biz.equatron.dattebayo.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@MyApplication)
            modules(
                listOf(
                    databaseModule,
                    networkModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule,
                )
            )
        }
    }
}