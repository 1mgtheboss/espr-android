package mg.espr;





import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.NavUtils;
import android.text.method.ScrollingMovementMethod;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class DisplayCHActivity extends Activity {
	private InterstitialAd interstitial;
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_display_ch);
		
		
		TextView information = (TextView)findViewById(R.id.information);
		information.setText("Cure Hangover: Price: USD 0.00");
		
		
		// Create the interstitial.
	    interstitial = new InterstitialAd(this);
	    interstitial.setAdUnitId("a152d84159c576d");
	    
	    
	    interstitial.setAdListener(new AdListener() {
	        @Override
	        public void onAdLoaded() {
	          
	        	displayInterstitial();

	          
	        }
	        @Override
	        public void onAdFailedToLoad(int errorCode) {
	          
	        }
	    });
		
	    // Create ad request.
	    AdRequest adRequest = new AdRequest.Builder().build();
	    
	    // Begin loading your interstitial.
	    interstitial.loadAd(adRequest);
		
	    
		// Show the Up button in the action bar.
		setupActionBar();
		
		
		
	}
	
	
	
	

	/**
	 * Set up the {@link android.app.ActionBar}, if the API is available.
	 */
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	private void setupActionBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
			getActionBar().setDisplayHomeAsUpEnabled(true);
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.display_ch, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. Use NavUtils to allow users
			// to navigate up one level in the application structure. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			NavUtils.navigateUpFromSameTask(this);
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	@Override
	public void onDestroy() {
	   super.onDestroy();
	   
	}
	
	// Invoke displayInterstitial() when you are ready to display an interstitial.
	  public void displayInterstitial() {
	    if (interstitial.isLoaded()) {
	      interstitial.show();
	    }
	  }
	  
	  
	  public void purchaseCH(View view) {
		    // Do something in response to button
		  Button purchaseButton = (Button) findViewById(R.id.button1);
		  purchaseButton.setVisibility(View.GONE);
		  TextView information = (TextView)findViewById(R.id.information);
		  information.setTextColor(getResources().getColor(R.color.green));
		  information.setTextSize(40);
		  information.setMovementMethod(new ScrollingMovementMethod());
		  information.setText("Cure Hangover: A hangover is your body's way of telling you to re-hydrate. Drink lots of water. Drinking warm water with lemon and honey in it also helps. Exercise: The endorphins released while working out will help you combat that nasty hangover by improving your mood. Avoid foods that are acidic or spicy, heavy or oily, since they are more difficult for your body to digest.");
		  
		}

}
