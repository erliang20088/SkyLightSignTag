package com.zel.entity;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.zel.interfaces.WoodInterface;

public class Library {

	// 辅助字符定位
	private static int temp_index = 0;
	private static int temp_count = 0;

	// 声明一个接口，来接Forest或是Branch，再添新词时经常要切换不同的对象
	private static WoodInterface woodInterface;

	// 暂存keyword中的每个char
	// public static char temp_char=0;
	/**
	 * 通过词典，构造分词的trie树结构
	 */
	public static void makeLibrary(Forest forest, List<String> keywordList) {
		for (String keyword : keywordList) {
			keyword = keyword.trim();
			if (keyword.length() > 0) {
				insertKeyword(forest, keyword);
			}
		}
	}

	// 将一关键词插入到Forest当中
	public static void insertKeyword(Forest forest, String keyword) {
		woodInterface = forest;

		char[] charArray = keyword.toCharArray();
		temp_count = charArray.length;

		for (temp_index = 0; temp_index < temp_count; temp_index++) {
			// 当取到某个keyword的最后一个char时，做参数和status的插入
			if (temp_index == (temp_count - 1)) {
				woodInterface
						.insertBranch(new Branch(charArray[temp_index], 1));
			} else {
				// 只要不是keyword的最后一个词，不添加任何的paras
				woodInterface
						.insertBranch(new Branch(charArray[temp_index], 0));
			}
			woodInterface = woodInterface.getBranch(charArray[temp_index]);
		}
	}
}
