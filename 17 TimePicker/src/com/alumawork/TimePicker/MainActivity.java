package com.alumawork.TimePicker;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends Activity {
    TimePicker timePicker;
    Button button;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        showTime();
    }
    public void showTime(){
        timePicker=(TimePicker)findViewById(R.id.timePicker);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getBaseContext(),timePicker.getCurrentHour()+" : "+timePicker.getCurrentMinute(),Toast.LENGTH_SHORT).show();

            }
        });
    }
}
