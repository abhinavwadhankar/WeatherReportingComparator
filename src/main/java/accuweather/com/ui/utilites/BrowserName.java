package accuweather.com.ui.utilites;

public enum BrowserName {
            CHROME("chrome"),
            FIREFOX("firefox");

    private String browserName;

    BrowserName(String name) {
     this.browserName = name;
    }

    public String getBrowserName() {
        return browserName;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }
}
