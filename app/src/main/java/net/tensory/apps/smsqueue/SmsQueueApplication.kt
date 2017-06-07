package net.tensory.apps.smsqueue

import android.app.Application
import net.tensory.apps.smsqueue.data.models.User
import net.tensory.apps.smsqueue.data.persistence.Filters
import net.tensory.apps.smsqueue.dependency_injection.ApplicationComponent
import net.tensory.apps.smsqueue.dependency_injection.ApplicationModule
import net.tensory.apps.smsqueue.dependency_injection.DaggerApplicationComponent
import net.tensory.apps.smsqueue.rules.Rule

class SmsQueueApplication : Application() {

    companion object {
        lateinit var applicationComponent: ApplicationComponent
    }

    var filters: Map<PhoneNumber, Rule> = mutableMapOf()

    /**
     * What needs to happen with filters?
     *
     * When filters are requested from the application object,
     * they should be parsed to Filter objects from the internal model that is serialized from Json.
     *
     * There is now integration test coverage of the List<Filter> property.
     * There are NOT any tests on a Filter or on the User.
     *
     * List<Rule> should be parsed from the mapping on the User object.
     * The User object json could look like this.
     *
     * user = {
     *   filters: {
     *     '425-555-5555': [1, 2],
     *     '999-234-2342': [2]
     *   }
     * }
     *
     * The basic test for size is implemented correctly.
     * The next step -- since this group of filters is a mapping --
     * is to load the json from the DAO when the application itself loads.
     *
     * The following test to write is whether the application knows about a specific filter.
     * Don't write this yet.
     *
     */

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
        applicationComponent.inject(this)
    }

    fun save(user: User) {
        // Persist the filters as json into the user DAO.
    }

    fun reload() {
        // Load in-memory cache data from User object.
    }
}