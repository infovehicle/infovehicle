package com.info.vehicle;

import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class GeneralActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general);

        TextView tv1 = (TextView) findViewById(R.id.textView3);
        TextView tv2 = (TextView) findViewById(R.id.textView2);
        TextView tv3 = (TextView) findViewById(R.id.textView4);
        tv1.setPaintFlags(tv1.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        tv2.setPaintFlags(tv1.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);
        tv3.setPaintFlags(tv1.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

        tv2.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Intent i = new Intent(GeneralActivity.this, MailActivity.class);
                startActivity(i);
            }
        });

        tv1.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                //String urlToShare = urlfbshare;
                //System.out.println(".....facebook..."+urlToShare);
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                // intent.putExtra(Intent.EXTRA_SUBJECT, "Foo bar"); // Has no effect!
                //intent.putExtra(Intent.EXTRA_TEXT, urlToShare);

                // See if official Facebook app is found
        /*		boolean facebookAppFound = false;
				List<ResolveInfo> matches = getPackageManager().queryIntentActivities(intent, 0);
				for (ResolveInfo info : matches) {
				    if (info.activityInfo.packageName.toLowerCase().startsWith("com.facebook")) {
				        intent.setPackage(info.activityInfo.packageName);
				        facebookAppFound = true;
				        break;
				    }
				}

				// As fallback, launch sharer.php in a browser
				if (!facebookAppFound) {
				*/
                String sharerUrl = "https://www.facebook.com/infovehicle";
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse(sharerUrl));
                //	}

                startActivity(intent);
            }
        });

        tv3.setOnClickListener(new OnClickListener() {

            @Override
            public void onClick(View v) {
                //String urlToShare = urlfbshare;
                //System.out.println(".....facebook..."+urlToShare);
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setType("text/plain");
                // intent.putExtra(Intent.EXTRA_SUBJECT, "Foo bar"); // Has no effect!
                //intent.putExtra(Intent.EXTRA_TEXT, urlToShare);

                // See if official Facebook app is found
                //boolean twitterAppFound = false;
                ///	List<ResolveInfo> matches = getPackageManager().queryIntentActivities(intent, 0);
                //	for (ResolveInfo info : matches) {
                ///    if (info.activityInfo.packageName.toLowerCase().startsWith("com.twitter")) {
                //        intent.setPackage(info.activityInfo.packageName);
                //        twitterAppFound = true;
                //        break;
                //    }
                //}

                // As fallback, launch sharer.php in a browser
                //if (!twitterAppFound) {
                String sharerUrl = "https://twitter.com/infovehicle";
                intent = new Intent(Intent.ACTION_VIEW, Uri.parse(sharerUrl));
                //}

                startActivity(intent);


            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // TODO Auto-generated method stub
		/*com.actionbarsherlock.view.MenuInflater inflater=getSupportMenuInflater();
	    inflater.inflate(R.menu.info_activty, menu);*/
        getMenuInflater().inflate(R.menu.info_activty, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(
            MenuItem item) {
        switch (item.getItemId()) {


            case R.id.faq:
                Intent i5 = new Intent(GeneralActivity.this, FAQActivity.class);
                startActivity(i5);
                break;

            case R.id.gen:
                Intent i = new Intent(GeneralActivity.this, InfoActivity.class);
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
        Intent i = new Intent(GeneralActivity.this, HomeActivity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(i);

        super.onBackPressed();
        finish();
    }

}

