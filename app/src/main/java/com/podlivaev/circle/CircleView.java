package com.podlivaev.circle;

import android.graphics.*;
import android.view.View;
import android.content.Context;

public class CircleView   extends View
{
    public CircleView(Context context) {
        super(context);
        path = new Path();
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        float angle = 200;

        float radius = canvas.getWidth()/3;
        float x = canvas.getWidth()/2;
        float y = canvas.getHeight()/2;
        final RectF oval = new RectF();

        paint.setFlags(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(25);

        oval.set(x - radius, y - radius, x + radius,y + radius);

        // Draw circle
        paint.setColor(Color.RED);
        canvas.drawArc(oval, 135, angle, false, paint);
        paint.setColor(Color.BLUE);
        canvas.drawArc(oval, angle, 405-angle, false, paint);

        paint.setStyle(Paint.Style.FILL);
        paint.setColor(Color.GRAY);


        float l = 1.3f;
        float l1 = 1.2f;

        float a = angle*(float)Math.PI/180;
        // Draw arrow 
        path.moveTo(x+ (float)Math.cos(a) *radius, y + (float)Math.sin(a) * radius);
        path.lineTo(x+ (float)Math.cos(a+0.1) *radius*l, y + (float)Math.sin(a+0.1) * radius*l);
        path.lineTo(x+ (float)Math.cos(a) *radius*l1, y + (float)Math.sin(a) * radius*l1);
        path.lineTo(x+ (float)Math.cos(a-0.1) *radius*l, y + (float)Math.sin(a-0.1) * radius*l);
        path.lineTo(x+ (float)Math.cos(a) *radius, y + (float)Math.sin(a) * radius);
        canvas.drawPath(path, paint);
    }
    private Path path;
    private Paint paint;
}