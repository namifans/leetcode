class Post {
    public int id;
    public Long time; 
    public Post prev;
    public Post(int id, long time) {
        this.id = id;
        this.time = time;
    }
}

class User {
    public Post post;
    public Set<Integer> follow;
    public User() {
        follow = new HashSet<>();
    }
}

class Twitter {

    Map<Integer, User> users;
    long seq;

    /** Initialize your data structure here. */
    public Twitter() {
        users = new HashMap<>();
        seq = 0;
    }
    
    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        User u = users.getOrDefault(userId, new User());
        Post np = new Post(tweetId, seq++);
        if (u.post != null) {
            np.prev = u.post;
        }
        u.post = np;
        users.put(userId, u);
    }
    
    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> feed = new ArrayList<>();
        if (users.containsKey(userId)) {
            Queue<Post> q = new PriorityQueue<Post>((x, y) -> y.time.compareTo(x.time));
            User u = users.get(userId);
            if (u.post != null) {
                q.offer(u.post);
            }
            for (int i : u.follow) {
                User f = users.get(i);
                if (f.post != null) {
                    q.offer(f.post);
                }
            }
            while(!q.isEmpty() && feed.size() < 10) {
                Post p = q.poll();
                feed.add(p.id);
                if (p.prev != null) {
                    q.offer(p.prev);
                }
            }
        }
        return feed;
    }
    
    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        if (!users.containsKey(followerId)) {
            register(followerId);
        }
        if (!users.containsKey(followeeId)) {
            register(followeeId);
        }
        User u = users.get(followerId);
        u.follow.add(followeeId);
        users.put(followerId, u);
    }
    
    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if (followerId == followeeId) {
            return;
        }
        if (!users.containsKey(followerId)) {
            register(followerId);
        }
        if (!users.containsKey(followeeId)) {
            register(followeeId);
        }
        User u = users.get(followerId);
        if (u.follow.contains(followeeId)) {
            u.follow.remove(followeeId);
        }
        users.put(followerId, u);
    }

    private void register(int userId) {
        users.put(userId, new User());
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