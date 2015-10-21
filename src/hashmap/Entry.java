package hashmap;

public class Entry {
	private int key;
	private int value;
	Entry next;
	
	public Entry(int k, int v) {
		key = k;
		value = v;
	}
	
	public int getKey() {
		return key;
	}
	
	public int getValue() {
		return value;
	}
}
