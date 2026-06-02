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
            int middle = left + ((right - left) / 2);
            int target = guess(middle);

            if (target == 0) return middle;
            if (target == -1) right = middle - 1;
            else left = middle + 1;
        }
    }
}
