package com.learn.algorithm.string;

import java.util.Arrays;

/**
 * 字典树/前缀树
 * 只包含小写字母的前缀树，单词需要按长度从长到短插入
 *
 * @author yymuhua
 * @create 2020-03-28 11:23
 */
public class Trie {
    TrieNode root;
    int size;     // 前缀树中能表示所有单词的字典单词长度

    public Trie() {
        root = new TrieNode();
    }

    public void insert(String word) {
        int N = word.length();
        // 按word从后往前搜索
        TrieNode curr = root;
        boolean needAdd = false;
        for (int i = 0; i < N; i++) {
            int child = word.charAt(i) - 'a';
            if (curr.children[child] == null) {
                needAdd = true;
                curr.children[child] = new TrieNode();
            }
            curr = curr.children[child];
        }
        if (needAdd) size += word.length();
    }

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
    }
}
