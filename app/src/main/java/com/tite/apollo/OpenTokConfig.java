package com.tite.apollo;

import android.webkit.URLUtil;

public class OpenTokConfig {
    // *** Fill the following variables using your own Project info from the OpenTok dashboard  ***
    // ***                      https://dashboard.tokbox.com/projects                           ***

    // Replace with your OpenTok API key
    public static final String API_KEY = "46304112";
    // Replace with a generated Session ID
    public static final String SESSION_ID = "1_MX40NjMwNDExMn5-MTU1NTE4NzUzOTg1N35UN0YxSlhzaXhFM01vRS9HVUdaam5EUEh-UH4";
    // Replace with a generated token (from the dashboard or using an OpenTok server SDK)
    public static final String TOKEN =  "T1==cGFydG5lcl9pZD00NjMwNDExMiZzaWc9MjZiY2RhMWVkYmNlMTdhZTBlNTNlOTcwMWYxMDEwMjM0Y2UwMmQ3YTpzZXNzaW9uX2lkPTFfTVg0ME5qTXdOREV4TW41LU1UVTFOVEU0TnpVek9UZzFOMzVVTjBZeFNsaHphWGhGTTAxdlJTOUhWVWRhYW01RVVFaC1VSDQmY3JlYXRlX3RpbWU9MTU1NTM5MzYyNiZub25jZT0wLjY2NDQyNTYzMDA1NTA2NDYmcm9sZT1wdWJsaXNoZXImZXhwaXJlX3RpbWU9MTU1NTM5NzIyNyZpbml0aWFsX2xheW91dF9jbGFzc19saXN0PQ==";










    /*                           ***** OPTIONAL *****
     If you have set up a server to provide session information replace the null value
     in CHAT_SERVER_URL with it.

     For example: "https://yoursubdomain.com"
    */

//    public static final String CHAT_SERVER_URL = "https://2pjylyzwta.execute-api.us-east-2.amazonaws.com/dev/tokbox";
    public static final String CHAT_SERVER_URL = null;
    public static final String SESSION_INFO_ENDPOINT = CHAT_SERVER_URL + "/session";


    // *** The code below is to validate this configuration file. You do not need to modify it  ***

    public static String webServerConfigErrorMessage;
    public static String hardCodedConfigErrorMessage;

    public static boolean areHardCodedConfigsValid() {
        if (OpenTokConfig.API_KEY != null && !OpenTokConfig.API_KEY.isEmpty()
                && OpenTokConfig.SESSION_ID != null && !OpenTokConfig.SESSION_ID.isEmpty()
                && OpenTokConfig.TOKEN != null && !OpenTokConfig.TOKEN.isEmpty()) {
            return true;
        }
        else {
            hardCodedConfigErrorMessage = "API KEY, SESSION ID and TOKEN in OpenTokConfig.java cannot be null or empty.";
            return false;
        }
    }

    public static boolean isWebServerConfigUrlValid(){
        if (OpenTokConfig.CHAT_SERVER_URL == null || OpenTokConfig.CHAT_SERVER_URL.isEmpty()) {
            webServerConfigErrorMessage = "CHAT_SERVER_URL in OpenTokConfig.java must not be null or empty";
            return false;
        } else if ( !( URLUtil.isHttpsUrl(OpenTokConfig.CHAT_SERVER_URL) || URLUtil.isHttpUrl(OpenTokConfig.CHAT_SERVER_URL)) ) {
            webServerConfigErrorMessage = "CHAT_SERVER_URL in OpenTokConfig.java must be specified as either http or https";
            return false;
        } else if ( !URLUtil.isValidUrl(OpenTokConfig.CHAT_SERVER_URL) ) {
            webServerConfigErrorMessage = "CHAT_SERVER_URL in OpenTokConfig.java is not a valid URL";
            return false;
        } else {
            return true;
        }
    }
}
