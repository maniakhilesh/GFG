class Solution {
    public int sumDiffPairs(int[] arr, int k) {
        // code here
        Arrays.sort(arr);
        int sum=0;
        for(int i=arr.length-1;i>0;i--){
            if(arr[i]-arr[i-1]<k){
                sum+=arr[i]+arr[i-1];
                i--;
            }
        }
        return sum;
    }
}



