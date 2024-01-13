public class StringOps {
    ////////////////////////////////////////////////////////////
    //////                                               ///////
    //////              Reminder:                        ///////
    //////        allowed methods                        ///////
    //////                                               ///////
    //////        1.charAt(int index)                    ///////
    //////        2.length()                             ///////
    //////        3.substring(int start)                 ///////
    //////        4.substring(int start,int ends)        ///////
    //////        5.indexOf(String str)                  ///////
    //////                                               ///////
    //////        The rest are not allowed !             ///////
    //////        if you want to use a different         ///////
    //////        method, and you can implement          ///////
    //////        it using material from the course      ///////
    //////        you need to implement a version of     ///////
    //////        the function by yourself.              ///////
    //////                                               ///////
    //////        see example for substring              ///////
    //////        in Recitation 3 question 5             ///////
    //////                                               ///////
    ////////////////////////////////////////////////////////////
    public static void main(String[] args) {
        // System.out.println(capVowelsLowRest(args[0]));
        // testAllIndexOf();
    }

    public static void testAllIndexOf(){
        System.out.println(java.util.Arrays.toString(allIndexOf("Hello world",'l')));
        System.out.println(java.util.Arrays.toString(allIndexOf("Hello worLd",'l')));
        System.out.println(java.util.Arrays.toString(allIndexOf("Hello world",'o')));
        System.out.println(java.util.Arrays.toString(allIndexOf("Hello world",' ')));
        System.out.println(java.util.Arrays.toString(allIndexOf("Hello world",'d')));
        System.out.println(java.util.Arrays.toString(allIndexOf("MMMM",'M')));
    }

    public static boolean isVowel(char test_char) {
        return "aeiou".indexOf(test_char) != -1;
    }

    public static char toUpperCase(char char_to_upper ){
        if (char_to_upper >= 97 && char_to_upper <= 122) {
            char_to_upper = (char) (char_to_upper - 32);
        }
        return char_to_upper;
    }

    public static char toLowerCase(char char_to_lower ){
        if (char_to_lower >= 65 && char_to_lower <= 90) {
            char_to_lower = (char) (char_to_lower + 32);
        }
        return char_to_lower;
    }

    public static String capVowelsLowRest (String string) {
        String result = "";
        for (int i = 0; i < string.length(); i++) {
            char char_at_i = string.charAt(i);
            if (isVowel(char_at_i)){
                result = result + toUpperCase(char_at_i);
            } else if ((char_at_i >= 67 && char_at_i <= 122) || (char_at_i >= 65 && char_at_i <= 90)) {
                result = result + toLowerCase(char_at_i);
            }
            else {
                result = result + char_at_i;
            }
        }
        return result;
    }

    public static String camelCase (String string) {
        String result = "";
        boolean is_first_word = true;
        boolean last_char_is_space = false;
        for (int i = 0; i < string.length(); i++) {
            char char_at_i = string.charAt(i);
            if (char_at_i == ' ') {
                last_char_is_space = true;
            } else if (is_first_word) {
                result = result + toLowerCase(char_at_i);
                is_first_word = false;
                last_char_is_space = false;
            } else if (last_char_is_space) {
                result = result + toUpperCase(char_at_i);
                last_char_is_space = false;
            } else {
                result = result + toLowerCase(char_at_i);
            }
        }
        return result;
    }

    public static int[] allIndexOf (String string, char chr) {
        int [] possible_char_locations = new int [string.length()]; // max location == length of string (string contains single char multiple times)
        int freq = 0;
        for (int i = 0; i < string.length(); i++) {
            if (chr == string.charAt(i)){
                possible_char_locations[i] = i;
                freq++;
            }
            else{
                possible_char_locations[i] = -1;
            }
        }
        int [] char_locations = new int [freq];
        for (int i = 0; i < freq; i++) {
            for (int j = 0; j < string.length(); j++) {
                if ( possible_char_locations[j] != -1){
                    char_locations[i] = possible_char_locations[j];
                    possible_char_locations[j] = -1;
                    break;
                }
            }
        }
        return char_locations;
    }
}
