package DS_ALGO.Arrays;

public class ReverseString {


    public static void main(String[] args) {

        System.out.format("Reverse of %s is: %s", "Sarfraz", reverse("Sarfraz"));

    }

    public static String reverse(String str) {

        char[] strArray = str.toCharArray();
        StringBuffer reverseString = new StringBuffer();
        for(int i = strArray.length-1; i > -1; i--) {
            reverseString.append(strArray[i]);
        }

        return reverseString.toString();
    }
}