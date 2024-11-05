package driverFactory;

import Constants.DriverType;

public class DriverManagerFactory {
    public static DriverManager getDriverType(DriverType driverType){
        switch(driverType){
            case CHROME :
                return new ChromeDriverManager();
            case FIREFOX :
                return new FirefoxDriverManager();
            case EDGE :
                return new EdgeDriverManager();
            default:
                throw new IllegalStateException("Not provided proper driver type");
        }
    }
}
