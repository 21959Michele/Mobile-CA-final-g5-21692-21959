package com.app.bsc20920;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Map;

public class Signup2 extends AppCompatActivity {

    EditText f_name, l_name, email;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    Button btnsignup;

    @SuppressLint({"CommitPrefEdits", "SetTextI18n"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup2);

        f_name = findViewById(R.id.first_name);
        l_name = findViewById(R.id.last_name);
        email = findViewById(R.id.email);
        btnsignup=findViewById(R.id.signup_click);


        sharedPreferences = getSharedPreferences("MSHARED", Context.MODE_PRIVATE);
        f_name.setText(sharedPreferences.getString("f_name", ""));
        l_name.setText(sharedPreferences.getString("l_name", ""));
        email.setText(sharedPreferences.getString("email", ""));

        editor = sharedPreferences.edit();

        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            boolean editor_check = bundle.getBoolean("edit");
            if (editor_check){
                editor.putBoolean("check",false);
                btnsignup.setText("Update");
                editor.putString("f_name", "");
                editor.putString("l_name", "");
                editor.putString("email", "");
                editor.apply();
            }
        }
    }
    public void signupOnClick(View view) {
        if (TextUtils.isEmpty(f_name.getText().toString()) &&
                TextUtils.isEmpty(l_name.getText().toString()) &&
                TextUtils.isEmpty(email.getText().toString())) {
            Toast.makeText(this, "Fill all Data", Toast.LENGTH_SHORT).show();
        } else {
            editor.putString("f_name", f_name.getText().toString());
            editor.putString("l_name", l_name.getText().toString());
            editor.putString("email", email.getText().toString());
            editor.putBoolean("check",true);
            editor.apply();

            startActivity(new Intent(this, MainButtonActivity.class));
            finish();
        }
    }
    @Override
    protected void onStart() {
        super.onStart();
        if (sharedPreferences.getBoolean("check",false)){
            startActivity(new Intent(this,MainButtonActivity.class));
            finish();
        }
    }
}