import java.util.*;
public class Johnann {
    
    // Lists storing John and Ann's Katas
    private static List<Long> John = new ArrayList<>();
    private static List<Long> Ann = new ArrayList<>();
    
    // Base case
    static {
        John.add(0L);
        Ann.add(1L);
    }
    
    // Recursively compute katas done on nth day.
    private static void count(List<Long> first , List<Long> second , Long day) {
        if (first.size() > day)
            return;
        int from = first.size() - 1;
        if (day - from > 1) {
            for (int i = from; i <= day; ++i) {
                count(first, second, (long) i);
            }
        } 
        else {
            Long lastDay = first.get(from);
            count(second , first , lastDay);
            first.add(day - second.get(lastDay.intValue()));
        }
    }

    public static List<Long> john(long n) {
        // Check if answer upto nth day is precomputed
        if (John.size() >= n)
            return John.subList(0 , (int)n);
        
        // Compute for remaining days
        for (int i = John.size(); i < n; ++i) {
            count(John, Ann, (long) i);
        }
        
        // Return first n days' katas
        return John.subList(0 , (int)n);
    }

    public static List<Long> ann(long n) {
        // Check if answer upto nth day is precomputed
        if (Ann.size() >= n)
            return Ann.subList(0 , (int)n);
        
        // Compute for remaining days
        for (int i = Ann.size(); i < n; ++i) {
            count(Ann, John, (long) i);
        }
        
        // Return first n days' katas
        return Ann.subList(0 , (int)n);
    }

    public static long sumJohn(long n) {
        count(John, Ann, n);
        // Find sum for first n days
        long sum = 0l;
        for (int i = 0; i < n; ++i) sum += John.get(i);
        return sum;
    }

    public static long sumAnn(long n) {
        count(Ann, John, n);
        // Find sum for first n days
        long sum = 0l;
        for (int i = 0; i < n; ++i) sum += Ann.get(i);
        return sum;
    }
}