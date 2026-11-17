class Solution {
    public boolean isBalanced(String num) {


int arr[] = new int[num.length()];

for (int i = 0; i < num.length(); i++) {
    arr[i] = num.charAt(i) - '0';
}

int esum=0;
int osum=0;

for (int i=0;i<num.length();i++){
    if(i%2==0){
        esum+=arr[i];

    }else{
        osum+=arr[i];

    }

}

  if(esum==osum){
    return true;

  }   

  return false;
    }
}