package test.hashmap;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import hashmap.HashMap;

public class HashMapGetTests {

	HashMap h;
	@Before
	public void setUp() throws Exception {
		h = new HashMap();
	}

	@Test
	public void GetFirstValueTest() {
		for(int i = 0; i < 10; ++i)
			h.put(i, i);
		
		assertEquals("Incorrect first value in HashMap", 0, (int)h.get(0));
	}
	
	@Test
	public void GetLastValueTest() {
		for(int i = 0; i < 10; ++i)
			h.put(i, i);
		
		assertEquals("Incorrect last value in HashMap", 9, (int)h.get(9));
	}
	
	@Test
	public void GetKeyNotExistsTest() {
		assertEquals("Key shouldn't exist in HashMap and should return null", null, h.get(0));
	}
	
	@Test
	public void GetCollisionTest() {
		h.put(0, 123);
		h.put(0, 567);
		
		assertEquals("Hashmap should have overwritten existing key", 567, (int)h.get(0));
	}

}
