package net.tensory.apps.smsqueue.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import net.tensory.apps.smsqueue.BuildConfig
import net.tensory.apps.smsqueue.data.models.Filter

@Database(entities = arrayOf(Filter::class), version = BuildConfig.DATABASE_VERSION)
@TypeConverters(Converters::class)
abstract class ApplicationDatabase : RoomDatabase() {
    abstract fun filterDao(): FilterDao
}