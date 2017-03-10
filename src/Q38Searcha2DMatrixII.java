/**
 * Created by Yifeng Zeng on 3/9/17.
 */
/*

Search a 2D Matrix II
        Write an efficient algorithm that searches for a value in an m x n matrix, return the occurrence of it.

        This matrix has the following properties:

        Integers in each row are sorted from left to right.
        Integers in each column are sorted from up to bottom.
        No duplicate integers in each row or column.
        Have you met this question in a real interview? Yes
        Example
        Consider the following matrix:

        [
          [1, 3, 5, 7],
          [2, 4, 7, 8],
          [3, 5, 9, 10]
        ]
        Given target = 3, return 2.
*/

public class Q38Searcha2DMatrixII {
    /**
     * @param matrix: A list of lists of integers
     * @param: A number you want to search in the matrix
     * @return: An integer indicate the occurrence of target in the given matrix
     */
    public int searchMatrix(int[][] matrix, int target) {
        // write your code here
        return 0;
    }

    public void main(String[] args) {
        Q38Searcha2DMatrixII a38 = new Q38Searcha2DMatrixII();
        int[][] matrix = {{1,3,5,7}, {2,4,7,8}, {3,5,9,10}};
        a38.searchMatrix(matrix, 3);
    }
}
