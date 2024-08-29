class Tweet {
    public int tweetId;
    public int timestamp;
    public Tweet(int tweetId, int timestamp) {
        this.tweetId = tweetId;
        this.timestamp = timestamp;
    }
}
class Twitter {

    Map<Integer, Set<Integer>> followMap;
    Map<Integer, List<Tweet>> userTweetMap;
    int currentTimeStamp;

    public Twitter() {
        followMap = new HashMap<>();
        userTweetMap = new HashMap<>();
        currentTimeStamp = 0;
    }
    
    public void postTweet(int userId, int tweetId) {
        Tweet tweet = new Tweet(tweetId, currentTimeStamp++);
        List<Tweet> tweetList = userTweetMap.getOrDefault(userId, new ArrayList<>());
        tweetList.add(tweet);
        userTweetMap.put(userId, tweetList);
    }
    
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feeds = new ArrayList<>();
        Queue<Tweet> feedsHeap = new PriorityQueue<>((x, y) -> (y.timestamp - x.timestamp));
        List<Tweet> tweetList = new ArrayList<>();
        tweetList.addAll(getFollowingTweets(userId));
        tweetList.addAll(userTweetMap.getOrDefault(userId, new ArrayList<>()));
        for (Tweet t : tweetList) {
            feedsHeap.add(t);
        }
        int i = 10;
        while (!feedsHeap.isEmpty() && i > 0) {
            feeds.add(feedsHeap.remove().tweetId);
            i--;
        }
        return feeds;
    }

    private List<Tweet> getFollowingTweets(int userId) {
         List<Tweet> tweetList = new ArrayList<>();
         Set<Integer> followSet = followMap.getOrDefault(userId, new HashSet<>());
         for (Integer uid : followSet) {
            List<Tweet> uidTweetlist = userTweetMap.getOrDefault(uid, new ArrayList<>());
            tweetList.addAll(uidTweetlist);
        }
        return tweetList;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> followSet = followMap.getOrDefault(followerId, new HashSet<>());
        followSet.add(followeeId);
        followMap.put(followerId, followSet);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followSet = followMap.getOrDefault(followerId, new HashSet<>());
        if (followSet.contains(followeeId)) {
            followSet.remove(followeeId);
        }
        followMap.put(followerId, followSet);
    }
}

/**
 * Your Twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */