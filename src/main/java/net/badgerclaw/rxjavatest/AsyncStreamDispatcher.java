package net.badgerclaw.rxjavatest;

import rx.Observable;

import static net.badgerclaw.rxjavatest.Main.toAsync;

public class AsyncStreamDispatcher implements Dispatcher {

    private final UserInfoService userInfoService = new UserInfoService();
    private final GeoLocationService geoLocationService = new GeoLocationService();
    private final DroneService droneService = new DroneService();

    public void dispatch(String[] names) {
        Observable.from(names)
                .flatMap(toAsync(userInfoService::findByName))
                .map(userInfo -> userInfo.streetName + " " + userInfo.houseNumber)
                .flatMap(toAsync(geoLocationService::lookupAddress))
                .flatMap(toAsync(droneService::dispatchDrone))
                .subscribe();
    }
}
