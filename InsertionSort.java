// insertion sort
import java.util.Random;

public class InsertionSort {
    
    static int[] randArr(int sz, int ceiling) {
        assert sz > 0;
        Random rand = new Random();
        int[] a = new int[sz];
        for(int i=0;i<a.length;i++) a[i] = rand.nextInt(ceiling);
        return a;
    }
    
    static void verifySorted(int a[]) {
        for(int i=0;i<a.length-1;i++){
            assert(a[i] <= a[i+1]);
        }
    }
    
    
    public static long sort(int[] a) {
        long moves = 0;
        for( int i=1; i<a.length; i++ ){
            int key = a[i];
            int j = i - 1;
            while( j >= 0 && a[j] > key ) {
                a[j+1] = a[j];
                moves++;
                j--;
            }
            a[j+1] = key;
        }
        return moves;
    }
    
    public static void main(String[] args) {
        int n = args.length >= 1 ? Integer.parseInt(args[0]) : 10;
        int ceiling = args.length >= 2 ? Integer.parseInt(args[1]) : 2 * n;
        
        int[] a = randArr(n,ceiling);
        long start = System.currentTimeMillis();
        long moves = sort(a);
        long end = System.currentTimeMillis();
        verifySorted(a);
        
        System.out.printf("Insertion sort n=%,d, ceiling=%,d, n^2=%,d moves=%,d\n, took %,d ms\n", 
        n, ceiling, n * n, moves, end - start);
    }
    
}
