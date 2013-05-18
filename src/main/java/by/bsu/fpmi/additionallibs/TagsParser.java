package by.bsu.fpmi.additionallibs;

import java.util.Collection;
import java.util.HashSet;

public class TagsParser {
	private static TagsParser instance;
	
	public static TagsParser getInstance() {
		if (instance == null) {
			instance = new TagsParser();
		}
		return instance;
	}
	
	public Collection<String> parse(String tagsToParse) {
		Collection<String> tags = new HashSet<String>();
		String splittedTags[] = tagsToParse.split(",");
		for (int i = 0; i < splittedTags.length; i++) {
			if (!("".equals(splittedTags[i]))) {
				tags.add(splittedTags[i]);
			}
		}
		return tags;
	}
	
	private TagsParser() {
		
	}
	
}
