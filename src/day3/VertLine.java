package day3;

public class VertLine extends Line  {
    int x;
    int y0;
    int y1;

    public VertLine(int x, int y0, int y1) {
        this.x = x;
        this.y0 = y0;
        this.y1 = y1;
        generateCoordinates();
    }

    @Override
    public Coordinate[] generateCoordinates() {
        int tempY = y0;
        this.coords = new Coordinate[Math.abs(y1 - y0)];
        //Coordinate[] coordinates = new Coordinate[Math.abs(y1 - y0)];
        for (int i = 0; i <Math.abs(y1 - y0) ; i++) {
            this.coords[i] = new Coordinate(x, tempY);
            tempY++;
        }
        return this.coords;
    }
}
