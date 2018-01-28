package com.example.shalinimenon.login;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class HRActivity extends AppCompatActivity implements View.OnClickListener {
    private static final int REQUEST_PHONE_CALL = 101;
    private static final String PHONE_NUMBER = "9497691027";

    Button hrok;
    EditText hr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hr);

        Toast.makeText(this, "HRActivity", Toast.LENGTH_LONG).show();
        hrok = (Button) findViewById(R.id.hrok);
        hr = (EditText) findViewById(R.id.hr);
        hrok.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        String value = hr.getText().toString();
        final int rate = Integer.parseInt(value);
        Log.d("YouAreSafe", "Rate : " + rate);

        if (rate > 90) {
            makePhoneCall(HRActivity.this, PHONE_NUMBER);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_PHONE_CALL:
                makePhoneCall(HRActivity.this, PHONE_NUMBER);
                break;
        }
    }

    private void makePhoneCall(Context context, String phoneNumber) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + PHONE_NUMBER));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(HRActivity.this, new String[]{Manifest.permission.CALL_PHONE}, REQUEST_PHONE_CALL);
            return;
        }

        context.startActivity(intent);
    }
}



