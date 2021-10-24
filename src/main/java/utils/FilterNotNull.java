package utils;

import java.util.function.Predicate;

/**
 * The Class FilterNotNull.
 *
 * @author Yvan Palliès
 * Class de filtrage
 * exclu les types String de valeur null ou ""
 */
public class FilterNotNull implements Predicate<String> {

	/**
	 * Test.
	 *
	 * @param value the value
	 * @return true, if successful
	 */
	@Override
	public boolean test(String value) {
		return (!value.contentEquals("") && value!=null);
	}

}
