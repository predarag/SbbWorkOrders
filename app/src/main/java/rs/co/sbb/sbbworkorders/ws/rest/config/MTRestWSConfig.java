package rs.co.sbb.sbbworkorders.ws.rest.config;

/**
 * Created by Predrag.Tasic on 6/6/2017.
 */

public class MTRestWSConfig {

    public static final String host = "http://192.168.2.163";
    public static final String port = ":5555";
    public static final String user = "Administrator";
    public static final String pass = "manage";

    //method invocation
    public static final String BASE_URL = host+port+"/rest/Sbb/MTBusinessService/services/pub/restWS/";
    public static final String URL_LOGIN_SERVICE = host+port+"/rest/Sbb/MTBusinessService/services/pub/restWS/logIn";

}
