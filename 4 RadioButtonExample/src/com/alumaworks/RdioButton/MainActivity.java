package com.alumaworks.RdioButton;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends Activity {
    /**
     * Called when the activity is first created.
     */
    private static RadioGroup radioGroup;
    private static RadioButton radio_b;
    private static Button button;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        onClickListnerButton();
    }
    public void onClickListnerButton(){
        radioGroup=(RadioGroup)findViewById(R.id.radio_grp);
        button=(Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int selected_id=radioGroup.getCheckedRadioButtonId();
                radio_b=(RadioButton)findViewById(selected_id);
                Toast.makeText(MainActivity.this,radio_b.getText().toString(),Toast.LENGTH_LONG).show();
            }
        });
    }
}
