package net.tensory.apps.smsqueue.data.persistence

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import net.tensory.apps.smsqueue.data.models.User

@Dao
interface UserDao {

    @Insert(onConflict = OnConflictStrategy.FAIL)
    fun insert(user: User)

    @Query("SELECT * from user")
    fun getAll(): List<User>
}