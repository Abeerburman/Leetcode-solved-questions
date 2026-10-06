class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int s = 0;
        for(int i = 0;i<n;i++){
            int c = 0;
            for(int j = i;j<n;j++){
                c+=nums[j];
                if(c==k)
                s++;
            }

        }
        return s;
    }
    
}