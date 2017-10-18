package com.londonappbrewery.climapm;

import android.content.Intent;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

public class ChangeCityController extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Sets the screen to show the change_city_layout
        setContentView(R.layout.change_city_layout);
        final EditText editTextField = (EditText) findViewById(R.id.queryET);
        ImageButton backButton = (ImageButton) findViewById(R.id.backButton);

        // Closes this activity and returns to main activity when backButton is pressed
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        editTextField.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            // onEditorAction is called when user presses enter on their keyboard in the TF
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {

                // Retrieves and stores text of the city entered by user
                String newCity = editTextField.getText().toString();

                // Switch back to main activity by creating new Intent
                // and passes an Extra of the newCity string, which is a key-value pair
                Intent newCityIntent = new Intent(ChangeCityController.this, WeatherController.class);
                newCityIntent.putExtra("City", newCity);
                startActivity(newCityIntent);

                return false;
            }
        });

    }
}
