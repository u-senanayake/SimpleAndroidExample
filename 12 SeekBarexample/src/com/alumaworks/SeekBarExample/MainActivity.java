package com.alumaworks.SeekBarExample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends Activity {
    private static SeekBar seekBar;
    private static EditText editText;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        SeekBarMethod();
    }
    public void SeekBarMethod(){
        seekBar=(SeekBar)findViewById(R.id.seekBar);
        editText=(EditText)findViewById(R.id.editText);
        editText.setText("Amount"+ seekBar.getProgress()+" / "+seekBar.getMax());
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            int value;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                value=progress;
                editText.setText("Amount"+ progress+" / "+seekBar.getMax());
                Toast.makeText(MainActivity.this,"SeekBar is in progress",Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MainActivity.this,"SeekBar is in start tracking",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                editText.setText("Amount"+ value+" / "+seekBar.getMax());
                Toast.makeText(MainActivity.this,"SeekBar is in stop tracking",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
