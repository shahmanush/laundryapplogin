package com.example.loginappv1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Homepage extends AppCompatActivity {

    TextView username, name, email, phone;
    SharedPreferences sharedpreferences;
    Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);

        username = findViewById(R.id.userdsp);
        name = findViewById(R.id.namedsp);
        email = findViewById(R.id.emaildsp);
        phone = findViewById(R.id.phonedsp);
        logout = findViewById(R.id.logout);

        sharedpreferences = getApplicationContext().getSharedPreferences("MyPrefs",MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedpreferences.edit();

        username.setText(sharedpreferences.getString("Username",null));
        phone.setText(sharedpreferences.getString("Phone",null));
        name.setText(sharedpreferences.getString("Name",null));
        email.setText(sharedpreferences.getString("Email",null));


        editor.commit();



        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(intent);
            }
        });



    }
}
