class PPCard {
	// initial variables
	float cbalance;
	String name;
	int acctNum;
	int authCode;
	int transactionNum;
	float[] tAmmount;
	String[] tType;
	
	PPCard(PPCard other) {
		this.name = other.name;
		this.acctNum = other.acctNum;
		this.authCode = other.authCode;
		this.cbalance = other.cbalance;
		this.transactionNum = other.transactionNum;
		this.tAmmount = other.tAmmount;
		this.tType = other.tType;
	}
	
	PPCard(float iniBal, String newName, int newAcct, int newAuth) {
		// main constructor
		cbalance = iniBal;
		name = newName;
		acctNum = newAcct;
		authCode = newAuth;
		transactionNum = 0;
		tAmmount = new float[100];
		tType = new String[100];
	}
	
	// balance retrieval
	public float getBalance() {
		return cbalance;
	}
	
	public void listTransactions() {
		System.out.println("\nTransactions:\n");
		for(int i = 0; i < transactionNum; i++) {
			System.out.println("#" + (i + 1) + ": " + tType[i] + " = $" + tAmmount[i]);
		}
		System.out.println("\nCurrent Balance: $" + cbalance + "\n");
	}
	// print information
	public void display() {
		System.out.println("\n" + name);
		System.out.println("Act#: " + acctNum);
		System.out.println("Current Balance: $" + cbalance);
		System.out.println("Number of transactions: " + transactionNum + "\n");
	}
	
	// recharge function
	public void recharge(float recharge, int code) {
		// requires authorization
		if (authorize(code) == 1) {
			cbalance = cbalance + recharge;
			System.out.println("\nCard successfully charged.");
			System.out.println("New balance: $" + cbalance + "\n");
			tType[transactionNum] = "Recharge";
			tAmmount[transactionNum] = recharge;
			transactionNum++;
		} else {
			System.out.println("\nUnauthorized transaction attempt.\n");
		}
	}
	
	public void pay(float charge, int code) {
		// requires authorization
		if (authorize(code) == 1) {
			if (cbalance - charge > 0) {
				cbalance = cbalance - charge;
				System.out.println("\nTransaction successful.");
				System.out.println("New balance: $" + cbalance + "\n");
				tType[transactionNum] = "Payment";
				tAmmount[transactionNum] = charge;
				transactionNum++;
			} else {
				System.out.println("\nInsufficient funds. Charge declined");
				System.out.println("The card's balance is: $" + cbalance + "\n");
			}
		} else {
			System.out.println("\nUnauthorized transaction attempt.\n");
		}
	}
	
	public int authorize(int authAttempt) {
		if (authAttempt == authCode) {
			return 1;
		} else {
			return 0;
		}
	}
	
	public static void main(String args[]) {
		
	}
}