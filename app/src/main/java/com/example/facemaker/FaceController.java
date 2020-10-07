/* --------------------------------------------
 * Author: Noah LaFave
 * CS301B
 * 10/2020
 * V.2
 * ---------------------------------------------
 */
package com.example.facemaker;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;

public class FaceController implements View.OnClickListener, SeekBar.OnSeekBarChangeListener, RadioGroup.OnCheckedChangeListener, Spinner.OnItemSelectedListener {
    //radio group button id's, grabbed from LogCat
    public static final int HAIRSELECT=2131230893;
    public static final int EYESSELECT=2131230894;
    public static final int SKINSELECT=2131230895;
    //Variables needed for
    public FaceModel modelF;
    public Face viewF;
    public int selection;
    private SeekBar seekRed;
    private SeekBar seekBlue;
    private SeekBar seekGreen;

    public FaceController(Face view, SeekBar Red, SeekBar Green, SeekBar Blue){
        this.viewF = view;
        modelF = viewF.getModel();
        selection=-1;
        //need to have these to change progress in other onChecked changed
        seekRed = Red;
        seekGreen=Green;
        seekBlue=Blue;

    }
    //Randomizes FaceModel Values, creates new face
    @Override
    public void onClick(View view) {
        viewF.randomize();
        viewF.invalidate();

    }
    //When Seekbars are used, updates apropriet FaceModel value, changes color
    @Override
    public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

        switch(seekBar.getId()){

                case R.id.seekRed:
                    seekRedSelect(i);
                    break;

                case R.id.seekGreen:
                    seekGreenSelect(i);
                    break;

                case R.id.seekBlue:
                    seekBlueSelect(i);
                    break;

        }
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) { /*METHOD NEVER CALLED*/ }
    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {/*METHOD NEVER CALLED*/}

    //sets selection variable, updates seekbars in view to reflect FaceModel values of selected variable
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        selection=i;
        setSeekers();
    }
    //sets hairstyle to selected value
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //spinner, called on initial
        modelF.hairStyleSelect = i;
        viewF.invalidate();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) { /*METHOD NEVER CALLED*/ }

    //helper method for OnCheckedChanged, updates the seekbars
    public void setSeekers(){
        if(selection == HAIRSELECT){
            seekRed.setProgress(modelF.rHair);
            seekGreen.setProgress(modelF.gHair);
            seekBlue.setProgress(modelF.bHair);
        }
        else if(selection == EYESSELECT){
            seekRed.setProgress(modelF.rEye);
            seekGreen.setProgress(modelF.gEye);
            seekBlue.setProgress(modelF.bEye);
        }
        else if(selection == SKINSELECT){
            seekRed.setProgress(modelF.rSkin);
            seekGreen.setProgress(modelF.gSkin);
            seekBlue.setProgress(modelF.bSkin);
        }

    }

    //seekbarhelpers, depending on selection set variable in model
    public void seekRedSelect(int i){

        if(selection ==HAIRSELECT){
            modelF.rHair = i;
            viewF.invalidate();
        }
        else if(selection==EYESSELECT){
            modelF.rEye = i;
            viewF.invalidate();
        }
        else if(selection==SKINSELECT){
            modelF.rSkin=i;
            this.viewF.invalidate();
        }
    }
    public void seekGreenSelect(int i){

        if(selection ==HAIRSELECT){
            modelF.gHair = i;
            viewF.invalidate();
        }
        else if(selection==EYESSELECT){
            modelF.gEye = i;
            viewF.invalidate();
        }
        else if(selection==SKINSELECT){
            modelF.gSkin=i;
            this.viewF.invalidate();
        }
    }
    public void seekBlueSelect(int i){

        if(selection ==HAIRSELECT){
            modelF.bHair = i;
            viewF.invalidate();
        }
        else if(selection==EYESSELECT){
            modelF.bEye = i;
            viewF.invalidate();
        }
        else if(selection==SKINSELECT){
            modelF.bSkin=i;
            this.viewF.invalidate();
        }
    }
}
