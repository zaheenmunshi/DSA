package DS.BinarySearch;

/**
 * LeetCode 875. Koko Eating Bananas.
 *
 * <p>
 * Koko can choose an eating speed {@code k} (bananas per hour). Each hour she
 * eats from a single pile; if that pile has fewer than {@code k} bananas she
 * eats
 * it and rests for the remainder of the hour. Given the pile sizes and a limit
 * of
 * {@code h} hours, return the minimum integer speed {@code k} at which she can
 * finish every pile within {@code h} hours.
 *
 * @see <a href="https://leetcode.com/problems/koko-eating-bananas/">Problem
 *      875</a>
 */
public class LC875KokoEatingBananas {

    /**
     * Binary-searches the eating speed over the range {@code [1, max(piles)]}.
     * A speed higher than the largest pile is never useful, since a pile takes at
     * most one hour regardless of how much faster she could have eaten. Because
     * the "can finish in time" predicate is monotonic — every speed above the
     * answer also works — binary search converges on the smallest valid speed.
     *
     * <p>
     * Time: O(n log m), where {@code n} is the number of piles and {@code m}
     * is the largest pile / Space: O(1).
     *
     * @param piles the number of bananas in each pile
     * @param h     the number of hours available to eat all piles
     * @return the minimum integer speed that finishes all piles within {@code h}
     *         hours
     */
    public int minEatingSpeed(int[] piles, int h) {

        int left = 1;
        int right = 1;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (kWorks(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return right;
    }

    /**
     * Checks whether eating at speed {@code k} clears every pile within
     * {@code h} hours. Each pile takes {@code ceil(pile / k)} hours; the ceiling
     * is computed with integer arithmetic as {@code (pile + k - 1) / k} to avoid
     * floating-point rounding.
     *
     * @param piles the number of bananas in each pile
     * @param h     the hour limit
     * @param k     the candidate eating speed (bananas per hour)
     * @return {@code true} if all piles can be finished within {@code h} hours at
     *         speed {@code k}
     */
    private boolean kWorks(int[] piles, int h, int k) {
        int hours = 0;

        for (int pile : piles) {
            hours += (pile + k - 1) / k;
        }

        return hours <= h;
    }
}
