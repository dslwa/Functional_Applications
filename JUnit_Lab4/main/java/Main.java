import Median.Median;
import ZigZagStr.ZigZag;
import ThreeSum.ThreeSum;
import Sortings.*;
import Spiral.Spiral;


public class Main {
    public static void main(String[] args) {

        int[] arrPesimistic = new int[1000];
        int[] arrOptimistic = new int[1000];
        int[] arrNormal = new int[1000];

        for (int i = 0; i < 1000; i++) {
            arrOptimistic[i] = i;
        }

        for (int i = 0; i < 1000; i++) {
            arrPesimistic[i] = -i;
        }

        for (int i = 0; i < 1000; i++) {
            arrNormal[i] = (int) (Math.random() * 10000) + 1;
        }

        SortingStrategy sortingStrategy = new InsertionSort();
        long startTime = System.nanoTime();
        sortingStrategy.sort(arrPesimistic.clone());
        long endTime = System.nanoTime();
        long insertionSortTimePesimistic = endTime - startTime;

        startTime = System.nanoTime();
        sortingStrategy.sort(arrOptimistic.clone());
        endTime = System.nanoTime();
        long insertionSortTimeOptimistic = endTime - startTime;

        startTime = System.nanoTime();
        sortingStrategy.sort(arrNormal.clone());
        endTime = System.nanoTime();
        long insertionSortTimeNormal = endTime - startTime;

        // Bubble Sort
        sortingStrategy = new BubbleSort();
        startTime = System.nanoTime();
        sortingStrategy.sort(arrPesimistic.clone());
        endTime = System.nanoTime();
        long bubbleSortTimePesimistic = endTime - startTime;

        startTime = System.nanoTime();
        sortingStrategy.sort(arrOptimistic.clone());
        endTime = System.nanoTime();
        long bubbleSortTimeOptimistic = endTime - startTime;

        startTime = System.nanoTime();
        sortingStrategy.sort(arrNormal.clone());
        endTime = System.nanoTime();
        long bubbleSortTimeNormal = endTime - startTime;

        // Selection Sort
        sortingStrategy = new SelectionSort();
        startTime = System.nanoTime();
        sortingStrategy.sort(arrPesimistic.clone());
        endTime = System.nanoTime();
        long selectionSortTimePesimistic = endTime - startTime;

        startTime = System.nanoTime();
        sortingStrategy.sort(arrOptimistic.clone());
        endTime = System.nanoTime();
        long selectionSortTimeOptimistic = endTime - startTime;

        startTime = System.nanoTime();
        sortingStrategy.sort(arrNormal.clone());
        endTime = System.nanoTime();
        long selectionSortTimeNormal = endTime - startTime;

        // Quick Sort
        sortingStrategy = new QuickSort();
        startTime = System.nanoTime();
        sortingStrategy.sort(arrPesimistic.clone());
        endTime = System.nanoTime();
        long quickSortTimePesimistic = endTime - startTime;

        startTime = System.nanoTime();
        sortingStrategy.sort(arrOptimistic.clone());
        endTime = System.nanoTime();
        long quickSortTimeOptimistic = endTime - startTime;

        startTime = System.nanoTime();
        sortingStrategy.sort(arrNormal.clone());
        endTime = System.nanoTime();
        long quickSortTimeNormal = endTime - startTime;

        // Merge Sort
        sortingStrategy = new MergeSort();
        startTime = System.nanoTime();
        sortingStrategy.sort(arrPesimistic.clone());
        endTime = System.nanoTime();
        long mergeSortTimePesimistic = endTime - startTime;

        startTime = System.nanoTime();
        sortingStrategy.sort(arrOptimistic.clone());
        endTime = System.nanoTime();
        long mergeSortTimeOptimistic = endTime - startTime;

        startTime = System.nanoTime();
        sortingStrategy.sort(arrNormal.clone());
        endTime = System.nanoTime();
        long mergeSortTimeNormal = endTime - startTime;

        System.out.println("Pesimistic:");
        System.out.println("Insertion Sort: " + insertionSortTimePesimistic + " nanoseconds");
        System.out.println("Bubble Sort: " + bubbleSortTimePesimistic + " nanoseconds");
        System.out.println("Selection Sort: " + selectionSortTimePesimistic + " nanoseconds");
        System.out.println("Quick Sort: " + quickSortTimePesimistic + " nanoseconds");
        System.out.println("Merge Sort: " + mergeSortTimePesimistic + " nanoseconds");

        System.out.println("\nOptimistic:");
        System.out.println("Insertion Sort: " + insertionSortTimeOptimistic + " nanoseconds");
        System.out.println("Bubble Sort: " + bubbleSortTimeOptimistic + " nanoseconds");
        System.out.println("Selection Sort: " + selectionSortTimeOptimistic + " nanoseconds");
        System.out.println("Quick Sort: " + quickSortTimeOptimistic + " nanoseconds");
        System.out.println("Merge Sort: " + mergeSortTimeOptimistic + " nanoseconds");

        System.out.println("\nNormal:");
        System.out.println("Insertion Sort: " + insertionSortTimeNormal + " nanoseconds");
        System.out.println("Bubble Sort: " + bubbleSortTimeNormal + " nanoseconds");
        System.out.println("Selection Sort: " + selectionSortTimeNormal + " nanoseconds");
        System.out.println("Quick Sort: " + quickSortTimeNormal + " nanoseconds");



        int m[][] = {
                {1,2,3},
                {4,5,6},
                {7,8,9}
        };
        Spiral s1 = new Spiral(3,3,m);
        s1.spiral();
        s1.print();

        int m1[][] = {
                {1,10,2,3},
                {4,5,6,12},
                {7,8,9,13}
        };

        Spiral s2 = new Spiral(4,3,m1);
        s2.spiral();
        s2.print();

        int a[] = {-8,-6,-1,0,1,2,3,4,5,7};
        ThreeSum t1 = new ThreeSum(a);
        t1.threeSum();
        t1.print();



        String p = "PAYPALISHIRING";
        ZigZag z1 = new ZigZag();
        System.out.println(z1.solution(p,4));

        int[] t11 = {1,2,3};
        int[] t2 = {5,6,7};

        Median me1 = new Median();
        System.out.println(me1.findMedian(t11,t2));
    }
}