/***
 * { @link https://leetcode.com/problems/longest-string-chain }
 * 
 * @author Arpan Pathak
 */
class Solution {

    public int longestStrChain(String[] words) {
        if ( words == null || words.length == 0 )
            return 0;
        
        Map<String, Integer> dp = new HashMap<>();
        
        // Sort in ascending order of length....
        Arrays.sort( words, (a,b) -> a.length() - b.length() );
        int maxLength = 0;
        for(String word: words) {
            int currentMax = 0;
            
            // Try to remove exactly one word and see if it's present in the map
            // If it's present then the current word is one of the successor of parent.
            // Find the longest chain length from map and update current max chain.
            for (int i=0; i<word.length(); i++) {
                String parent = word.substring(0,i) + word.substring(i+1);
                
                currentMax = Math.max(currentMax, 1 + dp.getOrDefault(parent, 0));
            }
            
            // Store the longest chain length for current word in the map
            dp.put(word, currentMax);
            
            // Update the max length if current max chain length is greter than the previous max chain length
            maxLength = Math.max(maxLength, currentMax);
        }
        
        return maxLength;
    }
}