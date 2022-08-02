package com.davidzimmerly.myapplication

import android.app.Application
import android.content.Intent
import android.database.Cursor
import android.os.Binder
import android.util.Log
import android.widget.RemoteViews
import android.widget.RemoteViewsService
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import java.net.HttpURLConnection
import java.net.URL
import java.util.*


class MyRemoteViewsFactory(val applicationContext: Application, val intent: Intent) : RemoteViewsService.RemoteViewsFactory {
    private var widgetList: List<String> = ArrayList()
    private var mCursor: Cursor? = null

    init {
        updateWidgetListView()
    }

    private fun updateWidgetListView() {
    }
    override fun onCreate() {

    }

    override fun onDataSetChanged() {

        mCursor?.close()

        val identityToken: Long = Binder.clearCallingIdentity()

        Binder.restoreCallingIdentity(identityToken)
    }

    override fun onDestroy() {

    }

    override fun getCount() = widgetList.size

    override fun getViewAt(position: Int): RemoteViews? {
        return null
    }

    override fun getLoadingView() = null

    override fun getViewTypeCount(): Int {
        return 1
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun hasStableIds(): Boolean {
        return false;
    }
}