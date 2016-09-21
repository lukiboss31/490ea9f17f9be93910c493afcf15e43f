import java.util.Comparator;

import data.Vokabel;


public class ENComparator implements Comparator<Vokabel> {

	public int compare(Vokabel o1, Vokabel o2) {
		return o1.geten().compareTo(o2.geten());
	}

}
