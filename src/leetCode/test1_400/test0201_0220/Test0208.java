package leetCode.test1_400.test0201_0220;

/**
 * @author nimingxiong
 * Created at 2020/3/6 21:23
 * 
 * 实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
 * 示例:
 * Trie trie = new Trie();
 * trie.insert("apple");
 * trie.search("apple");   // 返回 true
 * trie.search("app");     // 返回 false
 * trie.startsWith("app"); // 返回 true
 * trie.insert("app");
 * trie.search("app");     // 返回 true
 * 说明:
 * 你可以假设所有的输入都是由小写字母 a-z 构成的。
 * 保证所有输入均为非空字符串
 */

public class Test0208 {
    class TrieNode {
        public int path;
        public int end;
        public TrieNode[] map;

        public TrieNode() {
            path = 0;
            end = 0;
            map = new TrieNode[26];
        }
    }

    private TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Test0208() {
        //初始化根节点
        root = new TrieNode();
    }
    //添加word可以重复添加

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        if (word == null) {
            return;
        }
        //让node指向根节点并加1
        char[] chs = word.toCharArray();
        TrieNode node = root;
        node.path++;
        int index = 0;
        //下面for循环式判断这个元素为空就创建个节点，并让指针指向这个节点，并path加1，否则不创建节点只统计
        for (int i = 0; i < chs.length; i++) {
            index = chs[i] - 'a';
            if (node.map[index] == null) {
                node.map[index] = new TrieNode();
            }
            //指向下个节点
            node = node.map[index];
            //对应节点加1，这个使用的链表每个节点对应自己的path
            node.path++;
        }
        //最后以这个节点结束加1
        node.end++;
    }
    //查找单词word是否存在字典树里

    /**
     * Returns if the word is in the trie.
     */
    public boolean search(String word) {
        if (word == null) {
            return false;
        }
        char[] chs = word.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0; i < chs.length; i++) {
            index = chs[i] - 'a';
            if (node.map[index] == null) {
                return false;
            }
            node = node.map[index];
        }
        //找到尾结点了且这个end不为0证明以前有以这个几点结束的节点
        return node.end != 0;
    }
    //返回是否存在有以prefix为前缀的单词

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        if (prefix == null) {
            return false;
        }
        char[] chs = prefix.toCharArray();
        TrieNode node = root;
        int index = 0;
        for (int i = 0; i < chs.length; i++) {
            index = chs[i] - 'a';
            if (node.map[index] == null) {
                return false;
            }
            node = node.map[index];
        }
        //如果在上述查找在都没有返回false证明有以这为前缀的返回true
        return true;
    }

}
