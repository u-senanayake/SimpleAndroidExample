package com.alumaworks.TimePickerDialog;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends Activity {
    Button button,button2;
    static final int dialog_id=0,dialog_id_date=0;
    int hour,minut,year_a,month_a,date_a;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        showTimeDialog();
        showDateDialog();
    }
    public void showTimeDialog(){
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(dialog_id);
            }
        });

    }
    public void showDateDialog(){
        button2=(Button)findViewById(R.id.button2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(dialog_id_date);
            }
        });
    }
    @Override
    protected Dialog onCreateDialog(int id){
        if(id==dialog_id) return new TimePickerDialog(MainActivity.this,KTimePickerListner,hour,minut,false);
        else if(id==dialog_id_date) return  new DatePickerDialog(MainActivity.this,dPickerListner,year_a,month_a,date_a );
        return null;
    }
    protected TimePickerDialog.OnTimeSetListener KTimePickerListner=new TimePickerDialog.OnTimeSetListener() {
        @Override
        public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
            hour=hourOfDay;
            minut=minute;
            Toast.makeText(MainActivity.this,hour+" : "+minut,Toast.LENGTH_SHORT).show();
        }
    };
    private DatePickerDialog.OnDateSetListener dPickerListner=new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            year_a=year;
            month_a=monthOfYear;
            date_a=dayOfMonth;
            Toast.makeText(MainActivity.this,year_a+" : "+month_a+" : "+date_a,Toast.LENGTH_SHORT).show();
        }
    };

}
