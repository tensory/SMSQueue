package net.tensory.apps.smsqueue.data.persistence

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import net.tensory.apps.smsqueue.data.models.Trigger

@Dao
interface TriggerDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(trigger: Trigger)

    @Query("SELECT * from trigger")
    fun getAll(): List<Trigger>
}