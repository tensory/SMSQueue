package net.tensory.apps.smsqueue.data.persistence

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.matcher.ViewMatchers.assertThat
import android.support.test.runner.AndroidJUnit4
import net.tensory.apps.smsqueue.data.models.Filter
import org.hamcrest.CoreMatchers.equalTo
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class FilterTest {

    lateinit var db: ApplicationDatabase
    lateinit var filterDao: FilterDao

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getContext()
        db = Room.inMemoryDatabaseBuilder(context, ApplicationDatabase::class.java).build()
        filterDao = db.filterDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun insertOneFilter() {
        val filter = Filter()

        filterDao.insert(filter)

        val allFilters = filterDao.getAll()
        assertThat(allFilters.size, equalTo(1))
    }
}