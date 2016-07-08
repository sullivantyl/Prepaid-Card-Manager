class PPHASH {	
	
	public int size;
	public int[] keynum;
	public PPCard[] card;
	public int count;
	
	public PPHASH(int s) {	
		size = s;
		keynum = new int[size];
		card = new PPCard[size];
		for(int i = 0; i < size; i++) {
			keynum[i] = -99;
		}
		count = 0;
		System.out.println("HEY");
	}
	
	public void put(int value, PPCard c) {
		int key = value % 100;
		boolean check = false;
		boolean pass = false;
		int i = key;
		while (check==false) {
			System.out.println(i);
			if (keynum[i] == -99) {
				System.out.println("FUN");
				keynum[i] = value;
				card[i] = c;
				check = true;
				count++;
			} else if (i == size) {
				i = 0;
				pass = true;
			} else if (i == key && pass == true) {
				System.out.println("Hash full.");
				check = true;
			}
			i++;
		}
	}
	
	public boolean containsValue(int value) {
		int key = value % 100;
		boolean check = false;
		for(int i = key; i < size; i++) {
			if(keynum[i] == value) {
				check = true;
				break;
			}
		}
		if(check == false) {
			for(int i = 0; i < key; i++) {
				if(keynum[i] == value) {
					check = true;
					break;
				}
			}
		}
		return check;
	}
	
	public PPCard get(int value) {
		int key = value % 100;
		int i = 0;
		if (containsValue(value)) {
			i = key;
			boolean pass = false;
			while (pass == false && i != key) {
				if(keynum[i] == value) {
					return card[i];
				}
				if(i == size) {
					i = 0;
					pass = true;
				}
				i++;
			}
		}
		return card[i];
	}
	
	public boolean findKey(int k) {
		int key = k;
		boolean check = false;
		if (keynum[key] != -99) {
			check = true;
		}
		return check;
	}
	
	public void display(int k) {
		int key = k;
		card[key].display();
	}
}
