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

    var filters: MutableMap<PhoneNumber, MutableList<Rule>> = mutableMapOf()

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

    fun reloadCache() {
        insertRulesFromUser(
                applicationComponent.applicationDatabase().userDao().getAll().first())
    }

//    fun populateFilters(filters: List<Filter>) {
//
//        // now I have an extra function with no test...
//        // and I'm not sure I like this at all.
//        // how to solve?
//        // rather than representing the rule ID in the filters object on Application,
//        // construct Rules from the result set of the query.
//        // decide whether a User object or a relation that maps user_id:rule_id:trigger is really required
//        filtersList.forEach { filter ->
//            filters.get(filter.phoneNumber)?.add(filter.rule) ?:
//                    filters.put(filter.phoneNumber, mutableListOf(filter.rule))
//        }
//    }
}