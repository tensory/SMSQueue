package net.tensory.apps.smsqueue.data.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "message")
class Message {
    constructor(senderGroupId: Int, body: String) {
        this.senderGroupId = senderGroupId
        this.body = body
    }

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    var senderGroupId: Int

    var body: String

    var unread: Int = 1
}