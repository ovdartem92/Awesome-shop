package ru.awesome.shop.ta.product.bo.address;

public enum Region {
    ABERDEEN("Aberdeen"), BRISTOL("Bristol"), CORNWALL("Cornwall"),
    EDINBURGH("Edinburgh"), ESSEX("Essex"), FALKIRK("Falkirk"),
    FIFE("Fife"), FLINTSHIRE("Flintshire"), GLASGOW("Glasgow"),
    GREATER_LONDON("Greater London"), EMPTY_REGION(" --- Please Select --- ");

    private String regionName;

    Region(String regionName) {
        this.regionName = regionName;
    }

    public String getRegionName() {
        return regionName;
    }
}
