/*
 * Kyle Krstulich
 * 2/1/24
 * CSCI232
 * MergeSort.java
 */


class MergeSort{

    public static void sort(Comparable[] a){
        Comparable[] aux = new Comparable[a.length];
        sort(a,aux,0, a.length-1);

    }

    private static void sort(Comparable[] a, Comparable[] aux, int low, int high){
        if(high <= low){return;}// basecase when down to singleton arrays.
        
        int mid = (low + (high - low))/2;
        sort(a,aux,low,mid);
        sort(a, aux, mid + 1, high);
        merge(a,aux,low,mid,high);
    }

    private static void merge(Comparable[] a, Comparable[] aux, int low, int mid, int high){}// TODO: implement this 
    public static void main(String[] args) {
        
    }
}