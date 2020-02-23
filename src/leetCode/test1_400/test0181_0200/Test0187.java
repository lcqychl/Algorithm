package leetCode.test1_400.test0181_0200;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author nimingxiong
 * Created at 2020/2/23 19:59
 *
 * 所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，
 * 例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
 * 编写一个函数来查找 DNA 分子中所有出现超过一次的 10 个字母长的序列（子串）。
 * 示例：
 * 输入：s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * 输出：["AAAAACCCCC", "CCCCCAAAAA"]
 */

public class Test0187 {
    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        if (len == 0 || len < 10) {
            return new ArrayList<>();
        }
        Set<String> res = new HashSet<>();
        Set<Integer> set = new HashSet<>();
        int key = 0;
        char[] array = s.toCharArray();
        for (int i = 0; i < 10; i++) {
            key <<= 3;
            key |= (array[i] & 7);
        }
        set.add(key);
        for (int i = 10; i < len; i++) {
            key <<= 3;
            key |= (array[i] & 7);
            key &= 0x3fffffff;
            if (set.contains(key)) {
                res.add(s.substring(i - 9, i + 1));
            } else {
                set.add(key);
            }

        }
        return new ArrayList<>(res);
    }
}
