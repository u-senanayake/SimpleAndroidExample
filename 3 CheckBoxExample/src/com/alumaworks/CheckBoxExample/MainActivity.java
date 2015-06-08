package com.alumaworks.CheckBoxExample;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        addListenerButton();
        addListnerToCheckbox();
    }
    public void addListenerButton(){
        CheckBox checkBox1=(CheckBox)findViewById(R.id.checkBox);
        CheckBox checkBox2=(CheckBox)findViewById(R.id.checkBox2);
        CheckBox checkBox3=(CheckBox)findViewById(R.id.checkBox3);
        Button button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                StringBuffer stringBuffer = new StringBuffer();
                stringBuffer.append("Dog :").append(checkBox1.isChecked());
                stringBuffer.append("\nCat :").append(checkBox2.isChecked());
                stringBuffer.append("\n  Cow :").append(checkBox3.isChecked());

                Toast.makeText(MainActivity.this, stringBuffer.toString(), Toast.LENGTH_LONG).show();
            }
        });

    }
    public void addListnerToCheckbox(){
        CheckBox checkBox=(CheckBox)findViewById(R.id.checkBox);
        checkBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(((CheckBox)v).isChecked()){
                    Toast.makeText(MainActivity.this,"Dog is selected",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
