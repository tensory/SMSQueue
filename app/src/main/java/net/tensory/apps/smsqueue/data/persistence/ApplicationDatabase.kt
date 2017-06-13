package net.tensory.apps.smsqueue.data.persistence

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import net.tensory.apps.smsqueue.BuildConfig
import net.tensory.apps.smsqueue.data.models.Trigger
import net.tensory.apps.smsqueue.data.models.User

@Database(entities = arrayOf(User::class, Trigger::class), version = BuildConfig.DATABASE_VERSION)
abstract class ApplicationDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun triggerDao(): TriggerDao
}