package com.epam.spahetask.entity.point;

public class CustomPoint {
    private double x;
    private double y;

    public CustomPoint() {
    }

    public CustomPoint(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + Double.hashCode(x);
        result = prime * result + Double.hashCode(y);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        CustomPoint point = (CustomPoint) obj;
        return point.x == this.x && point.y == this.y;
    }

    @Override
    public String toString() {
        StringBuilder message = new StringBuilder();
        message.append("[X = ").append(x).append(", Y = ").append(y).append("]");
        return message.toString();
    }
}
