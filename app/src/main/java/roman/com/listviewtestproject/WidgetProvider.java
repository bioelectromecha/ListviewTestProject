package roman.com.listviewtestproject;

import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.RemoteViews;

import com.apkfuns.logutils.LogUtils;

/**
 * Created by roman on 3/8/17.
 */

public class WidgetProvider extends AppWidgetProvider {

    /**
     * this method is called every 30 mins as specified on widgetinfo.xml
     * this method is also called on every phone reboot
     **/

    @Override
    public void onUpdate(Context context, AppWidgetManager
            appWidgetManager, int[] appWidgetIds) {

/*int[] appWidgetIds holds ids of multiple instance
 * of your widget
 * meaning you are placing more than one widgets on
 * your homescreen*/
        LogUtils.d(this.getClass().getName());
        final int N = appWidgetIds.length;
        for (int i = 0; i < N; ++i) {
            LogUtils.d("update widget number " + i);
            RemoteViews remoteViews = updateWidgetListView(context, appWidgetIds[i]);
            appWidgetManager.updateAppWidget(appWidgetIds[i], remoteViews);
        }
        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }

    private RemoteViews updateWidgetListView(Context context, int appWidgetId) {
        //which layout to show on widget
        LogUtils.d("updateWidgetListView");
        RemoteViews remoteViews = new RemoteViews(context.getPackageName(),R.layout.widget_layout);
        //RemoteViews Service needed to provide adapter for ListView
        Intent serviceIntent = new Intent(context, WidgetService.class); /* this is where the service gets called */
        //passing app widget id to that RemoteViews Service
        serviceIntent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
        //setting a unique Uri to the intent
        //don't know its purpose to me right now
        serviceIntent.setData(Uri.parse(serviceIntent.toUri(Intent.URI_INTENT_SCHEME)));
        //setting adapter to listview of the widget
        remoteViews.setRemoteAdapter( R.id.listViewWidget, serviceIntent);
        //setting an empty view in case of no data
        remoteViews.setEmptyView(R.id.listViewWidget, R.id.empty_view);
        return remoteViews;
    }

}
