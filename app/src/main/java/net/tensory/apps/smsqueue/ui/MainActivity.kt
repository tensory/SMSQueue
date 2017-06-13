package net.tensory.apps.smsqueue.ui

import android.database.Cursor
import android.os.Bundle
import android.support.v4.app.LoaderManager
import android.support.v4.content.Loader
import android.support.v7.app.AppCompatActivity
import net.tensory.apps.smsqueue.R
import net.tensory.apps.smsqueue.data.models.Trigger
import net.tensory.apps.smsqueue.rules.Rule

class MainActivity : AppCompatActivity(), LoaderManager.LoaderCallbacks<Cursor> {

    // region LoaderManager.LoaderCallbacks

    override fun onCreateLoader(id: Int, args: Bundle?): Loader<Cursor> {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onLoadFinished(loader: Loader<Cursor>?, data: Cursor) {
        val myFilters: MutableMap<Trigger, MutableList<Rule>> = mutableMapOf()

        while (data.moveToNext()) {
            val phoneNumber: Trigger = Trigger.from(data.getString(0))
            val rulesSchema: String = data.getString(1)

            with(Rule.from(rulesSchema)) {
                myFilters.get(phoneNumber)?.add(this)
            }
        }

        // now you can set application filters!
    }

    override fun onLoaderReset(loader: Loader<Cursor>?) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    /**
     *

     */
    private val LOADER_FILTERS = 1

    // endregion

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        // this should probably be implemented on the MainPresenter,
        // but it needs an AppCompatActivity context...

        supportLoaderManager.initLoader(LOADER_FILTERS, null, this)
    }

    /**
     * TODO
     *
     * Before ANY graphical development can happen with this class,
     * after the Filter group loading code has been figured out,
     * the only acceptable next task is to implement MVP structure for presenting the data
     * per https://github.com/ribot/android-boilerplate/blob/master/app/src/main/java/uk/co/ribot/androidboilerplate/ui/main/MainActivity.java.
     *
     * <3 You are great.
     */
}
