class Solution {
    public ArrayList<Integer> constructList(int[][] queries) {
        int xor = 0;
        for(int i=0;i<queries.length;i++){
            if(queries[i][0]==1){
                xor ^= queries[i][1]; 
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(0^xor);
        for(int i=0;i<queries.length;i++){
            int op = queries[i][0];
            int ele = queries[i][1];
            if(op==0){
                ans.add(ele^xor);
            }
            else{
                xor ^= ele;
            }
        }
        Collections.sort(ans);
        return ans;
    }
}