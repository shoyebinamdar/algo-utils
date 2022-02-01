package sorting;

public class MergeSort {

    public void sort(int[] arr, int left, int right) {
        if (left < right) {
            int middle = (left + right) / 2;

            sort(arr, left, middle);
            sort(arr, middle + 1, right);

            merge(arr, left, middle, right);
        }
    }

    private void merge(int[] arr, int left, int middle, int right) {
        int lSize = middle - left + 1;
        int rSize = right - middle;

        int[] lArray = new int[lSize];
        int[] rArray = new int[rSize];

        for (int i = 0; i < lSize; i++) {
            lArray[i] = arr[left + i];
        }

        for (int i = 0; i < rSize; i++) {
            rArray[i] = arr[middle + 1 + i];
        }

        int i = 0, j = 0, k = left;

        while (i < lSize && j < rSize) {
            if (lArray[i] <= rArray[j]) {
                arr[k++] = lArray[i++];
            } else {
                arr[k++] = rArray[j++];
            }
        }

        while (i < lSize) {
            arr[k++] = lArray[i++];
        }

        while (j < rSize) {
            arr[k++] = rArray[j++];
        }
    }

    static void printArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    public static void main(String args[]) {
        int arr[] = { 12, 11, 13, 5, 6, 7, 7, 6};

        System.out.println("Given Array");
        printArray(arr);

        MergeSort ob = new MergeSort();
        ob.sort(arr, 0, arr.length - 1);

        System.out.println("\nSorted array");
        printArray(arr);
    }

}
