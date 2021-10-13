package ss6_ke_thua.bai_tap.lop_point2d_va_lop_point3d;

import java.lang.reflect.Array;

public class Point2D {
    private float x=0.0f;
    private float y=0.0f;
    private float[] xy= new float[2];
    public Point2D(){};
    public Point2D(float x,float y){
        this.x=x;
        this.y=y;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }
    public void setXY(float x,float y){
        xy[0]=x;
        xy[1]=y;
    }
    public float[] getXY(){
        return xy;
    }
    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + ")";
    }

}
