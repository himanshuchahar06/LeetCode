
class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int ans[] = new int[n];

        for (int i = 0; i < n; i++) {

            ans[i] = -1;

            int index = 0;

            // Find nums1[i] in nums2
            for (int j = 0; j < nums2.length; j++) {

                if (nums1[i] == nums2[j]) {
                    index = j;
                    break;
                }
            }

            // Find next greater element
            for (int j = index + 1; j < nums2.length; j++) {

                if (nums2[j] > nums1[i]) {

                    ans[i] = nums2[j];
                    break;
                }
            }
        }

        return ans;
    }
}
