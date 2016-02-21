package Assignment3;

import java.util.Comparator;

public class nameComparator implements Comparator<Item> {

	@Override
    public int compare(Item o1, Item o2) {
        return o1.name.toLowerCase().compareTo(o2.name.toLowerCase());
    }
	
}
