/* --------------------------------------------
 * Author: Noah LaFave
 * CS301B
 * 10/2020
 * V.2
 * ---------------------------------------------
 */
package com.example.facemaker;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceView;


import androidx.annotation.RequiresApi;

public class Face extends SurfaceView {

    public FaceModel model = new FaceModel();
    //set max opacity
    public static final int MAXVAL=255;

    /*
    //used these before to set random value colors to, using ARGB set color func was way more convenient
    public int skinColor;
    public int eyeColor;
    public int hairColor;
    public int hairStyle;
    */

    //create paint objects
    Paint skinPaint = new Paint();
    Paint eyePaint = new Paint();
    Paint hairPaint = new Paint();
    Paint pupilPaint = new Paint();

    public Face(Context context, AttributeSet attrs) {
        super(context, attrs);

        //make sure OnDraw will be called
        setWillNotDraw(false);
        //initialize colors
        randomize();

    }
    //getter
    public FaceModel getModel() { return this.model; }

    //helper methods for OnDraw
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP) //required for drawOval
    public void drawFace(Canvas canvas){
        canvas.drawOval(300.0f, 200.0f, 900.0f, 1000.0f, skinPaint);
    }

    public void drawEyes(Canvas canvas){
        canvas.drawCircle(400.0f, 600.0f, 100, eyePaint);
        canvas.drawCircle(800.0f, 600.0f, 100, eyePaint);
        canvas.drawCircle(820.0f, 600.0f, 80, pupilPaint);
        canvas.drawCircle(380.0f, 600.0f, 80, pupilPaint);
    }

    public void drawMouth(Canvas canvas){
        canvas.drawRect(500, 800, 700, 900, pupilPaint);
    }

    public void drawHair(Canvas canvas){

        if(model.hairStyleSelect == 0) {
            drawMohawk(canvas);
        }
        else if(model.hairStyleSelect == 1) {
            drawAfro(canvas);
        }
        else if(model.hairStyleSelect == 2) {
            drawBeard(canvas);
        }

    }


    public void setPaint(){
        skinPaint.setARGB(MAXVAL,model.rSkin, model.gSkin,model.bSkin);
        eyePaint.setARGB(MAXVAL,model.rEye,model.gEye,model.bEye);
        hairPaint.setARGB(MAXVAL,model.rHair,model.gHair,model.bHair);
    }


    //Randomizes FaceModel instance variables, used to set color hues
    public void randomize(){

        model.hairStyleSelect=(int)(Math.random() * (2  + 1) + 0);
        model.rHair= (int)(Math.random() * (MAXVAL + 1) + 0);
        model.gHair= (int)(Math.random() * (MAXVAL + 1) + 0);
        model.bHair= (int)(Math.random() * (MAXVAL+ 1) + 0);
        model.rEye= (int)(Math.random() * (MAXVAL + 1) + 0);
        model.gEye= (int)(Math.random() * (MAXVAL  + 1) + 0);
        model.bEye= (int)(Math.random() * (MAXVAL  + 1) + 0);
        model.rSkin= (int)(Math.random() * (MAXVAL  + 1) + 0);
        model.gSkin= (int)(Math.random() * (MAXVAL  + 1) + 0);
        model.bSkin= (int)(Math.random() * (MAXVAL  + 1) + 0);
    }

    //hairstyle helpers
    public void drawMohawk(Canvas canvas){
        canvas.drawRect(550, 50, 650, 280, hairPaint);
    }
    public void drawAfro(Canvas canvas){
        //bottom layer
        canvas.drawCircle(300.0f, 450.0f, 100, hairPaint);
        canvas.drawCircle(450.0f, 450.0f, 100, hairPaint);
        canvas.drawCircle(600.0f, 450.0f, 100, hairPaint);
        canvas.drawCircle(750.0f, 450.0f, 100, hairPaint);
        canvas.drawCircle(900.0f, 450.0f, 100, hairPaint);
        //middle layer
        canvas.drawCircle(350.0f, 350.0f, 100, hairPaint);
        canvas.drawCircle(470.0f, 350.0f, 100, hairPaint);
        canvas.drawCircle(650.0f, 350.0f, 100, hairPaint);
        canvas.drawCircle(730.0f, 350.0f, 100, hairPaint);
        canvas.drawCircle(850.0f, 350.0f, 100, hairPaint);
        //top layer
        canvas.drawCircle(450.0f, 250.0f, 100, hairPaint);
        canvas.drawCircle(550.0f, 250.0f, 100, hairPaint);
        canvas.drawCircle(650.0f, 250.0f, 100, hairPaint);
        canvas.drawCircle(750.0f, 250.0f, 100, hairPaint);

    }
    public void drawBeard(Canvas canvas){
        //old
        canvas.drawCircle(450.0f, 850.0f, 100, hairPaint);
        canvas.drawCircle(550.0f, 850.0f, 100, hairPaint);
        canvas.drawCircle(650.0f, 850.0f, 100, hairPaint);
        canvas.drawCircle(750.0f, 850.0f, 100, hairPaint);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)//needed for DrawFace:DrawOval
    public void onDraw(Canvas canvas){
        setPaint();
        drawFace(canvas);
        drawEyes(canvas);
        drawMouth(canvas);
        drawHair(canvas);
    }

}
