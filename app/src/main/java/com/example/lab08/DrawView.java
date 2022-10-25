package com.example.lab08;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Point;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawView extends View {
    private Tree tree1;
    private Tree tree2;
    private Tree tree3;
    private Tree tree4;
    private Path path;
    private Point[] points;
    private int height;
    private int width;
    private int delay = 5;
    private int count;
    Paint pathPaint;
    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        tree2 = new Tree(700,900,100*9/10,300*9/10,25*9/10, 150*9/10);
        tree1 = new Tree(200,1200,100,300,25, 150);
        tree3 = new Tree(400,500,100*7/10,300*7/10,25*7/10, 150*7/10);
        tree4 = new Tree(800,100,100*4/10,300*4/10,25*4/10, 150*4/10);
        pathPaint = new Paint();
//        pathPaint.setColor(Color.rgb(240,222,192));
        path = new Path();
        count = 0;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        height = getHeight();
        width = getWidth();
        pathPaint.setShader(new LinearGradient(width/3, height, width/3+150, 0, Color.rgb(240,222,192), Color.rgb(155,118,83), Shader.TileMode.MIRROR));
        points = new Point[]{new Point(width/3+150,height),new Point(2*width/3+50,0),new Point(2*width/3,0)};
        path.moveTo(width/3,height);
        for (Point point: points) {
            path.lineTo(point.x,point.y);
        }
        canvas.drawPath(path,pathPaint);
        if (count >= delay) {
            tree4.update();
            tree3.update();
            tree2.update();
            tree1.update();
            count = 0;
        }
        tree4.drawTree(canvas);
        tree3.drawTree(canvas);
        tree2.drawTree(canvas);
        tree1.drawTree(canvas);
        count++;
        invalidate();
    }
}
