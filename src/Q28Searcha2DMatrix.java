/**
 * Created by Yifeng Zeng on 3/9/17.
 */
/*

Search a 2D Matrix
        Write an efficient algorithm that searches for a value in an m x n matrix.

        This matrix has the following properties:

        Integers in each row are sorted from left to right.
        The first integer of each row is greater than the last integer of the previous row.
        Have you met this question in a real interview? Yes
        Example
        Consider the following matrix:

        [
        [1, 3, 5, 7],
        [10, 11, 16, 20],
        [23, 30, 34, 50]
        ]
        Given target = 3, return true.
*/

public class Q28Searcha2DMatrix {
    /**
     * @param matrix, a list of lists of integers
     * @param target, an integer
     * @return a boolean, indicate whether matrix contains target
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        // write your code here
        if (matrix == null || matrix.length == 0 || matrix[0][0] > target) {
            return false;
        }
        int start = 0;
        int end = matrix.length - 1;
        int row = 0;

        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (matrix[mid][0] > target) {
                end = mid;
            } else if (matrix[mid][0] < target) {
                start = mid;
            } else {
                return true;
            }
        }

        if (matrix[start][0] == target || matrix[end][0] == target) {
            return true;
        } else if (matrix[end][0] < target) {
            row = end;
        } else if (matrix[start][0] < target) {
            row = start;
        } else {
            return false;
        }

        start = 0;
        end = matrix[row].length - 1;

        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            if (matrix[row][mid] > target) {
                end = mid;
            } else if (matrix[row][mid] < target) {
                start = mid;
            } else {
                return true;
            }
        }

        if (matrix[row][start] == target) {
            return true;
        }
        if (matrix[row][end] == target) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        Q28Searcha2DMatrix a28 = new Q28Searcha2DMatrix();
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 50}};
        System.out.println(a28.searchMatrix(matrix, 1));
        System.out.println(a28.searchMatrix(matrix, 10));
        System.out.println(a28.searchMatrix(matrix, 23));
        System.out.println(a28.searchMatrix(matrix, 3));
        System.out.println(a28.searchMatrix(matrix, 50));
    }
}
