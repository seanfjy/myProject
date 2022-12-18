package com.fan.myexercise;

import org.junit.jupiter.api.Test;

import lombok.val;

public class LeetCode {

    @Test
    void test() {
        String s = "aa";
        val solution = new Solution();
        int i = solution.maxLengthBetweenEqualCharacters(s);
        System.out.println(i);
    }
    @Test
    void test1(){
        int[] nums1 = {1,3};
        int[] nums2 = {2};
        val solution = new Solution();
//        double medianSortedArrays = solution.findMedianSortedArrays(nums1, nums2);
//        System.out.println(medianSortedArrays);
    }

    class Solution {
        public int maxLengthBetweenEqualCharacters(String s) {
            int maxLength = -1;
            if (s.length() <= 1) {
                return maxLength;
            }
            char[] chars = s.toCharArray();
            for (int i = 0; i < chars.length / 2; i++) {
                char aChar = chars[i];
                int lastIndexOf = s.lastIndexOf(aChar);
                if (lastIndexOf != -1 && lastIndexOf > i) {
                    int len = lastIndexOf - i - 1;
                    if (len > maxLength) {
                        maxLength = len;
                    }
                }
            }
            return maxLength;
        }


//        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
//            List<Integer> integerList = new ArrayList<>();
//            for (int i : nums1) {
//                integerList.add(i);
//            }
//            for (int i : nums2) {
//                if (!integerList.contains(i)){
//                    integerList.add(i);
//                }
//            }
//            integerList.sort(Integer::compareTo);
//            int size = integerList.size();
//            Integer integer = integerList.get(integerList.size() / 2-1);
//            Integer integer2 = integerList.get(integerList.size() / 2);
//
//            return size%2==0? (integer+ integer2)/2.0:integer2;
//        }
    }
}
