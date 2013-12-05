package com.example.circlelayout;



import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageButton;
/**
 * @author Ravi
 *
 */
public class CircleLayout extends ViewGroup implements OnClickListener, BuddieChangeListener{
	
	
	private static String TAG="MainActivity";
	private int mMaxChildWidth;
	private int mMaxChildHeight;
	private int mMaxWidth;
	private int mMaxHeight;  
	
	public CircleLayout(Context context) {
		super(context);
		// TODO Auto-generated constructor stub
	}
	
	public CircleLayout(Context context, AttributeSet attrs) {
		super(context, attrs);
		// TODO Auto-generated constructor stub
	}

	public CircleLayout(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		// TODO Auto-generated constructor stub
		
		  
	}

	@Override
	protected void onLayout(boolean changed, int l, int t, int r, int b) {
		// TODO Auto-generated method stub
		
		int centerX= (r-l)/2;
		int centerY= (b-t)/2;
		
		
		float radius = (r-l)/3;
		
		
		Log.v(TAG, "onLayout");
		
	
		 if(getChildCount() >= 1)
	     {
			 View child= getChildAt(0);
			 
			 int shiftx=centerX-child.getMeasuredWidth()/2;
			 int shiftY=centerY-child.getMeasuredHeight()/2;
			 Log.v(TAG,"child"+0);
	    	 child.layout(shiftx, shiftY, shiftx+child.getMeasuredWidth(),shiftY+child.getMeasuredHeight());
	     }
		 
		 
		 
		 
		 int childCount = getChildCount()-1;
		 
		 int childI = 1;
		 
		 
		 
		   if(childCount >= 1)
		   {
			   float angleInDegrees=360/childCount;
			   
			   for(float angle=0;angle<360;angle=angle+angleInDegrees)
				{
					View child = getChildAt(childI);
					
					 if(child!=null)// && //child.getVisibility() != GONE)
				     {
					
						 float childx = (float)(radius * Math.cos(angle * Math.PI / 180F)) + centerX;
						 float childy = (float)(radius * Math.sin(angle * Math.PI / 180F)) + centerY;
			     
						 float shiftX=childx - child.getMeasuredWidth()/2;
			        	 float shiftY=childy - child.getMeasuredHeight()/2;
			        	child.layout((int)shiftX,(int)shiftY, (int)(shiftX+child.getMeasuredWidth()), (int)(shiftY+child.getMeasuredHeight()));
			        }
			        childI++; 
				}
		 
		   }
		 
		 
	     
	}
	
	
	 @Override
     protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
		 
		 mMaxWidth=0;
		 mMaxHeight = 0;
		 
		 mMaxChildWidth = 0;
	     mMaxChildHeight = 0;
		 
		 //Log.v(TAG,"widthMeasureSpec:"+widthMeasureSpec+" heightMeasureSpec:"+heightMeasureSpec);
		 
		 
		 int minWidth=getSuggestedMinimumWidth();
	     int minHeight=getSuggestedMinimumHeight();
	     
	     int count = getChildCount();
	     for (int i = 0; i < count; i++) 
	     {
             final View child = getChildAt(i);
             //if (child.getVisibility() != GONE) 
             //{
	    	  
	    	   final int childWidthMeasureSpec = MeasureSpec.makeMeasureSpec(
	                 MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.AT_MOST);
	    	   final int childHeightMeasureSpec = MeasureSpec.makeMeasureSpec(
	                 MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.AT_MOST);
	         
	         
	    	   child.measure(childWidthMeasureSpec, childHeightMeasureSpec);
	         
	         
	    	   mMaxChildWidth = Math.max(mMaxChildWidth, child.getMeasuredWidth());
	    	   mMaxChildHeight = Math.max(mMaxChildHeight, child.getMeasuredHeight());
	    	   
             //} 
	     }	 
	     
	     
	     
	  // Check against our minimum height and width
	     mMaxChildHeight = Math.max(mMaxChildHeight, getSuggestedMinimumHeight());
	     mMaxChildWidth = Math.max(mMaxChildWidth, getSuggestedMinimumWidth());
	     
	     
		 
	     setMeasuredDimension(resolveSize(mMaxChildWidth, widthMeasureSpec),
	                resolveSize(mMaxChildHeight, heightMeasureSpec));
	     
	     
	     //mMaxWidth= Math.max(mMaxWidth, widthMeasureSpec);
	     //mMaxHeight= Math.max(mMaxHeight, heightMeasureSpec);
	     
	     //setMeasuredDimension(mMaxWidth,mMaxHeight);
		 
		 
	 }
	 
	 
	 public void removeChild()
	 {
		 if(getChildCount()>1)
		 {
			 Log.v(TAG, "getChildCount():" +(getChildCount()-1));
			
			 final View child = getChildAt(getChildCount()-1);
			 if(child!=null)
			 {
				 //child.setVisibility(View.GONE);
				 removeView(child);
				 invalidate();
			 }
			 
		 }
		 
	 }
	 
	 
	 public void addChild(Bitmap friend)
	 {
		 
 
		 //addView(v);
		 
	 }
	 
	
	 
	 
	 @Override
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			Log.v(TAG, "touched the view");
			
			
		}

	@Override
	public void onBuddieAdded() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onBuddieRemoved() {
		// TODO Auto-generated method stub
		removeChild();
	}

	@Override
	public void onBuddieChanged() {
		// TODO Auto-generated method stub
		
	}
		 
	
	

}
