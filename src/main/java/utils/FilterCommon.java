package utils;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.function.Function;

public abstract class FilterCommon implements Comparator<Entry<String, Integer>>,
Function<Entry<String, Integer>, String> {
	
	protected HashMap<String, Integer> hahsMapCount = new HashMap<>();
	
	public int compare(Entry<String, Integer> o1, Entry<String, Integer> o2) {
		return o2.getValue() - o1.getValue();
	}
	
	public String apply(Entry<String, Integer> hashMap) {
		StringBuilder builderString = new StringBuilder();
		return builderString.append(hashMap.getKey()).append(" => ").append(hashMap.getValue()).toString();
	}
	/**Getter
	 * @return the hahsMapCount
	 */
	public HashMap<String, Integer> getHahsMapCount() {
		return hahsMapCount;
	}
}
