package com.alumaworks.AutoCompleteTextViewExample;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class MainActivity extends Activity {
    AutoCompleteTextView autoCompleteTextView;
    String[] countries={
            "aaa",
            "bbb",
            "ccc",
            "ddd",
            "eee"
    };
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        autoCompleteTextView=(AutoCompleteTextView)findViewById(R.id.autoCompleteTextView);
        ArrayAdapter adapter=new ArrayAdapter(this,android.R.layout.select_dialog_item,countries);
        autoCompleteTextView.setThreshold(1);//1 for auto complete
        autoCompleteTextView.setAdapter(adapter);
    }
}
