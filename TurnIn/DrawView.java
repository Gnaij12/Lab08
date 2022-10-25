package com.example.lab08;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import androidx.annotation.Nullable;

public class DrawView extends View {
    private Tree tree1;
    public DrawView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        tree1 = new Tree(500,700,100,400,25, 150);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        tree1.update(canvas);
        invalidate();
    }
}
