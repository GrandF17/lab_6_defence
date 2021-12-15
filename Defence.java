public class Defence {
    public Defence() { }

    public static <T extends Comparable<T>> void quickSort(T[] arr, int beginIndex, int endIndex) {
        if (arr.length == 0)
            return;
        if (beginIndex >= endIndex)
            return;

        int middle = beginIndex + (endIndex - beginIndex) / 2;
        T basis = arr[middle];
        int basisLength = arr[middle].toString().length();
        int i = beginIndex, j = endIndex;

        while (i <= j) {
            while (arr[i].toString().length() < basisLength || (arr[i].compareTo(basis) < 0 && arr[i].toString().length() == basisLength)) i++;//arr[i] < basis
            while (arr[j].toString().length() > basisLength || (arr[j].compareTo(basis) > 0 && arr[j].toString().length() == basisLength))  j--;//arr[j] > basis
            //sort by alphabet from low to high, if lengths are equal
            if (i <= j) {
                T temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
            }
        }
        if (beginIndex < j)
            quickSort(arr, beginIndex, j);
        if (endIndex > i)
            quickSort(arr, i, endIndex);
    }
}
