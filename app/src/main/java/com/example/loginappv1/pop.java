package com.example.loginappv1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class pop extends Activity {

    EditText code;
    Button go;
    String s;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popwindow);

        code = findViewById(R.id.grpcode);
        go = findViewById(R.id.go);
        s = code.getText().toString();

        /*
        if(s exists in firebase)
        go to new page which displays all participants
        else(s doesnt exist)
        toast to display no such group exists

         */

        go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pop.this,MainActivity.class);
                startActivity(intent);
            }
        });

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*0.75),(int)(height*0.75));







    }
}
