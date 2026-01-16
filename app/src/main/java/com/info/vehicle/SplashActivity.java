package com.info.vehicle;




import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;
import android.view.Menu;
import android.widget.ProgressBar;

public class SplashActivity extends Activity {

	ProgressBar progressBar;
	private Thread mThread;
	private boolean isFinish = false;
	
	private static int SPLASH_TIME_OUT =1000;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		//ActionBar bar= getSupportActionBar();
		//getSupportActionBar().hide();
		{

			new Handler().postDelayed(new Runnable() {

				// * Showing splash screen with a timer. This will be useful
				// when you
				// * want to show case your app logo / company

				@Override
				public void run() {
					// This method will be executed once the timer is overf
					// Start your app main activity
					//ImageView img = (ImageView) findViewById(R.id.imageView1);
				//	progressBar = (ProgressBar) findViewById(R.id.progressBar1);
					final String PREFS_NAME = "MyPrefsFile";

					SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);

					if (settings.getBoolean("my_first_time", true)) {
					    //the app is being launched for first time, do something        
					    Log.d("Comments", "First time");

					             // first time task

					    // record the fact that the app has been started at least once
					    settings.edit().putBoolean("my_first_time", false).commit(); 
					}
					else
					{
						Intent i = new Intent(SplashActivity.this, HomeActivity.class);

						startActivity(i);
					}
					

					// close this activity
					finish();
				}
			}, SPLASH_TIME_OUT);
		}
		
		
	}
	

	

}
