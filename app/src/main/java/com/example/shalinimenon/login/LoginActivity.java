package com.example.shalinimenon.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {
    Button signup;
    EditText id,pwd;
    TextView login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        signup=(Button)findViewById(R.id.signup);
        id=(EditText)findViewById(R.id.id);
        pwd=(EditText)findViewById(R.id.pwd);
        login=(TextView)findViewById(R.id.textView);
        login.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                if(id.getText().toString().equals("admin")&&pwd.getText().toString().equals("password")){
                    Toast.makeText(getApplicationContext(),"Login Success",Toast.LENGTH_LONG).show();
                    Intent myintent=new Intent(LoginActivity.this, HRActivity.class);
                    startActivity(myintent);
                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Login Unsuccessful",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
