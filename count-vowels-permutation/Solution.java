/***
 * https://leetcode.com/problems/count-vowels-permutation
 * 
 */
class Solution {
    public int countVowelPermutation(int n) {
        int MOD = 1000000007;
        long a = 1, e=1, i=1, o=1, u =1,a1,e1,i1,o1,u1;
        for (int ind=2; ind<=n; ind++) {
            a1 = e;
            e1 = (a+i)%MOD;
            i1 = (a+e+o+u)%MOD;
            o1 = (i+u)%MOD;
            u1 = a;
            
            a = a1; e=e1; i = i1; o = o1; u = u1;
        }
        
        return (int)(  ((a+e)% MOD + (i+o)%MOD) % MOD + u) % MOD;
    }
}