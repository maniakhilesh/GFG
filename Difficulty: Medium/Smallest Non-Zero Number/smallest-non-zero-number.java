class Solution {
    public int find(int[] arr) {
        // code here
        long x = 0;
        for (int i = arr.length - 1; i >= 0; i--){
            x = (x+arr[i] + 1) /2;
        }
        return (int) x;
    }
}
