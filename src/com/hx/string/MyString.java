package com.hx.string;

import com.hx.tree.TreeNode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author jxlgcmh
 * @date 2019-11-14 12:21
 * @description
 */
public class MyString {

    public static void main(String[] args) {
        MyString instance = new MyString();

        System.out.println(instance.rotatedDigits(10));
    }

    /**
     * 旋转数字  2 5  6  9
     * @param N
     * @return
     * 链接：https://leetcode-cn.com/problems/rotated-digits/solution/xuan-zhuan-shu-zi-by-leetcode/
     */
    public int rotatedDigits(int N) {
        // Count how many n in [1, N] are good.
        int ans = 0;
        for (int n = 1; n <= N; ++n)
            if (good(n, false)) ans++;
        return ans;
    }

    /**
     * 判断一个数反过来是否一样
     * @param n
     * @param flag
     * @return
     */
    private boolean good(int n, boolean flag) {
        if (n == 0) return flag;
        // 取模得到最后一位数
        int d = n % 10;
        // 如果最后一位数是 3,4,7，返回false
        if (d == 3 || d == 4 || d == 7) return false;
        // 如果是 0,1,8 继续遍历，初始flag为false
        if (d == 0 || d == 1 || d == 8) return good(n / 10, flag);
        // 如果是2,5,9，继续遍历，初始flag是true
        return good(n / 10, true);
    }





    /**
     * 重复叠加字符串匹配
     * 举个例子，A = "abcd"，B = "cdabcdab"。
     * 答案为 3， 因为 A 重复叠加三遍后为 “abcdabcdabcd”，此时 B 是其子串；A 重复叠加两遍后为"abcdabcd"，B 并不是其子串。
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/repeated-string-match
     *
     * @param A
     * @param B
     * @return
     */
    public int repeatedStringMatch(String A, String B) {
        StringBuilder tmp = new StringBuilder(A);
        int count = 0;
        for (int i = 0; i < B.length()/A.length() +1; i++) {
            if (tmp.toString().contains(B)) {
                return count +1;
            }
            count++;
            // 这里犯了一个很严重的错误
            tmp.append(A);
        }
        return -1;
    }

    /**
     * 二进制子串
     * 00110011
     *
     * @param s
     * @return 链接：https://leetcode-cn.com/problems/count-binary-substrings/solution/ji-shu-er-jin-zhi-zi-chuan-by-leetcode/
     */
    public int countBinarySubstrings(String s) {
        // 结果       前置坐标    后置坐标
        int ans = 0, prev = 0, cur = 1;
        // 循环遍历
        for (int i = 1; i < s.length(); i++) {
            // 如果前一个字符和后一个字符不一样
            if (s.charAt(i - 1) != s.charAt(i)) {
                ans += Math.min(prev, cur);
                prev = cur;
                cur = 1;
            }
            // 如果前一个字符和后一个字符一样,cur +1
            else {
                cur++;
            }
        }
        return ans + Math.min(prev, cur);
    }

    /**
     * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
     *
     * @param s
     * @return
     */
    public boolean validPalindrome(String s) {
        char[] chars = s.toCharArray();
        int left = 0, right = chars.length - 1, deleteIndex = -1;
        while (left < right) {
            // 如果头尾不一致
            if (chars[left] != chars[right]) {
                // 第一次出现不一样  把删除下标置为第一次出现不同的头下标，头下标加1
                if (deleteIndex == -1) {
                    deleteIndex = left;
                    left++;
                }
                // 如果删除下标的值等于字符串的长度，返回false
                else if (deleteIndex == chars.length) return false;
                    // 基于头尾不一样的情况下，改变左下标  改变右下标  改变删除下标
                    // 这种情况是把右下标往左移动一个位置
                else {
                    left = deleteIndex;
                    right = chars.length - left - 2;
                    deleteIndex = chars.length;
                }
            }
            // 头尾一致
            else {
                left++;
                right--;
            }
        }
        return true;
    }


    /**
     * 实现lowercase功能
     *
     * @param str
     * @return
     */
    public String toLowerCase(String str) {
        char[] chars = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char ch : chars) {
            if (ch >= 65 && ch <= 90) {
                sb.append((char) (ch - 32));
            } else {
                sb.append(ch);
            }
        }
        return sb.toString();
    }


    /**
     * 机器人是否能返回原点
     *
     * @param moves
     * @return
     */
    public boolean judgeCircle(String moves) {
        int du = 0;
        int lr = 0;
        char[] chars = moves.toCharArray();
        for (char ch : chars) {
            if (ch == 'U') du++;
            else if (ch == 'D') du--;
            else if (ch == 'R') lr++;
            else if (ch == 'L') lr--;
        }
        return du == 0 && lr == 0;
    }


    /**
     * 树转成字符串
     *
     * @param t
     * @return
     */
    public String tree2str(TreeNode t) {
        // 如果当前节点为null，返回空字符串
        if (t == null) return "";
        // 如果当前节点没有孩子，那我们不需要在节点后面加上任何括号；
        if (t.right == null && t.left == null) return t.val + "";
        // 如果当前节点只有左孩子，那我们在递归时，只需要在左孩子的结果外加上一层括号，而不需要给右孩子加上任何括号
        if (t.right == null) return t.val + "(" + tree2str(t.left) + ")";
        // 如果当前节点有两个孩子，那我们在递归时，需要在两个孩子的结果外都加上一层括号；
        return t.val + "(" + tree2str(t.left) + ")(" + tree2str(t.right) + ")";
    }


    /**
     * 反转字符串III
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        String[] split = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String tmp : split) {
            String s1 = reverseStringOneWord(tmp);
            sb.append(s1).append(" ");
        }
        return sb.toString().trim();
    }

    private String reverseStringOneWord(String str) {
        char[] s = str.toCharArray();
        int len = s.length;
        for (int i = 0; i < len / 2; i++) {
            char temp = s[len - 1 - i];
            s[len - 1 - i] = s[i];
            s[i] = temp;
        }
        return String.valueOf(s);
    }


    /**
     * 学生出勤记录 I
     *
     * @param s
     * @return https://leetcode-cn.com/problems/student-attendance-record-i/
     */
    public boolean checkRecord(String s) {
        int a = 0;
        int l = 0;
        int p = 0;
        char[] chars = s.toCharArray();
        for (char ch : chars) {
            if (ch == 'A') a++;
            else if (ch == 'L') l++;
            else p++;
        }
        int count = 0;
        if (a <= 1) {
            for (int i = 0; i < chars.length - 2; i++) {
                if (chars[i] == 'L' && chars[i + 1] == 'L' && chars[i + 1] == 'L') {
                    count++;
                }
            }
            return count <= 1;
        }
        return false;
    }


    /**
     * @param s
     * @param k
     * @return 链接：https://leetcode-cn.com/problems/reverse-string-ii/solution/fan-zhuan-zi-fu-chuan-ii-by-leetcode/
     */
    public String reverseStr(String s, int k) {
        char[] a = s.toCharArray();
        for (int start = 0; start < a.length; start += 2 * k) {
            int i = start, j = Math.min(start + k - 1, a.length - 1);
            while (i < j) {
                char tmp = a[i];
                a[i++] = a[j];
                a[j--] = tmp;
            }
        }
        return new String(a);
    }


    /**
     * 最长特殊序列
     *
     * @param a
     * @param b
     * @return 链接：https://leetcode-cn.com/problems/longest-uncommon-subsequence-i/solution/qi-xi-suan-fa-521-zui-chang-te-shu-xu-lie-i-by-gua/
     */
    public int findLUSlength(String a, String b) {
        if (a.equals(b))
            return -1;
        return Math.max(a.length(), b.length());
    }


    /**
     * 单词拼写是否正确
     *
     * @param word
     * @return
     */
    public boolean detectCapitalUse(String word) {
        char[] chars = word.toCharArray();
        int len = chars.length;
        if (len == 1) {
            return true;
        }
        if (len == 2) {
            if (chars[0] > 'a') {
                return chars[1] >= 'a';
            } else {
                return true;
            }
        }
        char first = chars[0];
        // 大写字母开头
        if (first >= 'A' && first <= 'Z') {
            for (int i = 2; i < len; i++) {
                // 第二个也是大写字母a
                if (chars[1] <= 'Z') {
                    if (chars[i] > 'Z') {
                        return false;
                    }
                } else {
                    if (chars[i] < 'a') {
                        return false;
                    }
                }
            }
        }
        //非大写字母开头
        else {
            for (int i = 1; i < len; i++) {
                if (chars[i] < 'a') {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * 重复的子字符串
     *
     * @param s
     * @return
     */
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        for (int i = len / 2; i > 0; i--) { // i=4,3,2,1
            if (len % i != 0)
                continue;
            boolean flag = true;
            for (int j = len / i; j > 1; j--) { // 3,2
                if (!s.substring(0, i).equals(s.substring((j - 1) * i, j * i))) {
                    flag = false;
                    break;
                }
            }
            if (flag) return true;
        }
        return false;
    }


    /**
     * 压缩字符串
     *
     * @param chars
     * @return https://leetcode-cn.com/problems/string-compression/
     */
    public int compress(char[] chars) {
        // read 标记读的位置，write标记写的位置 ，anchor 锚的意思  保留指针 anchor，指向当前读到连续字符串的起始位置。
        int anchor = 0, write = 0;
        for (int read = 0; read < chars.length; read++) {
            if (read + 1 == chars.length || chars[read + 1] != chars[read]) {
                chars[write++] = chars[anchor];
                if (read > anchor) {
                    for (char c : ("" + (read - anchor + 1)).toCharArray()) {
                        chars[write++] = c;
                    }
                }
                anchor = read + 1;
            }
        }
        return write;
    }

    /**
     * 统计字符串单词的个数
     * 统计字符串中的单词个数，这里的单词指的是连续的【不是空格】的字符。
     *
     * @param s
     * @return
     */
    public int countSegments(String s) {
        int count = 0;
        String[] strs = s.split(" ");
        for (String str : strs) {
            if (!"".equals(str)) {
                count++;
            }
        }
        return count;
    }

    /**
     * 字符相加
     *
     * @param num1
     * @param num2
     * @return 链接：https://leetcode-cn.com/problems/add-strings/solution/add-strings-shuang-zhi-zhen-fa-by-jyd/
     */
    public String addStrings(String num1, String num2) {
        StringBuilder res = new StringBuilder("");
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while (i >= 0 || j >= 0) {
            int n1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int n2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int tmp = n1 + n2 + carry;
            carry = tmp / 10;
            res.append(tmp % 10);
            i--;
            j--;
        }
        if (carry == 1) {
            res.append(1);
        }
        return res.reverse().toString();
    }


    /**
     * 字符串中的第一个唯一字符
     *
     * @param s
     * @return 时间复杂度  O(n)=2*n;
     */
    public int firstUniqChar(String s) {
        char[] chars = s.toCharArray();
        int len = chars.length;
        int[] arr = new int[26];
        for (char ch : chars) {
            arr[ch - 'a']++;
        }
        for (int i = 0; i < len; i++) {
            if (arr[chars[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;

    }

    /**
     * 赎金信
     *
     * @param ransomNote
     * @param magazine
     * @return
     */
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] b = new int[26];
        for (char c : magazine.toCharArray()) {
            b[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (b[c - 'a'] == 0) {
                return false;
            }
            b[c - 'a']--;
        }
        return true;
    }

    /**
     * 所有 DNA 都由一系列缩写为 A，C，G 和 T 的核苷酸组成，例如：“ACGAATTCCG”。在研究 DNA 时，识别 DNA 中的重复序列有时会对研究非常有帮助。
     * 编写一个函数来查找 DNA 分子中所有出现超过一次的 10 个字母长的序列（子串）。
     * 链接：https://leetcode-cn.com/problems/repeated-dna-sequences
     *
     * @param s
     * @return
     */
    public List<String> findRepeatedDnaSequences(String s) {
        int len = s.length();
        Set<String> res = new HashSet<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i <= len - 10; i++) {
            String key = s.substring(i, i + 10);
            //之前是否存在
            if (set.contains(key)) {
                res.add(key);
            } else {
                set.add(key);
            }

        }
        return new ArrayList<>(res);
    }


    /**
     * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母
     * 输入: "hello"
     * 输出: "holle"
     * https://leetcode-cn.com/problems/reverse-vowels-of-a-string/
     * <p>
     * 处理代码的健壮性问题，如果是非法字母 eg "!!!!"  处理超时问题
     *
     * @param s
     * @return
     */
    public String reverseVowels(String s) {
        if (s == null || s.length() < 2) {
            return s;
        }
        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            while (start < end && !isVowel(chars[start])) {
                start++;
            }
            while (end > start && !isVowel(chars[end])) {
                end--;
            }
            if (start < end) {
                char temp = chars[start];
                chars[start] = chars[end];
                chars[end] = temp;
            }
            start++;
            end--;
        }
        return new String(chars);
    }


    public String reverseVowelsIIII(String s) {
        char[] chars = s.toCharArray();
        int p2 = 0;
        int len = chars.length;
        for (int i = 0; i <= len - 2; i++) {
            while (!isVowel(chars[i])) {
                i++;
                if (i > len - 2) {
                    break;
                }
            }

            while (!isVowel(chars[len - 1 - p2])) {
                p2++;
                if (p2 >= len) {
                    break;
                }
            }
            if (i < len - 1 - p2) {
                char temp = chars[i];
                chars[i] = chars[len - 1 - p2];
                chars[len - 1 - p2] = temp;
                p2++;
            }

        }
        return new String(chars);
    }

    private boolean isVowel(char input) {
        return 'a' == input || 'e' == input || 'i' == input || 'o' == input || 'u' == input || 'A' == input || 'E' == input || 'I' == input || 'O' == input || 'U' == input;
    }

    /**
     * 输入："(()())(())"
     * 输出："()()()"
     * 解释：
     * 输入字符串为 "(()())(())"，原语化分解得到 "(()())" + "(())"，
     * 删除每个部分中的最外层括号后得到 "()()" + "()" = "()()()"。
     * 链接：https://leetcode-cn.com/problems/remove-outermost-parentheses
     *
     * @param S
     * @return
     */
    public String removeOuterParentheses(String S) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (char c : S.toCharArray()) {
            if (c == '(') {
                count++;
                if (count > 1) {
                    sb.append(c);
                }
            } else {
                if (count > 1) {
                    sb.append(c);
                }
                // 相当于使用栈的情况下的弹出栈顶
                count--;
            }
        }
        return sb.toString();
    }


    /**
     * 判断是否为回文字符串
     *
     * @param s "A man, a plan, a canal: Panama"
     * @return result
     */
    public boolean isPalindrome(String s) {
        char[] cs = s.toCharArray();
        int cnt = 0, j = 0;
        for (int i = 0; i < cs.length; i++) {
            if (('0' <= cs[i] && cs[i] <= '9') || ('a' <= cs[i] && cs[i] <= 'z')) {
                cs[cnt++] = cs[i];
            }
            // 大写字母的处理
            else if ('A' <= cs[i] && cs[i] <= 'Z') {
                cs[cnt++] = (char) (cs[i] - 'A' + 'a');
            }
            // 自动过滤了其他非字母的字符
        }
        // 下标指回去
        cnt--;
        while (j < cnt) {
            if (cs[j++] != cs[cnt--]) {
                return false;
            }
        }
        return true;
    }


    /**
     * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。 如果不存在最后一个单词，请返回 0 。
     * trim()方法的作用:取出字符串首位的空格,中间的空格不会去除
     *
     * @param s "Hello World";
     * @return
     */
    public int lengthOfLastWord(String s) {
        if (s == null || s.trim().length() == 0) {
            return 0;
        }
        int length = s.trim().length();
        int i = s.trim().lastIndexOf(" ");
        return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
    }


    /**
     * 给定一个 haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回  -1。
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (haystack == null || needle == null || haystack.length() < needle.length()) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        int[] shift = new int[256];
        int i = 0;
        int plen = needle.length();
        int len = haystack.length();
        int k = 0;
        for (char c : needle.toCharArray()) {
            shift[c] = plen - k++;
        }
        while (i + plen <= len) {
            if (needle.equals(haystack.substring(i, i + plen))) {
            } else {
                if (i + plen < len && shift[haystack.charAt(i + plen)] != 0) {
                    i = i + shift[haystack.charAt(i + plen)];
                } else {
                    i = i + plen;
                }
            }
        }
        return -1;
    }

    /**
     * 有效的括号 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        // 边界条件的判断
        if (s == null || s.length() % 2 == 1) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        int stackIndex = 0;
        char[] data = s.toCharArray();
        char[] stack = new char[data.length];
        stack[0] = '0';

        for (char item : data) {
            if (item == '[' || item == '{' || item == '(') {
                stack[stackIndex++] = item;
            } else if (stackIndex == 0 || item == ']' && stack[stackIndex - 1] != '['
                    || item == '}' && stack[stackIndex - 1] != '{'
                    || item == ')' && stack[stackIndex - 1] != '(') {
                boolean bool1 = stackIndex == 0 || item == ']';
                boolean bool2 = stack[stackIndex - 1] != '[' || item == '}';
                boolean bool3 = stack[stackIndex - 1] != '{' || item == ')';
                boolean bool4 = stack[stackIndex - 1] != '(';
                return false;
            } else {
                stack[--stackIndex] = '0';
            }
        }
        return stackIndex == 0;
    }


    /**
     * 罗马数字转整数
     * 解题思路：
     * 1. 依次迭代s,如果前后两个字符不一致，且非subtraction，进行次数累乘。如为subtraction取特别值。
     *
     * @param s 入参
     * @return 转换数值
     */
    public int romanToInt(String s) {
        char[] chars = s.toCharArray();
        int result = 0;
        int length = chars.length;
        for (int i = 0; i < length; i++) {
            char c = chars[i];
            switch (c) {
                case 'M':
                    result += 1000;
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'C':
                    if (i < length - 1) {
                        if (chars[i + 1] == 'M') {
                            result += 900;
                            i++;
                            break;
                        } else if (chars[i + 1] == 'D') {
                            result += 400;
                            i++;
                            break;
                        }
                    }
                    result += 100;
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'X':
                    if (i < length - 1) {
                        if (chars[i + 1] == 'C') {
                            result += 90;
                            i++;
                            break;
                        } else if (chars[i + 1] == 'L') {
                            result += 40;
                            i++;
                            break;
                        }
                    }
                    result += 10;
                    break;
                case 'V':
                    result += 5;
                    break;
                default:
                    // I
                    if (i < length - 1) {
                        if (chars[i + 1] == 'X') {
                            result += 9;
                            i++;
                            break;
                        } else if (chars[i + 1] == 'V') {
                            result += 4;
                            i++;
                            break;
                        }
                    }
                    result += 1;
                    break;
            }
        }
        return result;
    }
}
