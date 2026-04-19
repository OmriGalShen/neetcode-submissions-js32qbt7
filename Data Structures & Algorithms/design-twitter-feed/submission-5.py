class Twitter:

    def __init__(self):
        self.user_followers = defaultdict(set)
        self.user_to_tweets = defaultdict(list)
        self.timer = 0

    def postTweet(self, userId: int, tweetId: int) -> None:
        self.timer += 1
        self.user_to_tweets[userId].append((-self.timer, tweetId))

    def getNewsFeed(self, userId: int) -> List[int]:
        following = self.user_followers[userId] | {userId}
        maxHeap = []
        for followId in following:
            tweets = self.user_to_tweets[followId]
            if tweets:
                timer, last_tweet_id = tweets[-1]
                maxHeap.append((timer, last_tweet_id, followId, len(tweets)-1))
        heapq.heapify(maxHeap)
        res = []
        while maxHeap and len(res) < 10:
            _, last_tweet_id, follow_id, last_index = heapq.heappop(maxHeap)
            res.append(last_tweet_id)
            if last_index > 0:
                new_timer, new_last_tweet_id = self.user_to_tweets[follow_id][last_index-1]
                new_item = (new_timer, new_last_tweet_id, follow_id,last_index-1)
                heapq.heappush(maxHeap, new_item)

        return res


    def follow(self, followerId: int, followeeId: int) -> None:
        self.user_followers[followerId].add(followeeId)

    def unfollow(self, followerId: int, followeeId: int) -> None:
        self.user_followers[followerId].discard(followeeId)
