import java.util.Arrays;

public class cryptarithmetic {
    static String s1 = "send";
    static String s2 = "more";
    static String s3 = "money";

    static boolean[] usedNumber = new boolean[10];
    static int[] mapping = new int[128];

    public static int convertStringToNumber(String s){
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            res = res * 10 + mapping[s.charAt(i)];
        }
        return res;
    }
    public static int crypto(String str, int idx) {
        if (idx == str.length()) {
            if (mapping[s1.charAt(0)] == 0 || mapping[s2.charAt(0)] == 0 || mapping[s3.charAt(0)] == 0)
                return 0;
            int x = convertStringToNumber(s1);
            int y = convertStringToNumber(s2);
            int z = convertStringToNumber(s3);
            if (x + y == z) {
                StringBuilder sb = new StringBuilder();
                for (int i = 'a'; i <= 'z'; i++) {
                    if (mapping[i] >= 0) {
                        sb.append((char) i + "-" + mapping[i] + " ");
                    }
                }
                System.out.println(sb.toString());
                return 1;
            }
            return 0;
        }
        int count = 0;
        char ch = str.charAt(idx);
        for (int i = 0; i <= 9; i++) {
            if (!usedNumber[i]) {
                usedNumber[i] = true;
                mapping[ch] = i;
                count += crypto(str, idx + 1);
                usedNumber[i] = false;
                mapping[ch] = -1;
            }
        }
        return count;
    }
    public static void main(String[] args){
        String str = s1 + s2 + s3;
        int[] freq = new int[26];
        for (int i = 0; i < str.length(); i++)
            freq[str.charAt(i) - 'a']++;

        str = "";
        for (int i = 0; i < 26; i++)
            if (freq[i] > 0)
                str += (char) (i + 'a');

        Arrays.fill(mapping, -1);

        System.out.println(crypto(str, 0));
    }
}