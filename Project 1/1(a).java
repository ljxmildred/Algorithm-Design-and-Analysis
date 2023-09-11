public class Sorter {

    private static long keycomparison = 0;

    // PART A
    // HYBRID SORT ALGORITHM  //
    public static void hybridSort(int[] inputArray, int start, int end, int S) {

        int mid = (start + end) / 2;

        // Insertion Sort
        if (end - start <= 0) return;
        else if (end - start <= S)
            insertionSort(inputArray, start, end);
        else if (end - start > 1) {
            // Merge Sort
            if (end > start) {
                hybridSort(inputArray, start, mid, S);
                hybridSort(inputArray, mid + 1, end, S);
                merge(inputArray, start, end);
            }
        }
    }

     // INSERTION SORT ALGORITHM //
    public static void insertionSort(int[] inputArray, int start, int end) {

        for (int i = start + 1; i <= end; i++) {
            for (int j = i; j > start; j--) {

                // Count key comparisons
                keycomparison++;

                if (inputArray[j] < inputArray[j - 1])
                    swap(inputArray, j, j - 1);
                else 
                    break;
            }
        }
    }

    private static void merge(int[] inputArray, int start, int end) {

        int mid = (start + end) / 2;
        int a = start, b = mid + 1, temp;

        if (end > start) {
            while ((a <= mid) && (b <= end)) {
                keycomparison++;
                // Shifting
                if (inputArray[a] > inputArray[b]) {
                    temp = inputArray[b++];

                    for (int i = mid; i >= a; i--) {
                        inputArray[i + 1] = inputArray[i];
                    }
                    inputArray[a++] = temp;
                    mid++;
                }

                // Continue
                else if (inputArray[a] < inputArray[b])
                    a++;

                // Same items
                else {

                    // Base case (1 item each subarray)
                    if ((a == mid) && (b == end))
                        break;

                    tmp = inputArray[b++];
                    a++;
                    for (int i = mid; i >= a; i--) {
                        inputArray[i + 1] = inputArray[i];
                    }
                    inputArray[a++] = temp;
                    mid++;
                }
            }
        }
    }

    private static void swap(int[] inputArray, int i, int j) {
        int temp = inputArray[i];
        inputArray[i] = inputArray[j];
        inputArray[j] = temp;
    }
}
