package com.example.lab08;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawView extends View {
    private int y = 0, dy = 5;
    private Tree tree1;
    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        tree1 = new Tree(500,700,100,400,50);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        tree1.update(canvas);
        y+=dy;
        y%=getHeight();
        if (y < 0) {
            y = getHeight();
        }
        invalidate();
    }

    public int getDy() {
        return dy;
    }

    public void setDy(int dy) {
        this.dy = dy;
    }
}
