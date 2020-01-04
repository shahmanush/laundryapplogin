package com.example.loginappv1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText name, phno, email, username, password, cpassword;
    SharedPreferences sharedpreferences;
    Button sgnup;
    String Name, Phno, Email, Username, Password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.name);
        phno = findViewById(R.id.phno);
        email = findViewById(R.id.email);
        username = findViewById(R.id.username);
        password = findViewById(R.id.password);
        cpassword = findViewById(R.id.cpassword);
        sgnup = findViewById(R.id.signup);

        sharedpreferences = getApplicationContext().getSharedPreferences("MyPrefs", MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedpreferences.edit();

        Name = sharedpreferences.getString("Name",null);
        Phno = sharedpreferences.getString("Phno", null);
        Email = sharedpreferences.getString("Email", null);
        Username = sharedpreferences.getString("Username", null);
        Password = sharedpreferences.getString("Password", null);

        if(Username != null && Password != null){
            Intent log = new Intent(getApplicationContext(), Login.class);
            startActivity(log);
        }

        sgnup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(password.getText().toString().equals(cpassword.getText().toString())) {
                    Name = name.getText().toString();
                    Phno = phno.getText().toString();
                    Email = email.getText().toString();
                    Username = username.getText().toString();
                    Password = password.getText().toString();

                    editor.putString("Name",Name);
                    editor.putString("Phone",Phno);
                    editor.putString("Email",Email);
                    editor.putString("Username",Username);
                    editor.putString("Password",Password);

                    editor.commit();

                        if(Name.length()==0 || Email.length()==0|| Username.length()==0 || Phno.length()==0 || Password.length()==0){
                            Toast.makeText(getApplicationContext(), "None of the above fields can be empty", Toast.LENGTH_SHORT).show();
                        }

                        else {
                            Toast.makeText(getApplicationContext(), "Registration Complete", Toast.LENGTH_SHORT).show();
                            Intent Sign = new Intent(getApplicationContext(), Login.class);
                            startActivity(Sign);
                        }
                }
                else
                    Toast.makeText(getApplicationContext(), "The passwords entered do not match", Toast.LENGTH_SHORT).show();

            }
        });

    }
}
