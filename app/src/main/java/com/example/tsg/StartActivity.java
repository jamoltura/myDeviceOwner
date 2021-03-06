package com.example.tsg;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class StartActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        findViewById(R.id.btn_ok).setOnClickListener((View.OnClickListener) v -> {
            EditText ed_login = (EditText) findViewById(R.id.edit_login);
            EditText ed_password = (EditText) findViewById(R.id.edit_password);

            String login = ed_login.getText().toString();
            String password = ed_password.getText().toString();

            String a_login = "jfduSTov456";
            String a_password = "fjd8108fjd";

            if (login.equals(a_login) && password.equals(a_password)){
                Intent intent = new Intent(getApplicationContext(), PolicyManagementActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);
                finish();
            }else {
                Toast.makeText(StartActivity.this, "Логин или пароль введены не верно", Toast.LENGTH_SHORT).show();
            }
        });
    }
}