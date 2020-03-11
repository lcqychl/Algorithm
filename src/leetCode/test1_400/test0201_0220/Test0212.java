package leetCode.test1_400.test0201_0220;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nimingxiong
 * Created at 2020/3/11 21:36
 *
 * 给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。
 * 同一个单元格内的字母在一个单词中不允许被重复使用。
 * 示例:
 * 输入:
 * words = ["oath","pea","eat","rain"] and board =
 * [
 *   ['o','a','a','n'],
 *   ['e','t','a','e'],
 *   ['i','h','k','r'],
 *   ['i','f','l','v']
 * ]
 * 输出: ["eat","oath"]
 * 说明:
 * 你可以假设所有输入都由小写字母 a-z 组成。
 * 提示:
 * 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？
 * 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。
 * 什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 
 * 前缀树如何？如果你想学习如何实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。
 */

public class Test0212 {
    class Node {
        Node[] next;
        boolean isWord;
        String str;

        public Node() {
            next = new Node[26];
            isWord = false;
        }
    }

    private Node root;
    private int[] dr;
    private int[] dc;

    private void addWord(String word) {
        int len = word.length();
        Node curNode = root;
        for (int i = 0; i < len; i++) {
            char curChar = word.charAt(i);
            Node next = curNode.next[curChar - 'a'];
            if (next == null) curNode.next[curChar - 'a'] = new Node();
            curNode = curNode.next[curChar - 'a'];
        }
        curNode.isWord = true;
        curNode.str = word;
    }

    private void backtrack(char[][] board, boolean[][] used, int i, int j, List<String> result, Node cur) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || used[i][j]) {
            return;
        }
        cur = cur.next[board[i][j] - 'a'];
        if (cur == null) return;
        used[i][j] = true;
        if (cur.isWord) {
            result.add(cur.str);
            cur.isWord = false;
        }
        for (int k = 0; k < 4; k++)
            backtrack(board, used, i + dr[k], j + dc[k], result, cur);
        used[i][j] = false;
    }

    public List<String> findWords(char[][] board, String[] words) {
        root = new Node();
        dr = new int[]{1, 0, -1, 0};
        dc = new int[]{0, 1, 0, -1};
        for (String word : words) addWord(word);
        List<String> result = new ArrayList<>();
        boolean[][] used = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++)
            for (int j = 0; j < board[0].length; j++)
                backtrack(board, used, i, j, result, root);
        return result;
    }
}
