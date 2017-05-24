package net.tensory.apps.smsqueue

import android.app.Application
import net.tensory.apps.smsqueue.dependency_injection.ApplicationComponent
import net.tensory.apps.smsqueue.dependency_injection.ApplicationModule
import net.tensory.apps.smsqueue.dependency_injection.DaggerApplicationComponent

class SmsQueueApplication : Application() {

    companion object {
        lateinit var applicationComponent: ApplicationComponent
    }

    override fun onCreate() {
        super.onCreate()

        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(ApplicationModule(this))
                .build()
        applicationComponent.inject(this)
    }

}