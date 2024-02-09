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

    @SuppressWarnings("unchecked")
    private static void merge(Comparable[] a, Comparable[] aux, int low, int mid, int high){
        assert isSorted(a, low, mid);
        assert isSorted(a, mid+1, high);
        int i = low;
        int j = mid + 1;

        for(int k = low; k <= high; k++){
            aux[k] = a[k];
        }
        for(int k = low; k <= high; k++){
            if(i > mid) {a[k] = aux[j++];}
            else if(j > high){a[k] = aux[i++];}
            else if(less(aux[j], aux[i])) {a[k] = aux[j++];}
            else{a[k] = aux[i++];}
        }
        assert isSorted(a, low, high);
    }// TODO: implement this 

    @SuppressWarnings("unchecked")
    private static boolean less(Comparable comparable, Comparable comparable2) {
        // TODO Auto-generated method stub
        return comparable.compareTo(comparable2) == 1;
    }

    private static boolean isSorted(Comparable[] a) {
        return isSorted(a, 0, a.length - 1);
    }

    private static boolean isSorted(Comparable[] a, int lo, int hi) {
        for (int i = lo + 1; i <= hi; i++)
            if (less(a[i], a[i-1])) return false;
        return true;
    }

    public static void main(String[] args) {
        Comparable[] testing = {3,2,6,1,5};
        sort(testing);
        
    }
}