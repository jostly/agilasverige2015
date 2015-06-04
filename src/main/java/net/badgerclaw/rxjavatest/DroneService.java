package net.badgerclaw.rxjavatest;

class DroneService {

    public boolean dispatchDrone(Coordinate coordinate) {
        Main.LOG.info("Dispatching drone to " + coordinate);
        Main.simulateDelay();
        Main.LOG.info("Drone dispatched to: " + coordinate);
        return true;
    }

}
