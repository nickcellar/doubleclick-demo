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
//                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)        // All emulators
//                .addTestDevice("73FB16A586A92434E9C7BEA93A8CBCC7")        // All emulators
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
