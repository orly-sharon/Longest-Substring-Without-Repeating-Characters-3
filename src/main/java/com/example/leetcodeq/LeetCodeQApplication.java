package com.example.leetcodeq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
/*
3. Longest Substring Without Repeating Characters
Solved
Medium
Topics
premium lock icon
Companies
Hint
Given a string s, find the length of the longest substring without duplicate characters.



Example 1:

Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3. Note that "bca" and "cab" are also correct answers.
Example 2:

Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.


Constraints:

0 <= s.length <= 5 * 104
 */
@SpringBootApplication
public class LeetCodeQApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeetCodeQApplication.class, args);
        int count = lengthOfLongestSubstring("abcabcbb");
        System.out.println(count);
    }

    public static int lengthOfLongestSubstring(String s) {
            HashMap<Character, Integer> map = new HashMap<>();

            int strat = 0;
            int maxLength = 0;

            for (int right = 0; right < s.length(); right++) {
                char current = s.charAt(right);

                if (map.containsKey(current)) {
                    strat = Math.max(strat, map.get(current) + 1);
                }

                map.put(current, right);
                maxLength = Math.max(maxLength, right - strat + 1);
            }

            return maxLength;
        }
}

