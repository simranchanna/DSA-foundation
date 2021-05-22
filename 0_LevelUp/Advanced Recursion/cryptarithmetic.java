public class cryptarithmetic {
    static String s1 = "send";
    static String s2 = "more";
    static String s3 = "money";

    static boolean[] usedNumber = new boolean[10];
    static int[] mapping = new int[128];

    public static int convertStringToNumber(String s){
        int ans = 0;
        int pow = 1;
        for(int i=s.length()-1; i>=0; i--){
            int n = mapping[s.charAt(i)];
            ans += n * pow;
            pow *= 10;
        }
        return ans;
    }
    public static int crypto(String str, int idx, String asf) {
        if(idx == str.length()){
            int x = convertStringToNumber(s1);
            int y = convertStringToNumber(s2);
            int z = convertStringToNumber(s3);

            if(x + y == z){
                System.out.println(asf);
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

                count += crypto(str, idx + 1, asf + ch + "-" + i + " ");
                usedNumber[i] = false;
                mapping[ch] = 0;
            }
        }

        return count;
    }

    public static int crypto() {
        String str = s1 + s2 + s3;
        int[] freq = new int[26];
        for (int i = 0; i < str.length(); i++)
            freq[str.charAt(i) - 'a']++;

        str = "";
        for (int i = 0; i < 26; i++)
            if (freq[i] > 0)
                str += (char) (i + 'a');
        return crypto(str, 0, "");
    }

    public static void main(String[] args){
        System.out.println(crypto());
    }
}