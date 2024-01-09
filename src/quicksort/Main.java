package quicksort;

public class Main {

  public static void main(String[] args) {

  }

  public static void quickSort(int[] arr, int begin, int end) {
        if(begin < end){
          // partitioning : around the pivot
          // we keep all elements less than pivot to the left of arr
          // we keep all the elements greater than pivot to the right of arr
         int partitionIndex = partition(arr, begin, end);
          quickSort(arr,begin, partitionIndex-1 );
          quickSort(arr,partitionIndex + 1,  end);

        }
  }

  private static int partition(int[] arr, int begin, int end) {
    int pivot = arr[end];
    int i = (begin -1);
    for(int j = begin; j < end; j++){
      if(arr[j] <= pivot){
        i++;
        int swapTemp = arr[i];
        arr[i] = arr[j];
        arr[j] = swapTemp;
      }
    }

    // i = 2+1 = 3
    // swap pivot with last change
    int swapTemp = arr[i+1];
    arr[i+1] = arr[end];
    arr[end] = swapTemp;

    return i+1;
  }

}
