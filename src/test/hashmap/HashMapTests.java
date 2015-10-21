package test.hashmap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import hashmap.HashMap;

public class HashMapTests {

	HashMap<Integer, Integer> h;
	@Before
	public void setUp() throws Exception {
		h = new HashMap<Integer, Integer>();
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
	public void GetOverwrittenValueTest() {
		h.put(0, 123);
		h.put(0, 567);
		
		assertEquals("Hashmap should have overwritten existing key", 567, (int)h.get(0));
	}
	
	@Test
	public void GetCollisionTest() {
		h.put(0, 123);
		h.put(16, 567);
		
		assertEquals("First collision value is wrong", 123, (int)h.get(0));
		assertEquals("Second collision value is wrong", 567, (int)h.get(16));
	}
	
	@Test
	public void ContainsKeyTest() {
		h.put(0,  123);
		h.put(1,  456);
		
		assertTrue("ContainsKey should have been true", h.containsKey(0));
	}
	
	@Test
	public void NotContainsKeyInEmptyMapTest() {
		assertFalse("Shouldn't contain key", h.containsKey(0));
	}
	
	@Test
	public void NotContainsKeyTest() {
		for (int i = 0; i < 100000; ++i)
			h.put(i, i);
		
		assertFalse("Shouldn't contain key", h.containsKey(999999));
	}
	
	@Test
	public void PutLoadTest() {
		for (int i = 0; i < 100000; ++i)
			h.put(i, i);
		
		assertEquals("Thousand entries weren't added", 99999, (int)h.get(99999));
	}

}
