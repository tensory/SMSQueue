package net.tensory.apps.smsqueue.data.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "filter")
class Filter {
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0

//    @ColumnInfo(name = "phoneNumbers")
//    var phoneNumbers: MutableList<String> = mutableListOf<String>()
}