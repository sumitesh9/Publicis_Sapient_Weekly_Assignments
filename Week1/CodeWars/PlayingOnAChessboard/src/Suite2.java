public class Suite2 {
	
	public static String game(long n) {
    // your code
    // This is a ad-hoc problem requiring us to observe pattern
    
    // We can just brute force the solution by actually summing the fractional values
    // but it leads to inefficient solution and also lots of precision errors while
    // dealing with fractions
    
    // Idea here is to sum by scanning diagonally because denominators are same
    // If n is odd -> Answer = (n * n) / 2
    // If n is even -> Answer = n * n / 2;
    
    
    String result = "[";
    String numerator = "" , denominator = "";
    
    // n is even
    if (n % 2 == 0) {
        numerator = String.valueOf((n * n) / 2);
        result += numerator;
        result += "]";
    }
    
    // n is odd
    else {
        numerator = String.valueOf((n * n));
        denominator = "2";
        result += numerator + ", " + denominator;
        result += "]";
    }
    
    return result;
	}
}