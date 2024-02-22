package string_search;

public class BruteForce {
    public static void main(String[] args) {
        String text = "ABDABEACBAABC";
        String pattern = "ABC";

        int idx = bfMatch(text, pattern);
        if (idx == -1) {
            System.out.println("텍스트에 패턴이 없습니다.");
        } else {
            System.out.println(idx);
        }
    }

    static int bfMatch(String t, String p) {
        int pt = 0;
        int pp = 0;

        while (pt != t.length() && pp != p.length()) {
            if (t.charAt(pt) == p.charAt(pp)) {
                pt++;
                pp++;
            } else {
                pt = pt - pp + 1;
                pp = 0;
            }
        }

        if (pp == p.length())
            return pt - pp;
        return -1;
    }
}
