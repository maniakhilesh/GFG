class Solution {
    public void sortIt(int[] arr) {

        int i=0,j=arr.length-1,oddcount=0;
        while(i<=j){

            while(i<arr.length && arr[i]%2!=0){
               i++;
               oddcount++;
            }
            while(j >=0 && arr[j]%2==0)
               j--;
            if(i<j){   
                oddcount++;
            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            }

            i++;j--;
        }

          Arrays.sort(arr,0,oddcount);
         Arrays.sort(arr,oddcount,arr.length);

        reverse(arr,0,oddcount-1);




    }

    void reverse(int [] arr, int i, int j){

        while(i<j){

            int temp=arr[i];
            arr[i]=arr[j];
            arr[j]=temp;
            i++;j--;
        }

    }
}