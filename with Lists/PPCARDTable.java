
class PPCARDTable {
	static int size = 100;
	static PPHASH table = new PPHASH(size);
	static int key;
	
	public static void create(String name, int actNum, int authCode, float iniBal) {
		key = actNum;
		table.put(key, new PPCard(iniBal, name, actNum, authCode));
	}
	
	public static boolean findCard(int fkey) {
		key = fkey;
		return table.containsValue(key);
	}
	
	public static void pay(float payment, int code) {
		(table.get(key)).pay(payment, code);
	}
	
	public static void recharge(float recharge, int code) {
		(table.get(key)).recharge(recharge, code);
	}
	
	public static void display() {
		(table.get(key)).display();
	}
	
	public static void listTransactions() {
		(table.get(key)).listTransactions();
	}
	
	public static  float getBalance() {
		return (table.get(key)).getBalance();
	}
	
	public static String getName() {
		return (table.get(key)).name;
	}
	
	public static int getActNum() {
		return (table.get(key)).acctNum;
	}
	
	public static void displayAll() {
		for (int i = 0; i < size; i++) {
			table.display(i);
		}
	}
}