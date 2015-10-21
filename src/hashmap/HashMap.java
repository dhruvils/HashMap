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

		entry[h] = new Entry(key, value);
	}
	
	public int get(int key) {
		int h = hash(key);
		return entry[h].getValue();
	}
	
	public void printAll() {
		for(Entry e : entry) {
			if (e != null)
				System.out.println(e.getKey() +":" +e.getValue());
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		HashMap h = new HashMap();
		
		for (int i = 0; i < 10; ++i)
			h.put(i, i);
		
		h.printAll();
	}

}
