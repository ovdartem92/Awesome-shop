package ru.awesome.shop.ta.product.bo.address;

import org.apache.commons.lang3.RandomStringUtils;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

import static java.lang.String.format;

public final class AddressFactory {
    private static final int startInclusive = 3;
    private static final int endExclusive = 10;
    private static final String FIRST_ADDRESS = RandomStringUtils.randomAlphanumeric(startInclusive, endExclusive);
    private static final String SECOND_ADDRESS = RandomStringUtils.randomAlphanumeric(startInclusive, endExclusive);
    private static final String CITY = RandomStringUtils.randomAlphabetic(startInclusive, endExclusive);
    private static final String POSTCODE = RandomStringUtils.randomNumeric(startInclusive, endExclusive);
    private static final String COUNTRY = RandomStringUtils.randomAlphabetic(startInclusive, endExclusive);
    private static final String REGION = Region.getRandomRegion();

    private AddressFactory() {
        throw new AssertionError(format("Creation of instance of %s is prohibited.", AddressFactory.class));
    }

    public static Address generateValidAddress() {
        return new Address(FIRST_ADDRESS, SECOND_ADDRESS, CITY, POSTCODE, COUNTRY, REGION);
    }

    public static Address generateAddressWithInvalidCity() {
        String invalidCity = RandomStringUtils.randomAscii(startInclusive, endExclusive);
        return new Address(FIRST_ADDRESS, SECOND_ADDRESS, invalidCity,
                POSTCODE, COUNTRY, REGION);
    }

    public static Address generateAddressWithEmptyFirstAddress() {
        return new Address("", SECOND_ADDRESS, CITY, POSTCODE, COUNTRY, REGION);
    }

    public static Address generateAddressWithEmptySecondAddress() {
        return new Address(FIRST_ADDRESS, "", CITY, POSTCODE, COUNTRY, REGION);
    }

    public static Address generateAddressWithEmptyCity() {
        return new Address(FIRST_ADDRESS, SECOND_ADDRESS, "", POSTCODE, COUNTRY, REGION);
    }

    public static Address generateAddressWithEmptyPostCode() {
        return new Address(FIRST_ADDRESS, SECOND_ADDRESS, CITY, "", COUNTRY, REGION);
    }

    public static Address generateAddressWithEmptyCountry() {
        return new Address(FIRST_ADDRESS, SECOND_ADDRESS, CITY, CITY, "", REGION);
    }

    public static Address generateAddressWithEmptyRegion() {
        return new Address(FIRST_ADDRESS, SECOND_ADDRESS, CITY, CITY, COUNTRY, " --- Please Select --- ");
    }

    enum Region {
        ABERDEEN("Aberdeen"), ABERDEENSHIRE("Aberdeenshire"), ANGLESEY("Anglesey"),
        ANGUS("Angus"), ARGYLL_AND_BUTE("Argyll and Bute"), BEDFORDSHIRE("Bedfordshire"),
        BERKSHIRE("Berkshire"), BLAENAU_GWENT("Blaenau Gwent"), BRIDGEND("Bridgend"),
        BRISTOL("Bristol"), BUCKINGHAMSHIRE("Buckinghamshire"), CAERPHILLY("Caerphilly"),
        CAMBRIDGESHIRE("Cambridgeshire"), CARDIFF("Cardiff"),
        CARMARTHENSHIRE("Carmarthenshire"), CEREDIGION("Ceredigion"),
        CHESHIRE("Cheshire"), CLACKMANNANSHIRE("Clackmannanshire"), CONWY("Conwy"),
        CORNWALL("Cornwall"), COUNTY_ANTRIM("County Antrim"),
        COUNTY_ARMAGH("County Armagh"), COUNTY_DOWN("County Down"),
        COUNTY_FERMANAGH("County Fermanagh"), COUNTY_LONDONDERRY("County Londonderry"),
        COUNTY_TYRONE("County Tyrone"), CUMBRIA("Cumbria"), DENBIGHSHIRE("Denbighshire"),
        DERBYSHIRE("Derbyshire"), DEVON("Devon"), DORSET("Dorset"),
        DUMFRIES_AND_GALLOWAY("Dumfries and Galloway"), DUNDEE("Dundee"),
        DURHAM("Durham"), EAST_AYRSHIRE("East Ayrshire"),
        EAST_DUNBARTONSHIRE("East Dunbartonshire"), EAST_LOTHIAN("East Lothian"),
        EAST_RENFREWSHIRE("East Renfrewshire"),
        EAST_RIDING_OF_YORKSHIRE("East Riding of Yorkshire"), EAST_SUSSEX("East Sussex"),
        EDINBURGH("Edinburgh"), ESSEX("Essex"), FALKIRK("Falkirk"),
        FIFE("Fife"), FLINTSHIRE("Flintshire"), GLASGOW("Glasgow"),
        GLOUCESTERSHIRE("Gloucestershire"), GREATER_LONDON("Greater London"),
        GREATER_MANCHESTER("Greater Manchester"), GWYNEDD("Gwynedd"),
        HAMPSHIRE("Hampshire"), HEREFORDSHIRE("Herefordshire"),
        HERTFORDSHIRE("Hertfordshire"), HIGHLANDS("Highlands"), INVERCLYDE("Inverclyde"),
        ISLE_OF_WIGHT("Isle of Wight"), KENT("Kent"), LANCASHIRE("Lancashire"),
        LEICESTERSHIRE("Leicestershire"), LINCOLNSHIRE("Lincolnshire"),
        MERSEYSIDE("Merseyside"), MERTHYR_TYDFIL("Merthyr Tydfil"),
        MIDLOTHIAN("Midlothian"), MONMOUTHSHIRE("Monmouthshire"), MORAY("Moray"),
        NEATH_PORT_TALBOT("Neath Port Talbot"), NEWPORT("Newport"), NORFOLK("Norfolk"),
        NORTH_AYRSHIRE("North Ayrshire"), NORTH_LANARKSHIRE("North Lanarkshire"),
        NORTH_YORKSHIRE("North Yorkshire"), NORTHAMPTONSHIRE("Northamptonshire"),
        NORTHUMBERLAND("Northumberland"), NOTTINGHAMSHIRE("Nottinghamshire"),
        ORKNEY_ISLANDS("Orkney Islands"), OXFORDSHIRE("Oxfordshire"),
        PEMBROKESHIRE("Pembrokeshire"), PERTH_AND_KINROSS("Perth and Kinross"),
        POWYS("Powys"), RENFREWSHIRE("Renfrewshire"),
        RHONDDA_CYNON_TAFF("Rhondda Cynon Taff"), RUTLAND("Rutland"),
        SCOTTISH_BORDERS("Scottish Borders"), SHETLAND_ISLANDS("Shetland Islands"),
        SHROPSHIRE("Shropshire"), SOMERSET("Somerset"), SOUTH_AYRSHIRE("South Ayrshire"),
        SOUTH_LANARKSHIRE("South Lanarkshire"), SOUTH_YORKSHIRE("South Yorkshire"),
        STAFFORDSHIRE("Staffordshire"), STIRLING("Stirling"), SUFFOLK("Suffolk"),
        SURREY("Surrey"), SWANSEA("Swansea"), TORFAEN("Torfaen"),
        TYNE_AND_WEAR("Tyne and Wear"), VALE_OF_GLAMORGAN("Vale of Glamorgan"),
        WARWICKSHIRE("Warwickshire"), WEST_DUNBARTONSHIRE("West Dunbartonshire"),
        WEST_LOTHIAN("West Lothian"), WEST_MIDLANDS("West Midlands"),
        WEST_SUSSEX("West Sussex"), WEST_YORKSHIRE("West Yorkshire"),
        WESTERN_ISLES("Western Isles"), WILTSHIRE("Wiltshire"),
        WORCESTERSHIRE("Worcestershire"), WREXHAM("Wrexham");

        private String regionName;

        Region(String regionName) {
            this.regionName = regionName;
        }

        static String getRandomRegion() {
            List<Region> regionList = Arrays.asList(Region.values());
            Random random = new Random();
            int size = regionList.size();
            int randomIndex = random.nextInt(size);
            Region randomRegion = regionList.get(randomIndex);
            return randomRegion.regionName;
        }
    }
}
