/**
 * Created by Yifeng Zeng on 1/22/17.
 */

/*
strStr

    For a given source string and a target string, you should output
            the first index(from 0) of target string in source string.

            If target does not exist in source, just return -1.

            If source = "source" and target = "target", return -1.

            If source = "abcdabcdefg" and target = "bcd", return 1.
*/

class Q13strStr {
    /**
     * Returns a index to the first occurrence of target in source,
     * or -1  if target is not part of source.
     * @param source string to be scanned.
     * @param target string containing the sequence of characters to match.
     */
    public int strStr(String source, String target) {

        if (source == null || target == null || source.length() < target.length()) {
            return -1;
        }
        // if (source.length() <= 0 || source.length() < 0 || source.length() < target.length()) {
        //     return -1;
        // }

        int j;
        for (int i = 0; i < source.length() - target.length() + 1; i++) {
            for (j = 0; j < target.length(); j++) {
                if (source.charAt(i + j) != target.charAt(j)) {
                    break;
                }
            }
            if (j == target.length()) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        Q13strStr A13 = new Q13strStr();
        System.out.println(A13.strStr("acdabcdefg", "target"));
        System.out.println(A13.strStr("abcdabcdefg", "bcd"));
        System.out.println(A13.strStr("acdabcdefg", "bcd"));
    }
}