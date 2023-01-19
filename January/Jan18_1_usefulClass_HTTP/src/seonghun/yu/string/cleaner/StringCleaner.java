package seonghun.yu.string.cleaner;

public class StringCleaner {
	public static String clean(String s) {
		s = s.replace("<b>", "");
		s = s.replace("</b>", "");
		s = s.replace("&apos;", "");
		s = s.replace("&quot;", "");
		return s;
	}
}