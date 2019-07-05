package kamal;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Kamal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        for (String line = sc.nextLine(); !line.equals("0"); line = sc.nextLine()) {
            String[] pieces = line.split(" ");
            String S = pieces[0], L = pieces[1];

            System.out.println(go(S, L) + " " + goRemOneChar(S, L));
        }
        sc.close();
    }

    public static int go(String S, String L) {
        return getNumFinds(S, L);
    }

    public static int goRemOneChar(String S, String L) {
        int ans = 0;
        Set<String> unique = new HashSet<>();

        for (int i = 0; i < S.length(); i++) {
            StringBuilder sb = new StringBuilder(S);
            sb.deleteCharAt(i);
            unique.add(sb.toString());
        }

        for (String s: unique)
            ans += getNumFinds(s, L);

        return ans;
    }

    public static int goAddOneChar(String S, String L) {
        char[] chars = {'A', 'G', 'T', 'C'};
        Set<String> unique = new HashSet<>();
        int ans = 0;

        for (int i = 0; i < S.length(); i++) {
            for (char aChar : chars) {
                StringBuilder sb = new StringBuilder(S);
                sb.insert(i, aChar);
                unique.add(sb.toString());
            }
        }

        for (char c: chars) {
            StringBuilder sb = new StringBuilder(S);
            sb.append(c);
            unique.add(sb.toString());
        }

        for (String s: unique) {
            int temp =getNumFinds(s, L);
            ans += temp;
        }

        return ans;
    }

    private static int getNumFinds(String S, String L) {
        int sInd, lInd = 0, ans = 0;
        Set<String> unique = new HashSet<>();

        while (lInd < L.length() - S.length() + 1) {
            sInd = 0;
            int temp = lInd;
            while (sInd < S.length() && S.charAt(sInd) == L.charAt(lInd)) {
                sInd++;
                lInd++;
            }

            if (sInd == S.length()) {
                ans++;
                lInd = temp + 1;
            }
            else if (sInd == 0) lInd++;
        }

        return ans;
    }
}
