package com.example.cmpeandroid;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class NextActivity extends Activity {
	protected Button finishButton;
	String uriString;
	protected TextView nameViewer;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_next);
		Intent i = getIntent();
		uriString = i.getStringExtra("name");
		nameViewer = (TextView) findViewById(R.id.nameView);
		nameViewer.setText("Name :: " + uriString);
		finishButton = (Button) findViewById(R.id.existButton);
		
		//Check if the intent extra is empty
		if(uriString.isEmpty()){
			nameViewer.setText(" ");
			Toast.makeText(getApplicationContext(), "Sorry Nothing to Display",Toast.LENGTH_LONG).show();
		}else{
			finishButton.setOnClickListener(new OnClickListener() {

				public void onClick(View v) {
					Intent intent = new Intent(NextActivity.this,
							MainActivity.class);
					startActivity(intent);

				}
			});
		}
		
		
		
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.next, menu);
		return false;
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
