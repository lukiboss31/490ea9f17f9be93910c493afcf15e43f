package database;
import java.util.Comparator;

import data.Vokabel;


public class IndexComparator implements Comparator<Vokabel> {

	public int compare (Vokabel o1, Vokabel o2) {
		if (o1.getBox() > o2.getBox()){
			return 1;
		} else if (o1.getBox() < (o2.getBox())){
			return -1;
		} else{
			return 0;
		}
	}


}
