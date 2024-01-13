public class ArrayOps {
    public static void main(String[] args) {
        int size = args.length;
        int [] int_arr = new int [size];
        for(int i=0; i<size; i++) {
            int_arr[i] = Integer.parseInt(args[i]);
        }
        // testFindMissingInt(int_arr);
        // testSecondMaxValue(int_arr);
        // testContainsTheSameElements();
        // testIsSorted(int_arr);
    }

    public static void testFindMissingInt (int [] test_array){
        System.out.println(findMissingInt(test_array));
    }

    public static void testSecondMaxValue (int [] test_array){
        System.out.println(secondMaxValue(test_array));
    }

    public static void testContainsTheSameElements (){
        int [] r1 = {2, 1, 1, 2, 1};
        int [] r2 = {2, 1};
        int [] r3 = {5, 2, 1, -4, 3};
        int [] r4 = {5, 1, -4, 3};
        System.out.println(containsTheSameElements(r1, r2));
        System.out.println(containsTheSameElements(r2, r1));
        System.out.println(containsTheSameElements(r3, r4));
        System.out.println(containsTheSameElements(r4, r3));
    }

    public static void testIsSorted (int [] test_array){
        System.out.println(isSorted(test_array));
    }

    public static void sortArray (int [] array){
        for (int i = 0; i < array.length; i++)
        {
            for (int j = 0; j < i; j++)
            {
                if (array[i] <= array[j])
                {
                    // swap array[i] and array[j]
                    int temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
        }
    }

    public static int findMissingInt (int [] array) {
        sortArray(array);
        int missing_int = 0;
        for (int i = 0; i < array.length; i++) {
            if ((array[i] + 1) != array[i + 1]){ // This function assumes that each number aapears once in the given array
                missing_int = array[i] + 1;
                break;
            }
        }
        return missing_int;
    }

    public static int secondMaxValue(int [] array) {
        sortArray(array);
        int array_second_last_location = array.length - 2;
        return array[array_second_last_location];
    }

    public static boolean containsTheSameElements(int [] array1,int [] array2) {
        int array1_length = array1.length;
        int array2_length = array2.length;
        int [] max_array = array1_length < array2_length ? array2 : array1;
        int [] min_array = array1_length < array2_length ? array1 : array2;
        int max_length = max_array.length;

        for (int i = 0; i < max_array.length; i++) {
            boolean found = false;
            for (int j = 0; j < min_array.length; j++) {
                if (max_array[i] == min_array[j]) {
                    max_length--;
                    found = true;
                    break;
                }
            }
            if (!found) {
                return false;
            }
        }
        return max_length == 0;
    }


    public static boolean isSorted(int [] array) {
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] > array[i + 1])
                return false;
        }
        return true;
    }

}
