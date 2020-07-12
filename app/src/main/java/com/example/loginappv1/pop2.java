package com.example.loginappv1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class pop2 extends Activity {
    TextView codedisp;
    Button move;
    int code;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.popwindow2);

        codedisp = findViewById(R.id.codegen);
        move = findViewById(R.id.movepg);

        code=0000;
        /*INSERT CODE FOR 4/6 DIGIT RANDOM NUMBER GENERATOR AND ASSIGN IT TO code*/

        move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(pop2.this,MainActivity.class);
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
