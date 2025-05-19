package 二分查找.寻找两个正序数组的中位数;

public class FindMedianSortedArrays_4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLen = nums1.length + nums2.length;
        if (totalLen % 2 == 1) {
            return getKthElement(nums1, nums2, totalLen / 2 + 1);
        } else {
            int left = getKthElement(nums1, nums2, totalLen / 2);
            int right = getKthElement(nums1, nums2, totalLen / 2 + 1);
            return (left + right) / 2.0;
        }
    }

    // 找两个有序数组中的第 k 小的数
    private int getKthElement(int[] nums1, int[] nums2, int k) {
        int index1 = 0, index2 = 0;
        int len1 = nums1.length, len2 = nums2.length;
        while (true) {
            if (index1 == len1) return nums2[index2 + k - 1];
            if (index2 == len2) return nums1[index1 + k - 1];
            if (k == 1) return Math.min(nums1[index1], nums2[index2]);

            int half = k / 2;
            int newIndex1 = Math.min(index1 + half, len1) - 1;
            int newIndex2 = Math.min(index2 + half, len2) - 1;

            int pivot1 = nums1[newIndex1];
            int pivot2 = nums2[newIndex2];

            if (pivot1 <= pivot2) {
                k -= (newIndex1 - index1 + 1);
                index1 = newIndex1 + 1;
            } else {
                k -= (newIndex2 - index2 + 1);
                index2 = newIndex2 + 1;
            }
        }
    }
}
