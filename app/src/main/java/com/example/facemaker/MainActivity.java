/* --------------------------------------------
* Author: Noah LaFave
* CS301B
* 10/2020
* V.2
* ---------------------------------------------
*/
package com.example.facemaker;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {



    //instance variabes
    private String[] hairStyles = {"Mohawk","Afro","Beard"};
    Spinner hairSpinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create spinner, spinner has collection of items arr hairtypes
        populateSpinner();

        //Need to declare these before creating the face controller object to pass through the id's for the seekbars
        //otherwise the progress can't be changed by radio buttons, took about 2 hours trial error, don't touch.
        SeekBar red = findViewById(R.id.seekRed);
        SeekBar green = findViewById(R.id.seekGreen);
        SeekBar blue = findViewById(R.id.seekBlue);

        //create view and controller objects
        Face view = findViewById(R.id.surfaceView);
        FaceController GUIController = new FaceController(view, red, green, blue);

        //random button listener
        Button randomize = findViewById(R.id.rand);
        randomize.setOnClickListener(GUIController);

        //seekbar for red

        red.setOnSeekBarChangeListener(GUIController);
        //seekbar for Green

        green.setOnSeekBarChangeListener(GUIController);
        //seekbar for Blue

        blue.setOnSeekBarChangeListener(GUIController);

        //radio button selection for hair, eyes, skin listener
        RadioGroup hesButton = findViewById(R.id.HES_select);
        hesButton.setOnCheckedChangeListener(GUIController);
        //spinner listener
        Spinner hairSelect = findViewById(R.id.hairstyle);
        hairSelect.setOnItemSelectedListener(GUIController);




    }








    protected void populateSpinner() {
        //code referenced from Dr. Nuxoll in class example

        ArrayAdapter<String> hairAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_dropdown_item,hairStyles);

        //set spinner to xml id
        hairSpinner = findViewById(R.id.hairstyle);

        //spinner values go to array
        hairSpinner.setAdapter(hairAdapter);
    }

}