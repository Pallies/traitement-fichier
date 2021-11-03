package models;






import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

public class AdditifTest {

	@Test
	public void test_name() {
		Additif additif = new Additif("e202 - Sorbate de potassium");
		String name="E202 - sorbate de potassium";
		assertEquals(additif.getNom(),name);
	}
	@Test
	public void test_name2() {
		Additif additif = new Additif("202 - Sorbate de potassium");
		String name="202 - sorbate de potassium";
		assertEquals(additif.getNom(),name);
	}
	@Test
	public void test_toString() {
		Additif additif = new Additif("e202 potassium");
		String name="E202 potassium";
		String nameTostring="Additif "+name;
		assertEquals(additif.toString(), nameTostring);
	}
	@Test
	public void test_equals() {
		Additif additif =new Additif("test");
		Additif additif2 =new Additif("test");
		Additif additif3 =new Additif("test_false");
		Allergene allergene = new Allergene("test");
		assertEquals(additif, additif);
		assertEquals(additif, additif2);
		assertNotEquals(additif, additif3);
		assertNotEquals(additif, additif3);
		assertNotEquals(additif, allergene);
	}
	@Test
	public void test_hashCode() {
		Additif additif =new Additif("hashCode");
		Additif additif2 =new Additif("hashCode");
		assertEquals(additif.hashCode(),additif2.hashCode());
	}

}
