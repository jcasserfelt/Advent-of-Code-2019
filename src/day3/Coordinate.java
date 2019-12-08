package day3;

public class Coordinate {
    int xValue;
    int yValue;

    public Coordinate(int xValue, int yValue) {
        this.xValue = xValue;
        this.yValue = yValue;
    }

    public int getManhattan(){
        return (Math.abs(xValue) + Math.abs(yValue));
    }
}
