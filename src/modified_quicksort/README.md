

##  Solution  Java Program: Modified Quicksort Algorithm

This Java program implements the **modified Quicksort algorithm** as described in the assignment.

### Functions

- The `findMedian()` function finds the median of the first, middle, and last element of the array (or sub-array).
- The `partition()` function uses this *median* as the pivot.
- The `quicksort()` function sorts the array using the modified `partition()` function.

### Main Function

The `main()` function takes an array of integers as input, calls the `quicksort()` function to sort the array, and then prints the sorted array as output.

```java
public class QuickSort {
    // Swap function to swap two elements in an array
    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i]; // Temporary variable to hold the value of arr[i]
        arr[i] = arr[j]; // Swap the value of arr[j] into arr[i]
        arr[j] = temp; // Swap the value of temp (originally arr[i]) into arr[j]
    }

    // Function to find the median among three numbers
    private static int findMedian(int[] arr, int low, int high) {
        int mid = low + (high - low) / 2; // Calculate the index of the middle element
        // Determine the median of arr[low], arr[mid], and arr[high]
        if (arr[low] < arr[mid]) {
            if (arr[mid] < arr[high]) {
                return mid;
            } else if (arr[low] < arr[high]) {
                return high;
            } else {
                return low;
            }
        } else if (arr[low] < arr[high]) {
            return low;
        } else if (arr[mid] < arr[high]) {
            return high;
        } else {
            return mid;
        }
    }

    // Partition function to partition the array around the pivot
    private static int partition(int[] arr, int low, int high) {
        // Find the median and use it as pivot
        int medianIndex = findMedian(arr, low, high);
        // Swap the median with the first element
        swap(arr, low, medianIndex);
        int pivot = arr[low]; // The pivot element
        int i = low + 1; // Index for the next smaller element
        // Partition the array around the pivot
        for (int j = low + 1; j <= high; j++) {
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
        }
        // Swap the pivot into its correct position
        swap(arr, low, i - 1);
        // Return the index of the pivot
        return i - 1;
    }

    // Quicksort function to sort the array
    private static void quicksort(int[] arr, int low, int high) {
        if (low < high) {
            // Partition the array and get the index of the pivot
            int pi = partition(arr, low, high);
            // Recursively sort the two partitions
            quicksort(arr, low, pi - 1);
            quicksort(arr, pi + 1, high);
        }
    }

    // Main function
    public static void main(String[] args) {
        int[] arr = {10, 7, 8, 9, 1, 5}; // The array to be sorted
        int n = arr.length; // The number of elements in the array
        // Sort the array
        quicksort(arr, 0, n - 1);
        // Print the sorted array
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
```