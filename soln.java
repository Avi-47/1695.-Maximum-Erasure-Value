class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        int a = 0;
        int l = 0;
        int max = 0;
        Set<Integer> map = new HashSet<>();
        for(int r = 0;r<nums.length;r++){
            while(l<r && map.contains(nums[r])){
                max-=nums[l];
                map.remove(nums[l]);
                l++;
            }
            map.add(nums[r]);
            max+=nums[r];
            a = Math.max(max,a);
        }
        return a;
    }
}
