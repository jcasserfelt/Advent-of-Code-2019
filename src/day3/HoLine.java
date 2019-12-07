package day3;

public class  HoLine extends Line {

    int x0;
    int x1;
    int y;

    public HoLine(int x0, int x1, int y) {
        this.x0 = x0;
        this.x1 = x1;
        this.y = y;
        generateCoordinates();
    }
    @Override
    public Coordinate[] generateCoordinates() {
        int tempX = x0;
        this.coords = new Coordinate[Math.abs(x1 - x0)];
        for (int i = 0; i <Math.abs(x1 - x0) ; i++) {
            this.coords[i] = new Coordinate(tempX, y);
            tempX++;
        }
        return this.coords;
    }
}
