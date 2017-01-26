/**
 * Created by Yifeng Zeng on 1/25/17.
 */
/*

Copy Books
        Given n books and the ith book has A[i] pages. You are given k people to copy the n books.

        n books list in a row and each person can claim a continous range of the n books. For
        example one copier can copy the books from ith to jth continously, but he can not copy
        the 1st book, 2nd book and 4th book (without 3rd book).

        They start copying books at the same time and they all cost 1 minute to copy 1 page of
        a book. What's the best strategy to assign books so that the slowest copier can finish
        at earliest time?

        Have you met this question in a real interview? Yes
        Example
        Given array A = [3,2,4], k = 2.

        Return 5( First person spends 5 minutes to copy book 1 and book 2 and second person spends 4 minutes to copy book 3. )
*/


public class Q437CopyBooks {
    /**
     * @param pages: an array of integers
     * @param k: an integer
     * @return: an integer //return maxMinute
     */
    public int copyBooks(int[] pages, int k) {
        int totalMinutes = 0;
        int maxMinute = 0;
        for (int time : pages) {
            if (time > maxMinute) {
                maxMinute = time;
            }
            totalMinutes += time;
        }
        if (k < 1) {
            return -1;
        } else if (k == 1) {
            return totalMinutes;
        } else if (k >= pages.length) {
            return maxMinute;
        }

        //find minimum(maxMinute)
        int start = maxMinute;
        int end = totalMinutes;
        while (start + 1 < end) {
            int mid = (end - start) / 2 + start;
            int peopleNeeded = getPeopleNeeded(pages, mid);
            if (peopleNeeded <= k) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (getPeopleNeeded(pages, start) == k) {
            return start;
        }
        if (getPeopleNeeded(pages, end) == k) {
            return end;
        }
        return 0;
    }

    private int getPeopleNeeded(int[] pages, int maxMinuteForEachPerson) {
        int peopleNeeded = 0;
        int minuteNeededForCurrentPersion = 0;
        for (int i = 0; i < pages.length; i++) {
            minuteNeededForCurrentPersion += pages[i];
            if (minuteNeededForCurrentPersion > maxMinuteForEachPerson) {
                peopleNeeded++;
                i--;
                minuteNeededForCurrentPersion = 0;
            } else if (i == pages.length - 1) {
                peopleNeeded++;
            }
        }
        return peopleNeeded;
    }

    private int countCopiers(int[] pages, int limit) {
        if (pages.length == 0) {
            return 0;
        }

        int copiers = 1;
        int sum = pages[0]; // limit is always >= pages[0]
        for (int i = 1; i < pages.length; i++) {
            if (sum + pages[i] > limit) {
                copiers++;
                sum = 0;
            }
            sum += pages[i];
        }

        return copiers;
    }

    public static void main(String[] args) {
        Q437CopyBooks A437 = new Q437CopyBooks();
        int[] A = {3, 2, 4};
        System.out.println(A437.copyBooks(A, 2));

        System.out.println("===");
        for (int i = 4; i < 20; i++) {
            System.out.println(A437.getPeopleNeeded(A, i));
        }
        System.out.println("===");
        for (int i = 1; i < 20; i++) {
            System.out.println(A437.countCopiers(A, i));
        }
    }
}
