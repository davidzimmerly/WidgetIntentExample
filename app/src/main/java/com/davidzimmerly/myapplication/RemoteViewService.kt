package com.davidzimmerly.myapplication

import android.content.Intent
import android.widget.RemoteViewsService

class MyRemoteViewsService : RemoteViewsService() {
    override fun onGetViewFactory(p0: Intent) = MyRemoteViewsFactory(applicationContext = application, intent = p0)
}