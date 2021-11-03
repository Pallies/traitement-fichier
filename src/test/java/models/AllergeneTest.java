package models;

import static org.junit.Assert.*;

import org.junit.Test;

public class AllergeneTest {

	@Test
	public void test_name() {
		Allergene allergene = new Allergene("gluten");
		String name="Gluten";
		assertEquals(allergene.getNom(),name);
	}
	@Test
	public void test_name2() {
		Allergene allergene = new Allergene("gluten");
		String name="Gluten";
		assertEquals(allergene.getNom(),name);
	}
	@Test
	public void test_toString() {
		Allergene allergene = new Allergene("gluten");
		String name="Gluten";
		String nameTostring="Allergene "+name;
		assertEquals(allergene.toString(), nameTostring);
	}
	@Test
	public void test_equals() {
		Allergene allergene =new Allergene("test");
		Allergene allergene2 =new Allergene("test");
		Allergene allergene3 =new Allergene("test_false");
		Additif additif = new Additif("test");
		assertEquals(allergene, allergene);
		assertEquals(allergene, allergene2);
		assertNotEquals(allergene, allergene3);
		assertNotEquals(allergene, allergene3);
		assertNotEquals(allergene, additif);
	}
	@Test
	public void test_hashCode() {
		Allergene allergene =new Allergene("hashCode");
		Allergene allergene2 =new Allergene("hashCode");
		assertEquals(allergene.hashCode(),allergene2.hashCode());
	}

}
