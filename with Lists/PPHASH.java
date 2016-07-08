class PPHASH {	
	
	public int size;
	public List[] cards;
	public int count;
	
	public PPHASH(int s) {	
		size = s;
		cards = new List[size];
		for (int i = 0; i < size; i++) {
			cards[i] = new List();
		}
		count = 0;
	}
	
	public void put(int value, PPCard c) {
		int key = value % size;
		ListElt newElt = new ListElt(c);
		cards[key].add(newElt);
	}
	
	public boolean containsValue(int value) {
		int key = value % size;
		boolean check = false;
		if (cards[key].find(value) != null) {
			check = true;
		}
		return check;
	}
	
	public PPCard get(int value) {
		int key = value % size;
		int i = 0;
		if (containsValue(value)) {
			return cards[key].find(value);
		} else {
			return null;
		}
	}
	
	public void display(int k) {
		int key = k;
		cards[key].show();
	}
}
