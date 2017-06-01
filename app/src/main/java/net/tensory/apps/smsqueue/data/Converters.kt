package net.tensory.apps.smsqueue.data

import android.arch.persistence.room.TypeConverter

class Converters {
    @TypeConverter
    fun listOfPhoneNumbersToString(phoneNumbers: List<String>): String {
        return phoneNumbers.joinToString(",")
    }

//    @TypeConverter
//    fun listOfPhoneNumbersToString(phoneNumbers: List<PhoneNumber>): String {
//        return phoneNumbers
//                .map { k -> k.value }
//                .joinToString(",")
//    }
}