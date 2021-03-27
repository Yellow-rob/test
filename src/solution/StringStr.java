package solution;

public class StringStr {
	public int strStr(String haystack, String needle) {
		if(needle.equals("")) {
			return 0;
		}else if(!haystack.contains(needle)) {
			return -1;
		}
		for(int i = 0; i < haystack.length(); i++) {
			if((haystack.charAt(i)) == (needle.charAt(0)) && haystack.substring(i, i + needle.length()).equals(needle)) {
				return i;
			}
		}
		return -1;
	}
}
