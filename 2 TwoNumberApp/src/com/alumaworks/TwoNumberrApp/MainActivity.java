package com.alumaworks.TwoNumberrApp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
    public void onButtonClick(View view){
        EditText editText=(EditText)findViewById(R.id.number1);
        EditText editText1=(EditText)findViewById(R.id.number2);
        TextView textView=(TextView)findViewById(R.id.result);
        Button button=(Button)findViewById(R.id.button);
        int n1=Integer.parseInt(editText.getText().toString());
        int n2=Integer.parseInt(editText1.getText().toString());
        int sum=n1+n2;
        textView.setText(Integer.toString(sum));
    }
}
