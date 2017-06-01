package net.tensory.apps.smsqueue.data.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "message")
abstract class Message {
    constructor(body: String) {
        this.body = body
        this.unread = 1
    }

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    var body: String

    var unread: Int

    abstract var filterIds: IntArray
}