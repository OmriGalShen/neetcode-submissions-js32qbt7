class Solution {
    /*
    many overlapping sub problems + optimal solution -> dp
    def: D - days[days.length-1] (D <= 365)

    dp[i] - minimum dollars to travel from 1 to to i
    recursive defintion:

    if i is traveling day
        option 1 - dp[i-1], i - 1 >= 0
        option 2 - dp[i-7], i-7 >= 0
        option 3- dp[i-30], i-30 >= 0
        dp[i] = min(option 1, option 2, option 3)
    else:
        dp[i] = dp[i-1]

    base case:
    dp[0] = 0

    result:
    dp[days[days.length-1]]

    time: O(D) = O(1)
    space: O(D) = O(1)
    */
    public int mincostTickets(int[] days, int[] costs) {
        // guard
        if (days == null || days.length == 0) {
            return 0;
        }

        // initialize
        Set<Integer> travelDays = new HashSet<>();
        for (int day : days) {
            travelDays.add(day);
        }
        int[] dp = new int[365 + 1];

        // base case
        dp[0] = 0;

        // fill up
        for (int i = 1; i <= 365; i++) {
            if (!travelDays.contains(i)) {
                dp[i] = dp[i - 1];
            } else {
                int min = dp[i - 1] + costs[0];
                min = Math.min(min, ((i - 7 >= 0) ? dp[i - 7] : 0) + costs[1]);
                min = Math.min(min, ((i - 30 >= 0) ? dp[i - 30] : 0) + costs[2]);
                dp[i] = min;
            }
        }

        // retuslt
        return dp[days[days.length - 1]];
    }
}