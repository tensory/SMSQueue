package net.tensory.apps.smsqueue.rules

import net.tensory.apps.smsqueue.PhoneNumber

class Rulestore {
    private val ruleStore = HashMap<PhoneNumber, Rule>()

    fun hasRule(phoneNumber: PhoneNumber): Boolean {
        return ruleStore.containsKey(phoneNumber)
    }

    fun addRule(phoneNumber: PhoneNumber) {
        ruleStore.put(phoneNumber, Rule())
    }
}