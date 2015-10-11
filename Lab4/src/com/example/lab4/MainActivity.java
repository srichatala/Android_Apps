package com.example.lab4;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Paint.Style;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.LinearLayout;

public class MainActivity extends Activity {
	private float w = 35;
	private float x = 45;
	private float y = 45;
	private float z = 60;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		Paint paint = new Paint();
		paint.setColor(Color.BLUE);
		paint.setStyle(Style.STROKE);
		paint.setStrokeWidth(3);
		Bitmap bg = Bitmap.createBitmap(480,800,Bitmap.Config.ARGB_8888);
		Canvas can = new Canvas(bg);
		Shader mShader = new LinearGradient(0, 0, 400, 400, new int[] {
		Color.RED, Color.BLUE },
         null, Shader.TileMode.MIRROR);  // CLAMP MIRROR REPEAT
         paint.setShader(mShader);
		int i = 0;
		while(i<25){
			for(int j=0;j<40;j++){
				RectF rectF = new RectF(w,x,y,z);
				can.drawArc(rectF, 0, 180, false, paint);
				w = y;
				y = w+10;
			}
			printf("\n");
			w = 35;
			x = z+5;
			z = x+15;
			y = 45;
			i++;
		}
		LinearLayout l = (LinearLayout)findViewById(com.example.lab4.R.id.drawarea);
		l.setBackgroundDrawable(new BitmapDrawable(bg));
	}

	private void printf(String string) {
		// TODO Auto-generated method stub
		
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
