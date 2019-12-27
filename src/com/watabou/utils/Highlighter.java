package com.watabou.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Highlighter {
	
	private static final Pattern HIGHLIGHTER	= Pattern.compile( "_(.*?)_" );
	private static final Pattern STRIPPER		= Pattern.compile( "[ \n]" );
	
	public String text;
	
	public boolean[] mask;
	
	public Highlighter( String text ) {
		
		String stripped = STRIPPER.matcher( text ).replaceAll( "" );
		mask = new boolean[stripped.length()];
		
		Matcher m = HIGHLIGHTER.matcher( stripped );
		
		int pos = 0;
		int lastMatch = 0;
		
		while (m.find()) {
			pos += (m.start() - lastMatch);
			int groupLen = m.group( 1 ).length();
			for (int i=pos; i < pos + groupLen; i++) {
				mask[i] = true;
			}
			pos += groupLen;
			lastMatch = m.end();
		}
		
		m.reset( text );
		StringBuffer sb = new StringBuffer();
		while (m.find()) {
			m.appendReplacement( sb, m.group( 1 ) );
		}
		m.appendTail( sb );
		
		this.text = sb.toString();
	}
	
	public boolean[] inverted() {
		boolean[] result = new boolean[mask.length];
		for (int i=0; i < result.length; i++) {
			result[i] = !mask[i];
		}
		return result;
	}
	
	public boolean isHighlighted() {
		for (int i=0; i < mask.length; i++) {
			if (mask[i]) {
				return true;
			}
		}
		return false;
	}
}