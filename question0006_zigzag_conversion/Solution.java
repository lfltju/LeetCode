package question0006_zigzag_conversion;

/**
 * https://leetcode-cn.com/problems/zigzag-conversion/
 *
 * 增加一个zigZag标记位来指示移动方向。
 *
 * 时间复杂度是O(n)，其中n为字符串s的长度。空间复杂度是O(numRows * n)。
 *
 * 执行用时：24ms，击败62.22%。消耗内存：44.8MB，击败70.46%。
 */
public class Solution {
    public String convert(String s, int numRows) {
        int n;
        if (null == s || (n = s.length()) <= numRows || numRows == 1 || numRows == 0) {
            return s;
        }
        StringBuilder[] stringBuilders = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            stringBuilders[i] = new StringBuilder();
        }
        int row = 0, zigZag = 1;
        for (int i = 0; i < n; i++) {
            stringBuilders[row].append(s.charAt(i));
            row += zigZag;
            if (row == numRows - 1) {
                zigZag = -1;    //移动到底了，接下去将上移
            }
            if (row == 0) {
                zigZag = 1;     //移动到顶了，接下去将下移
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < stringBuilders.length; i++) {
            result.append(stringBuilders[i]);
        }
        return result.toString();
    }
}