package leetCode.test1_400.test0081_0100;

/**
 * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
 * 示例:
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 */

import java.util.ArrayList;
import java.util.List;

public class Test0093 {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        int n = s.length();
        for (int i = 0; i < 3; i++) {
            for (int j = i + 1; j < i + 4; j++) {
                for (int k = j + 1; k < j + 4; k++) {
                    if (i < n && j < n && k < n) {
                        String tmp1 = s.substring(0, i + 1);
                        String tmp2 = s.substring(i + 1, j + 1);
                        String tmp3 = s.substring(j + 1, k + 1);
                        String tmp4 = s.substring(k + 1);
                        if (helper(tmp1) && helper(tmp2) && helper(tmp3) && helper(tmp4))
                            res.add(tmp1 + "." + tmp2 + "." + tmp3 + "." + tmp4);
                    }
                }
            }
        }
        return res;
    }

    private boolean helper(String tmp) {
        if (tmp == null || tmp.length() == 0 || tmp.length() > 3 || (tmp.charAt(0) == '0' && tmp.length() > 1) || Integer.parseInt(tmp) > 255)
            return false;
        return true;
    }
}
