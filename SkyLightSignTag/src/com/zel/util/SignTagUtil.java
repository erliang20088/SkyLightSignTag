package com.zel.util;

import java.util.ArrayList;
import java.util.List;

import com.zel.core.SkyLightAnalyzer;
import com.zel.entity.Forest;
import com.zel.entity.Library;

public class SignTagUtil {
	private Forest forest = new Forest();
	private SkyLightAnalyzer skyLightAnalyzer;
	private String beginTag;
	private String endTag;

	public SignTagUtil(String source, List<String> keywordList,
			String beginTag, String endTag) {
		Library.makeLibrary(forest, keywordList);
		skyLightAnalyzer = new SkyLightAnalyzer(forest, source);

		this.beginTag = beginTag;
		this.endTag = endTag;
	}

	public String getSingTagResult() {
		return skyLightAnalyzer.getSplitResult(this.beginTag, this.endTag);
	}

	public static void main(String[] args) {
		String source = "abc中国vb";
		List<String> list = new ArrayList<String>();

		list.add("中国");
		list.add("中国人");
		
		list.add("abc");
		list.add("a");
		
		String beginTag = "<a>";
		String endTag = "</a>";

		SignTagUtil tagUtil = new SignTagUtil(source, list, beginTag, endTag);

		String result = tagUtil.getSingTagResult();
		System.out.println(result);
	}
}
