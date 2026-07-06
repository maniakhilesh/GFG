class Solution {
    public int maxPathSum(int[] a, int[] b) {
        // code here
        int l = a.length; int r = b.length;
        int i = 0; int j =0;
        int suma = 0 ; int sumb =0;
        int maxsum =0;
        while(i< l && j< r)
        {
            if(a[i] < b[j])
            {
                suma += a[i];
                i++;
            }else if(a[i] >b[j])
            {
                sumb += b[j];
                j++;
            }
            else
            {
                suma += a[i];
                sumb += b[j];
                i++;
                j++;
                
                maxsum += Math.max(suma,sumb);
                suma = sumb = 0;
                
                
            }
        }
        while(i < l)
        {
            suma +=a[i++];
        }
        while(j<r)
        {
            sumb += b[j++];
        }
        maxsum += Math.max(suma,sumb);
        return maxsum;
    }
}