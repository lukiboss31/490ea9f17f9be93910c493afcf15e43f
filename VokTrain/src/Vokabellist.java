import data.Vokabel;

public class Vokabellist {
	private Vokabel[] list = new Vokabel[100];
	private int num = 0;
	private Vokabel tmp;
	private boolean de;

	public Vokabellist() {
		initlist();

	}

	public void sortList(boolean de) {
		this.de = de;
		for (int i = 1; i < list.length; i++) {
			if (list[i] != null) {
				tmp = list[i];
				for (int j = i - 1; j >= 0; j--) {
					if (getChar(list[j])[0] > getChar(tmp)[0]) {
						list[j + 1] = list[j];
						if (j == 0) {
							list[j] = tmp;
							break;
						}
					} else if (getChar(list[j])[0] == getChar(tmp)[0]) {
						check(j, tmp, 1);
					} else {
						list[j] = tmp;
						break;
					}
				}
			}
		}
	}

	public char[] getChar(Vokabel v) {
		if (de) {
			return v.getdtch();
		} else {
			return v.getench();
		}
	}

	public void bubbleSort(boolean de) {
		this.de = de;
		boolean c = true;
		while (c) {
			c = false;
			for (int i = 0; i < list.length - 1; i++) {
				if (list[i] != null && list[i + 1] != null) {
					if (getChar(list[i])[0] > getChar(list[i + 1])[0]) {
						Vokabel tmp = list[i + 1];
						list[i + 1] = list[i];
						list[i] = tmp;
						c = true;
					} else if (getChar(list[i])[0] == getChar(list[i + 1])[0]) {
						// TODO
					}
				}
			}
		}
	}

	public void check(int j, Vokabel tmp, int index) {
		if (getChar(list[j])[index] > getChar(tmp)[index]) {
			list[j + 1] = list[j];
		} else if (getChar(list[j])[index] == getChar(tmp)[index]) {
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
		addtoList(new Vokabel("haus", "house",0));
		addtoList(new Vokabel("aaa", "house",0));
		addtoList(new Vokabel("aba", "house",0));
		addtoList(new Vokabel("eins", "one",0));
		addtoList(new Vokabel("zwei", "two",0));
		addtoList(new Vokabel("aab", "house",0));
		addtoList(new Vokabel("drei", "three",0));
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
