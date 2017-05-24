package net.tensory.apps.smsqueue.persistence

import net.tensory.apps.smsqueue.PhoneNumber

abstract class SenderGroupManager {
    abstract fun create(varargs: PhoneNumber)
}