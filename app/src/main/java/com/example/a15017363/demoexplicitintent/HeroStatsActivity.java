package com.example.a15017363.demoexplicitintent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class HeroStatsActivity extends AppCompatActivity {

    TextView tvName, tvStrength, tvTechnicalProwess;
    Button btnLike, btnDislike;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hero_stats);

        //Get the intent
        Intent i = getIntent();
        //Get the Hero object first activity put in Intent
        Hero hero = (Hero)i.getSerializableExtra("hero");

        tvName = (TextView)findViewById(R.id.textViewName);
        tvStrength = (TextView)findViewById(R.id.textViewStrength);
        tvTechnicalProwess = (TextView)findViewById(R.id.textViewTechnicalProwess);
        btnLike = (Button)findViewById(R.id.buttonLike);
        btnDislike = (Button)findViewById(R.id.buttonDislike);

        //Use getters of Hero object to get the attributes
        tvName.setText(hero.getName());
        tvStrength.setText("Strength: " +hero.getStrength());
        tvTechnicalProwess.setText("Technical: "+hero.getTechnicalProwess());

        //When button Like is clicked, set the results
        //accordingly and finish() to close this act.
        btnLike.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create intent & pass in String data
                Intent i = new Intent();
                i.putExtra("like","like");
                //Set the result to RESULT_OK to indical normal
                //response and pass in the intent containing the like
                setResult(RESULT_OK,i);
                finish();
            }
        });

        // When button Dislike is clicked, set the results
        // accordingly and finish() to close this activity
        btnDislike.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                //Create intent & pass in String data
                Intent i = new Intent();
                i.putExtra("like", "dislike");
                // Set result to RESULT_OK to indicate normal
                // response and pass in the intent containing the dislike
                setResult(RESULT_OK, i);
                finish();
            }});
    }


}
