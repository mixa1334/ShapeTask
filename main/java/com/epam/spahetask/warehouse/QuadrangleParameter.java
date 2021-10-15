package com.epam.spahetask.warehouse;

public class QuadrangleParameter {
    private double area;
    private double perimeter;

    public QuadrangleParameter(double area, double perimeter) {
        this.area = area;
        this.perimeter = perimeter;
    }

    public double getArea() {
        return area;
    }

    public void setArea(double area) {
        this.area = area;
    }

    public double getPerimeter() {
        return perimeter;
    }

    public void setPerimeter(double perimeter) {
        this.perimeter = perimeter;
    }


    @Override
    public int hashCode() {
        return Double.hashCode(area) + Double.hashCode(perimeter);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        QuadrangleParameter quadrangleParameter = (QuadrangleParameter) obj;
        return quadrangleParameter.area == this.area && quadrangleParameter.perimeter == this.perimeter;
    }

    @Override
    public String toString() {
        StringBuilder message = new StringBuilder();
        message
                .append("[area=")
                .append(area)
                .append(",perimeter=")
                .append(perimeter)
                .append("]");
        return message.toString();
    }
}
