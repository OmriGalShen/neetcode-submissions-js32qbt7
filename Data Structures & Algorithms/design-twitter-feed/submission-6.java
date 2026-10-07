class Twitter {
    record Tweet(int tweetId, int time, int userId, int index) {
    }

    private Map<Integer, Set<Integer>> userIdToFollowing;
    private Map<Integer, List<Tweet>> userIdToTweets;
    private int time;

    public Twitter() {
        this.userIdToFollowing = new HashMap<>();
        this.userIdToTweets = new HashMap<>();
        this.time = 0;
    }

    public void postTweet(int userId, int tweetId) {
        this.time++;
        userIdToTweets.putIfAbsent(userId, new ArrayList<>());
        int length = userIdToTweets.get(userId).size();
        userIdToTweets.get(userId).add(new Tweet(tweetId, time, userId, length));
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        PriorityQueue<Tweet> maxHeap = new PriorityQueue<>((t1, t2) -> Integer.compare(t2.time, t1.time));
        Set<Integer> following = userIdToFollowing.getOrDefault(userId, new HashSet<>());
        following.add(userId);
        for (int followId : following) {
            List<Tweet> followTweets = userIdToTweets.getOrDefault(followId, new ArrayList<>());
            if (!followTweets.isEmpty()) {
                maxHeap.offer(followTweets.get(followTweets.size() - 1));
            }
        }
        while (!maxHeap.isEmpty()) {
            Tweet tweet = maxHeap.poll();
            res.add(tweet.tweetId);
            if (res.size() == 10) {
                return res;
            }
            if (tweet.index > 0) {
                Tweet nextTweet = userIdToTweets.get(tweet.userId).get(tweet.index - 1);
                maxHeap.offer(nextTweet);
            }
        }
        return res;
    }

    public void follow(int followerId, int followeeId) {
        userIdToFollowing.putIfAbsent(followerId, new HashSet<>());
        userIdToFollowing.get(followerId).add(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        userIdToFollowing.putIfAbsent(followerId, new HashSet<>());
        userIdToFollowing.get(followerId).remove(followeeId);

    }
}
