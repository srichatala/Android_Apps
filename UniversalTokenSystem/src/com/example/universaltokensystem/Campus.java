package com.example.universaltokensystem;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.example.universaltokensystem.MainActivity.RestOperations;
import com.example.universaltokensystem.R.string;
import com.google.gson.JsonArray;
import com.google.gson.annotations.JsonAdapter;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.ContactsContract.CommonDataKinds.StructuredName;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class Campus extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_campus);
		TextView sID = (TextView)findViewById(R.id.StudentID);
		Intent intent = getIntent();
		String studentList = getIntent().getExtras().getString("StudentInfo").toString();
		try {
			JSONArray stList = new JSONArray(studentList);
			for(int i = 0; i<stList.length();i++){
				JSONObject stObj = stList.getJSONObject(0);
				String st_FName = stObj.getString("Firstname");
				String st_LName = stObj.getString("Lastname");
				String st_FullName = "Welcome to CCToken System: " +st_FName+" "+st_LName;
				sID.setText(st_FullName);
			}
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		new RestOperations().execute();
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
	    	
	    	@Override
	    	protected void onPreExecute() {
	    		// TODO Auto-generated method stub
	    		super.onPreExecute();
	    		
	    	}
	    	
	    	@Override
	    	protected String doInBackground(Void... params) {
	    		// TODO Auto-generated method stub
	    		HttpClient httpClient = new DefaultHttpClient();
				HttpContext localContext = new BasicHttpContext();
				String restStudentURL = "http://cctoken.azurewebsites.net/api/campuses/";
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
	    		final ArrayList<String> items = new ArrayList<String>();		
	    		ListView listView = (ListView) findViewById(R.id.listCampus);
	    		try {
					JSONArray stList = new JSONArray(result);
					for(int i=0; i < stList.length() ; i++) {
					    JSONObject json_data = stList.getJSONObject(i);
					    int id=json_data.getInt("CampusId");
					    String name=json_data.getString("CampusName");
					    String address = json_data.getString("Address");
					    String Campus = name +  address;
					    items.add(Campus);
					}
					ArrayAdapter<String> mArrayAdapter = new ArrayAdapter<String>(Campus.this,android.R.layout.simple_expandable_list_item_1, items);
					listView.setAdapter(mArrayAdapter);
					listView.setOnItemClickListener(new OnItemClickListener() {

						@Override
						public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
							Toast.makeText(Campus.this,"Campus Selected", Toast.LENGTH_SHORT).show();
							
						}
					});
				} catch (JSONException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
	    	}
	    }		

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.campus, menu);
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
