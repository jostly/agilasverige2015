package net.badgerclaw.rxjavatest;

public class IterativeDispatcher implements Dispatcher {

    private final UserInfoService userInfoService = new UserInfoService();
    private final GeoLocationService geoLocationService = new GeoLocationService();
    private final DroneService droneService = new DroneService();

    public void dispatch(String[] names) {
        for (String name : names) {
            UserInfo userInfo = userInfoService.findByName(name);
            String address = userInfo.streetName + " " + userInfo.houseNumber;
            Coordinate coordinate = geoLocationService.lookupAddress(address);
            droneService.dispatchDrone(coordinate);
        }
    }
}
