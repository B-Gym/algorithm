package string_search;

public class BoyerMoore {
    static int bmMatch(String txt, String pat) {
        int pt;
        int pp;
        int txtLen = txt.length();
        int patLen = pat.length();
        int[] skip = new int[Character.MAX_VALUE + 1];

        for (pt = 0; pt <= Character.MAX_VALUE; pt++)
            skip[pt] = patLen;
        for (pt = 0; pt < patLen - 1; pt++)
            skip[pat.charAt(pt)] = patLen - pt - 1;

        while (pt < txtLen) {
            pp = patLen - 1;

            while (txt.charAt(pt) == pat.charAt(pp)) {
                if (pp == 0)
                    return pt;
                pp--;
                pt--;
            }
            pt += (skip[txt.charAt(pt)] > patLen - pp) ? skip[txt.charAt(pt)] : patLen - pp;
        }
        return -1;
    }
}
