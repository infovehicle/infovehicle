package com.info.vehicle;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnTouchListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.AdListener;
import com.facebook.ads.AdSettings;
import com.facebook.ads.AdSize;
import com.facebook.ads.AdView;
import com.facebook.ads.InterstitialAd;

public class HomeActivity extends AppCompatActivity {

	private AdView adView;
	Button search;
	//EditText ed1,ed2;
	static String state,urls;
	Context context;
	private String TAG = "SpinnerHint";
	 private static final String LOG_TAG = "InterstitialSample";

	  /** Your ad unit id. Replace with your actual ad unit id. */
	private static final String AD_UNIT_ID = "ca-app-pub-2434569027995793/6253979266";
	private Spinner typeSpinner;
	private TextView text,text1;
	private LayoutInflater mInflator;
	private boolean selected;
	private InterstitialAd interstitial;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_home);
		
		
		// Create the interstitial.
	  /*  interstitial = new InterstitialAd(this);
	    interstitial.setAdUnitId(AD_UNIT_ID);

	    // Create ad request.
	    AdRequest adRequest = new AdRequest.Builder().build();

	    // Begin loading your interstitial.
	    interstitial.loadAd(adRequest);
        displayInterstitial();
		//AdBuddiz.setPublisherKey("a2efe1f3-5909-44f3-b296-0997a80e9fa4");
	   //   AdBuddiz.cacheAds(this);
		// AdBuddiz.showAd(this);
		 AdView adView=new AdView(this, AdView.BANNER_TYPE_IN_APP_AD, AdView.PLACEMENT_TYPE_INTERSTITIAL, false, false, 
			     AdView.ANIMATION_TYPE_LEFT_TO_RIGHT);
			     adView.setAdListener(adlistener);*/
		//ed1=(EditText)findViewById(R.id.editText1);
		//MobileAds.initialize(this, "app-pub-3940256099942544~3347511713");
		/*MobileAds.initialize(this, "ca-app-pub-9159540250464397~7665821970");
		mAdView = (AdView)findViewById(R.id.adView);
		AdRequest adRequest = new AdRequest.Builder().build();
		mAdView.loadAd(adRequest);*/


		adView = new AdView(this,"463630587698599_463640881030903", AdSize.BANNER_HEIGHT_50);

		// Find the Ad Container
		LinearLayout adContainer = (LinearLayout) findViewById(R.id.banner_container);

		// Add the ad view to your activity layout
		adContainer.addView(adView);

        /*adView.setAdListener(new AdListener() {
            @Override
            public void onError(Ad ad, AdError adError) {
                // Ad error callback
              //  Toast.makeText(HomeActivity.this, "Error: " + adError.getErrorMessage(),
              //''''          Toast.LENGTH_LONG).show();
            }

            @Override
            public void onAdLoaded(Ad ad) {
                // Ad loaded callback
            }

            @Override
            public void onAdClicked(Ad ad) {
                // Ad clicked callback
            }

            @Override
            public void onLoggingImpression(Ad ad) {
                // Ad impression logged callback
            }
        });
        AdSettings.addTestDevice("HASHED ID");
		// Request an ad
		adView.loadAd();*/

		initUI();

		//ed2=(EditText)findViewById(R.id.editText2);
	    search= (Button)findViewById(R.id.Button1);


 /*    ed1.addTextChangedListener(new TextWatcher() {

    	    public void onTextChanged(CharSequence s, int start,int before, int count) 
    	    {
    	        // TODO Auto-generated method stub
    	        if(ed1.getText().toString().length()==2)     //size as per your requirement
    	        {
    	            ed2.requestFocus();
    	        }
    	    }
    	    public void beforeTextChanged(CharSequence s, int start,
    	                    int count, int after) {
    	                // TODO Auto-generated method stub

    	    }

    	    public void afterTextChanged(Editable s) {
    	                // TODO Auto-generated method stub
    	    }

    	});  
    */
		search.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//System.out.println("efrg...1"+text);
				state=(String) text.getText();
				//System.out.println("efrg.2.."+state);
				if(state.equals("Select State"))
				{
				Toast.makeText(getApplicationContext(), "Please select the state!", Toast.LENGTH_SHORT).show();
				}
			// if(ed1.getText().toString().equals("") || ed2.getText().toString().equals(""))
			//	{
			//	Toast.makeText(getApplicationContext(), "All the information are necessary!", Toast.LENGTH_SHORT).show();
			//	}else if(ed1.length()!=2 || ed2.length()!= 6)
			//	{
			//	Toast.makeText(getApplicationContext(), "Please enter the valid number!", Toast.LENGTH_SHORT).show();
			//	}
				else{
				Intent i=new Intent(HomeActivity.this,WebViewActivity.class);
				i.putExtra("urls", urls);
				startActivity(i);
					finish();
				}
			}
		});
		
		 
	}
	// Invoke displayInterstitial() when you are ready to display an interstitial.
	  public void displayInterstitial() {

	  }

	/*AdListener.MraidAdListener adlistener = new AdListener.MraidAdListener() {

	     @Override
	     public void onAdClickListener()
	     {
	     //This will get called when ad is clicked.
	     }

	     @Override
	     public void onAdLoadedListener()
	     {
	     //This will get called when an ad has loaded.
	     }

	     @Override
	     public void onAdLoadingListener()
	     {
	     //This will get called when a rich media ad is loading.
	     }

	     @Override
	     public void onAdExpandedListner()
	     {
	     //This will get called when an ad is showing on a user's screen. This may cover the whole UI.
	     }

	     @Override
	     public void onCloseListener()
	     {
	     //This will get called when an ad is closing/resizing from an expanded state.
	     }

	     @Override
	     public void onErrorListener(String message)
	     {
	     //This will get called when any error has occurred. This will also get called if the SDK notices any integration mistakes.
	     }
	     @Override
	      public void noAdAvailableListener() {
	      //this will get called when ad is not available 
			
	     }
	};*/
	
/*	 AdListener adCallbackListener=new AdListener() {
        
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
	     };
	*/
	private void initUI() {
		selected = false;
		typeSpinner = (Spinner) findViewById(R.id.spinner1);
		typeSpinner.setAdapter(typeSpinnerAdapter);
		typeSpinner.setOnItemSelectedListener(typeSelectedListener);
		typeSpinner.setOnTouchListener(typeSpinnerTouchListener);
		mInflator = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
		//Log.d(TAG, "UI Initialized");
	}
	private SpinnerAdapter typeSpinnerAdapter = new BaseAdapter() {

		
		private String[] data = { "All INDIA VEHICLES", "Andhra Pradesh", "Chattisgarh", "Chandigarh", "Madhya Pradesh", "Odisha", "Telangana", "Tripura" };
		private int count = 8;

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			if (convertView == null) {
				convertView = mInflator.inflate(R.layout.row_spinner, null);
			}
			text = (TextView) convertView.findViewById(R.id.spinnerTarget);
			if (!selected) {
				text.setText("Select State");
			} 
		else {
				text.setText(data[position]);
				String tct= (String) text.getText();
				System.out.println("this is str al"+tct);
				
				if(tct.equals("Madhya Pradesh"))
				{
					urls="http://mis.mptransport.org/MPLogin/eSewa/VehicleSearch.aspx";
				}
				if(tct.equals("All INDIA VEHICLES"))
				{
					urls="https://parivahan.gov.in/rcdlstatus/?pur_cd=102";
				}
				//if(tct.equals("TRACE VEHICLE LOCATION (NEW)"))
				//{
				//	urls="https://vahan.nic.in/nrservices/faces/user/jsp/SearchStatus.jsp";
				//}
				if(tct.equals("Chattisgarh"))
				{
					urls="http://olps.cgtransport.org/Esewa/ESewa/VehicleSpecialSearch.aspx";
				}
				//if(tct.equals("Rajasthan"))
				//{
					//urls="http://police.rajasthan.gov.in/VehicleSearch.aspx";
				//}
				//if(tct.equals("Jharkhand"))
				//{
				///	urls="https://vahan.jhr.nic.in/SRReports/";
				//}
				if(tct.equals("Andhra Pradesh"))
				{
					urls="https://aptransport.in/APCFSTONLINE/Reports/VehicleRegistrationSearch.aspx";
				}
				//if(tct.equals("Delhi"))
				//{
					//urls="http://vahan.dl.nic.in/SRReports/";
				//}
				if(tct.equals("Telangana"))
				{
					urls="https://aptransport.in/TGCFSTONLINE/Reports/VehicleRegistrationSearch.aspx";
				}
				//if(tct.equals("Andaman and Nicobar Islands"))
				{
					//urls="http://andssw1.and.nic.in/mvd/Forms/Regn/RegnDetails.aspx";
				}
				//if(tct.equals("Karnataka"))
				{
					//urls="http:164.100.80.164/vehiclesearch/";
				}
				if(tct.equals("Odisha"))
				{
					urls="http://as2.ori.nic.in:8080/web/public.jsp";
				}
				//if(tct.equals("Meghalaya"))
				//{
					//urls="https://vahan.meg.nic.in/SRReports/";
				//}
				//if(tct.equals("Haryana"))
				//{
				//	urls="https://haryanatransport.gov.in/SRReports/vahan/report/jsp/Search.jsp";
				//}
				//if(tct.equals("Himachal Pradesh"))
				//{
				//	urls="https://vahan.hp.nic.in/SRReports/vahan/report/jsp/Search.jsp";
				//}
				if(tct.equals("Tripura"))
				{
					urls="http://tsu.trp.nic.in/transport/public/vahan/RegistrationSearch_citz.aspx";
				}
				if(tct.equals("Chandigarh"))
				{
					urls="http://chdtransport.gov.in/Webpages/CheckRegistrationDetails.aspx";
				}
				//if(tct.equals("Delhi"))
				{
					//urls="http://vahan.dl.nic.in/SRReports/vahan/report/jsp/Search.jsp";
				}	
			}
			return convertView;
		}



		@Override
		public long getItemId(int position) {
			return position;
		}

		@Override
		public Object getItem(int position) {
			return data[position];
		}

		@Override
		public int getCount() {
			return count;
		}

		public View getDropDownView(int position, View convertView,
				ViewGroup parent) {
			if (convertView == null) {
				convertView = mInflator.inflate(
						android.R.layout.simple_spinner_dropdown_item, null);
			}
			text1 = (TextView) convertView.findViewById(android.R.id.text1);
		    text1.setText(data[position]);
			return convertView;
		};
	};

	private OnItemSelectedListener typeSelectedListener = new OnItemSelectedListener() {

		@Override
		public void onItemSelected(AdapterView<?> parent, View view,
				int position, long id) {
			Log.d(TAG, "user selected : "
					+ typeSpinner.getSelectedItem().toString());

		}

		@Override
		public void onNothingSelected(AdapterView<?> parent) {

		}
	};

	private OnTouchListener typeSpinnerTouchListener = new OnTouchListener() {

		@Override
		public boolean onTouch(View v, MotionEvent event) {
			selected = true;
			((BaseAdapter) typeSpinnerAdapter).notifyDataSetChanged();
			return false;
		}
	};

	/* (non-Javadoc)
	 * @see com.actionbarsherlock.app.SherlockActivity#onOptionsItemSelected(com.actionbarsherlock.view.MenuItem)
	 */
	
	
	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		// /Intent intent = new Intent(Intent.ACTION_MAIN);
		// intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		//    startActivity(intent);
		
		 moveTaskToBack(true);
	System.exit(1);
		this.finish();
		//onDestroy();
	//super.onBackPressed();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.home, menu);//Menu Resource, Menu
		return super.onCreateOptionsMenu(menu);
	}
	/* (non-Javadoc)
	 * @see com.actionbarsherlock.app.SherlockActivity#onCreateOptionsMenu(com.actionbarsherlock.view.Menu)
	 */
/*	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		com.actionbarsherlock.view.MenuInflater inflater=getSupportMenuInflater();
	    inflater.inflate(R.menu.home, menu);
		return super.onCreateOptionsMenu(menu);
	}*/
	@Override
	public boolean onOptionsItemSelected(android.view.MenuItem item) {
		// TODO Auto-generated method stub
		switch (item.getItemId()) {
		case R.id.gen:
			Intent i=new Intent(HomeActivity.this,InfoActivity.class);
			startActivity(i);
			break;

		 case R.id.faq:
				Intent i5=new Intent(HomeActivity.this,FAQActivity.class);
				startActivity(i5);
				break;
		case R.id.abt:
			Intent i4=new Intent(HomeActivity.this,GeneralActivity.class);
			startActivity(i4);
			break;
		default:
			return super.onOptionsItemSelected(item);			

		
	}
		
		return false;
	}

	/** Called when leaving the activity */
	@Override
	public void onPause() {

		super.onPause();
	}

	/** Called when returning to the activity */
	@Override
	public void onResume() {
		super.onResume();

	}

	/** Called before the activity is destroyed */
	@Override
	protected void onDestroy() {
		if (adView != null) {
			adView.destroy();
		}
		super.onDestroy();
	}
}
