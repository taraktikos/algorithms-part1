package week1.analysis;

import lib.In;
import lib.StdRandom;
import lib.Stopwatch;

/**
 * Created by Taras S. on 02.03.15.
 */
public class ThreeSum {

    public static int count(int[] a) {
        int N = a.length;
        int count = 0;
        for (int i = 0; i < N; i ++) {
            for (int j = i+1; j < N; j ++) {
                for (int k = j + 1; k < N; k ++) {
                    if (a[i] + a[j] + a[k] == 0) {
                        count ++;
                    }
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        In in = new In(ThreeSum.class.getResource("/week1/analysis/1Kints.txt"));
        int[] a = in.readAllInts();
        System.out.println(count(a));

        for (int N = 250; N < 10000; N += N) {
            double time = timeTrial(N);
            System.out.printf("%7d %5.1f\n", N, time);
        }
    }

    public static double timeTrial(int N) {
        int MAX = 1000000;
        int[] a = new int[N];
        for (int i = 0; i < N; i++) {
            a[i] = StdRandom.uniform(-MAX, MAX);
        }
        Stopwatch timer = new Stopwatch();
        ThreeSum.count(a);
        return timer.elapsedTime();
    }
}
