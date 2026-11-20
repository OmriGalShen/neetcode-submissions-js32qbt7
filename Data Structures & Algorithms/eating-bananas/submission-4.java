class Solution {
    /*
    N - piles
    K - max(piles)
    time: O(log(K) * N)
    space: O(1)
    */
    public int minEatingSpeed(int[] piles, int h) {
        int max = 0;
        for (int pile : piles) {
            max = Math.max(max, pile);
        }
        int l = 1, r = max;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (possible(piles, h, m)) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        return r;
    }

    private boolean possible(int[] piles, int h, int k) {
        int hours = 0;
        for (int pile : piles) {
            hours += Math.ceil(pile / (double) k);
            if (hours > h) {
                return false;
            }
        }
        return true;
    }
}
