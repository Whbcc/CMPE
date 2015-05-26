package com.example.cmpeandroid;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity implements
		android.view.View.OnClickListener {
	protected Button nextButton;
	protected TextView nameViwer;
	protected EditText nameHolder;
	protected Button displayButton;
	protected Button finishButton;
	// Actions
	static String grabText = " ";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		nextButton = (Button) findViewById(R.id.nextButton);
		displayButton = (Button) findViewById(R.id.displayButton);
		finishButton = (Button) findViewById(R.id.finishButton);
		nameHolder = (EditText) findViewById(R.id.nameHolder);
		nameViwer = (TextView) findViewById(R.id.nameView);

		// Setting the Listner
		nextButton.setOnClickListener(this);
		displayButton.setOnClickListener(this);
		finishButton.setOnClickListener(this);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return false;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return false;
		}
		return super.onOptionsItemSelected(item);
	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.displayButton:

			if (nameHolder.getText().toString().isEmpty()) {
				// Warn User
				Toast.makeText(getApplicationContext(),
						"Nothing to Display. Enter some Text", Toast.LENGTH_LONG).show();

			} else {
				// Grab the info the Move on
				grabText = nameHolder.getText().toString();
				nameViwer.setText(grabText);
			}

			break;
		case R.id.finishButton:

			new AlertDialog.Builder(this)
					.setMessage("Are you sure you want to exit?")
					.setCancelable(false)
					.setPositiveButton("Yes",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									MainActivity.this.finish();
								}
							}).setNegativeButton("No", null).show();

			break;

		case R.id.nextButton:
			if (nameHolder.getText().toString().isEmpty()) {
				// Warn User
				Toast.makeText(getApplicationContext(),
						"Sorry Enter some Text", Toast.LENGTH_LONG).show();

			} else {
				// Grab the info the Move on
				Intent intent = new Intent(MainActivity.this,
						NextActivity.class);
				grabText = nameHolder.getText().toString();
				intent.putExtra("name", grabText);
				startActivity(intent);
			}

			break;

		default:

			break;
		}

	}
}
