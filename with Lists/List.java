// class List : holds head pointer, also utility functions


class List {
	
	ListElt head;
	ListElt tail;

	void add(ListElt newElt) {
		// add newElt to front of list
		if (head == null) {
			tail = newElt;
		}
		ListElt temp = head;
		head = newElt;
		head.next = temp;
	}
	
	void extend(ListElt newElt) {
		tail.next = newElt;
		tail = tail.next;	
	}

	ListElt remove() {
		// remove first item from list, return it
		// should not be called if list is empty
		ListElt temp = head;
		head = head.next;
		return temp;  
	}

	boolean isEmpty() {
		// indicate if the list ie empty
		boolean empty = false;
		if (head == null) {
			empty = true;
		}
		return empty;
	}

	PPCard find(int what) {
		// look for an element whose data field is as specified.  
		// Return a pointer to that element (do not remove from list)
		//  or null if not found.
		ListElt temp = head;
		while (temp != null) {
			if ((temp.card).acctNum == what) {
				break;
			} else {
				temp = temp.next;
			}
		}
		return temp.card; 
	}

	int count() {
		// figure out how many elements are in the list
		int count = 0;
		ListElt temp = head;
		while (temp != null) {
			count++;
			temp = temp.next;
		}
		return count;    
	}

	void show() {
		ListElt temp = head;
		// print out all the elements of the list.  
		// need not be really pretty.
		while (temp != null) {
			(temp.card).display();
			temp = temp.next;
		}
	}
}