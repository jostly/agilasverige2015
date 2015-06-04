package net.badgerclaw.rxjavatest;

class GeoLocationService {

    public Coordinate lookupAddress(String address) {
        Main.LOG.info("Finding coordinate for " + address);
        Main.simulateDelay();
        return new Coordinate("Coordinate for " + address);
    }

}
