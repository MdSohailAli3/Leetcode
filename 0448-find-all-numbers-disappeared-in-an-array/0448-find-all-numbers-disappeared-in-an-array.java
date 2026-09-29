class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int i = 0;
        // pigeon hole principle
        // filling the holes one by one
        while(i<n){
            if(nums[i] != nums[nums[i]-1]){
                int temp = nums[i];
                nums[i] = nums[nums[i]-1];
                nums[temp-1] = temp;
            }
            else i++;
        }
        for(int j=0; j<n; j++){
            if(nums[j] != j+1) ans.add(j+1);
        }
        return ans;
    }
}