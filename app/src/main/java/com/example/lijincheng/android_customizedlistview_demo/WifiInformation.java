package com.example.lijincheng.android_customizedlistview_demo;

/**
 * Created by lijincheng on 2/2/16.
 */
public class WifiInformation {

    private String wifiName;
    private int wifiState;
    private int kindOfSecurity;
    private boolean isBlocked;

    public String getWifiName() {
        return wifiName;
    }

    public int getWifiState() {
        return wifiState;
    }

    public int getKindOfSecurity() {
        return kindOfSecurity;
    }

    public boolean isBlocked() {
        return isBlocked;
    }

    public void setWifiName(String wifiName) {
        this.wifiName = wifiName;
    }

    public WifiInformation(String name) {
        this.wifiState = 0;
        this.kindOfSecurity = 0;
        this.isBlocked = true;
        this.wifiName = name;
    }

    public WifiInformation(String wifiName, int wifiState, int kindOfSecurity, boolean isBlocked) {
        this.wifiName = wifiName;
        this.wifiState = wifiState;
        this.kindOfSecurity = kindOfSecurity;
        this.isBlocked = isBlocked;
    }
}
