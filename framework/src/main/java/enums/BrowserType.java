package enums;

public enum BrowserType {

    CHROME("chrome"), FIREFOX("firefox"),
    EDGE("edge"), OPERA("opera");

    private String name;

    BrowserType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
