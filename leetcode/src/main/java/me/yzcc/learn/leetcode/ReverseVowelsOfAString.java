package me.yzcc.learn.leetcode;

/**
 * 345. 反转字符串中的元音字母
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "hello"
 * 输出: "holle"
 * 示例 2:
 * <p>
 * 输入: "leetcode"
 * 输出: "leotcede"
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-vowels-of-a-string
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReverseVowelsOfAString {
    private static char[] VOWELS = {'a', 'e', 'i', 'o', 'u'};

    private static boolean isNotVowels(char c) {
        char lowerCaseChar = Character.toLowerCase(c);
        for (char vowel : VOWELS) {
            if (vowel == lowerCaseChar) {
                return false;
            }
        }
        return true;
    }

    private static void swap(char[] array, int i, int j) {
        char tmp = array[i];
        array[i] = array[j];
        array[j] = tmp;
    }

    public static String reverseVowels(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        char[] input = s.toCharArray();

        for (int i = 0, j = input.length - 1; ; ) {
            while (i <= j && isNotVowels(input[i])) {
                i++;
            }
            while (i <= j && isNotVowels(input[j])) {
                j--;
            }
            if (i >= j) {
                break;
            }
            swap(input, i, j);
            i++;
            j--;
        }

        return new String(input);
    }

    public static void main(String[] args) {
        System.out.println(reverseVowels("hello"));
        System.out.println(reverseVowels(" "));
        System.out.println(reverseVowels("O E"));
        System.out.println(reverseVowels("E"));
        System.out.println(reverseVowels("qqqqqqqqqEqqqqqqqqqqqq"));


    }
}
