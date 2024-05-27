package Median;
import Exceptions.EmptyArray;
public class Median {
    public double findMedian(int[] nums1, int[] nums2) {
        try{
            if(nums1.length == 0 && nums2.length == 0){
                throw new EmptyArray("Array is empty");
            }
        }
        catch(EmptyArray a){
            System.out.printf(a.getMessage());
        }
        if (nums2.length < nums1.length) {
            return findMedian(nums2, nums1);
        }
        int m = nums1.length;
        int n = nums2.length;
        int start = 0;
        int end = m;

        while (start <= end) {
            int part1 = (start + end) / 2;
            int part2 = (m + n + 1) / 2 - part1;
            int maxleftnums1 = (part1 == 0) ? Integer.MIN_VALUE : nums1[part1 - 1];
            int maxleftnums2 = (part2 == 0) ? Integer.MIN_VALUE : nums2[part2 - 1];
            int minrightnums1 = (part1 == m) ? Integer.MAX_VALUE : nums1[part1];
            int minrightnums2 = (part2 == n) ? Integer.MAX_VALUE : nums2[part2];

            if (maxleftnums1 <= minrightnums2 && maxleftnums2 <= minrightnums1) {
                if ((m + n) % 2 == 0) {
                    return (Math.max(maxleftnums1, maxleftnums2) + Math.min(minrightnums1, minrightnums2)) / 2.0;
                } else {
                    return Math.max(maxleftnums1, maxleftnums2);
                }
            } else if (maxleftnums1 > minrightnums2) {
                end = part1 - 1;
            } else {
                start = part1 + 1;
            }
        }
        throw new IllegalArgumentException("Input arrays are not sorted or empty.");
    }
}