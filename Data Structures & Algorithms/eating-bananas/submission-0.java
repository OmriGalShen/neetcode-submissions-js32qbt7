class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1, r = Arrays.stream(piles).max().getAsInt();
        int k = r;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (isPossible(piles, h, m)) {
                k = m;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return k;
    }

    public boolean isPossible(int[] piles, int h, int speed) {
        int c = 0;
        for (int p : piles) {
            c += (int) Math.ceil((double) p / speed);
        }
        return c <= h;
    }
}
