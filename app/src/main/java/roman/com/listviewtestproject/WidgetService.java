package roman.com.listviewtestproject;

import android.appwidget.AppWidgetManager;
import android.content.Intent;
import android.widget.RemoteViewsService;

import com.apkfuns.logutils.LogUtils;

/**
 * Created by roman on 3/8/17.
 */
public class WidgetService extends RemoteViewsService {
/*
* So pretty simple just defining the Adapter of the listview
* here Adapter is WidgetRemoteFactory
* */

    @Override
    public RemoteViewsFactory onGetViewFactory(Intent intent) {
        LogUtils.d("onGetViewFactory");
        int appWidgetId = intent.getIntExtra( AppWidgetManager.EXTRA_APPWIDGET_ID, AppWidgetManager.INVALID_APPWIDGET_ID);
        return (new WidgetRemoteFactory(this.getApplicationContext(), intent));
    }

}