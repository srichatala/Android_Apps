package com.example.microproject;

import java.util.Random;

import com.example.microproject.R.string;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.*;

public class MainActivity extends Activity {

	final Context context = this;
	int finalScore = 100;
	int chances = 10;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		DialogBuilder();
		final Button submit = (Button)findViewById(R.id.btnSubmit);
		final EditText txtNumber = (EditText)findViewById(R.id.txtNumber);
		final TextView Score = (TextView)findViewById(R.id.lblScore);
		final TextView Chances = (TextView)findViewById(R.id.lblChances);
		Score.setText(String.valueOf(finalScore));
		Chances.setText(String.valueOf(chances));
		//Click event to compare the random and input number
		submit.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int min = 0;
				int max =100;
				int randomNumber;
				int gameValue = Integer.parseInt(txtNumber.getText().toString());
				Random r = new Random();
				randomNumber = r.nextInt(max - min + 1) + min;
				Score.setText(String.valueOf(randomNumber));
				if(chances > 0){
					if(gameValue < randomNumber){
						finalScore = finalScore -10;
						chances--;
						Score.setText(String.valueOf(finalScore));
						Chances.setText(String.valueOf(chances));
						Toast.makeText(getApplicationContext(), "The number you entered is less than the number choosen by the program",
								   Toast.LENGTH_LONG).show();
					}
					if(gameValue > randomNumber){
						finalScore = finalScore -10;
						chances--;
						Score.setText(String.valueOf(finalScore));
						Chances.setText(String.valueOf(chances));
						Toast.makeText(getApplicationContext(), "The number you entered is greater than the number choosen by the program",
								   Toast.LENGTH_LONG).show();
					}
					if(gameValue == randomNumber){
						Toast.makeText(getApplicationContext(), "CONGRATUALTION, You won the game and your score is",
								   Toast.LENGTH_LONG).show();
					}
				}else{
					Score.setText("0");
					Chances.setText("0");
					Toast.makeText(getApplicationContext(), "SORRY GAME OVER",
							   Toast.LENGTH_LONG).show();
					DialogBuilder();
					
				}	
			}
		});
	}

	private void DialogBuilder() {
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(context);
		// set title
		alertDialogBuilder.setTitle("Gussing Game");
		// set dialog message
		alertDialogBuilder
			.setMessage("Would you like to play Gussing Game?")
			.setCancelable(false)
			.setPositiveButton("Yes",new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,int id) {
					dialog.cancel();
				}
			  })
			.setNegativeButton("No",new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface dialog,int id) {
					MainActivity.this.finish();
				}
			});
			//Create dialog 
			AlertDialog alertDialog = alertDialogBuilder.create();
			//Display dialog 
			alertDialog.show();
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
