package com.madan.kunal.srisriwallpapers;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RelativeLayout;

import com.github.javiersantos.appupdater.AppUpdater;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;


public class MainActivity extends AppCompatActivity  {
    private InterstitialAd mInterstitial;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(isConnectingToInternet()) {

            setContentView(R.layout.activity_main);
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
            setSupportActionBar(toolbar);
           ((MyApplication) getApplication()).startTracking();
            AppUpdater appUpdater = new AppUpdater(this);
            appUpdater.start();
            RelativeLayout adViewContainer = (RelativeLayout) findViewById(R.id.adViewContainer);

           /* adView = new AdView(this, "326817451028391_326818587694944", AdSize.BANNER);
            adViewContainer.addView(adView);
            adView.loadAd();*/
        }

        else {
            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
            // builder.setTitle(getString(R.string.dialog_title));
            builder.setMessage("You are not connected to internet. " +
                    "Please connect to internet and try again!!");

            String positiveText = getString(android.R.string.ok);
            builder.setPositiveButton(positiveText,
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // positive button logic
                            // mInterstitial.show();
                            finish();
                        }
                    });

            String negativeText = getString(android.R.string.cancel);
            builder.setNegativeButton(negativeText,
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            // negative button logic
                            //  mInterstitial.show();
                            finish();
                        }
                    });

            AlertDialog dialog = builder.create();
            // display dialog
            dialog.show();
        }

    }



    @Override
    protected void onResume() {
        super.onResume();
        //loadInterstitialAd();
        mInterstitial = new InterstitialAd(this);
        mInterstitial.setAdUnitId(getResources().getString(R.string.interstitial_ad_unit_id));
        AdRequest ar = new AdRequest.Builder().build();
        mInterstitial.loadAd(ar);
    }

    @Override
    public void onBackPressed() {


        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        // builder.setTitle(getString(R.string.dialog_title));
        builder.setMessage("Are you sure you want to Exit!");

        String positiveText = getString(android.R.string.ok);
        builder.setPositiveButton(positiveText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // positive button logic
                        mInterstitial.show();
                        finish();
                    }
                });

        String negativeText = getString(android.R.string.cancel);
        builder.setNegativeButton(negativeText,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // negative button logic
                        dialog.dismiss();
                    }
                });

        AlertDialog dialog = builder.create();
        // display dialog
        dialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public boolean isConnectingToInternet(){

        ConnectivityManager cm =
                (ConnectivityManager)this.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        boolean isConnected = activeNetwork != null &&
                activeNetwork.isConnectedOrConnecting();
        return isConnected;
    }
   /* private void loadInterstitialAd() {
        interstitialAd = new InterstitialAd(this, "326817451028391_326872404356229");
        interstitialAd.setAdListener(new AbstractAdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                super.onError(ad, adError);
            }

            @Override
            public void onAdLoaded(Ad ad) {
                super.onAdLoaded(ad);

            }

            @Override
            public void onAdClicked(Ad ad) {
                super.onAdClicked(ad);
            }
        });
        interstitialAd.loadAd();
    }*/

}
