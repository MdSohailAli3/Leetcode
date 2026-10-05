class Solution {
    public int maximumProduct(int[] nums) {
        int firstMax = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;
        int firstMin = Integer.MAX_VALUE;
        int secMin = Integer.MAX_VALUE;

        for(int num : nums){
            if(num>=firstMax){
                thirdMax = secMax;
                secMax = firstMax;
                firstMax = num;
            }
            else if(num >= secMax){
                thirdMax= secMax;
                secMax = num;
            }
            else if(num >= thirdMax){
                thirdMax = num;
            }

            if(num <= firstMin){
                secMin = firstMin;
                firstMin = num;
            }
            else if( num <= secMin){
                secMin = num;
            }
        }

        int maxProd1 = firstMax * secMax * thirdMax;
        int maxProd2 = firstMax * firstMin * secMin;

        return Math.max(maxProd1, maxProd2);
    }
}