package com.github.soshibby.swedbank.types;

/**
 * Created by Henrik on 29/01/2017.
 */
public class Verify {

    private boolean extendedUsage;
    private String status;
    private String formattedServerTime;
    private String serverTime;
    private Links links;

    public boolean isExtendedUsage() {
        return extendedUsage;
    }

    public void setExtendedUsage(boolean extendedUsage) {
        this.extendedUsage = extendedUsage;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Links getLinks() {
        return links;
    }

    public void setLinks(Links links) {
        this.links = links;
    }

    public String getFormattedServerTime() {
        return formattedServerTime;
    }

    public void setFormattedServerTime(String formattedServerTime) {
        this.formattedServerTime = formattedServerTime;
    }

    public String getServerTime() {
        return serverTime;
    }

    public void setServerTime(String serverTime) {
        this.serverTime = serverTime;
    }
}
