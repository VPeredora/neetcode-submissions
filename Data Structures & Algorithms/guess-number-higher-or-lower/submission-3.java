/** 
 * Forward declaration of guess API.
 * @param  num   your guess
 * @return 	     -1 if num is higher than the picked number
 *			      1 if num is lower than the picked number
 *               otherwise return 0
 * int guess(int num);
 */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int left = 1, right = n;

        while (true) {
            int mid1 = left + ((right - left) / 3);
            int mid2 = right - ((right - left) / 3);
            int target1 = guess(mid1);
            int target2 = guess(mid2);

            if (target1 == 0) return mid1;
            if (target2 == 0) return mid2;
            if ((target1 + target2) == 0) {
                left = mid1 + 1; 
                right = mid2 - 1;
                continue;
            }
            if (target1 == - 1) right = mid1 - 1;
            else left = mid2 + 1;
        }
    }
}