class Solution {
    public int maxDiffSubArrays(int[] arr) {
        // code here
        
        int n=arr.length,res=Integer.MIN_VALUE;
        
        int min[]=new int[n];
        int max[]=new int[n];
        
        int mi=Integer.MAX_VALUE,rs=0;
        int ma=Integer.MIN_VALUE,cs=0;
        
        for(int j=0;j<n;j++){
            
            rs+=arr[j];
            rs=Math.min(rs,arr[j]);
            mi=Math.min(mi,rs);
            
            cs+=arr[j];
            cs=Math.max(cs,arr[j]);
            ma=Math.max(ma,cs);
            
            min[j]=mi;
            max[j]=ma;
        }
        
        int min1[]=new int[n];
        int max1[]=new int[n];
        
        mi=Integer.MAX_VALUE;rs=0;
        ma=Integer.MIN_VALUE;cs=0;
        
        for(int j=n-1;j>=0;j--){
            
            rs+=arr[j];
            rs=Math.min(rs,arr[j]);
            mi=Math.min(mi,rs);
            
            cs+=arr[j];
            cs=Math.max(cs,arr[j]);
            ma=Math.max(ma,cs);
            
            min1[j]=mi;
            max1[j]=ma;
        }
        
        for(int i=0;i<n-1;i++){
            
            int ans=Math.max(Math.abs(min[i]-max1[i+1]),Math.abs(max[i]-min1[i+1]));
            if(res<ans){
                res=ans;
            }
        }
        return res;
    }
}