/**
 * Created by Yifeng Zeng on 1/25/17.
 */

/*

Wood Cut

        Given n pieces of wood with length L[i] (integer array).
        Cut them into small pieces to guarantee you could have
        equal or more than k pieces with the same length. What
        is the longest length you can get from the n pieces of
        wood? Given L & k, return the maximum length of the
        small pieces.

        You couldn't cut wood into float length.

        If you couldn't get >= k pieces, return 0.

        Have you met this question in a real interview? Yes
        Example
        For L=[232, 124, 456], k=7, return 114.
*/


public class Q183WoodCut {
    /**
     *@param L: Given n pieces of wood with length L[i]
     *@param k: An integer
     *return: The maximum length of the small pieces.
     */
    public int woodCut(int[] L, int k) {
        if (L == null || L.length == 0) {
            return 0;
        }

        int max = 0;
        for (int l : L) {
            max = Math.max(l, max);
        }
        int start = 1;
        int end = max;

        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (cutPieces(L, mid) >= k) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (cutPieces(L, end) >= k) {
            return end;
        }
        if (cutPieces(L, start) >= k) {
            return start;
        }

        return 0;
    }

    private int cutPieces(int[] L, int cutLength) {
        int pieces = 0;
        for (int l : L) {
            pieces += l / cutLength;
        }
        return pieces;
    }

    public static void main(String[] args) {
        Q183WoodCut A183 = new Q183WoodCut();
        int[] L = {232, 124, 456};
        System.out.println(A183.woodCut(L, 7));
        System.out.println(A183.woodCut(L, 1));
        System.out.println(A183.woodCut(L, 125));
        int[] L2 = {6,6,5,5,6,5,4,4,5,6,6,6,5,4,5,6,5,6,4,4,4,4,6,4,5,5,4,6,6,6,6,4,6,4,4,5,6,5,5,4,6,4,6,4,4,6,4,5,6,5,6,6,5,4,4,5,6,4,5,5,5,6,6,4,4,5,5,6,5,5,6,4,6,4,5,6,4,4,4,6,4,6,4,5,4,6,5,6,6,5,4,4,6,5,6,5,6,4,4,6,4,6,5,4,4,4,4,6,6,4,6,6,6,5,4,4,6,4,4,4,5,4,6,4,6,6,4,5,6,5,6,5,4,5,5,5,4,6,5,4,5,6,4,4,6,6,5,6,6,4,6,5,6,5,4,6,4,6,4,6,5,6,4,6,6,4,5,4,6,6,5,6,6,5,4,4,4,4,4,5,5,4,6,5,4,6,4,6,5,6,6,5,4,5,6,4,4,6,5,5,6,6,6,4,6,6,5,6,5,4,6,5,4,6,5,6,4,5,4,4,5,4,5,6,6,4,4,4,4,6,6,6,6,6,5,5,4,4,5,5,6,6,5,6,6,6,4,5,5,4,6,4,6,4,4,6,5,6,6,6,5,4,4,4,6,4,6,4,5,6,6,4,5,6,6,6,6,6,4,5,6,4,4,4,4,5,5,5,6,5,5,5,4,4,5,6,6,4,6,6,6,4,5,4,6,5,6,5,5,6,5,4,5,4,6,4,5,5,5,5,5,5,4,5,5,6,4,5,6,5,6,5,6,4,4,5,6,5,6,6,6,5,4,5,4,6,6,6,6,4,5,5,4,5,5,5,4,6,5,5,4,6,5,6,6,6,4,4,4,6,4,6,6,4,5,4,5,6,6,6,5,6,4,6,6,5,6,5,6,4,4,6,4,6,5,6,6,5,4,6,5,6,6,5,6,6,4,6,6,5,6,5,6,4,5,5,5,6,6,4,5,4,4,6,4,6,6,5,6,6,6,5,6,6,4,6,6,5,5,6,5,6,6,6,5,5,6,6,5,4,6,5,6,5,6,5,5,6,5,4,5,6,5,4,6,5,5,4,5,4,5,6,5,6,4,6,5,4,4,4,5,5,4,5,4,6,4,5,5,6,5,6,6,5,4,6,6,5,5,6,5,5,5,5,6,5,5,4,4,6,4,5,4,6,6,5,6,5,6,6,4,5,5,5,5,6,6,4,4,5,6,5,5,6,4,6,6,5,5,6,4,4,4,4,5,4,5,4,5,5,4,5,5,5,4,6,4,4,4,5,4,4,5,4,6,6,5,6,4,4,6,6,4,4,5,6,5,5,4,6,6,4,6,5,4,5,5,6,6,6,4,6,6,5,6,4,5,6,4,6,4,5,5,4,4,6,6,6,4,6,5,5,4,5,5,4,5,6,6,6,4,5,4,5,6,4,6,4,5,4,5,4,6,6,6,5,4,6,4,6,4,5,6,5,6,6,6,5,4,5,6,6,6,6,4,5,6,5,4,4,5,5,4,4,4,5,4,6,6,6,6,4,5,5,4,5,4,5,4,4,6,4,5,5,6,4,6,5,4,6,4,6,5,5,6,5,4,4,5,4,4,5,5,5,5,4,4,5,6,4,4,6,6,5,4,6,5,5,4,4,6,4,6,4,5,6,4,5,4,6,5,4,4,5,6,4,4,5,5,6,6,6,6,6,6,4,6,5,6,6,6,6,4,4,5,6,5,4,5,4,4,5,6,5,5,4,4,4,6,6,6,6,6,4,5,4,4,4,4,5,6,4,4,5,5,6,6,6,6,4,6,6,5,4,6,4,5,4,5,5,4,6,6,4,6,4,5,4,5,5,4,6,5,5,4,4,6,6,5,5,4,6,5,5,6,6,4,6,6,4,6,6,4,5,6,6,5,4,5,4,5,5,5,4,6,5,4,6,5,4,4,5,6,5,5,6,4,4,6,4,4,5,4,5,5,4,5,5,4,4,6,4,5,6,4,4,5,6,6,4,5,4,6,5,5,5,5,6,4,5,6,6,6,4,6,5,4,6,5,4,5,4,5,4,6,4,6,6,4,5,6,4,4,6,5,4,4,5,6,6,4,6,6,4,6,5,6,6,4,4,5,5,6,5,4,4,5,4,5,4,4,6,4,4,4,4,4,4,6,6,6,5,6,5,5,4,5,5,5,5,5,6,5,6,4,6,5,4,5,4,5,4,6,5,5,4,5,6,5,4,5,5,6,4,6,5,6,4,6,6,5,6,4,4,4,5,4,6,4,4,4,5,4,5,4,6,4,4,5,4,5,6,4,6,6,5,4,5,4,5,6,4,5,6,4,5,4,5,5,4,4,5,4,5,6,5,4,5,5,6,4,5,5,4,6,6,6,5,5,5,6,6,4,6,5,4,6,6,6,5,6,6,4,4,5,6,4,4,5,6,5,5,5,6,6,5,4,6,6,5,4,5,6,4,4,6,4,6,4,4,5,4,5,4,5,4,6,4,5,5,6,5,5,4,6,6,4,6,5,5,5,6,5,4,5,6,6,4,6,6,4,5,6,4,6,4,5,4,4,6,5,5,4,6,5,4,6,6,4,4,5,6,4,4,4,4,4,6,6,6,4,5,5,4,4,5,4,4,5,6,5,4,6,6,6,5,6,5,4,5,4,6,6,5,6,5,4,4,5,4,4,4,6,4,5,5,4,4,5,4,5,5,5,5,5,6,4,5,4,4,4,4,4,4,5,4,6,5,5,4,4,5,5,4,4,5,5,6,4,6,4,5,5,6,5,5,6,4,4,5,5,6,5,4,4,4,4,4,6,5,4,5,6,4,4,6,4,4,4,6,4,4,6,5,6,6,6,5,6,5,4,5,4,5,5,6,5,6,4,6,5,6,4,4,6,6,4,4,5,5,5,5,5,4,6,4,5,4,4,4,4,5,6,4,4,5,4,5,5,6,6,5,6,6,5,6,6,5,5,4,5,4,5,5,5,4,4,6,5,4,6,6,6,4,4,6,5,6,5,6,6,4,5,6,6,6,4,4,4,5,4,4,6,5,5,6,4,6,4,6,4,4,4,5,6,6,6,6,5,6,5,5,4,4,6,4,6,4,4,6,6,5,4,4,6,5,4,5,4,4,6,6,6,5,5,5,6,6,6,4,4,6,5,6,4,6,5,6,5,5,5,5,6,5,6,6,4,6,6,6,6,4,5,6,5,6,4,6,6,5,5,4,4,6,4,4,5,4,4,5,6,6,4,4,6,6,6,4,5,4,5,6,6,5,6,4,5,5,5,4,4,4,5,4,5,5,5,5,4,4,5,5,6,4,6,5,5,4,4,6,6,5,6,4,4,6,4,6,4,6,4,4,4,6,5,6,4,6,5,4,4,6,4,6,6,4,5,6,6,4,4,4,4,6,5,4,4,5,5,6,6,5,4,4,4,6,6,5,5,5,6,4,5,4,5,5,4,4,6,5,4,5,4,6,5,6,5,4,4,6,4,5,6,5,4,5,4,5,4,4,5,6,5,6,5,4,5,4,4,5,6,4,6,4,6,4,5,4,4,6,5,5,5,4,5,6,4,5,4,4,6,5,5,6,5,6,6,4,4,6,6,6,6,4,6,4,4,5,4,4,4,6,6,5,4,6,4,6,6,6,5,4,5,6,5,5,5,5,5,4,4,6,4,5,5,5,5,5,5,5,4,6,4,6,6,4,5,4,4,6,5,6,5,4,4,6,5,6,5,6,5,5,6,6,6,5,4,4,4,5,4,6,6,5,5,4,6,5,6,6,5,4,4,5,4,6,5,4,6,6,5,5,5,5,6,6,6,6,6,4,6,6,5,6,6,4,4,4,4,5,4,5,4,4,6,6,6,6,6,6,5,5,5,5,5,5,4,5,4,6,4,4,5,5,5,6,6,5,6,5,4,4,4,6,6,5,6,4,5,5,6,6,4,5,5,4,5,5,4,5,6,5,6,5,6,6,5,5,4,5,4,5,6,5,5,5,4,4,6,5,5,4,4,6,6,6,6,5,6,6,4,5,5,4,5,4,4,4,4,5,6,6,5,4,4,4,5,6,5,5,4,4,6,5,4,6,4,4,4,4,5,6,4,5,5,4,5,4,5,6,5,5,4,5,6,4,5,4,4,4,6,5,4,5,6,4,5,4,4,4,5,5,5,6,6,4,4,6,6,4,4,5,5,6,4,6,6,6,6,4,5,6,4,6,6,6,5,6,5,6,5,5,5,5,5,5,5,4,6,5,4,4,6,6,6,6,6,4,5,4,6,4,5,5,6,6,5,5,6,6,5,6,5,6,4,5,4,5,4,5,6,5,4,5,5,6,4,4,6,6,6,6,5,5,6,4,6,4,6,6,6,6,4,6,5,4,6,4,4,5,6,6,6,6,4,5,6,4,6,4,4,4,6,6,4,5,6,4,6,6,5,6,6,6,5,5,4,4,5,5,5,6,5,6,6,6,6,6,5,5,5,6,4,5,6,5,4,4,5,4,5,5,4,4,6,4,4,6,4,5};
        System.out.println(A183.woodCut(L2, 90000));
    }
}
