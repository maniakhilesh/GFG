class Solution
 {
     static long pairAndSum(int[] arr)
     {
         long sum = 0;
         for(int i = 0; i<31; i++)
         {
             long count = 0;
             for(int num : arr)
             {
                 if((num & (1 << i)) != 0)
                 {
                     count++;
                 }
             }
             sum += (count * (count - 1) / 2) * (1L << i);
         }
         return sum;
     }
 }