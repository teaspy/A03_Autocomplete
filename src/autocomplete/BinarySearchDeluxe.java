package autocomplete;



import java.util.Arrays;
import java.util.Comparator;

public class BinarySearchDeluxe {
    public static void main(String[] args){
        Integer[] ints = {5, 3, 6, 4, 6, 6, 4, 3, 5, 6, 7, 3};
        Arrays.sort(ints);
        for(Integer i : ints) System.out.println(i);
        System.out.println("answer below");
        System.out.println(BinarySearchDeluxe.firstIndexOf(ints, -1, Comparator.naturalOrder()));
        System.out.println("last index below");
        System.out.println(BinarySearchDeluxe.lastIndexOf(ints, -1, Comparator.naturalOrder()));
    }
    public static <Key> int firstIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        int low = 0, high = a.length - 1;
        while (high - low > 1) {
            int mid = (low + high) / 2;
            int result = comparator.compare(a[mid], key);
            if (result > 0) {
                high = mid - 1;
            } else if (result < 0) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        if (comparator.compare(a[low], key) == 0) {
            return low;
        } else if (comparator.compare(a[high], key) == 0) {
            return high;
        } else {
            return -1;// not found
        }
    }

    public static <Key> int lastIndexOf(Key[] a, Key key, Comparator<Key> comparator) {
        int low = 0, high = a.length - 1;
        while ((high - low) > 1) {
            int mid = (low + high) / 2;
            int result = comparator.compare(a[mid], key);
            if (result > 0) {
                high = mid - 1;
            } else if (result < 0) {
                low = mid + 1;
            } else {
                low = mid;
            }
        }
        if (comparator.compare(a[high], key) == 0) {
            return high;
        } else if (comparator.compare(a[low], key) == 0) {
            return low;
        } else {
            return -1;
        }
    }
}

