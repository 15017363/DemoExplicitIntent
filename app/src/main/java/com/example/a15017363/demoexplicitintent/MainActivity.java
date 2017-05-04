package com.example.a15017363.demoexplicitintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //These request identify who started the second activity
    int requestCodeForSupermanStats = 1;
    int requestCodeForBatmanStats = 2;

    TextView tvSuperman, tvBatman;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvSuperman = (TextView)findViewById(R.id.textViewSuperman);
        tvBatman = (TextView)findViewById(R.id.textViewBatman);

        //Set listener to handle the clicking of Superman TextView
        tvSuperman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create Hero object of strength 100 & technical 60
                Hero Superman = new Hero("Superman",100,60);
                Intent i = new Intent(MainActivity.this, HeroStatsActivity.class);
                //Put hero object in intent
                i.putExtra("hero", Superman);
                //Start activity with requestCodeForSupermanStats to
                //identify it was started by clicking on Superman
                startActivityForResult(i,requestCodeForSupermanStats);
            }
        });

    }

    @Override
    protected  void onActivityResult(int requestCode, int resultcode, Intent data){
        super.onActivityResult(requestCode,resultcode,data);

        //Only handle when 2nd activity closed normally
        //and data contains something
        if(resultcode == RESULT_OK){
            if(data != null){
                //Get data passed back from 2nd activity
                String like = data.getStringExtra("like");
                String statement = "";

                //If it is activity started by clicking
                //Superman, create corresponding String
                if(requestCode == requestCodeForSupermanStats){
                    statement = "You " + like + " Superman";
                }
                //If 2nd activity started by clicking
                //Batman, create corresponding String
                if(requestCode == requestCodeForBatmanStats){
                    statement = "You " +like+ " Batman";
                }
                Toast.makeText(this, statement, Toast.LENGTH_LONG).show();
            }
        }
    }
}
