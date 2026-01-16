package com.info.vehicle;




import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

public class InfoActivity extends AppCompatActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_info);
		
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// TODO Auto-generated method stub
	/*	com.actionbarsherlock.view.MenuInflater inflater=getSupportMenuInflater();
	    inflater.inflate(R.menu.info_activty, menu);*/
		getMenuInflater().inflate(R.menu.info_activty, menu);
		return super.onCreateOptionsMenu(menu);
	}

	
	@Override
	public boolean onOptionsItemSelected(
			MenuItem item) {
switch (item.getItemId()) {

		case R.id.abt:
			Intent i4=new Intent(InfoActivity.this,GeneralActivity.class);
			startActivity(i4);
			break;
		 case R.id.faq:
				Intent i5=new Intent(InfoActivity.this,FAQActivity.class);
				startActivity(i5);
				break;	
			
		default:
		return super.onOptionsItemSelected(item);
	}
		return false;
	}

	@Override
	public void onBackPressed() {
		// TODO Auto-generated method stub
		Intent i=new Intent(InfoActivity.this,HomeActivity.class);
		i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
		startActivity(i);
		
		super.onBackPressed();
		finish();
	}
}
