import java.lang.reflect.Array;
import java.util.Arrays;

public class DefenceTest<T> {
    private final T[] array;

    @SuppressWarnings("unchecked")
    public DefenceTest(int capacity, T... dummy) {
        if (dummy.length > 0)
            throw new IllegalArgumentException("Do not provide values for dummy argument.");
        Class<?> c = dummy.getClass().getComponentType();
        array = (T[]) Array.newInstance(c, capacity);
    }

    @Override
    public String toString() {
        return "GenSet of " + array.getClass().getComponentType().getName() + "[" + array.length + "]";
    }

    public static void main(String[] args) {
        int size = Integer.parseInt(args[0]);
        DefenceTest<String> stringSet = new DefenceTest<>(size);
        String[] gen = {"a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z"};
        for(int i = 0; i < size; i++) {
            for(int j = 0; j < (int) (Math.random() * 10) + 1; j++) {
                if(j == 0) {
                    stringSet.array[i] = gen[(int) (Math.random() * 26)];
                } else {
                    stringSet.array[i] += gen[(int) (Math.random() * 26)];
                }
            }
        }
        System.out.println("Our string of random words: " + Arrays.toString(stringSet.array));

        Defence.quickSort(stringSet.array, 0, size - 1);//Here you can write any index you want

        System.out.println("Our string of random words: " + Arrays.toString(stringSet.array));
    }
}
