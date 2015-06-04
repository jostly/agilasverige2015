package net.badgerclaw.rxjavatest;

class UserInfoService {

    public UserInfo findByName(String name) {
        Main.LOG.info("Looking up " + name);
        Main.simulateDelay();
        return new UserInfo(name + "'s street", name + "'s house");
    }

}
