import java.util.*; 
class Main {
  public static void main(String[] args) {
    int k = 2; 
    int arr[] = { 1,4,5,2,3,7,8,6,10,9 }; 
    int n = arr.length; 
    sortK(arr, n, k); 
    System.out.println(Arrays.toString(arr));
  }
  public static void sortK(int[] arr, int size, int k) {
    PriorityQueue<Integer> pQueue = 
                          new PriorityQueue<Integer>();
    for(int i=0; i<k+1; i++) { // For {1,3,4,2,5} and k = 2, if we take i<k in this for loop, then only [1,3] will be in queue initially and polled out will be 1 then queue will be [3,4] and polled out will be 3, which is wrong as the resultant array becomes [1,3,...] when actually it should be [1,2,3,...] thus we need to check for i<k+1 i.e iterate till k as k is the max an element can be moved for sorting
      pQueue.add(arr[i]);
    }
    System.out.println(pQueue);
    for(int j=0; j<size; j++ ) {
      arr[j] = pQueue.poll();
      if(j+k+1<size) {
        pQueue.add(arr[j+k+1]);
      }
    }
  }
}