//Quick sort in java
import java.util.Random;

public class QuickSort {
    int numSwaps = 0;
    
    static void verifySorted(int a[]) {
        for(int i=0;i<a.length-1;i++){
            assert(a[i] <= a[i+1]);
        }
    }
    
    public static int[] randArr(int sz, int ceiling) {
        assert sz > 0;
        Random rand = new Random();
        int[] a = new int[sz];
        for(int i=0;i<a.length;i++) a[i] = rand.nextInt(ceiling);
        return a;
    }
    
    public static void prnArr(int a[]) {
        System.out.printf("[");
        for(int i=0;i<a.length;i++) System.out.printf("%d ",a[i]);
        System.out.println("]");
    }
    
    public void swap(int a[], int i, int j) {
        if(i != j) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
            numSwaps++;
        }
    }
    
    private int pivotOf(int a[], int left, int right) {
        if(right > left + 1) {
            int mid = (right - left)/2;
            int p = right;
            if(a[left] > a[mid]) {
                if(a[mid] > a[right]) p = mid;
                else if(a[right] > a[left]) p = left;
            } else {
                if(a[mid] < a[right]) p = mid;
                else if(a[left] > a[right]) p = left;
            }
            if(p != right) swap(a,p,right);
        }
        return a[right];
    }
    
    private int partition(int a[], int left, int right) {
        
        int pivot = pivotOf(a,left,right);
        int i = left -1;
        for(int j=left;j<right;j++){
            if(a[j] < pivot) swap(a,++i,j);
        }
        swap(a,i+1,right);
        return i+1;
    }
    
    private void quickSort(int a[], int left, int right) {
        if(left < right) {
            int p =partition(a,left,right);
            //System.out.printf("\t %d,%d: [%d] = %d ",left,right,p, a[p]);
            //prnArr(a);
            quickSort(a,left,p-1);
            quickSort(a,p+1,right);
        }
    }
    
    void quickSort(int a[]) {
        quickSort(a,0,a.length-1);
    }
    
   
    public static int log2(int x)
    {
        return (int) (Math.log(x) / Math.log(2));
    }

    public static void main(String[] args) {
        int n = args.length >= 1 ? Integer.parseInt(args[0]) : 10;
        int ceiling = args.length >= 2 ? Integer.parseInt(args[1]) : 2 * n;
        int[] a = randArr(n,ceiling);
        //prnArr(a);
        QuickSort qs = new QuickSort();
        long start = System.currentTimeMillis();
        qs.quickSort(a);
        long end = System.currentTimeMillis();
        verifySorted(a);
        //prnArr(a);
        System.out.printf("quick sort n=%,d, ceiling=%,d, n*logn=%,d moves=%,d\n, took %,d ms\n", 
        n, ceiling, n * log2(n), qs.numSwaps, end - start);
    }
}
