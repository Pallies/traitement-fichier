package models;

import static org.junit.Assert.*;

import org.junit.Test;

public class MarqueTest {

	@Test
	public void test_name() {
		Marque marque = new Marque("Le Gaulois");
		String name="Le Gaulois";
		System.out.println(marque.getNom());
		assertEquals(marque.getNom(),name);
	}
	@Test
	public void test_name2() {
		Marque marque = new Marque("Le Gaulois");
		String name="Le Gaulois";
		assertEquals(marque.getNom(),name);
	}
	@Test
	public void test_toString() {
		Marque marque = new Marque("Le Gaulois");
		String name="Le Gaulois";
		String nameTostring="Marque "+name;
		assertEquals(marque.toString(), nameTostring);
	}
	@Test
	public void test_equals() {
		Marque marque =new Marque("test");
		Marque marque2 =new Marque("test");
		Marque marque3 =new Marque("test_false");
		Additif additif = new Additif("test");
		assertEquals(marque, marque);
		assertEquals(marque, marque2);
		assertNotEquals(marque, marque3);
		assertNotEquals(marque, marque3);
		assertNotEquals(marque, additif);
	}
	@Test
	public void test_hashCode() {
		Marque marque =new Marque("hashCode");
		Marque marque2 =new Marque("hashCode");
		assertEquals(marque.hashCode(),marque2.hashCode());
	}
}
