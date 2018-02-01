package com.tinklabs.handy.doubleclickdemo

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.doubleclick.AppEventListener
import com.google.android.gms.ads.doubleclick.PublisherAdRequest
import com.google.android.gms.ads.doubleclick.PublisherAdView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val views = ArrayList<PublisherAdView>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        MobileAds.initialize(this);

        views.add(adViewExample)
        views.add(adView1)
        views.add(adView2)
        views.add(adView3)
        views.add(adView4)
        views.add(adView5)

        val adRequest = PublisherAdRequest.Builder()
                .addCustomTargeting("country", "25")
                .addCustomTargeting("city", "25")
                .addCustomTargeting("hotel", "25")
                .addCustomTargeting("lang", "25")
                .addCustomTargeting("rating", "25")
                .addCustomTargeting("lockscreenid", "25")
                .addCustomTargeting("pos", "25")
                .addCustomTargeting("deviceid", "25")
                .build()

        views.forEach {
            it.loadAd(adRequest)
        }
    }

    override fun onPause() {
        views.forEach(PublisherAdView::pause)
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        views.forEach(PublisherAdView::resume)
    }

    override fun onDestroy() {
        views.forEach(PublisherAdView::destroy)
        super.onDestroy()
    }
}
