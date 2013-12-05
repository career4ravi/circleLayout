package com.example.circlelayout;

import android.os.Bundle;
import android.app.Activity;
import android.util.Log;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends Activity {

	private static String TAG="MainActivity";
	
	
	BuddieChangeListener mcl;
	
	CircleLayout mCL;
	
	
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	    mCL = (CircleLayout)findViewById(R.id.circleLayout);
		
	    addBuddieListener(mCL);
		
		
		
ImageButton im = (ImageButton)findViewById(R.id.imageButton1);
		
		if(im!=null)
		{
		
			im.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View arg0) {
					// TODO Auto-generated method stub
					Log.v(TAG, "touched the view");
					
						mCL.removeChild();
					
				}});
			
		}
		
		else
		{
			
			Log.v(TAG, "button not created yet");
		}
		
		
		
		new Thread(mSomeThread).start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		
		
		
		return true;
	}
	
	
	void addBuddieListener(BuddieChangeListener bcl)
	{
		mcl=bcl;
	}
	
	
	
	Runnable mSomeThread = new Runnable()
	{
		@Override
		public void run() 
		{
			// TODO Auto-generated method stub
			try {
				int i=1;
				while(i<5)
				{
					Log.v(TAG, "thread fired");
					Thread.sleep(10000);
					//mCL.onBuddieRemoved();
					i++;
				}
				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	};  
	

}
