import java.util.Comparator;

import data.Vokabel;

public class DEComparator implements Comparator<Vokabel>{

	public int compare(Vokabel o1, Vokabel o2) {
		return o1.getdt().compareTo(o2.getdt());
	}

}
