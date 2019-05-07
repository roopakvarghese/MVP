package test.sumskar.com.mvp.ui.activity.home

import android.app.Activity
import android.os.Bundle
import android.support.v4.app.FragmentActivity
import test.sumskar.com.mvp.R
import test.sumskar.com.mvp.ui.fragment.HomeFragment

class HomeActivity: FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.base_activity)
        loadHomeFragment()
    }

    private fun loadHomeFragment() {
        supportFragmentManager.beginTransaction().add(R.id.baseLayout,HomeFragment()).commit()
    }
}