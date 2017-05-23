package net.tensory.apps.smsqueue.data

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Update
import net.tensory.apps.smsqueue.data.models.SenderGroup

@Dao
interface SenderGroupDao {
    @Insert(onConflict = OnConflictStrategy.FAIL)
    fun insertGroup(senderGroup: SenderGroup)

    @Update
    fun updateGroup(senderGroup: SenderGroup)
}