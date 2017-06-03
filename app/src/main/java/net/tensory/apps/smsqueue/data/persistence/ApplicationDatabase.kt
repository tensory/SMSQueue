package net.tensory.apps.smsqueue.data.persistence

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import net.tensory.apps.smsqueue.BuildConfig
import net.tensory.apps.smsqueue.data.models.Filter
import net.tensory.apps.smsqueue.data.models.User

@Database(entities = arrayOf(User::class, Filter::class), version = BuildConfig.DATABASE_VERSION)
abstract class ApplicationDatabase : RoomDatabase() {
    abstract fun filterDao(): FilterDao
    abstract fun userDao(): UserDao
}