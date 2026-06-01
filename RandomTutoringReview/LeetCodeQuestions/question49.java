package LeetCodeQuestions;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class question49 {

    public static void main(String[] args) {
        
        String[] anagrams = {"a"};

        System.out.println(groupAnagrams(anagrams));
    }

    public static List<List<String>> groupAnagrams(String[] strs){

        Arrays.sort(strs);

        ArrayList<String> strs2 = new ArrayList<>(Arrays.asList(strs));

        ArrayList<List<String>> results = new ArrayList<>();

        ArrayList<String> temp = new ArrayList<>();

        int i = 0;
        int j = i+1;
        int k = 0;

        if(strs2.size() <= 0){
            results.add(List.of(""));
            return results;

        } else if(strs2.size() == 1){
            results.add(List.of(strs2.get(i)));
            return results;

        } else {

                while(i < strs2.size()){

                String s1 = strs2.get(i);

                while(j < strs2.size()){

                    while(k < strs2.get(i).length()) {

                        char c1 = s1.charAt(k);
                        String s2 = strs2.get(j);

                        if(s2.contains(String.valueOf(c1))){

                            if(k >= strs2.get(i).length()-1){
                                temp.add(s2);
                                break;
                            
                            } else {
                                k++;
                                continue;
                            }
                        } else {
                            break;
                        }
                    }
                    j++;
                }

                temp.add(s1);
                results.add(new ArrayList<>(temp));
                strs2.removeAll(temp);
                i = 0;
                j=i+1;
                k=0;
                temp.clear();
            }
        }

        return results;
    }
}