package com.example.leetcodeq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;

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

