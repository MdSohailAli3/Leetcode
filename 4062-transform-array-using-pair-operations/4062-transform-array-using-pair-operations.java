class Solution {
    public boolean canTransform(int[] source, int[] target) {
        // sum of [x+y-delta,delta] == target[x,y]
        long sum1 = 0, sum2 = 0;
        for(int num : source) sum1 += num;
        for(int num : target) sum2 += num;
        return sum1==sum2;
    }
}