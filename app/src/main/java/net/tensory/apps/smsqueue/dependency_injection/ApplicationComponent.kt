package net.tensory.apps.smsqueue.dependency_injection

import android.app.Application
import dagger.Component
import net.tensory.apps.smsqueue.SmsQueueApplication
import net.tensory.apps.smsqueue.data.persistence.ApplicationDatabase
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(ApplicationModule::class, PersistenceModule::class))
interface ApplicationComponent {
    fun inject(application: SmsQueueApplication)

    fun application(): Application
    fun applicationDatabase(): ApplicationDatabase
}