package comparators;

import model.Hotel;

import java.util.Comparator;

public class CompareHotelByPrice implements Comparator<Hotel> {

    @Override
    public int compare(Hotel h1, Hotel h2) {
        if (h1.getPrice() > h2.getPrice()) return 1;
        else if (h1.getPrice() < h2.getPrice()) return -1;
        else return 0;
    }
}
