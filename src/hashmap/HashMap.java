/**
 * 
 */
package hashmap;

/**
 * @author Dhruvil
 *My hashmap implementation
 */
public class HashMap {

	private Entry[] entry;
	private int numEntries;
	
	public HashMap() {
		this(16);
	}
	
	public HashMap(int entries) {
		entry = new Entry[entries];
		numEntries = entries;
	}
	
	private int hash(int key) {
		return key & (numEntries - 1);
	}
	
	public void put(int key, int value) {
		int h = hash(key);

		if (entry[h] == null) {
			entry[h] = new Entry(key, value);
			return;
		}
		
		Entry head = entry[h];
		Entry prev = null;
		while (head != null) {
			if (head.getKey() == key) {
				Entry temp = head;
				head = new Entry(key, value);
				head.next = temp.next;
				if (prev != null)
					prev.next = head;
				else
					entry[h] = head;
				break;
			} else {
				prev = head;
				head = head.next;
			}
		}
		
		if (head == null) {
			if (prev != null)
				prev.next = new Entry(key, value);
			else
				entry[h] = new Entry(key, value);
		}
	}
	
	public Integer get(int key) {
		int h = hash(key);
		
		if (entry[h] != null){
			Entry head = entry[h];
			while (head != null) {
				if (head.getKey() == key)
					break;
				head = head.next;
			}
			return head != null ? head.getValue() : null;
		}
		else
			return (Integer) null;
	}
	
	/*public void printAll() {
		for(Entry e : entry) {
			if (e != null)
				System.out.println(e.getKey() +":" +e.getValue());
		}
	}*/

}
