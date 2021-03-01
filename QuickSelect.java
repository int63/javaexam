//Select kth smallest from given list of numbers
import java.util.Random;

public class QuickSelect {

    public static int[] randArr(int sz, int ceiling) {
        assert sz > 0;
        Random rand = new Random();
        int[] a = new int[sz];
        for(int i=0;i<a.length;i++) a[i] = rand.nextInt(ceiling);
        return a;
    }

    public static void prnArr(int a[]) {
        System.out.printf("[");
        for(int i=0;i<a.length;i++) System.out.printf("%d,",a[i]);
        System.out.println("]");
    }
    
    public static void prnArr(int a[], int left, int right) {
        System.out.printf("[");
        for(int i=left;i<right;i++) System.out.printf("%d,",a[i]);
        System.out.println("]");
    }
    
    public static void swap(int a[], int i, int j) {
        if(i != j) {
            int tmp = a[i];
            a[i] = a[j];
            a[j] = tmp;
        }
    }
    
    private int pivotOf(int a[], int left, int right) {
        if(right > left + 1) {
            //System.out.printf("\t\t pivotOf %d,%d ",left, right); prnArr(a);
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
            //System.out.printf("\t\tp=%d\n",a[right]);
        }
        
        return a[right];
    }
    
    private int partition(int a[], int left, int right) {
        if(left<right) {
            int pivot = pivotOf(a,left,right);
            int i = left -1;
            for(int j=left;j<right;j++){
                if(a[j] < pivot) swap(a,++i,j);
            }
            swap(a,i+1,right);
            return i+1;
        } else 
            return left;
    }
    
    private int quickSelect(int a[], int k, int left,int right) {
        
        System.out.printf("\t[%d,%d]\t",left,right); prnArr(a);
        if(left < right) {
            int p = partition(a,left,right);
            System.out.printf("\t\ta[%d]=%d ",p,a[p]); prnArr(a,left,right);
            //System.out.printf("\t\tk=%d p=%d left=%d ",k,p,left); prnArr(a);
            
            if(p == k - 1) 
                return a[p];
            else 
                if (p > k - 1) 
                    return quickSelect(a,k,left,p-1);
                else
                    return quickSelect(a,k,p+1,right);
        } else 
            return a[left];
    }
    
    public int quickSelect(int a[], int k){
        assert(k <= a.length);
        return quickSelect(a,k,0,a.length-1);
    }
    
    
    public static void main(String[] args) {
        int[] a = randArr(15,100);
        int k = new Random().nextInt(a.length) + 1;
        
        //int[] a = new int[] {14,12,5,0,6, 6, 9, 15, 4, 10};
        //int k = 6;
        
        System.out.printf("No.%d smallest in len=%d array ",k, a.length); prnArr(a);
        
        int result = new QuickSelect().quickSelect(a,k);
        
        System.out.printf("answer: %d\n",result);
    }
}
