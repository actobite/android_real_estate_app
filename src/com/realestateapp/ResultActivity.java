package com.realestateapp;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.Locale;

import org.json.JSONObject;

import android.annotation.SuppressLint;
import android.app.ActionBar;
import android.app.ActionBar.LayoutParams;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

public class ResultActivity extends ActionBarActivity {
String msg=null;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_result);
		  
this.setTitle("Results from Zillow");
		Intent intent = getIntent();
		msg = intent.getStringExtra(GetSearchResults.EXTRA_MESSAGE);
		
	/*	 TextView textView = new TextView(this);
		    textView.setTextSize(17);
		    textView.setText(msg);
		    // Set the text view as the activity layout
		    setContentView(textView); */
		
		    JSONObject json=null;
		    String homedetails="", propertyType="", yearBuilt="", lotSize="", finishedArea="", bathrooms="", bedrooms="", taxAssessYear="";
		    String taxAssess="", lastSoldPrice="", lastSoldDate="", zestimate="",zestimateDate="",overallChange="",street="",city="",state="",zipcode="",img1="",img2="",img3="",errorField="";
		    String allTimePropLow="",allTimePropHigh="",rentChange="",allTimeRentLow="",allTimeRentHigh="";
		    String rentZestAmt="",rentZestDate="";String lotSize1="",finishedArea1="",taxAssess1="",lastSoldPrice1="",zestimate1="",overallChange1="",allTimePropLow1="",allTimePropHigh1="",rentChange1="";
		    String allTimeRentLow1="",allTimeRentHigh1="",rentZestAmt1="";
		    DecimalFormat formatter = (DecimalFormat) NumberFormat.getInstance(Locale.US);
		    DecimalFormatSymbols symbols = formatter.getDecimalFormatSymbols();
		    symbols.setGroupingSeparator(' ');
		    try {

		        json = new JSONObject(msg);

		        Log.d("My App", json.toString());

		    } catch (Throwable t) {
		        Log.e("My App", "Could not parse malformed JSON");
		    }
		try
		
		{
			errorField=json.getString("error");
			if(errorField.compareTo("0 ")==0)
			{
		    homedetails=json.getString("homedetails");
		    propertyType=json.getString("propertyType");
		    yearBuilt=json.getString("yearBuilt");
		    
		    lotSize1=json.getString("lotSizeSqFt"); 
		    Float f=Float.parseFloat(lotSize1);
		    lotSize=(formatter.format(f.longValue()));
		   
		    finishedArea1=json.getString("finishedSqFt"); 
		    f=Float.parseFloat(finishedArea1); 
		    finishedArea=(formatter.format(f.longValue()));
		    
		    bathrooms=json.getString("bathrooms");
		    bedrooms=json.getString("bedrooms");
		    taxAssessYear=json.getString("taxAssessmentYear");
		    
		    taxAssess1=json.getString("taxAssessment"); 
		    f=Float.parseFloat(taxAssess1); 
		    taxAssess=(formatter.format(f.longValue()));
		    
		    lastSoldPrice1=json.getString("lastSoldPrice"); 
		    f=Float.parseFloat(lastSoldPrice1); 
		    lastSoldPrice=(formatter.format(f.longValue()));
		    
		    lastSoldDate=json.getString("lastSoldDate");
		    
		    zestimate1=json.getString("zestimate"); 
		    f=Float.parseFloat(zestimate1); 
		    zestimate=(formatter.format(f.longValue()));
		    
		    zestimateDate=json.getString("zestimateDate");
		    
		    overallChange1=json.getString("overallChangeThirtyDays");
		    f=Float.parseFloat(overallChange1); 
		    overallChange=(formatter.format(f.longValue()));
		
		    allTimePropLow1=json.getString("allTimePropLow"); 
		    f=Float.parseFloat(allTimePropLow1);
		    allTimePropLow=(formatter.format(f.longValue()));
	
		    allTimePropHigh1=json.getString("allTimePropHigh");
		    f=Float.parseFloat(allTimePropHigh1); 
		    allTimePropHigh=(formatter.format(f.longValue()));
		
		    rentChange1=json.getString("rentChangeThirtyDays");
		    f=Float.parseFloat(rentChange1);
		    rentChange=(formatter.format(f.longValue()));
		
		    allTimeRentLow1=json.getString("allTimeRentLow");
		    f=Float.parseFloat(allTimeRentLow1); 
		    allTimeRentLow=(formatter.format(f.longValue()));
		
		    allTimeRentHigh1=json.getString("allTimeRentHigh");
		    f=Float.parseFloat(allTimeRentHigh1); 
		    allTimeRentHigh=(formatter.format(f.longValue()));
		
		    rentZestAmt1=json.getString("rentZestimateAmount");
		    f=Float.parseFloat(rentZestAmt1); 
		    rentZestAmt=(formatter.format(f.longValue()));
		
		    rentZestDate=json.getString("rentZestimateDate");
		    street=json.getString("street");
		    city=json.getString("city");
		    state=json.getString("state");
		    zipcode=json.getString("zipcode");
		    img1=json.getString("imgurl1");
		    img2=json.getString("imgurl2");
		    img3=json.getString("imgurl3");
			}
		}
		catch(Exception e)
		{
		String error="Error while parsing";
		}
		ScrollView s1=(ScrollView)findViewById(R.id.scrollView1);
		 
		//TableLayout lay1 = new TableLayout(this);
		TableLayout tabLay=(TableLayout) findViewById(R.id.tableLayout1);
		TextView  t1=null,t2=null; TableRow row1=null;
		
		//row 1
		row1=new TableRow(this);
		   row1.setId(1); //row1
		   TableRow.LayoutParams  params1=new TableRow.LayoutParams(LayoutParams.MATCH_PARENT,LayoutParams.WRAP_CONTENT);
		   TableRow.LayoutParams  params2=new TableRow.LayoutParams(0,LayoutParams.WRAP_CONTENT, 1.0f);
		   row1.setLayoutParams(params1);
		    row1.setGravity(Gravity.CENTER_HORIZONTAL);
		    t1=new TextView(this);
		    t1.setId(11);
		    t1.setTextSize(15);
		    t1.setGravity(Gravity.LEFT);
		    t1.setLayoutParams(params2);
		    t1.setText("See more details on Zillow");
		    Button btn=new Button(this);
		    btn.setBackgroundResource(R.drawable.fbshare);
		    btn.setId(12);
		    btn.setLayoutParams(params2);
		    row1.addView(t1);
		    row1.addView(btn);
		    tabLay.addView(row1);
		
		    //row2   
		    TableRow row2=new TableRow(this);
			   row2.setId(2); //row2
			   row2.setLayoutParams(params1);
			    row2.setGravity(Gravity.CENTER_HORIZONTAL);
			    t1=new TextView(this);
			    t1.setId(21);
			    t1.setTextSize(15);
			    t1.setGravity(Gravity.LEFT);
			    t1.setLayoutParams(params2);
			    String linkText="<a href=\""+homedetails+"\">"+street+","+city+","+state+" - "+zipcode+"</a>";
			    t1.setText(Html.fromHtml(linkText));
			    t1.setMovementMethod(LinkMovementMethod.getInstance());
			    row2.addView(t1);
			    tabLay.addView(row2);

			    //row3
			    TableRow row3=new TableRow(this);
				   row3.setId(3); //row3
				   row3.setLayoutParams(params1);
				    row3.setGravity(Gravity.CENTER_HORIZONTAL);
				    t1=new TextView(this);
				    t1.setId(31);
				    t1.setTextSize(15);
				    t1.setGravity(Gravity.LEFT);
				    t1.setLayoutParams(params2);
				    t1.setText("Property Type"); 
				    t2=new TextView(this);
				    t2.setId(42);
				    t2.setTextSize(15);
				    t2.setGravity(Gravity.RIGHT);
				    t2.setLayoutParams(params2);
				    t2.setText(propertyType);
				    row3.addView(t1);
				    row3.addView(t2);
				    tabLay.addView(row3);
				    
				  //row4
				    TableRow row4=new TableRow(this);
					   row4.setId(4); //row4
					   row4.setLayoutParams(params1);
					    row4.setGravity(Gravity.CENTER_HORIZONTAL);
					    t1=new TextView(this);
					    t1.setId(41);
					    t1.setTextSize(15);
					    t1.setGravity(Gravity.LEFT);
					    t1.setLayoutParams(params2);
					    t1.setText("Year Built"); 
					    t2=new TextView(this);
					    t2.setId(42);
					    t2.setTextSize(15); t2.setGravity(Gravity.RIGHT);
					    t2.setLayoutParams(params2);
					    t2.setText(yearBuilt);
					    row4.addView(t1);
					    row4.addView(t2);
					    tabLay.addView(row4);
					    
					  //row5
					    TableRow row5=new TableRow(this);
						   row5.setId(5); //row5
						   row5.setLayoutParams(params1);
						    row5.setGravity(Gravity.CENTER_HORIZONTAL);
						    t1=new TextView(this);
						    t1.setId(51);
						    t1.setTextSize(15);
						    t1.setGravity(Gravity.LEFT);
						    t1.setLayoutParams(params2);
						    t1.setText("Lot Size"); 
						    t2=new TextView(this);
						    t2.setId(52);
						    t2.setTextSize(15); t2.setGravity(Gravity.RIGHT);
						    t2.setLayoutParams(params2);
						    t2.setText(lotSize+"Sq.Ft.");
						    row5.addView(t1);
						    row5.addView(t2);
						    tabLay.addView(row5);
						    
							  //row6
							    TableRow row6=new TableRow(this);
								   row6.setId(6); //row6
								   row6.setLayoutParams(params1);
								    row6.setGravity(Gravity.CENTER_HORIZONTAL);
								    t1=new TextView(this);
								    t1.setId(61);
								    t1.setTextSize(15);
								    t1.setGravity(Gravity.LEFT);
								    t1.setLayoutParams(params2);
								    t1.setText("Finished Area"); 
								    t2=new TextView(this);
								    t2.setId(62);
								    t2.setTextSize(15);
								    t2.setGravity(Gravity.RIGHT);   t2.setLayoutParams(params2);
								    t2.setText(finishedArea+"Sq.Ft.");
								    row6.addView(t1);
								    row6.addView(t2);
								    tabLay.addView(row6);
		    
								    //row7
								    TableRow row7=new TableRow(this);
									   row7.setId(7); //row7
									   row7.setLayoutParams(params1);
									    row7.setGravity(Gravity.CENTER_HORIZONTAL);
									    t1=new TextView(this);
									    t1.setId(71);
									    t1.setTextSize(15);
									    t1.setGravity(Gravity.LEFT);
									    t1.setLayoutParams(params2);
									    t1.setText("Bathrooms"); 
									    t2=new TextView(this);
									    t2.setId(72);
									    t2.setTextSize(15);
									    t2.setGravity(Gravity.RIGHT);
									    t2.setLayoutParams(params2);
									    t2.setText(bathrooms);
									    row7.addView(t1);
									    row7.addView(t2);
									    tabLay.addView(row7);

									    //row8
									    TableRow row8=new TableRow(this);
										   row8.setId(8); //row8
										   row8.setLayoutParams(params1);
										    row8.setGravity(Gravity.CENTER_HORIZONTAL);
										    t1=new TextView(this);
										    t1.setId(81);
										    t1.setTextSize(15);
										    t1.setGravity(Gravity.LEFT);
										    t1.setLayoutParams(params2);
										    t1.setText("Bedrooms"); 
										    t2=new TextView(this);
										    t2.setId(82);
										    t2.setTextSize(15);
										    t2.setGravity(Gravity.RIGHT);
										    t2.setLayoutParams(params2);
										    t2.setText(bedrooms);
										    row8.addView(t1);
										    row8.addView(t2);
										    tabLay.addView(row8); 
										    
										    //row9
										    TableRow row9=new TableRow(this);
											   row9.setId(9); //row9
											   row9.setLayoutParams(params1);
											    row9.setGravity(Gravity.CENTER_HORIZONTAL);
											    t1=new TextView(this);
											    t1.setId(91);
											    t1.setTextSize(15);
											    t1.setGravity(Gravity.LEFT);
											    t1.setLayoutParams(params2);
											    t1.setText("Tax Assessment Year"); 
											    t2=new TextView(this);
											    t2.setId(92);
											    t2.setTextSize(15);
											    t2.setGravity(Gravity.RIGHT);
											    t2.setLayoutParams(params2);
											    t2.setText(taxAssessYear);
											    row9.addView(t1);
											    row9.addView(t2);
											    tabLay.addView(row9);
							
											    //row10
											    TableRow row10=new TableRow(this);
												   row10.setId(10); //row10
												   row10.setLayoutParams(params1);
												    row10.setGravity(Gravity.CENTER_HORIZONTAL);
												    t1=new TextView(this);
												    t1.setId(101);
												    t1.setTextSize(15);
												    t1.setGravity(Gravity.LEFT);
												    t1.setLayoutParams(params2);
												    t1.setText("Tax Assessment"); 
												    t2=new TextView(this);
												    t2.setId(102);
												    t2.setTextSize(15);
												    t2.setGravity(Gravity.RIGHT);
												    t2.setLayoutParams(params2);
												    t2.setText(taxAssess);
												    row10.addView(t1);
												    row10.addView(t2);
												    tabLay.addView(row10);
												    
												    //row11
												    TableRow row11=new TableRow(this);
													   row11.setId(11); //row11
													   row11.setLayoutParams(params1);
													    row11.setGravity(Gravity.CENTER_HORIZONTAL);
													    t1=new TextView(this);
													    t1.setId(111);
													    t1.setTextSize(15);
													    t1.setGravity(Gravity.LEFT);
													    t1.setLayoutParams(params2);
													    t1.setText("Last Sold Price"); 
													    t2=new TextView(this);
													    t2.setId(112);
													    t2.setTextSize(15); t2.setGravity(Gravity.RIGHT);
													    t2.setLayoutParams(params2);
													    t2.setText(lastSoldPrice);
													    row11.addView(t1);
													    row11.addView(t2);
													    tabLay.addView(row11);
													 
													    //row12
													    TableRow row12=new TableRow(this);
														   row12.setId(12); //row12
														   row12.setLayoutParams(params1);
														    row12.setGravity(Gravity.CENTER_HORIZONTAL);
														    t1=new TextView(this);
														    t1.setId(121);
														    t1.setTextSize(15);
														    t1.setGravity(Gravity.LEFT);
														    t1.setLayoutParams(params2);
														    t1.setText("Last Sold Date"); 
														    t2=new TextView(this);
														    t2.setId(122);
														    t2.setTextSize(15); t2.setGravity(Gravity.RIGHT);
														    t2.setLayoutParams(params2);
														    t2.setText(lastSoldDate);
														    row12.addView(t1);
														    row12.addView(t2);
														    tabLay.addView(row12);
														    
														    //row13
														    TableRow row13=new TableRow(this);
															   row13.setId(13); //row12
															   row13.setLayoutParams(params1);
															    row13.setGravity(Gravity.CENTER_HORIZONTAL);
															    t1=new TextView(this);
															    t1.setId(131);
															    t1.setTextSize(15);
															    t1.setGravity(Gravity.LEFT);
															    t1.setLayoutParams(params2);
															    t1.setText("Zestimate \u00ae Property Estimate as of " + zestimateDate); 
															    t2=new TextView(this);
															    t2.setId(132);
															    t2.setTextSize(15); t2.setGravity(Gravity.RIGHT);
															    t2.setLayoutParams(params2);
															    t2.setText(zestimate);
															    row13.addView(t1);
															    row13.addView(t2);
															    tabLay.addView(row13);
															    
															    //row14
															    TableRow row14=new TableRow(this);
																   row14.setId(14); //row12
																   row14.setLayoutParams(params1);
																    row14.setGravity(Gravity.CENTER_HORIZONTAL);
																    t1=new TextView(this);
																    t1.setId(141);
																    t1.setTextSize(15);
																    t1.setGravity(Gravity.LEFT);
																    t1.setLayoutParams(params2);
																    t1.setText("30 Days Overall Change"); 
																    t2=new TextView(this);
																    t2.setId(142);
																    t2.setTextSize(15); t2.setGravity(Gravity.RIGHT);
																    t2.setLayoutParams(params2);
																    t2.setText(overallChange);
																    row14.addView(t1);
																  //`  row14.addView(img);
																    row14.addView(t2);
																    tabLay.addView(row14);
																    
																    //row15
																    TableRow row15=new TableRow(this);
																	   row15.setId(15); //row12
																	   row15.setLayoutParams(params1);
																	    row15.setGravity(Gravity.CENTER_HORIZONTAL);
																	    t1=new TextView(this);
																	    t1.setId(151);
																	    t1.setTextSize(15);
																	    t1.setGravity(Gravity.LEFT);
																	    t1.setLayoutParams(params2);
																	    t1.setText("All Time Property Change"); 
																	    t2=new TextView(this);
																	    t2.setId(152);
																	    t2.setTextSize(15); t2.setGravity(Gravity.RIGHT);
																	    t2.setLayoutParams(params2);
																	    t2.setText("$"+allTimePropLow+"-$"+allTimePropHigh);
																	    row15.addView(t1);
																	    row15.addView(t2);
																	    tabLay.addView(row15);
																	    
																	  //row16
																	    TableRow row16=new TableRow(this);
																		   row16.setId(16); //row12
																		   row16.setLayoutParams(params1);
																		    row16.setGravity(Gravity.CENTER_HORIZONTAL);
																		    t1=new TextView(this);
																		    t1.setId(161);
																		    t1.setTextSize(15);
																		    t1.setGravity(Gravity.LEFT);
																		    t1.setLayoutParams(params2);
																		    t1.setText("Rent Zestimate \u00ae Valuation as of "+rentZestDate); 
																		    t2=new TextView(this);
																		    t2.setId(162);
																		    t2.setTextSize(15); t2.setGravity(Gravity.RIGHT);
																		    t2.setLayoutParams(params2);
																		    t2.setText("$"+rentZestAmt);
																		    row16.addView(t1);
																		    row16.addView(t2);
																		    tabLay.addView(row16);
																		    
																		    //row17
																		    TableRow row17=new TableRow(this);
																			   row17.setId(17); //row12
																			   row17.setLayoutParams(params1);
																			    row17.setGravity(Gravity.CENTER_HORIZONTAL);
																			    t1=new TextView(this);
																			    t1.setId(171);
																			    t1.setTextSize(15);
																			    t1.setGravity(Gravity.LEFT);
																			    t1.setLayoutParams(params2);
																			    t1.setText("30 Days Rent Change"); 
																			    t2=new TextView(this);
																			    t2.setId(172);
																			    t2.setTextSize(15); t2.setGravity(Gravity.RIGHT);
																			    t2.setLayoutParams(params2);
																			    t2.setText("$"+rentChange);
																			     row17.addView(t1);
																			   // row17.addView(img);
																			    row17.addView(t2);
																			    tabLay.addView(row17);
																			    
																			  //row18
																			    TableRow row18=new TableRow(this);
																				   row18.setId(18); //row12
																				   row18.setLayoutParams(params1);
																				    row18.setGravity(Gravity.CENTER_HORIZONTAL);
																				    t1=new TextView(this);
																				    t1.setId(181);
																				    t1.setTextSize(15);
																				    t1.setGravity(Gravity.LEFT);
																				    t1.setLayoutParams(params2);
																				    t1.setText("All Time Rent Range"); 
																				    t2=new TextView(this);
																				    t2.setId(182);
																				    t2.setTextSize(15); t2.setGravity(Gravity.RIGHT);
																				    t2.setLayoutParams(params2);
																				    t2.setText("$"+allTimeRentLow+"-$"+allTimeRentHigh);
																				    row18.addView(t1);
																				    row18.addView(t2);
																				    tabLay.addView(row18);
																            
																    String html = "<p>\u00a9 Zillow, Inc., 2006-2014 <br>Use is subjected to <a href=\"http://www.zillow.com/corp/Terms.htm\">Terms of Use</a></br><br/><a href=\"http://www.zillow.com/zestimate/\">What's a Zestimate?</a>";
																    	TextView	myTextView1=(TextView) findViewById(R.id.footerText);
																    myTextView1.setText(Html.fromHtml(html));
																    
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
