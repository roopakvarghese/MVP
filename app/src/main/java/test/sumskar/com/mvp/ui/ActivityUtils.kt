package test.sumskar.com.mvp.ui

import android.view.View

class ActivityUtils {
    public interface OnItemClickCallback{
         fun onItemClick(view: View, `object`: Any, position: Int)
    }
}