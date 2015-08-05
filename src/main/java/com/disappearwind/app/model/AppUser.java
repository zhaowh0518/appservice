package com.disappearwind.app.model;

import java.util.Date;

public class AppUser {
    private Integer appuserid;

    private Integer userinfoid;

    private String apptoken;

    private String appversion;

    private String devicenum;

    private String devicemodel;

    private String deviceresolution;

    private Boolean jailbroken;

    private String osversion;

    private Date createdate;

    public Integer getAppuserid() {
        return appuserid;
    }

    public void setAppuserid(Integer appuserid) {
        this.appuserid = appuserid;
    }

    public Integer getUserinfoid() {
        return userinfoid;
    }

    public void setUserinfoid(Integer userinfoid) {
        this.userinfoid = userinfoid;
    }

    public String getApptoken() {
        return apptoken;
    }

    public void setApptoken(String apptoken) {
        this.apptoken = apptoken;
    }

    public String getAppversion() {
        return appversion;
    }

    public void setAppversion(String appversion) {
        this.appversion = appversion;
    }

    public String getDevicenum() {
        return devicenum;
    }

    public void setDevicenum(String devicenum) {
        this.devicenum = devicenum;
    }

    public String getDevicemodel() {
        return devicemodel;
    }

    public void setDevicemodel(String devicemodel) {
        this.devicemodel = devicemodel;
    }

    public String getDeviceresolution() {
        return deviceresolution;
    }

    public void setDeviceresolution(String deviceresolution) {
        this.deviceresolution = deviceresolution;
    }

    public Boolean getJailbroken() {
        return jailbroken;
    }

    public void setJailbroken(Boolean jailbroken) {
        this.jailbroken = jailbroken;
    }

    public String getOsversion() {
        return osversion;
    }

    public void setOsversion(String osversion) {
        this.osversion = osversion;
    }

    public Date getCreatedate() {
        return createdate;
    }

    public void setCreatedate(Date createdate) {
        this.createdate = createdate;
    }
}