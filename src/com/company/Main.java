package com.company;

import java.util.Arrays;
import java.util.Comparator;

public class Main {

    public static void main(String[] args) {
        Integer [] a = {3, 2, 34, 4, 34, 1, 54, 12, 51, 66};
        System.out.println(Arrays.toString(a));

        mergeSort(a);
        System.out.println(Arrays.toString(a));


        String [] s = {"1123", "%@32421", "Peter", "George", "Zealot"};
        System.out.println(Arrays.toString(s));

        mergeSort(s, String::compareTo);
        System.out.println(Arrays.toString(s));
    }

    public static <E> void mergeSort(E[] list, Comparator<? super E> comparator){
        if(list.length > 1){
            E[] first = Arrays.copyOf(list, list.length/2);
            mergeSort(first, comparator);

            E[] second = Arrays.copyOfRange(list, list.length/2, list.length);
            mergeSort(second, comparator);

            merge(first, second, list, comparator);
        }
    }

    public static <E> void merge(E[] first, E[] second, E[] list,
                                 Comparator<? super E> comparator) {
        int f = 0, s = 0,  n = 0;

        while (f < first.length && s < second.length) {
            if (comparator.compare(first[f], second[s]) < 0)
                list[n++] = first[f++];
            else
                list[n++] = second[s++];
        }

        while (f < first.length)
            list[n++] = first[f++];

        while (s < second.length)
            list[n++] = second[s++];
    }


    public static <E extends Comparable<E>> void mergeSort(E[] list) {
        if (list.length > 1) {
            E[] first = Arrays.copyOf(list, list.length/2);
            mergeSort(first);

            E[] second = Arrays.copyOfRange(list, list.length/2, list.length);
            mergeSort(second);

            merge(first, second, list);
        }
    }

    public static <E extends Comparable<E>> void merge(E[] first, E[] second, E[] list) {
        int f = 0, s = 0, n = 0;

        while (f < first.length && s < second.length) {
            if (first[f].compareTo(second[s]) < 0)
                list[n++] = first[f++];
            else
                list[n++] = second[s++];
        }

        while (f < first.length)
            list[n++] = first[f++];

        while (s < second.length)
            list[n++] = second[s++];
    }

}
