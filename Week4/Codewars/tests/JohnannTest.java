import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

import org.junit.Test;

public class JohnannTest {

    private static void testJohn(long n, String res) {
        assertEquals(res, Arrays.toString(Johnann.john(n).toArray())); 
    }
    @Test
    public void test1() {
        testJohn(11, "[0, 0, 1, 2, 2, 3, 4, 4, 5, 6, 6]");
        testJohn(14, "[0, 0, 1, 2, 2, 3, 4, 4, 5, 6, 6, 7, 7, 8]");
        testJohn(9, "[0, 0, 1, 2, 2, 3, 4, 4, 5]");
        testJohn(5, "[0, 0, 1, 2, 2]");
        testJohn(30, "[0, 0, 1, 2, 2, 3, 4, 4, 5, 6, 6, 7, 7, 8, 9, 9, 10, 11, 11, 12, 12, 13, 14, 14, 15, 16, 16, 17, 17, 18]");
    }
    private static void testAnn(long n, String res) {
        assertEquals(res, Arrays.toString(Johnann.ann(n).toArray())); 
    }
    @Test
    public void test2() {
        testAnn(6, "[1, 1, 2, 2, 3, 3]");
        testAnn(15, "[1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6, 7, 8, 8, 9]");
        testAnn(11, "[1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6]");
        testAnn(12, "[1, 1, 2, 2, 3, 3, 4, 5, 5, 6, 6, 7]");
    }
    private static void testSumAnn(long n, long res) {
        assertEquals(res, Johnann.sumAnn(n)); 
    }
    @Test
    public void test3() {
        testSumAnn(115, 4070);
        testSumAnn(150, 6930);
        testSumAnn(112, 3860);
        testSumAnn(83, 2118);
        testSumAnn(59, 1069);
        testSumAnn(1000, 308834);
        testSumAnn(10000, 30899800);
        testSumAnn(50000, 772532948);
    }
    private static void testSumJohn(long n, long res) {
        assertEquals(res, Johnann.sumJohn(n)); 
    }
    @Test
    public void test4() {
        testSumJohn(75, 1720);
        testSumJohn(78, 1861);
        testSumJohn(85, 2212);
        testSumJohn(76, 1766);
        testSumJohn(99, 3005);
        testSumJohn(1000, 308819);
        testSumJohn(10000, 30899781);
        testSumJohn(15000, 69525949);
        testSumJohn(50000, 772532925);
        //testSumJohn(100000, 3090150833);
        //testSumJohn(500000, 77254153089);
    }
    //........
    private static List<List<Long>> johnAnn1234(long n) {
        List<Long>johnList = new ArrayList<Long>();
        List<Long>annList = new ArrayList<Long>();
        List<List<Long>> res = new ArrayList<List<Long>>();
        annList.add(1L);
        johnList.add(0L);
        if (n == 0) {
            res.add(annList);
            res.add(johnList);
        } else {
            long i = 1;
            while (i < n) {
                long j = johnList.get((int)(i - 1));
                long a1 = annList.get((int)j);
                johnList.add(i - a1);
                long a = annList.get((int)(i - 1));
                long j1 = johnList.get((int)a);
                annList.add(i - j1);
                i++;
            }
            res.add(annList);
            res.add(johnList);
        }
        return res;
    }
    public static long sumAnn1234(long n) {
        return johnAnn1234(n).get(0).stream().mapToLong(Long::intValue).sum();
    }
    //........
    private static long randintLong(Random rnd, long min, long max) {
        long randomNumber = (long)(rnd.nextDouble()*(max - min));
        return randomNumber;
    }
    private static void wTests1() 
    {
        for (int i = 0; i < 200; i++) {
            Random rnd = new Random();
            long n = randintLong(rnd, 15000, 40000);
            long ans = sumAnn1234(n);
            //System.out.println("n " + n + " solution " + ans);
            testSumAnn(n, ans);
        }
    }
    @Test
    public void tests1() {
        System.out.println("Random Tests 1 ****");
        wTests1();
    }
}