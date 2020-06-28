/***
 * {@link https://leetcode.com/problems/partition-labels/ }
 */
import java.util.*;

class Solution {
    
    public List<Integer> partitionLabels(String S) {
        List<Integer> partitions = new ArrayList<Integer>();
        Map<Character, Integer> M = new TreeMap<>();
        int start = 0, end = 0;
        
        for(int i = 0; i< S.length() ; i++) 
            M.put(S.charAt(i), i);
        
        for(int i=0 ;i<S.length(); i++) {
            end = Math.max(end, M.get(S.charAt(i)));
            if (end == i) {
                partitions.add(end - start +1);
                start = i + 1; 
            }
        }
    
        return partitions;      
    }
}
