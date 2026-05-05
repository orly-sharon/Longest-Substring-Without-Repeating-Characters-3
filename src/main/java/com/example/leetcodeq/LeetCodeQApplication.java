package com.example.leetcodeq;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashMap;
/*
4. Median of Two Sorted Arrays
Hard
Topics
premium lock icon
Companies
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).



Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.


Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
 */
@SpringBootApplication
public class LeetCodeQApplication {

    public static void main(String[] args) {
        SpringApplication.run(LeetCodeQApplication.class, args);
        int[] firstArray = new int[]{1, 2, 3, 4, 5};
        int[] secondArray = new int[]{7, 8, 9, 10};
        double res = findMedianSortedArrays(firstArray, secondArray);
        System.out.println(res);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        // Always binary search the smaller array
        if (nums1.length > nums2.length) {
            return findMedianSortedArrays(nums2, nums1);
        }

        int A = nums1.length;
        int B = nums2.length;

        int low = 0, high = A;

        while (low <= high) {
            int i = (low + high) / 2;              // partition in nums1
            int j = (A + B + 1) / 2 - i;          // partition in nums2

            int maxLeftA = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int minRightA = (i == A) ? Integer.MAX_VALUE : nums1[i];

            int maxLeftB = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int minRightB = (j == B) ? Integer.MAX_VALUE : nums2[j];

            // correct partition found
            if (maxLeftA <= minRightB && maxLeftB <= minRightA) {

                // even total length
                if ((A + B) % 2 == 0) {
                    return (
                            Math.max(maxLeftA, maxLeftB) +
                                    Math.min(minRightA, minRightB)
                    ) / 2.0;
                }
                // odd total length
                else {
                    return Math.max(maxLeftA, maxLeftB);
                }
            }

            // too far right in nums1 → move left
            else if (maxLeftA > minRightB) {
                high = i - 1;
            }
            // too far left in nums1 → move right
            else {
                low = i + 1;
            }
            ;
        }
        return 0.0;
    }
}




