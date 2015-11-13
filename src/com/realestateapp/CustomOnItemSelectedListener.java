package com.realestateapp;

import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.TextView;
import android.widget.Toast;
 
public class CustomOnItemSelectedListener implements OnItemSelectedListener {
 
  public void onItemSelected(AdapterView<?> parent, View view, int pos,long id) {
/*	Toast.makeText(parent.getContext(), 
		"OnItemSelectedListener : " + pos + "\n" + parent.getItemAtPosition(pos).toString(),
		Toast.LENGTH_SHORT).show(); */
	  ((TextView) parent.getChildAt(0)).setTextColor(Color.WHITE);
       if(pos==0)
	  {
		  //do validation
	  }
  }
 
  @Override
  public void onNothingSelected(AdapterView<?> arg0) {
	// TODO Auto-generated method stub
  }
 
}