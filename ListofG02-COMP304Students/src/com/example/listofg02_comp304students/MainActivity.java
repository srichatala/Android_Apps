package com.example.listofg02_comp304students;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		//drawingView = (DrawingView) findViewById(R.id.flag);
		Button alagu = (Button)findViewById(R.id.btnAlagu);
		Button vangli = (Button)findViewById(R.id.btnVangli);
		Button sandy = (Button)findViewById(R.id.btnSandy);
		Button sateesh = (Button)findViewById(R.id.btnSateesh);
		Button evlyn = (Button)findViewById(R.id.btnEvlyn);
		Button sri = (Button)findViewById(R.id.btnSri);
		final ImageView imgAlagu = (ImageView)findViewById(R.id.imgViewAlagu);
		final ImageView imgVangli = (ImageView)findViewById(R.id.imgViewVangli);
		final ImageView imgSandy = (ImageView)findViewById(R.id.imgViewSandy);
		final ImageView imgEvlyn = (ImageView)findViewById(R.id.imgViewEvlyn);
		final ImageView imgSatessh = (ImageView)findViewById(R.id.imgViewSateesh);
		final ImageView imgSri = (ImageView)findViewById(R.id.imgViewSri);
		
		alagu.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				imgAlagu.setVisibility(View.VISIBLE); 
			}
		});
		
		vangli.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				imgVangli.setVisibility(View.VISIBLE);
			}
		});
		
		sandy.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				imgSandy.setVisibility(View.VISIBLE);
			}
		});
		
		sateesh.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				imgSatessh.setVisibility(View.VISIBLE);
			}
		});
		
		evlyn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				imgEvlyn.setVisibility(View.VISIBLE);
			}
		});
		
		sri.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				imgSri.setVisibility(View.VISIBLE);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
