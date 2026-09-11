class Solution {
    public int sameMod(int[] arr) {
        int max = arr[0];
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<arr.length;i++) {
            max = Math.max(max,arr[i]);
            set.add(arr[i]);
        }
        if(set.size()==1) return -1;
        int c = 0;
        for(int k=1;k<=max;k++) {
            boolean f = true;
            int rem = arr[0]%k;
            for(int i=1;i<arr.length;i++) {
                if(arr[i]%k!=rem) {
                    f = false;
                    break;
                }
            }
            if(f) {
                c++;
            }
        }
        return c;
    }
}

