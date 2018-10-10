package com.az.city7;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button bt1 = (Button) findViewById(R.id.button);
        bt1.setOnClickListener(new View.OnClickListener() {

           // @Override

            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), CreateActivity.class );
                startActivityForResult(intent, 0);

               // bt1.setText("Automatically created a listener!");

            }
        });
    }
}
