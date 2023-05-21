public class HeapSort {
    public void sort(int arr[], boolean ascending) {
        int N = arr.length;

        // Build heap (rearrange array)
        for (int i = N / 2 - 1; i >= 0; i--)
            heapify(arr, N, i);

        // One by one extract an element from the heap
        for (int i = N - 1; i > 0; i--) {
            // Swap current root with the last element
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // Call heapify on the reduced heap
            heapify(arr, i, 0);
        }

        // Reverse the array if sorting in descending order
        if (!ascending) {
            reverseArray(arr);
        }
    }

    void heapify(int arr[], int N, int i) {
        int largest = i; // Initialize largest as root
        int l = 2 * i + 1; // left = 2*i + 1
        int r = 2 * i + 2; // right = 2*i + 2

        // If left child is larger than root
        if (l < N && arr[l] > arr[largest])
            largest = l;

        // If right child is larger than the largest so far
        if (r < N && arr[r] > arr[largest])
            largest = r;

        // If the largest is not the root
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // Recursively heapify the affected sub-tree
            heapify(arr, N, largest);
        }
    }

    static void printArray(int arr[]) {
        int N = arr.length;

        for (int i = 0; i < N; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    static void reverseArray(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String args[]) {
        int arr[] = { 12, 11, 13, 5, 6, 7 };
        int N = arr.length;

        HeapSort ob = new HeapSort();
        // Sort in ascending order
        ob.sort(arr, true);

        System.out.println("Sorted array in ascending order:");
        printArray(arr);

        // Sort in descending order
        ob.sort(arr, false);

        System.out.println("Sorted array in descending order:");
        printArray(arr);
    }
}

