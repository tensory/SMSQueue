package net.tensory.apps.smsqueue.data.models

import android.arch.persistence.room.ColumnInfo
import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "trigger")
class Trigger {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

    var value: String = ""

    companion object {
        fun from(value: String): Trigger {
            val trigger = Trigger()
            trigger.value = value
            return trigger
        }
    }
}