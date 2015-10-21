/**
 * 
 */
package hashmap;

/**
 * @author Dhruvil
 *My hashmap implementation
 */
public class HashMap<K, V> {

	private Entry<K, V>[] entry;
	private int numEntries;
	
	public HashMap() {
		this(16);
	}
	
	@SuppressWarnings("unchecked")
	public HashMap(int entries) {
		entry = new Entry[entries];
		numEntries = entries;
	}
	
	private int hash(K key) {
		return key.hashCode() & (numEntries - 1);
	}
	
	public void put(K key, V value) {
		int h = hash(key);

		if (entry[h] == null) {
			entry[h] = new Entry<K, V>(key, value);
			return;
		}
		
		Entry<K, V> head = entry[h];
		Entry<K, V> prev = null;
		while (head != null) {
			if (head.getKey() == key) {
				Entry<K, V> temp = head;
				head = new Entry<K, V>(key, value);
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
				prev.next = new Entry<K, V>(key, value);
			else
				entry[h] = new Entry<K, V>(key, value);
		}
	}
	
	public V get(K key) {
		int h = hash(key);
		
		if (entry[h] != null){
			Entry<K, V> head = entry[h];
			while (head != null) {
				if (head.getKey() == key)
					break;
				head = head.next;
			}
			return head != null ? head.getValue() : null;
		}
		else
			return null;
	}
}
