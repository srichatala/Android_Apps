package com.example.universaltokensystem;

import java.io.IOException;
import java.io.InputStream;
import java.util.EmptyStackException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import com.google.gson.Gson;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); 
        Button submit = (Button)findViewById(R.id.btnLogin);
        submit.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Button submit = (Button)findViewById(R.id.btnLogin);
				//EditText StudentID = (EditText)findViewById(R.id.txtStudentID);
				submit.setClickable(false);
				new RestOperations().execute();
				//StudentID.setText("");
				
			}
		});
    }
    
    public class RestOperations extends AsyncTask<Void, Void, String> {
    	protected String getASCIIContentFromEntity(HttpEntity entity) throws IllegalStateException, IOException {
 	       InputStream in = entity.getContent();
 	         StringBuffer out = new StringBuffer();
 	         int n = 1;
 	         while (n>0) {
 	             byte[] b = new byte[4096];
 	             n =  in.read(b);
 	             if (n>0) out.append(new String(b, 0, n));
 	         }
 	         return out.toString();
 	    }
    	final HttpClient httpClient = new DefaultHttpClient();
    	/*String content;
    	String error;*/
    	ProgressDialog progressDailog = new ProgressDialog(MainActivity.this);
    	//String Data;
    	@Override
    	protected void onPreExecute() {
    		// TODO Auto-generated method stub
    		super.onPreExecute();
    		
    		progressDailog.setTitle("Please wait...");
    		progressDailog.show();
    	}
    	
    	@Override
    	protected String doInBackground(Void... params) {
    		// TODO Auto-generated method stub
    		HttpClient httpClient = new DefaultHttpClient();
			HttpContext localContext = new BasicHttpContext();
			EditText StudentID = (EditText)findViewById(R.id.txtStudentID);
			String SId = StudentID.getText().toString().trim();	
			String restStudentURL = "http://cctoken.azurewebsites.net/api/students/?StudentID="+SId;
            HttpGet httpGet = new HttpGet(restStudentURL);
            String text = null;
            try {
                  HttpResponse response = httpClient.execute(httpGet, localContext);
                  HttpEntity entity = response.getEntity();
                  text = getASCIIContentFromEntity(entity);
            } catch (Exception e) {
           	 return e.getLocalizedMessage();
            }
            return text;
    	}

    	@Override
    	protected void onPostExecute(String result) {
    		// TODO Auto-generated method stub
    		super.onPostExecute(result);
    		
    		//Gson gson = new Gson();
    		//String data = gson.toJson(result);
    		if (result.equals("[]")) {
    			TextView errorMSG = (TextView)findViewById(R.id.error);
				errorMSG.setText("Invalid StudentID");
				progressDailog.dismiss();
			}else{
				Intent intent = new Intent(MainActivity.this,Campus.class);
				startActivity(intent);
				progressDailog.dismiss();
			}
    	}
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
