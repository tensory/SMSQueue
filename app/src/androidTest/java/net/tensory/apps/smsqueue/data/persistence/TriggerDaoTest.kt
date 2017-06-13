package net.tensory.apps.smsqueue.data.persistence

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import net.tensory.apps.smsqueue.data.models.Trigger
import org.hamcrest.MatcherAssert.assertThat
import org.hamcrest.Matchers.equalTo
import org.junit.Before
import org.junit.Test

class TriggerDaoTest {

    lateinit var db: ApplicationDatabase
    lateinit var triggerDao: TriggerDao

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getContext()
        db = Room.inMemoryDatabaseBuilder(context, ApplicationDatabase::class.java).build()
        triggerDao = db.triggerDao()
    }

    @Test
    fun insertOneTrigger() {
        val trigger = Trigger("todo replace with generated string")

        triggerDao.insert(trigger)
        assertThat(triggerDao.getAll().size, equalTo(1))
    }
}