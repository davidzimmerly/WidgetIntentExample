package com.davidzimmerly.myapplication

import android.app.PendingIntent
import android.app.PendingIntent.FLAG_MUTABLE
import android.appwidget.AppWidgetManager
import android.appwidget.AppWidgetProvider
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.widget.RemoteViews


import java.util.*


/**
 * Implementation of App Widget functionality.
 */
class NewAppWidget : AppWidgetProvider() {
    override fun onUpdate(
        context: Context,
        appWidgetManager: AppWidgetManager,
        appWidgetIds: IntArray
    ) {
        // There may be multiple widgets active, so update all of them
        for (appWidgetId in appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId)
        }
        super.onUpdate(context, appWidgetManager, appWidgetIds)
    }

    override fun onEnabled(context: Context) {
        // Enter relevant functionality for when the first widget is created
    }

    override fun onDisabled(context: Context) {
        // Enter relevant functionality for when the last widget is disabled
    }


}

internal fun updateAppWidget(
    context: Context,
    appWidgetManager: AppWidgetManager,
    appWidgetId: Int
) {
    val widgetText = context.getString(R.string.appwidget_text)
    // Construct the RemoteViews object
    val views = RemoteViews(context.packageName, R.layout.new_app_widget)
    views.setTextViewText(R.id.appwidget_text, widgetText)


    views.setOnClickPendingIntent(R.id.appwidget_text, PendingIntent.getActivity(
        context,
        UUID.randomUUID().hashCode(),
        Intent(context, MainActivity2::class.java).apply {
            action = Intent.ACTION_ANSWER
            data = Uri.parse(this.toUri(Intent.URI_INTENT_SCHEME));
            putExtra("UUID", "333333")
        },
        FLAG_MUTABLE or PendingIntent.FLAG_UPDATE_CURRENT
    ))
    views.setRemoteAdapter(R.id.list_view, Intent(context, MyRemoteViewsService::class.java))

    // Instruct the widget manager to update the widget
    appWidgetManager.updateAppWidget(appWidgetId, views)
}