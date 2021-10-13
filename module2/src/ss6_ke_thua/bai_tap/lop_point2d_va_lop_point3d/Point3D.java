package ss6_ke_thua.bai_tap.lop_point2d_va_lop_point3d;

import ss6_ke_thua.bai_tap.lop_point2d_va_lop_point3d.Point2D;

public class Point3D extends Point2D {
    private float z=0.0f;
    private float[] xyz = new float[3];

    public Point3D(float z) {
        this.z = z;
    }

    public Point3D(float x, float y, float z) {
        super(x, y);
        this.z = z;
    }

    public float getZ() {
        return z;
    }

    public void setZ(float z) {
        this.z = z;
    }
    public void setXYZ(float x, float y, float z) {
        xyz[0] = x;
        xyz[1] = y;
        xyz[2] = z;
    }
    public float[] getXYZ(){
        return xyz;
    }
    @Override
    public String toString() {
        return "(" + getX() + "," + getY() + "," + getZ() + ")";
    }
}
