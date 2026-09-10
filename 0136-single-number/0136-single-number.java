class Solution {
    public int singleNumber(int[] nums) {
      HashMap<Integer,Integer> map= new HashMap<>();

      for(int ele:nums){
        map.put(ele,map.getOrDefault(ele,0)+1);

      }
        for(int i=0;i<nums.length;i++){
            if(map.get(nums[i])==1){
                return nums[i];

            }
        }
        return -1;
    }
}