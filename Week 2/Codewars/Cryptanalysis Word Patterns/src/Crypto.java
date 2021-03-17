class Crypto {
  
  public static String wordPattern(final String word){
    // Your code here!
    
    // Just simulate the question statement
    // Iterate the word from left to right and assign integer code accordingly
    
    // Time Complexity - O(n)
    // Space Complexity - O(1) 
    
    // code[i] is for storing code for ith character of alphabet
    // Initially all of them are -1
    
    int code[] = new int[26];
    for (int i = 0; i < 26; ++i) code[i] = -1;
    StringBuffer answer = new StringBuffer("");
    int len = 0;
    for (int i = 0; i < word.length(); ++i) {
        char c = word.charAt(i);
        // find index in of c in alphabet
        int index = Character.toLowerCase(c) - 'a';
        if (code[index] == -1) {
          code[index] = len++;
        }
        answer.append(code[index] + ".");
    }
    
    return answer.substring(0 , answer.length() - 1);
  }
}