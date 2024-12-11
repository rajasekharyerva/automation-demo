package com.automation.magento.utilites;

public class Utility {
    public static String appendEmailWithTimeStamp(String email) {
        String timeStamp = String.valueOf(System.currentTimeMillis());
        String localPart = email.split("@")[0];
        String domain = email.split("@")[1];
        return localPart + "+" + timeStamp + "@" + domain;
    }
}