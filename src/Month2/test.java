package Month2;

class Solution {
    public String samePerfix(String word1, String word2){
        StringBuffer sb = new StringBuffer();
        int len1 = word1.length();
        int len2 = word2.length();
        int n = Math.min(len1,len2);
        int i = 0;
        while(word1.charAt(i) == word2.charAt(i)){
            sb.append(word1.charAt(i));
            i++;
        }

        return sb.toString();

    }

    public String largestMerge(String word1, String word2) {
        StringBuffer merge = new StringBuffer();

        while(!word1.equals("") && !word2.equals("")){
            int len1 = word1.length();
            int len2 = word2.length();

            String perfix = samePerfix(word1, word2);
            int lenFix = perfix.length();
            //比较perfix之后的字符大小
            if(!word1.equals("") && !word2.equals("")){
                if(word1.charAt(lenFix+1) > word2.charAt(lenFix+1)){
                    merge.append(perfix).append(word1.charAt(lenFix+1));
                    //StringBuffer kong = new StringBuffer();
                    //word1.replace(0,lenFix+1,kong); //相当于删除
                    word1 = word1.substring(lenFix+1);
                }else{
                    merge.append(perfix).append(word2.charAt(lenFix+1));
                    //StringBuffer kong = new StringBuffer();
                    //word2.replace(0,lenFix+1,kong); //相当于删除
                    word2 = word2.substring(lenFix+1);
                }
            }
        }
        if(!word1.equals("")) merge.append(word1);
        if(!word2.equals("")) merge.append(word2);
        return merge.toString();
    }
}

public class test{
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.largestMerge("cabaa","bcaaa"));
        //System.out.println(s.samePerfix("bcbaa","bcaaa"));
    }
}