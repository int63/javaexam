// insertion sort
import java.util.Random;

public class InsertionSort {
    
    public static int[] randArray(int len, int high) {
        assert len >0 && high > 0;
        Random r = new Random();
        int[] a = new int[len];
        for(int i=0;i<a.length;i++){
            a[i] = r.nextInt(high);
        }
        return a;
    }
    
    public static void log(int[] a, String prefix) {
        System.out.print(prefix);
        for(int i=0;i<a.length;i++) {
            System.out.printf("%d ",a[i]);
        }
        System.out.println("");
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
            //log(a,String.format("\ti=%d ",i));
        }
        return moves;
    }
    
    public static void main(String[] args) {
        int[] a = randArray(10000,20000);
        log(a,"");
        long start = System.currentTimeMillis();
        long moves = sort(a);
        long end = System.currentTimeMillis();
        log(a,"");
        System.out.printf("len %d moves %d, took %d ms\n",a.length, moves, end - start);
    }
    
}
