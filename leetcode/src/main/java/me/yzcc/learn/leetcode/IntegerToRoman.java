package me.yzcc.learn.leetcode;

/**
 * 12. 整数转罗马数字
 * 罗马数字包含以下七种字符： I， V， X， L，C，D 和 M。
 *
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * 例如， 罗马数字 2 写做 II ，即为两个并列的 1。12 写做 XII ，即为 X + II 。 27 写做  XXVII, 即为 XX + V + II 。
 *
 * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做 IIII，而是 IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为 IX。这个特殊的规则只适用于以下六种情况：
 *
 * I 可以放在 V (5) 和 X (10) 的左边，来表示 4 和 9。
 * X 可以放在 L (50) 和 C (100) 的左边，来表示 40 和 90。 
 * C 可以放在 D (500) 和 M (1000) 的左边，来表示 400 和 900。
 * 给定一个整数，将其转为罗马数字。输入确保在 1 到 3999 的范围内。
 *
 * 示例 1:
 *
 * 输入: 3
 * 输出: "III"
 * 示例 2:
 *
 * 输入: 4
 * 输出: "IV"
 * 示例 3:
 *
 * 输入: 9
 * 输出: "IX"
 * 示例 4:
 *
 * 输入: 58
 * 输出: "LVIII"
 * 解释: L = 50, V = 5, III = 3.
 * 示例 5:
 *
 * 输入: 1994
 * 输出: "MCMXCIV"
 * 解释: M = 1000, CM = 900, XC = 90, IV = 4.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/integer-to-roman
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class IntegerToRoman {
    private enum RomanLetter {
        M("M", 1000),
        CM("CM", 900),
        D("D", 500),
        CD("CD", 400),
        C("C", 100),
        XC("XC", 90),
        L("L", 50),
        XL("XL", 40),
        X("X", 10),
        IX("IX", 9),
        V("V", 5),
        IV("IV", 4),
        III("III", 3),
        II("II", 2),
        I("I", 1);

        RomanLetter(String letter, int val) {
            this.letter = letter;
            this.val = val;
        }

        private String letter;
        private int val;
    }
    private static final int[] VALUES = new int[]{
            1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 3, 2, 1};
    private static final String[] ROMANS = new String[] {
            "M", // 1000
            "CM", // 900
            "D", // 500
            "CD", // 400
            "C", // 100
            "XC", // 90
            "L", // 50,
            "XL", // 40,
            "X", //10
            "IX", //9
            "V", // 5
            "IV", // 4
            "III", // 3
            "II", // 2
            "I", // 1
    };

    public String intToRoman(int num) {
        RomanLetter[] letters = RomanLetter.values();
        StringBuilder result = new StringBuilder();
        int curr = num;
        int i = 0;

        while (curr > 0) {
            if (curr >= letters[i].val) {
                curr -= letters[i].val;
                result.append(letters[i].letter);
            } else {
                i ++;
            }
        }

        return result.toString();
    }

    public String intToRoman2(int num) {
        StringBuilder result = new StringBuilder();
        int i = 0;
        while (num > 0) {
            if (num >= VALUES[i]) {
                num -= VALUES[i];
                result.append(ROMANS[i]);
            } else {
                i ++;
            }
        }
        return result.toString();
    }

    public static void main(String[] args) {
        IntegerToRoman solution = new IntegerToRoman();
        System.out.println(solution.intToRoman2(3));
        System.out.println(solution.intToRoman2(4));
        System.out.println(solution.intToRoman2(9));
        System.out.println(solution.intToRoman2(58));
        System.out.println(solution.intToRoman2(1994));
    }
}
