class Solution {
    public ArrayList<Integer> countVowels(String s, int[][] queries) {
        // code here

        // String s="geeksforgeeks";
        // String s="helloworld";

        // int[][] queries={{1,3},{2,4},{1,9}};
        // int[][] queries={{0,4},{5,9},{0,9}};

        if(s.trim().isEmpty() || queries.length==0){
            return new ArrayList<>();
        }

        ArrayList<Integer> list=new ArrayList<>();

        int[] prefix=new int[s.length()+1];

        for(int i=0;i<s.length();i++){
            prefix[i+1]=prefix[i]+(isVowel(s.charAt(i))?1:0);
        }

        // System.out.println("index character count");

        // int index=0;

        // for(char c:s.toCharArray()){
        //   System.out.println(index+"\t\t"+c+"\t\t"+prefix[index]);

        //   index++;
        // }

        for(int[] query:queries){
            int left=query[0];
            int right=query[1];

            int vowelCount=prefix[right+1]-prefix[left];
            // System.out.println(vowelCount);

            list.add(vowelCount);
        }

        // System.out.println(list);
        return list;
    }

    public static boolean isVowel(char c){
        return (c=='a'||c=='e'||c=='i'||c=='o'||c=='u');
    }
}