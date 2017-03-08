package roman.com.listviewtestproject;

/**
 * Created by roman on 3/8/17.
 */

import android.appwidget.AppWidgetManager;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;
import android.widget.RemoteViewsService;

import com.apkfuns.logutils.LogUtils;

import java.util.ArrayList;

/**
 * If you are familiar with Adapter of ListView,this is the same as adapter
 * with few changes
 */
public class WidgetRemoteFactory implements RemoteViewsService.RemoteViewsFactory {

    private ArrayList<Recipe> mlistItemList;
    private Context mContext;
    private int mAppWidgetId;

    public WidgetRemoteFactory(Context context, Intent intent) {
        LogUtils.d(this.getClass().getName());

        this.mContext = context;
        mAppWidgetId = intent.getIntExtra(AppWidgetManager.EXTRA_APPWIDGET_ID,
                AppWidgetManager.INVALID_APPWIDGET_ID);
        mlistItemList = Data.getRecipes();
    }

    @Override
    public void onCreate() {
    }

    @Override
    public void onDataSetChanged() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public RemoteViews getLoadingView() {
        return null;
    }

    @Override
    public int getViewTypeCount() {
        return 1;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public int getCount() {
        return mlistItemList.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    /*
    *Similar to getView of Adapter where instead of View
    *we return RemoteViews
    *
    */
    @Override
    public RemoteViews getViewAt(int position) {
        final RemoteViews remoteView = new RemoteViews(mContext.getPackageName(), R.layout.list_item_recipe);
        remoteView.setTextViewText(R.id.recipe_list_title, mlistItemList.get(position).getName());

        return remoteView;
    }
}