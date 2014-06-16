package com.example.dieta;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;

import com.example.dieta.utils.Validator;

public class Inputs extends ActionBarActivity {
	public final static String EXTRA_NAME = "com.example.EXTRA_NAME";
	public final static String EXTRA_YEARS = "com.example.EXTRA_YEARS";
	public final static String EXTRA_WEIGHT = "com.example.EXTRA_WEIGHT";
	public final static String EXTRA_HEIGHT = "com.example.EXTRA_HEIGHT";
	public final static String EXTRA_GAIN = "com.example.EXTRA_GAIN";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inputs);

		if (savedInstanceState == null) {
			getSupportFragmentManager().beginTransaction()
					.add(R.id.container, new PlaceholderFragment()).commit();
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.inputs, menu);
		return true;
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

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_inputs,
					container, false);
			return rootView;
		}
	}

	public void next(View view) {
		Intent intent = new Intent(this, Diet.class); 
		String name = ((EditText) findViewById(R.id.name)).getText().toString();
		String years = ((EditText) findViewById(R.id.years)).getText().toString();
		String weight = ((EditText) findViewById(R.id.weight)).getText().toString();
		String height = ((EditText) findViewById(R.id.height)).getText().toString();
		RadioButton gain = (RadioButton) findViewById(R.id.gain);
		RadioButton lose= (RadioButton) findViewById(R.id.lose);
		
		Validator validator = new Validator(name, years, weight, height, gain, lose);
		
		if (validator.validate()) {
			intent.putExtra(EXTRA_NAME, name);
			intent.putExtra(EXTRA_YEARS, years);
			intent.putExtra(EXTRA_WEIGHT, weight);
			intent.putExtra(EXTRA_HEIGHT, height);
			if (gain.isChecked())
				intent.putExtra(EXTRA_GAIN, gain.isChecked());
			else
				intent.putExtra(EXTRA_GAIN, false);
			startActivity(intent);
		} else {
			AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
			dialogBuilder.setMessage(R.string.dialog_message);
			dialogBuilder.setCancelable(true).setTitle(R.string.title_dialog);
			dialogBuilder.create().show();
		}
	}			

}