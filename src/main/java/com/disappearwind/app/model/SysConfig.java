package com.disappearwind.app.model;

public class SysConfig {
    private Integer sysconfigid;

    private Integer configtype;

    private String configkey;

    private String configvalue;

    private String description;

    public Integer getSysconfigid() {
        return sysconfigid;
    }

    public void setSysconfigid(Integer sysconfigid) {
        this.sysconfigid = sysconfigid;
    }

    public Integer getConfigtype() {
        return configtype;
    }

    public void setConfigtype(Integer configtype) {
        this.configtype = configtype;
    }

    public String getConfigkey() {
        return configkey;
    }

    public void setConfigkey(String configkey) {
        this.configkey = configkey;
    }

    public String getConfigvalue() {
        return configvalue;
    }

    public void setConfigvalue(String configvalue) {
        this.configvalue = configvalue;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}