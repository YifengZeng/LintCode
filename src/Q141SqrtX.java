/**
 * Created by Yifeng Zeng on 1/22/17.
 */
/*
Sqrt(x)
        Implement int sqrt(int x).

        Compute and return the square root of x.

        sqrt(3) = 1

        sqrt(4) = 2

        sqrt(5) = 2

        sqrt(10) = 3

        sqrt(999999999) = 31622
*/

class Q141SqrtX {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {

        long start = 1;
        long end = x;
        while (start + 1 < end) {
            long mid = (end - start) / 2 + start;
            if (mid * mid < x) {
                start = mid;
            } else if (mid * mid > x) {
                end = mid;
            } else {
                return (int)mid;
            }

        }

        if (start * start <= x) {
            return (int)start;
        }
        return (int)end;
    }


    public static void main(String[] args){

        Q141SqrtX ret = new Q141SqrtX();
        System.out.println(ret.sqrt(3));
        System.out.println(ret.sqrt(4));
        System.out.println(ret.sqrt(5));
        System.out.println(ret.sqrt(10));
        System.out.println(ret.sqrt(999999999));
    }
}