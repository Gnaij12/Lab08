package com.example.lab08;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Tree {
    private float[] radii;
    private Paint[] paints;
    private Paint bark = new Paint();
    int botLeaves;
    public Tree(int left, int bot, int width, int height, int minRadius) {
        radii = new float[100];
        paints = new Paint[100];
        for (int i = 0;i<radii.length;i++) {
            radii[i] = (float) (Math.random()*minRadius+minRadius);
            paints[i].setColor(Color.GREEN);
        }
        bark.setColor(Color.rgb(97, 59, 22));
    }

    public void update(Canvas canvas) {

    }
}
