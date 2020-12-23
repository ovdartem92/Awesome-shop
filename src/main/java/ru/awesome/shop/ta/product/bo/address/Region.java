package ru.awesome.shop.ta.product.bo.address;

enum Region {
    ABERDEEN("Aberdeen"), BRISTOL("Bristol"), CORNWALL("Cornwall"),
    EDINBURGH("Edinburgh"), ESSEX("Essex"), FALKIRK("Falkirk"),
    FIFE("Fife"), FLINTSHIRE("Flintshire"), GLASGOW("Glasgow"),
    GREATER_LONDON("Greater London");

    private String regionName;

    Region(String regionName) {
        this.regionName = regionName;
    }

    String getRegionName() {
        return regionName;
    }
}
