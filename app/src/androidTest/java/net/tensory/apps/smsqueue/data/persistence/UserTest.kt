package net.tensory.apps.smsqueue.data.persistence

import android.arch.persistence.room.Room
import android.support.test.InstrumentationRegistry
import android.support.test.espresso.matcher.ViewMatchers
import android.support.test.runner.AndroidJUnit4
import net.tensory.apps.smsqueue.data.models.Filter
import net.tensory.apps.smsqueue.data.models.User
import org.hamcrest.CoreMatchers
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class UserTest {

    lateinit var db: ApplicationDatabase
    lateinit var userDao: UserDao

    @Before
    fun createDb() {
        val context = InstrumentationRegistry.getContext()
        db = Room.inMemoryDatabaseBuilder(context, ApplicationDatabase::class.java).build()
        userDao = db.userDao()
    }

    @After
    fun closeDb() {
        db.close()
    }

    @Test
    fun createUser() {
        val user = User()

        userDao.insert(user)

        val allUsers = userDao.getAll()
        ViewMatchers.assertThat(allUsers.size, CoreMatchers.equalTo(1))
    }
}