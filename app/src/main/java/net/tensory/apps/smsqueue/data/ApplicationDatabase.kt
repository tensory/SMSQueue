package net.tensory.apps.smsqueue.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import net.tensory.apps.smsqueue.BuildConfig
import net.tensory.apps.smsqueue.data.models.SenderGroup

@Database(entities = arrayOf(SenderGroup::class), version = BuildConfig.DATABASE_VERSION)
abstract class ApplicationDatabase : RoomDatabase() {
    abstract fun senderGroupDao(): SenderGroupDao
}