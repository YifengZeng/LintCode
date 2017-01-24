/**
 * Created by Yifeng Zeng on 1/24/17.
 */
/*

First Bad Version
        The code base version is an integer start from 1 to n.
        One day, someone committed a bad version in the code case,
        so it caused this version and the following versions are
        all failed in the unit tests. Find the first bad version.

        You can call isBadVersion to help you determine which
        version is the first bad one. The details interface can
        be found in the code's annotation part.

        Given n = 5:

        isBadVersion(3) -> false
        isBadVersion(5) -> true
        isBadVersion(4) -> true
*/

/**
 * public class SVNRepo {
 *     public static boolean isBadVersion(int k);
 * }
 * you can use SVNRepo.isBadVersion(k) to judge whether
 * the kth code version is bad or not.
 */
class Q74FirstBadVersion {
    /**
     * @param n: An integers.
     * @return: An integer which is the first bad version.
     */
    public int findFirstBadVersion(int n) {
        /*
        // need to ask if the last version (n) is always bad
        // return -1 if all versions are not bad
        if (SVNRepo.isBadVersion(n) == false) {
            return -1;
        }
        */
        int start = 1;
        int end = n;

        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (SVNRepo.isBadVersion(mid) == false) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (SVNRepo.isBadVersion(start) == true) {
            return start;
        }
        return end;
    }

    public static void main(String[] args) {
        Q74FirstBadVersion A74 = new Q74FirstBadVersion();
        System.out.println(A74.findFirstBadVersion(5));
    }

    /**
     * placeholder to get rid of IDE error messages
     */
    private SVNRepoClass SVNRepo = new SVNRepoClass();

    public class SVNRepoClass {
        private boolean isBadVersion(int k) {
            if (k > 3) {
                return true;
            }
            return false;
        }
    }

}

