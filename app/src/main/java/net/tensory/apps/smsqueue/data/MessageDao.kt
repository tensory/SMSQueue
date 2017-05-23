package net.tensory.apps.smsqueue.data

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Query
import net.tensory.apps.smsqueue.data.models.Message

@Dao
interface MessageDao {
    @Query("SELECT * from message WHERE " +
            "read = 0 AND " +
            "senderGroupId = :arg0")
    fun getUnreadMessagesFromSenderGroup(groupId: Int): List<Message>
}