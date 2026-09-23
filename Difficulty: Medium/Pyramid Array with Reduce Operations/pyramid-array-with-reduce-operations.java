class Solution {
    public int formPyramid(int[] arr) {
        // code here
          int n= arr.length;
          int sum = 0;
          for(int i=0; i<n; i++) sum += arr[i];

          // A pyramid of height 1 (a single stone of height 1) is always possible
          if(n<=2) return sum-1;


          int[] left = new int[n];
           int[] right = new int[n];

           //left [i]= max possible pyramid height ending at i, built from the left
              left[0] = Math.min(1, arr[0]);
              for(int i=1; i<n; i++)
                  left[i] = Math.min(left[i-1]+1, arr[i]);


           //right [i]= max possible pyramid height ending at i, built from the right
              right[n-1] = Math.min(1, arr[n-1]);
              for(int i=n-2; i>=0; i--)
                  right[i] = Math.min(right[i+1]+1, arr[i]);

             long maxSq=0;
             for(int i=0; i<n; i++)
             {
                 int h = Math.min(left[i], right[i]); //achieveable peak height at 1
                 maxSq = Math.max(maxSq, (long) h*h); //pyramid of heighr h has area h^2
             }

             return(int) (sum-maxSq);
    }
}