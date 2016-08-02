package com.colorlight.app;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MainActivity extends Activity {

	/** Called when the activity is first created. */
	private LinearLayout mylayout;
	//private Resources myColor;
	//private int li;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        HideStatusBase();
        setContentView(R.layout.activity_main);
        
       
        mylayout=(LinearLayout)findViewById(R.id.mylayout);
        
        SetColor(R.color.red);
        
        //li=0;
        SetBright(0.5f);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
    	super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        
        switch(item.getItemId())
        {
        case R.id.about:
        	//Toast.makeText(ColorLightActivity.this, "���ڲ˵�", Toast.LENGTH_LONG).show();
        	about();
        	return true;
        case R.id.setcolor:
        	//Toast.makeText(ColorLightActivity.this, R.string.setcolor, Toast.LENGTH_SHORT).show();
        	selectColor();
        	return true;
        case R.id.setbright:
        	selectBright();
        	//Toast.makeText(ColorLightActivity.this, "���ڲ˵�", Toast.LENGTH_LONG).show();
        	return true;
        case R.id.seteffer:
        	//Toast.makeText(ColorLightActivity.this, "���ڲ˵�", Toast.LENGTH_LONG).show();
        	finish();
        	return true;
        
        }
        //return false;
        return super.onOptionsItemSelected(item);
    }
    
    public boolean onTouchEvent(MotionEvent event){
    	//Toast.makeText(ColorLightActivity.this, "����", Toast.LENGTH_SHORT).show();
    	openOptionsMenu();
    	//return super.onTouchEvent(event);
    	return false;
    }
    
    /**
     * ȫ������
     */
    private void HideStatusBase()
	{
		requestWindowFeature(Window.FEATURE_NO_TITLE);
		int flag=WindowManager.LayoutParams.FLAG_FULLSCREEN;
		Window myWindow=this.getWindow();
		myWindow.setFlags(flag,flag);
	}
    
    private void SetColor(int color){
    		
        	//myColor = getBaseContext().getResources();
    		//Drawable color_M = myColor.getDrawable(color_1);
    		//mylayout.setBackgroundColor(color);
    		mylayout.setBackgroundResource(color);
    		//mylayout.setBackgroundResource(color);
        	//mylayout.setBackgroundDrawable(color_M);
            //mylayout.setBackgroundColor(Color.argb(255, 255, 255, 255));
    }
    
    /**
     * ������Ļ����
     * @param light
     */
    private void SetBright(float light)
    {
    	WindowManager.LayoutParams lp=getWindow().getAttributes();
    	lp.screenBrightness=light;
    	getWindow().setAttributes(lp);
    	
    }
    
    private void about(){
    	new AlertDialog.Builder(this).setTitle("阳光手电筒")
		.setMessage("欢迎使用阳光手电筒").setIcon(R.drawable.icon)
		.setPositiveButton("确定", new DialogInterface.OnClickListener() {
			public void onClick(DialogInterface dialog, int whichButton) {
				// finish();
			}
		}).setNegativeButton("返回",
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog,
							int which) {
						// TODO Auto-generated method stub

					}

				}).show();
    }
    
    private void selectColor(){
    	final String[] items = {"白色", "红色", "黑色","黄色"}; 
    	new AlertDialog.Builder(this).setTitle("选择颜色").setItems(items, new DialogInterface.OnClickListener() { 
    	public void onClick(DialogInterface dialog, int item) { 
    		Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show(); 
    		switch (item) {
					case 0:
						SetColor(R.color.white);
						break;
					case 1:
						SetColor(R.color.red);
						break;
					case 2:
						SetColor(R.color.black);
						break;
					case 3:
						SetColor(R.color.yellow);
						break;
					default:
						SetColor(R.color.white);
						break;
				}
    		} 
    	}).show();
    }
    
    private void selectBright(){
        	final String[] items = {"100%", "75%", "50%","25%","10%"}; 
        	new AlertDialog.Builder(this) 
        	.setTitle("选择亮度") 
        	.setSingleChoiceItems(items, 2, new DialogInterface.OnClickListener() { //�˴�����Ϊѡ����±꣬��0��ʼ�� ��ʾĬ�����ѡ�� 
        	public void onClick(DialogInterface dialog, int item) { 
        	Toast.makeText(getApplicationContext(), items[item],Toast.LENGTH_SHORT).show(); 
        	//li=item;
        	switch (item) {
    		case 0:
    			SetBright(1.0F);
    			break;
    		case 1:
    			SetBright(0.75F);
    			break;
    		case 2:
    			SetBright(0.5F);
    			break;
    		case 3:
    			SetBright(0.25F);
    			break;
    		case 4:
    			SetBright(0.1F);
    			break;
    		default:
    			SetBright(1.0F);
    			break;
    		}	
        	dialog.cancel(); 
        	} 
        	}).show();
    	}
}
