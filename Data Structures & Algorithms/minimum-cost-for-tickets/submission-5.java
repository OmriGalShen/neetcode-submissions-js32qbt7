class Solution {
    /*
    T - max(days)

    dp[i] = minimum dollars to travel int days[0,..,i]
    0 <= i<= T

    for i:
    if i in days:
        min(dp[i-1] + costs[0], dp[i-7] + costs[1], dp[i-30] + costs[2])
    else:
        dp[i-1]

    base:
    dp[0] = 0

    result:
    dp[T]

    time: O(365) = O(1)
    space: O(T) = O(365) = O(1)
    */
    public int mincostTickets(int[] days, int[] costs) {
        // guard
        if (days == null || days.length == 0) {
            return 0;
        }

        // intialize
        int lastDay = days[days.length - 1];
        int[] dp = new int[lastDay + 1];
        Set<Integer> travelDays = new HashSet<>();
        for (int day : days) {
            travelDays.add(day);
        }

        // base cases
        dp[0] = 0;

        // bottom up
        for (int d = 1; d <= lastDay; d++) {
            if (travelDays.contains(d)) {
                int day = dp[d - 1] + costs[0];
                int week = ((d - 7 >= 0) ? dp[d - 7] : 0) + costs[1];
                int month = ((d - 30 >= 0) ? dp[d - 30] : 0) + costs[2];
                dp[d] = Math.min(day, week);
                dp[d] = Math.min(dp[d], month);
            } else {
                dp[d] = dp[d - 1];
            }
        }

        // result
        return dp[lastDay];
    }
}