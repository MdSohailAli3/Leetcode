class Solution {
    public int[] rearrangeArray(int[] nums) {
        int[] hash = new int[101];
        for(int num : nums){
            hash[num]++;
        }
        int k=0;
        int[] ans = new int[nums.length];
        for(int i=0; i<=100; i++){
            for(int j=0; j<=100; j++){
                if(hash[j] != 0){
                    ans[k++]=j;
                    hash[j]--;
                }
                
            }
            if(k==nums.length)break;
        }
        return ans;
    }
}