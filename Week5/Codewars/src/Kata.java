public class Kata {

  public static long[] wheatFromChaff(long[] values) {
    int n = values.length;
    int l = 0 , r = n - 1;
    
    // Using two pointer algorithm on cloned array
    long copy[] = values.clone();
     
    // Scan from left to right
    while (l < r) {
      // Check if current element is positive
      if (copy[l] > 0) {
         
         // Move right pointer to left till negative is found 
         while (r > l && copy[r] > 0) --r;
        
         // If no negative is found then we are done
         if (r == l) break;
        
         // Else swap rightmost negative with current positive 
         long t = copy[l];
         copy[l] = copy[r];
         copy[r] = t;
      }
      
      // Move left pointer to right
      ++l;
    }
    
    // Return result
    return copy;
  }
}