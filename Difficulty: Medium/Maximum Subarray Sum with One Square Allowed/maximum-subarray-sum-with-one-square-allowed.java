class Solution {
    int[] dp0;
    int[] dp1;
    public int maximumSubarray(int[] arr) {
        int maxSum=0;
        dp0 = new int[arr.length];
        dp1 = new int[arr.length];
        int sum =0,sum1=0;
        for(int i =0;i<arr.length;i++){
            sum+=arr[i];
            sum1+=arr[arr.length-1-i];
            dp1[arr.length-1-i]=Math.max(dp1[arr.length-1-i],sum1);
            dp0[i]=Math.max(dp0[i],sum);
            sum = Math.max(sum,0);
            sum1 = Math.max(sum1,0);

        }
        for(int i =0;i<arr.length;i++){
           maxSum=Math.max(maxSum,sum(arr,i));
        }
        return maxSum;

    }
    private int sum(int[] arr, int maxElement_index){
        int left_max = 0, right_max=0;
        if(maxElement_index>0){
            left_max=dp0[maxElement_index-1];
        }
        if(maxElement_index<arr.length-1){
            right_max=dp1[maxElement_index+1];
        }
        int maxElement = Math.abs(arr[maxElement_index]);

        return left_max + maxElement*maxElement + right_max;
    }
}

