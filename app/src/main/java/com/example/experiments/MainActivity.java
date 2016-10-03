package com.example.experiments;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity
{
	private EditText editText;
	private SeekBar slider;
	private int valueOfEditText=-1;
	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		editText=(EditText)findViewById(R.id.editText);
		editText.setHint("0.00");
		slider=(SeekBar)findViewById(R.id.seekBar);
		slider.setMax(1500);
		slider.setKeyProgressIncrement(100);

		slider.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener()
		{
			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean b)
			{
				if (progress!=valueOfEditText)
				{
					progress = Math.round(progress / 100) * 100;

				}

				seekBar.setProgress(progress);
				if (progress==0)
				{
					editText.setText("0.0");
				}
				else
				{
					editText.setText(String.valueOf((double)progress));
				}
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar)
			{

			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar)
			{

			}
		});
		editText.addTextChangedListener(new TextWatcher()
		{
			@Override
			public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2)
			{

			}

			@Override
			public void onTextChanged(CharSequence charSequence, int i, int i1, int i2)
			{
//				editText.setSelection(i+i1);
			}

			@Override
			public void afterTextChanged(Editable editable)
			{
				String st=editable.toString();
				double d=Double.parseDouble(st);
				int progress=(int) d;
				if (progress>0 && progress<1500)
				{
					valueOfEditText=progress;
					slider.setProgress(progress);
//					editText.setText(String.valueOf(d));
				}
				else if (progress>1500)
				{
					slider.setProgress(1500);

				}
			}
		});
	}
}
