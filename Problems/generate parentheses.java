class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> permutations = new ArrayList<>();
        backtrack(permutations, "", 0, 0, n);
        return permutations;
    }
    
    private void backtrack(List<String> permutations, String sb, int openP, int closeP, int n) {
        if(sb.length() == n*2) {
            permutations.add(sb);
            return;
        }
        
        if(openP < n) {
            backtrack(permutations, sb+"(", openP+1, closeP, n);
        }
 
        if(closeP < openP) {
            backtrack(permutations, sb+")", openP, closeP+1, n);
        }
    }
}