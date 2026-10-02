class Solution {
    public int maximumStrongPairXor(int[] nums) {
        int len = nums.length;
        int max = 0;
        for(int i=0; i<len; i++){
            for(int j=i; j<len; j++){
                if(Math.abs(nums[i] - nums[j]) <= Math.min(nums[i],nums[j])){
                    max = Math.max(max,nums[i]^nums[j]);
                }
            }
        }
        return max;
    }
}