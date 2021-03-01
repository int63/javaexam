//Minimal Changes with given amount and coins, https://youtu.be/jgiZlGzXMBw
package algo;

public class CoinChange1 {
  //DP solution
  public static int cc(int a, int[] c) {
     assert a > 0 && c.length > 0;
     for(int i=0; i< c.length;i++) assert c[i] > 0;
     
     int[] t = new int[a+1];
     t[0] = 0;
     for(int i=1;i<t.length;i++) t[i] = a + 1;
     
     for(int i=1;i<t.length;i++) {
        for(int j=0;j<c.length;j++){
            int r = i - c[j]; 
            if(r>=0 && 1+ t[r] < t[i]) {
                t[i] = 1 + t[r];
                System.out.printf("\ti=%d j=%d t[i] = %d\n",i,j,t[i]);
            }
        } 
     } 
     
     return t[a];
  }
  public static void main(String[] args){
    System.out.println( cc(
        11, new int[]{1,2,5}
        ));
  }
}

