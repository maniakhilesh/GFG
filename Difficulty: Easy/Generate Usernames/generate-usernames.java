class Solution {
    public ArrayList<String> generateUsernames(String[] arr) {
        // code here
        Set<String>set=new HashSet<>();
        for(String s:arr)set.add(s);
        Set<String>set2=new HashSet<>();
        ArrayList<String>list=new ArrayList<>();
        for(String s:arr){
            if(!set2.contains(s)){
                list.add(s);
                set2.add(s);
            }
            else{
                int x=1;
                while(set.contains(s+x)){
                    x++;
                }
                set2.add(s+x);
                set.add(s+x);
                list.add(s+x);
            }
        }
        return list;
        }
}

