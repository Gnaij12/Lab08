package com.example.lab08;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.concurrent.PriorityBlockingQueue;

public class Tree {
    private float[] radii;
    private int[] colorSelection;
    private Paint bark = new Paint();
    private int left,top,width,height;
    private int[] x;
    private int[] y;
    private int[] colors;
    private Paint[] paints;
    private ArrayList<Integer> notChanged;
    public Tree(int l, int t, int w, int h, int minLeafRadius, int treeRadius) {
        radii = new float[100];
        colorSelection = new int[100];
        paints = new Paint[100];
        x = new int[100];
        y = new int[100];
        notChanged = new ArrayList<Integer>();
        colors = new int[]{Color.GREEN,Color.rgb(145,15,0),Color.rgb(208, 122, 4),Color.TRANSPARENT,Color.rgb(255, 183, 197)};
        left = l;
        top = t;
        width = w;
        height = h;
        for (int i = 0;i<radii.length;i++) {
            notChanged.add(i);
            radii[i] = (float) (Math.random()*minLeafRadius+minLeafRadius);
            colorSelection[i] = 0;
            paints[i] = new Paint();
            paints[i].setColor(colors[0]);
            double r = treeRadius * Math.sqrt(Math.random());
            double theta = Math.random() * 2 * Math.PI;
            x[i] = (int) (left + width/2 + r * Math.cos(theta));
            y[i] = (int) (top - treeRadius*4/5 + r * Math.sin(theta));

        }
        bark.setColor(Color.rgb(97, 59, 22));
        Collections.shuffle(notChanged);
    }

    public void update() {
        if (notChanged.isEmpty()) {
            for (int i = 0;i<radii.length;i++) {
                notChanged.add(i);
            }
            Collections.shuffle(notChanged);
        }
        int iChange = notChanged.remove(0);
        colorSelection[iChange] = (colorSelection[iChange]+1)%colors.length;
        paints[iChange].setColor(colors[colorSelection[iChange]]);
    }
    public void drawTree(Canvas canvas) {
        canvas.drawRect(left,top,left+width,top+height,bark);
        for (int i = 0;i<radii.length;i++) {
            canvas.drawCircle(x[i],y[i],radii[i],paints[i]);
        }
    }
}
