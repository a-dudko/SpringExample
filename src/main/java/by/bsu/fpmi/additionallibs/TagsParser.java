package by.bsu.fpmi.additionallibs;

import java.util.HashSet;
import java.util.Set;

import by.bsu.fpmi.domain.Tag;

public class TagsParser {
	private static TagsParser instance;
	
	public static TagsParser getInstance() {
		if (instance == null) {
			instance = new TagsParser();
		}
		return instance;
	}
	
	public Set<Tag> parse(String tagsToParse) {
		Set<Tag> tags = new HashSet<Tag>();
		String splittedTags[] = tagsToParse.split(",");
		for (int i = 0; i < splittedTags.length; i++) {
			if (!("".equals(splittedTags[i]))) {
				Tag tag = new Tag();
				tag.setText(splittedTags[i]);
				tags.add(tag);
			}
		}
		return tags;
	}
	
	private TagsParser() {
		
	}
	
}
