package net.androidbootcamp.interactivequizgame;

import android.content.Intent;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ResultsActivity extends AppCompatActivity {

    // declare textviews and redo quiz button
    TextView show;
    TextView result;
    Button redo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        // set the textview and redo quiz button
        redo = (Button) findViewById(R.id.Redo_btn);
        show = (TextView) findViewById(R.id.Show_txt);
        result = (TextView) findViewById(R.id.results_txt);

        // get the intent so the final score and incorrect answer explanations can be displayed
        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String resultsString = extras.getString("combine_String");  // get the incorrect answer explanations
        int finalScore = extras.getInt("final_score");  // get the final score as a string


        result.setText("Score: "+finalScore + "%");
        show.setText("\n"+resultsString);

        // if the user clicks the "Redo Quiz" button, it will start the quiz over and reset all previous results
        redo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultsActivity.this, SingleAnswer.class);
                startActivity(intent);
            }
        });


    }
}
