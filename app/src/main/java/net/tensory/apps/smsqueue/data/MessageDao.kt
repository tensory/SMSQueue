package net.tensory.apps.smsqueue.data

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import net.tensory.apps.smsqueue.data.models.Message

@Dao
interface MessageDao {

    @Insert
    fun insert(message: Message)

//    @Query("SELECT * from message WHERE " +
//            "read = 0 AND " +
//            "senderGroupId = :arg0")
//    fun getUnreadMessagesInSenderGroup(groupId: Int): List<Message>
}