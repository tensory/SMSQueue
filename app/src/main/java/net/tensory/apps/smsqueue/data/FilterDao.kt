package net.tensory.apps.smsqueue.data

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import net.tensory.apps.smsqueue.data.models.Filter

@Dao
interface FilterDao {

    @Insert(onConflict = OnConflictStrategy.FAIL)
    fun insert(filter: Filter)

    @Query("SELECT * from filter")
    fun getAll(): List<Filter>
}