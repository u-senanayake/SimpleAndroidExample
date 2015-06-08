package com.alumaworks.LoginExample;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends Activity {
    private static EditText username,password;
    private static TextView attemps;
    private static Button button;
    int attempt_count=5;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        login();
    }
    public void login(){
        username=(EditText)findViewById(R.id.editText_user_name);
        password=(EditText)findViewById(R.id.editText_password);
        attemps=(TextView)findViewById(R.id.textView_attemps);
        button=(Button)findViewById(R.id.button);
        attemps.setText(Integer.toString(attempt_count));
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("user")&&password.getText().toString().equals("pass")){
                    Toast.makeText(LoginActivity.this,"User name & password is correct",Toast.LENGTH_LONG).show();
                    Intent intent=new Intent(LoginActivity.this,UserActivity.class);
                    startActivity(intent);
                }else{
                    Toast.makeText(LoginActivity.this,"User name or password in incorrect",Toast.LENGTH_LONG).show();
                    attempt_count --;
                    attemps.setText(Integer.toString(attempt_count));
                    if(attempt_count==0){
                        button.setEnabled(false);
                    }
                }
            }
        });
    }
}
