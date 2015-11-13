package com.realestateapp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class GetSearchResults extends AsyncTask<String, Integer, String>{
	Context context;
	public final static String EXTRA_MESSAGE = "com.realestateapp.MESSAGE";

//	public GetSearchResults () { }
    public  GetSearchResults(Context context) {
        this.context = context.getApplicationContext();
    }

	@Override
	protected String doInBackground(String... urls) {
		// TODO Auto-generated method stub
		DefaultHttpClient httpclient = new DefaultHttpClient();
       HttpGet httpget =new HttpGet(urls[0]);
       // HttpGet httpget=new HttpGet("http://csci571awsapp-env.elasticbeanstalk.com/?streetInput=2636%20Menlo%20Avenue&cityInput=Los%20Angeles&stateInput=CA");
		HttpResponse response = null;   StringBuffer sb=null;   String line = "";
		try {
		response = httpclient.execute(httpget);

		if (response.getStatusLine().getStatusCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
			   + response.getStatusLine().getStatusCode());
		}
		BufferedReader in = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));
      sb = new StringBuffer("");
       // String NL = System.getProperty("line.separator");
     //  while ((line = in.readLine()) != null) {                    
     //       sb.append(line);
    //    } 
      line=in.readLine();
        in.close();
		}
		catch (Exception e)
		{
			String l=e.toString();
			System.out.println(l);
			return l;
		}
		
       // String result = sb.toString();
       // Log.v("My Response :: ", result);
       // return result;
		return line;
	}
	protected void onProgressUpdate(Integer... progress) {
      
    }

    protected void onPostExecute(String result) 
    {
    super.onPostExecute(result);
    Intent intent = new Intent(context, ResultActivity.class);
 //   EditText editText = (EditText) findViewById(R.id.edit_message);
  //  String message = editText.getText().toString();
    intent.putExtra(EXTRA_MESSAGE, result);
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    context.startActivity(intent);
  //  context.startActivity(new Intent(context, ResultActivity.class));
    }
}
