package net.tensory.apps.smsqueue.dependency_injection

import android.app.Application
import android.arch.persistence.room.Room
import dagger.Module
import dagger.Provides
import net.tensory.apps.smsqueue.data.ApplicationDatabase
import javax.inject.Singleton

@Module
class PersistenceModule {

    @Provides
    @Singleton
    fun providesAppDatabase(application: Application): ApplicationDatabase = Room.databaseBuilder(
            application.applicationContext,
            ApplicationDatabase::class.java,
            "application-data")
            .build()
}