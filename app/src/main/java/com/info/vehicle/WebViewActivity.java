package com.info.vehicle;


import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.facebook.ads.*;

public class WebViewActivity extends AppCompatActivity {
    WebView w;
    ProgressBar progressBar;
    private InterstitialAd interstitialAd;
    public static String TAG = WebViewActivity.class.getName();
    boolean isAdLoaded = false;


    //private MA ma;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

		/*if(ma==null)
			ma=new MA(this,adCallbackListener, false);
		ma.callAppWall();
		ma.callSmartWallAd();*/


        progressBar = (ProgressBar) findViewById(R.id.progressBar1);

        w = (WebView) findViewById(R.id.webView1);
        //w.setWebViewClient(new MyBrowser());
        if (isConnected()) {
            open();
        } else {
            Toast.makeText(getApplicationContext(), "YOU ARE NOT CONNECTED TO NETWORK...Try Again", Toast.LENGTH_LONG).show();
            finish();
        }
       // initFullscreenAd();
    }

    private void initFullscreenAd() {
     /*   mInterstitialAd = new InterstitialAd(this);
       // mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.setAdUnitId("ca-app-pub-5468817073944283/1033479563");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                // Code to be executed when an ad finishes loading.
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                // Code to be executed when an ad request fails.
            }

            @Override
            public void onAdOpened() {
                // Code to be executed when the ad is displayed.
            }

            @Override
            public void onAdLeftApplication() {
                // Code to be executed when the user has left the app.
            }

            @Override
            public void onAdClosed() {
                // Code to be executed when when the interstitial ad is closed.
                starthomeActivity();
                finish();
            }
        });*/

        interstitialAd = new InterstitialAd(this, "463630587698599_463647291030262");
        // Set listeners for the Interstitial Ad
       /* interstitialAd.setAdListener(new InterstitialAdListener() {
            @Override
            public void onInterstitialDisplayed(Ad ad) {
                // Interstitial ad displayed callback
                Log.e(TAG, "Interstitial ad displayed.");
                showToast("Interstitial ad displayed");

            }

            @Override
            public void onInterstitialDismissed(Ad ad) {
                // Interstitial dismissed callback
                Log.e(TAG, "Interstitial ad dismissed.");
                showToast("Interstitial ad dismissed.");
                isAdLoaded=false;
                starthomeActivity();
                finish();
            }

            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
                Log.e(TAG, "Interstitial ad failed to load: " + adError.getErrorMessage());
                showToast("Interstitial ad failed to load:");
            }

            @Override
            public void onAdLoaded(Ad ad) {
                // Interstitial ad is loaded and ready to be displayed
                Log.d(TAG, "Interstitial ad is loaded and ready to be displayed!");
                showToast("Interstitial ad is loaded and ready to be displayed!");
                // Show the ad
               //interstitialAd.show();
                isAdLoaded=true;
            }

            @Override
            public void onAdClicked(Ad ad) {
                // Ad clicked callback
                Log.d(TAG, "Interstitial ad clicked!");
                showToast("Interstitial ad clicked!");
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                // Ad impression logged callback
                Log.d(TAG, "Interstitial ad impression logged!");
                showToast("Interstitial ad impression logged!!");
            }
        });
        interstitialAd.loadAd();*/
    }


    /* AdListener adCallbackListener=new AdListener() {
         
            @Override
            public void onSDKIntegrationError(String message) {
            //Here you will receive message from SDK if it detects any integration issue.
            }

            public void onSmartWallAdShowing() {
            // This will be called by SDK when it�s showing any of the SmartWall ad.
            }

            @Override
            public void onSmartWallAdClosed() {
            // This will be called by SDK when the SmartWall ad is closed.
            }

            @Override
            public void onAdError(String message) {
            //This will get called if any error occurred during ad serving.
            }
            @Override
            public void onAdCached(AdType arg0) {
            //This will get called when an ad is cached.

            }
             @Override
            public void noAdAvailableListener() {
            //this will get called when ad is not available

            }
         };*/
    public boolean isConnected() {
        ConnectivityManager connMgr = (ConnectivityManager) getSystemService(Activity.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();
        if (networkInfo != null && networkInfo.isConnected())
            return true;
        else
            // TODO Auto-generated method stub
            return false;
    }

    public void open() {
        Intent inc = getIntent();
        String url = getIntent().getExtras().getString("urls");

        // w.getSettings().setLoadWithOverviewMode(true);
        //  w.getSettings().setDefaultZoom(2);
        // w.getSettings().setLayoutAlgorithm(LayoutAlgorithm.SINGLE_COLUMN);

        //Log.e("cdvfgbf", "cdghh...11111111..."+url);

        if (url.equals("http://mis.mptransport.org/MPLogin/eSewa/VehicleSearch.aspx")) {
            //w.getSettings().setBuiltInZoomControls(true);
            w.getSettings().setUseWideViewPort(true);
            w.setInitialScale(130);
            // Log.e("cdvfgbf", "cdghh...11111111inn..."+url);

        }

        if (url.equals("http://cg.nic.in/transport/RegnOwner.aspx")) {
            w.getSettings().setBuiltInZoomControls(true);
            //Log.e("cdvfgbf", "cdghh...222222222..."+url);
            w.getSettings().setUseWideViewPort(true);
            w.setInitialScale(60);
        }

        if (url.equals("https://aptransport.in/CFSTONLINE/Reports/VehicleRegistrationSearch.aspx")) {
            w.getSettings().setBuiltInZoomControls(true);
            //Log.e("cdvfgbf", "cdghh...133333..."+url);
            w.getSettings().setUseWideViewPort(true);
            w.setInitialScale(90);
        }

        if (url.equals("http://btis.in/rto")) {
            w.getSettings().setBuiltInZoomControls(true);
            // Log.e("cdvfgbf", "cdghh...133333..."+url);
            w.getSettings().setUseWideViewPort(true);
            w.setInitialScale(90);
        }
        float currentScale = w.getScale();
        Log.e("cdvfgbf", "cdghh...133333..." + currentScale);
        w.setWebViewClient(new myWebClient());
        w.getSettings().setJavaScriptEnabled(true);
        w.loadUrl(url);

    }

    private class myWebClient extends WebViewClient {
        @Override
        public void onPageStarted(WebView view, String url, Bitmap favicon) {
            // TODO Auto-generated method stub
            super.onPageStarted(view, url, favicon);
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            // TODO Auto-generated method stub

            view.loadUrl(url);
            return true;

        }

        @Override
        public void onPageFinished(WebView view, String url) {
            // TODO Auto-generated method stub
            super.onPageFinished(view, url);
            //String url_new = view.getUrl();

            //  Log.v("","Webview Function URL: "+url_new);
            progressBar.setVisibility(View.GONE);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
	/*	com.actionbarsherlock.view.MenuInflater inflater=getSupportMenuInflater();
	    inflater.inflate(R.menu.info_activty, menu);*/
        getMenuInflater().inflate(R.menu.info_activty, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // TODO Auto-generated method stub
        switch (item.getItemId()) {
            case R.id.refresh:
                open();
                return true;


            case R.id.faq:
                Intent i5 = new Intent(WebViewActivity.this, FAQActivity.class);
                startActivity(i5);
                break;

            case R.id.abt:
                Intent i4 = new Intent(WebViewActivity.this, GeneralActivity.class);
                startActivity(i4);
                break;

            case R.id.gen:
                Intent i = new Intent(WebViewActivity.this, InfoActivity.class);
                startActivity(i);
                break;
            default:
                return super.onOptionsItemSelected(item);
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        // TODO Auto-generated method stub
        // Intent intent = new Intent(Intent.ACTION_MAIN);
        // intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        //   startActivity(intent);

        //super.onBackPressed();
        //finish();

        if (isAdLoaded) {
            interstitialAd.show();
        } else {// if not lodedfinish the activity
            starthomeActivity();
            finish();
        }
    }

    private void starthomeActivity(){
        Intent i=new Intent(this,HomeActivity.class);
        startActivity(i);
    }

    private void showToast(String msg){
      //  Toast.makeText(getApplicationContext(), "Error: " + msg,Toast.LENGTH_LONG).show();
    }

}

