
public class Vokabellist {
	private Vokabel[] list = new Vokabel[100];
	private int num = 0;
	private Vokabel tmp;

	public Vokabellist() {
		initlist();

	}

	public void sortList(boolean de) {

		for (int i = 1; i < list.length; i++) {
			if (list[i] != null) {
				tmp = list[i];
				for (int j = i - 1; j >= 0; j--) {
					if (list[j].getdtch()[0] > tmp.getdtch()[0]) {
						list[j + 1] = list[j];
						if (j == 0) {
							list[j] = tmp;
							break;
						}
					} else if (list[j].getdtch()[0] == tmp.getdtch()[0]) {
						check(j, tmp, 1);
					} else {
						list[j] = tmp;
						break;
					}
				}
			}
		}
	}

	public void bubbleSort() {
		boolean c = true;
		while (c) {
			c = false;
			for (int i = 0; i < list.length - 1; i++) {
				if (list[i] != null && list[i + 1] != null) {
					if (list[i].getdtch()[0] > list[i + 1].getdtch()[0]) {
						Vokabel tmp = list[i + 1];
						list[i + 1] = list[i];
						list[i] = tmp;
						c = true;
					} else if (list[i].getdtch()[0] == list[i + 1].getdtch()[0]) {
						// TODO
					}
				}
			}
		}
	}

	public void check(int j, Vokabel tmp, int index) {
		if (list[j].getdtch()[index] > tmp.getdtch()[index]) {
			list[j + 1] = list[j];
		} else if (list[j].getdtch()[index] == tmp.getdtch()[index]) {
			check(j, tmp, index++);
		} else {
			return;
		}
	}

	public void getDt(String en) {
		for (Vokabel v : list) {
			if (en.equals(v.geten())) {
				System.out.println("in Deutsch heiﬂt das " + v.getdt());
				break;
			}
		}
	}

	public void getEn(String dt) {
		for (Vokabel v : list) {
			if (dt.equals(v.getdt())) {
				System.out.println("in Englisch heiﬂt das " + v.geten());
				break;
			}
		}
	}

	public void initlist() {
		addtoList(new Vokabel("haus", "house"));
		addtoList(new Vokabel("aaa", "house"));
		addtoList(new Vokabel("aba", "house"));
		addtoList(new Vokabel("eins", "one"));
		addtoList(new Vokabel("zwei", "two"));
		addtoList(new Vokabel("aab", "house"));
		addtoList(new Vokabel("drei", "three"));
	}

	public void printList() {

		for (Vokabel v : list) {
			if (v != null) {
				System.out.println(v.getdt() + " - " + v.geten());
			} else {
				break;
			}
		}
	}

	public void addtoList(Vokabel v) {
		list[num] = v;
		num++;
	}

	public Vokabel[] getlist() {
		return list;
	}

	public int getnum() {
		return num;
	}
}
