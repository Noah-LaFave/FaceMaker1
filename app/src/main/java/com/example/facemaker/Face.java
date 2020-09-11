package com.example.facemaker;

public class Face {

    public int skinColor;
    public int eyeColor;
    public int hairColor;
    public int hairStyle;

    public void Face(){



    }

    public void randomize(){
    //randomize
        skinColor = (int)(Math.random() * (250 - 0 + 1) + 0);
        eyeColor = (int)(Math.random() * (250 - 0 + 1) + 0);
        hairColor = (int)(Math.random() * (250 - 0 + 1) + 0);
        hairStyle = (int)(Math.random() * (3 - 1 + 1) + 1);


    }






}
