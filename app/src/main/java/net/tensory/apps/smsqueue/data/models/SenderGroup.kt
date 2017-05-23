package net.tensory.apps.smsqueue.data.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "senderGroup")
class SenderGroup {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0

    var phoneNumbers: String = ""
}