package com.example.myapp;

import android.support.v7.app.ActionBarActivity;
import android.R.string;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.*;

public class MainActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Button submit = (Button)findViewById(R.id.btnSubmit);
		submit.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				
				EditText firstname = (EditText)findViewById(R.id.txtFirstname);
				EditText lastname = (EditText)findViewById(R.id.txtLastname);
				EditText phoneno = (EditText)findViewById(R.id.txtPhoneno);
				EditText address = (EditText)findViewById(R.id.txtAddress);
				EditText email = (EditText)findViewById(R.id.txtEmail);
				
				String f_name = (firstname.getText().toString()); 
				
				TextView fname = (TextView)findViewById(R.id.lblFirstname);
				fname.setText(f_name);
				
				
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
