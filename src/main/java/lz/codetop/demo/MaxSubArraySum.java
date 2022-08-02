package lz.codetop.demo;

public class MaxSubArraySum {
    /**
     * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     *
     * 子数组 是数组中的一个连续部分。
     *
     *  
     *
     * 示例 1：
     *
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组 [4,-1,2,1] 的和最大，为 6 。
     * 示例 2：
     *
     * 输入：nums = [1]
     * 输出：1
     * 示例 3：
     *
     * 输入：nums = [5,4,-1,7,8]
     * 输出：23
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode.cn/problems/maximum-subarray
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     *
     *
     * 做完可以看{@link LongestIncreasingSubsequence}这个题目
     */
    public static int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(maxSum <= 0) {
                maxSum = nums[i];
            } else {
                maxSum += nums[i];
            }
            if(maxSum > max) {
                max = maxSum;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        int[] a = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(a));
    }
}
