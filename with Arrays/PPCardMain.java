import java.util.Scanner;

class PPCardMain {
	
	public static int cardNum = 0;
	public static int totalcards = 0;
	public static Scanner scn = new Scanner(System.in);
	// Create card array
	public static PPCard[] card = new PPCard[10];

	public static void newCard() {
		// adds counts to keep track of cards
		cardNum++;
		totalcards++;
		
		// fill variables within Card
		System.out.println("\nPlease enter your first and last name: ");
		String fname = scn.next();
		String lname = scn.next();
		String name = fname + " " + lname;
		System.out.println("\nAssign an account number: ");
		int acctNum = scn.nextInt();
		System.out.println("\nEnter an authorization code: ");
		int authCode = scn.nextInt();
		System.out.println("\nHow much would you like to add to the card?");
		float iniBal = scn.nextFloat();
		
		card[cardNum] = new PPCard(iniBal, name, acctNum, authCode);
		
		System.out.println("\nCard created successfully.\n");
	}
	
	public static void newCardTest(String name, int actNum, int authNum, float iniBal) {
		
		cardNum++;
		totalcards++;
		card[cardNum] = new PPCard(iniBal, name, actNum, authNum);
	}
	
	public static void loadCard(String conf) {
		
		float payment = 0;
		int code = 0;
		float recharge = 0;
		int cardRunning = 0;
		String cardConf = "";
		
		for (int i = 1; i <= totalcards; i++) {
			if (Integer.parseInt(conf) == (card[i].acctNum)) {	
				cardRunning = 1;
				System.out.println("\n" + card[i].name + "'s card #" + card[i].acctNum + " loaded, what would you like to do?");
				// if card is found, begins card manipulation options and prompts
				while (cardRunning == 1) {
					System.out.println("( pay / balance / recharge / information / list transactions / cancel)");
					cardConf = scn.next();
					if (cardConf.startsWith("p")) {
						System.out.println("\nPay how much?");
						payment = scn.nextFloat();
						System.out.println("\nAuthorize:");
						code = scn.nextInt();
						card[i].pay(payment, code);
					}
					if (cardConf.startsWith("r")) {
						System.out.println("\nHow much would you like to add?");
						recharge = scn.nextFloat();
						System.out.println("\nAuthorize:");
						code = scn.nextInt();
						card[i].recharge(recharge, code);
					}
					if (cardConf.startsWith("b")) {
						System.out.println("\nThe current balance is: $" + card[i].cbalance);
					}
					if (cardConf.startsWith("c") || cardConf.startsWith("q")) {
						System.out.println("\nCanceling.");
						cardRunning = 0;
					}
					if (cardConf.startsWith("l") || cardConf.startsWith("t")) {
						card[i].listTransactions();
					}
					if (cardConf.startsWith("i")) {
						card[i].display();
					}
				}
			} else if (i == totalcards) {
				System.out.println("\nInvalid card number / input.\n");
			}
		}
	}
	
	public static void main(String args[]) {
		// Initial variables
		int running = 1;
		String conf = "";
		
		// begin program with prompts
		while (running == 1) {
			System.out.println("\nCreate a new card, select a card, or quit: \n( new / account# / list / quit )");

			conf = scn.next();

			if (conf.startsWith("n")) {
				newCard();
			} else if (conf.startsWith("q")) {
				System.out.println("\nExiting.\n");
				running = 0;
			} else if (conf.startsWith("l")) {
				for(int i = 1; i <= totalcards; i++) {
					card[i].display();
				}
			} else {
				loadCard(conf);
			}
		}
	}
}

