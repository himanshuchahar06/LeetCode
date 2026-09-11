class Solution {
    public boolean isIsomorphic(String s, String t) {

        HashMap<Character,Character>map= new HashMap<>();
        HashMap<Character,Character>map1= new HashMap<>();

       char arr[]= s.toCharArray();
       char arr1[]=t.toCharArray();

       for(int i=0;i<arr.length;i++){
        
      
         if(map.containsKey(arr[i])){
            if(map.get(arr[i])!=arr1[i]){
                return false;
            }
         }else{
            map.put(arr[i],arr1[i]);
         }
         

       }
         for(int i=0;i<arr.length;i++){
        
      
         if(map1.containsKey(arr1[i])){
            if(map1.get(arr1[i])!=arr[i]){
                return false;
            }
         }else{
            map1.put(arr1[i],arr[i]);
         }
         

       }
     

        // for(int i=0;i<arr.length;i++){
        //     if(map.isEmpty()&& map1.isEmpty()){
        //         return  true;
        //     }
        // }
        
        return true;

    }
}