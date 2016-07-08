class ListElt {
	ListElt next;
	ListElt last;
	PPCard card;
	int key;

	ListElt(PPCard myCard) {
		// create a new cell with specified data.
		card = myCard;
		key = card.acctNum;
	}
}