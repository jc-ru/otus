public class RemoteWebDriver {

    private static WebDriver driver;

    public static WebDriver setDriver(DriverEnum driverType) {
        switch (driverType) {
            case FIREFOX: {
                return getFirefoxDriver();
            }
            default: {
                return getChromeDriver();
            }
        }
    }

    public static WebDriver getChromeDriver() {
        if (driver == null) {
            try {
                DesiredCapabilities capability = DesiredCapabilities.chrome();
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub/"), capability);
            } catch (Exception e) {
                e.printStackTrace();
            }
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static WebDriver getFirefoxDriver() {
        if (driver == null) {
            WebDriverManager.firefoxdriver().setup();
            DesiredCapabilities capability = DesiredCapabilities.firefox();
            try {
                 driver =  new RemoteWebDriver(new URL("http://localhost:4444/wd/hub/"), capability);
            } catch (Exception e) {
                e.printStackTrace();
            }
            driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            driver.manage().window().maximize();
        }
        return driver;
    }

    public static void closeDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}