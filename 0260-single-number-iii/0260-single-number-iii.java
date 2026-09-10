class Solution {
    public int[] singleNumber(int[] nums) {


        HashMap<Integer,Integer>map= new HashMap<>(); 
        for(int ele:nums){
            map.put(ele,map.getOrDefault(ele,0)+1);

        }
        int arr[]=new int[2];
        int k=0;

        for(int i=0;i<nums.length;i++)
{
    if(map.get(nums[i])==1){
        arr[k]=nums[i];
        k++;


    }
}  

return arr;
    }
}