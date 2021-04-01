import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;
import java.util.stream.*;
import java.util.*;


public class SolutionTest {
    
  @Test
  public void exampleTests() {
        String[][] tests = {
            {"hello", "0.1.2.2.3"},
            {"heLlo", "0.1.2.2.3"},
            {"helLo", "0.1.2.2.3"},
            {"Hippopotomonstrosesquippedaliophobia", "0.1.2.2.3.2.3.4.3.5.3.6.7.4.8.3.7.9.7.10.11.1.2.2.9.12.13.14.1.3.2.0.3.15.1.13"},
        };
      for(String[] arr: tests)
        assertEquals(arr[1],Crypto.wordPattern(arr[0]));
    }
  
  @Test
  public void randomTests(){
    for(int i=0;i<100;i++){
      var inp = getRndStr();
      var exp = gnaRefCrypto(inp);
      /*
      System.out.println(inp);
      System.out.println(exp);
      System.out.println("---");
      //*/
      var act = Crypto.wordPattern(inp);
      assertEquals(exp,act);
    }
  }
  
  private static Random RND = new Random();
  
  private static int rnd(int a)       { return rnd(0,a); }
  private static int rnd(int a, int b){ return a+RND.nextInt(b-a); }
  
  
  private static String getRndStr(){
    return IntStream.range(0,rnd(5,100))
                    .mapToObj( i-> ""+(char) ((rnd(2)==1?65:97) + rnd(26)) )
                    .collect(Collectors.joining());
  }
  
  private static String gnaRefCrypto(final String word){
    var h = new HashMap<Integer,Integer>();
    String[] arr = word.toLowerCase().chars()
                                     .mapToObj( c-> "" + h.computeIfAbsent(c,k->h.size()) )
                                     .toArray(String[]::new);
    return String.join(".", arr);
  }
}