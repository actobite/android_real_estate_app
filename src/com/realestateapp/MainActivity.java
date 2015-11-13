package com.realestateapp;

import java.net.MalformedURLException;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import java.net.URL;
import android.R.string;
import android.support.v7.app.ActionBarActivity;
import android.app.ActionBar;
import android.app.TabActivity;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnClickListener;
import com.android.*;
public class MainActivity extends ActionBarActivity{
Spinner spinner1; Button btnSearch;
String streetInput;
String cityInput;
String stateInput;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		addListenerOnButton();
		addListenerOnSpinnerItemSelection();
		this.setTitle("Real Estate Search App");
				
	}
	 public void addListenerOnSpinnerItemSelection() {
			spinner1 = (Spinner) findViewById(R.id.spinner1);
			spinner1.setOnItemSelectedListener(new CustomOnItemSelectedListener());
		  }
		 
		  // get the selected dropdown list value
		  public void addListenerOnButton() {
		 
			spinner1 = (Spinner) findViewById(R.id.spinner1);
			//spinner2 = (Spinner) findViewById(R.id.spinner2);
			btnSearch = (Button) findViewById(R.id.btnSearch);
		 
			btnSearch.setOnClickListener(new OnClickListener() {
		 
			  @Override
			  public void onClick(View v) {
		 
			 /*   Toast.makeText(MainActivity.this,
				"OnClickListener : " + 
		                "\nSpinner 1 : "+ String.valueOf(spinner1.getSelectedItem()) ,
					Toast.LENGTH_SHORT).show(); */
				  
				  //http://csci571awsapp-env.elasticbeanstalk.com/?streetInput=2636%20Menlo%20Avenue&cityInput=Los%20Angeles&stateInput=CA
				  //DO VALIDATION
				  
				  EditText mEdit   = (EditText)findViewById(R.id.streetInput);
				  streetInput=mEdit.getText().toString();
				  mEdit   = (EditText)findViewById(R.id.cityInput);
				  cityInput=mEdit.getText().toString();
				 streetInput=streetInput.replace(" ", "%20");
				 cityInput=cityInput.replace(" ","%20");
				  stateInput=String.valueOf(spinner1.getSelectedItem()) ;
				  String urlLink="http://csci571awsapp-env.elasticbeanstalk.com/?streetInput="+streetInput+"&cityInput="+cityInput+"&stateInput="+stateInput;
				  GetSearchResults searchResults=null;
				  TextView tv=(TextView) findViewById(R.id.errorText); int flag=1;
				  if (streetInput.matches("^.*[^a-zA-Z0-9 ].*$")==true || cityInput.matches("^.*[^a-zA-Z ].*$")==true)
				  {
					  tv.setText("Invalid input!");
					  tv.setVisibility(View.VISIBLE);
				  }
				  TextView e=null;
				   if(streetInput.isEmpty())
				  {  e=(TextView) findViewById(R.id.err1);
				  e.setText("This field is required");flag=0;
				  }  
				   if(cityInput.isEmpty())
				  { e=(TextView) findViewById(R.id.err2);
				  e.setText("This field is required");flag=0;
				  } 
				  
				  if(flag==1)
				  searchResults=(GetSearchResults) new GetSearchResults(MainActivity.this).execute(urlLink);
				
			  } 
		 
			});
		  }
}
