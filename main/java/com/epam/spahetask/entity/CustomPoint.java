package com.epam.spahetask.entity;

public class CustomPoint implements Cloneable {
    private int x;
    private int y;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    @Override
    public int hashCode() {
        return Integer.hashCode(x) + Integer.hashCode(y);
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
        message.append("[X=").append(x).append(",Y=").append(y).append("]");
        return message.toString();
    }
}
