package com.learn.algorithm.design;

import java.util.*;

/**
 * @author yymuhua
 * @create 2020-04-13 10:43
 */
public class Twitter {
    public static void main(String[] args) {
        Twitter twitter = new Twitter();

        // 用户1发送了一条新推文 (用户id = 1, 推文id = 5).
        for(int i = 0; i < 12; i++) {
            twitter.postTweet(1, i);
        }
        System.out.println(twitter.getNewsFeed(1));
    }

    long time;
    Map<Integer, User> userMap; // 用户集合
    /** Initialize your data structure here. */
    public Twitter() {
        time = 0L;
        userMap = new HashMap<>();
    }

    /** Compose a new tweet. */
    public void postTweet(int userId, int tweetId) {
        if(!userMap.containsKey(userId)) {
            userMap.put(userId, new User(userId));
        }
        User user = userMap.get(userId);
        Tweet tweet = new Tweet(tweetId, time);
        user.tweets.add(tweet);
        time++;
    }

    /** Retrieve the 10 most recent tweet ids in the user's news feed. Each item in the news feed must be posted by users who the user followed or by the user herself. Tweets must be ordered from most recent to least recent. */
    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new ArrayList<>();
        if(!userMap.containsKey(userId)) return res;
        User user = userMap.get(userId);
        Queue<Tweet> q = new PriorityQueue<>((a, b) -> (int) (b.createTime - a.createTime));
        for(Tweet tweet : user.tweets) {
            q.add(tweet);
        }
        for(User followee : user.followees) {
            for(Tweet tweet : followee.tweets) {
                q.add(tweet);
            }
        }
        for(int i = 0; i < 10 && !q.isEmpty(); i++) {
            res.add(q.remove().tweetId);
        }
        return res;
    }

    /** Follower follows a followee. If the operation is invalid, it should be a no-op. */
    public void follow(int followerId, int followeeId) {
        if(!userMap.containsKey(followerId)) {
            userMap.put(followerId, new User(followerId));
        }
        if(!userMap.containsKey(followeeId)) {
            userMap.put(followeeId, new User(followeeId));
        }
        User user = userMap.get(followerId);
        user.followees.add(userMap.get(followeeId));
    }

    /** Follower unfollows a followee. If the operation is invalid, it should be a no-op. */
    public void unfollow(int followerId, int followeeId) {
        if(!(userMap.containsKey(followerId) && userMap.containsKey(followeeId))) return ;
        User user = userMap.get(followerId);
        user.followees.remove(userMap.get(followeeId));
    }
    class User {
        int userId;
        Set<User> followees;
        List<Tweet> tweets;
        public User(int id) {
            userId = id;
            followees = new HashSet<>();
            tweets = new ArrayList<>();
        }
    }
    class Tweet {
        int tweetId;
        long createTime;
        public Tweet(int id, long time) {
            tweetId = id;
            createTime = time;
        }
    }
}
