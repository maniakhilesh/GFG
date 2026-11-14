class Solution {
    public int maxEqualSum(ArrayList<Integer> s1, ArrayList<Integer> s2,
                           ArrayList<Integer> s3) {
        // code here
        int sum1=0, sum2=0, sum3=0;
        for(int i:s1){
            sum1+=i;
        }
        for(int i:s2){
            sum2+=i;
        }
        for(int i:s3){
            sum3+=i;
        }

        int i=0, j=0, k=0;

        while(i<s1.size() || j<s2.size() || k<s3.size()){
            // System.out.println(sum1+ " "+sum2+ " "+ sum3);
            if(sum1 == sum2 && sum2 == sum3){
                return sum1;
            }
            else if (sum1 >= sum2 && sum1 >= sum3){
                // System.out.println("1st "+ sum1);
                sum1-=s1.get(i++);
            } else if (sum2 >= sum1 && sum2 >= sum3){
                // System.out.println("2nd "+sum2);
                sum2-=s2.get(j++);
            } else {
                // System.out.println("3rd "+ sum3);
                sum3-=s3.get(k++);
            }
        }
        return 0;
    }
}