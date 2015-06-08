package com.alumaworks.ClockExample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AnalogClock;
import android.widget.Button;
import android.widget.DigitalClock;

public class MainActivity extends Activity {
    private static Button button;
    private static AnalogClock analogClock;
    private static DigitalClock digitalClock;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        onButtonClickListner();
    }
    public  void onButtonClickListner(){
        button=(Button)findViewById(R.id.button);
        analogClock=(AnalogClock)findViewById(R.id.analogClock);
        digitalClock=(DigitalClock)findViewById(R.id.digitalClock);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(digitalClock.getVisibility()==DigitalClock.GONE){
                    digitalClock.setVisibility(digitalClock.VISIBLE);
                    analogClock.setVisibility(analogClock.GONE);
                }else{
                    digitalClock.setVisibility(digitalClock.GONE);
                    analogClock.setVisibility(analogClock.VISIBLE);
                }
            }
        });
    }
}
