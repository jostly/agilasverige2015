package net.badgerclaw.rxjavatest;

class Coordinate {
    public final String coordinate;

    Coordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    @Override
    public String toString() { return coordinate; }
}
