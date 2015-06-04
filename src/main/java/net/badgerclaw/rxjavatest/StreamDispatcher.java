package net.badgerclaw.rxjavatest;

import rx.Observable;

import static net.badgerclaw.rxjavatest.Main.toAsync;

public class StreamDispatcher implements Dispatcher {

    private final UserInfoService userInfoService = new UserInfoService();
    private final GeoLocationService geoLocationService = new GeoLocationService();
    private final DroneService droneService = new DroneService();

    public void dispatch(String[] names) {
        Observable.from(names)
                .map(userInfoService::findByName)
                .map(userInfo -> userInfo.streetName + " " + userInfo.houseNumber)
                .map(geoLocationService::lookupAddress)
                .subscribe(droneService::dispatchDrone);
    }
}
