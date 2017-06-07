package net.tensory.apps.smsqueue.integration.app

import android.app.Instrumentation
import android.support.test.InstrumentationRegistry
import net.tensory.apps.smsqueue.SmsQueueApplication
import net.tensory.apps.smsqueue.data.models.Filter
import net.tensory.apps.smsqueue.data.models.User
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Test

class SmsQueueApplicationTest {
    lateinit var application: SmsQueueApplication

    @Before
    fun setUp() {
        application = Instrumentation.newApplication(SmsQueueApplication::class.java,
                InstrumentationRegistry.getContext()) as SmsQueueApplication
    }

    @Test
    fun application_withUserWithoutFilters_hasNoFilters() {
        assertThat("Application has no filters set", application.filters.isEmpty())
    }

    @Test
    fun application_withUserWithFilters_hasFilters() {
        val user: User = User()
        user.addRule(Filter())

        // save user

        application.reload()
        assertThat("At least one filter is defined", application.filters.isNotEmpty())
    }
}