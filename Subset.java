
import java.util.Scanner;

public class Subset {

    public static void main(String[] args) {

        System.err.println("Enter Total Numbers");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int[] n = new int[a];
        for (int i = 0; i < n.length; i++) {
            System.out.print("Enter No:");
            n[i] = sc.nextInt();
            System.out.println(" ");
        }
                    int[] subset = new int[n.length];
        //remove duplicate variable
        remove(n);
    }

    //Recursive Method
    static void helper(int[] given_arr, int[] subset, int i) {
                   
        if (i == given_arr.length) {
            System.out.print("{");
            for (int j = 0; j < given_arr.length; j++) {
                if (subset[j] == 0) {
                    //printing null
                } else {
                    System.out.print(subset[j]);
                }
            }
            System.out.print("}\n");

        } else {
            subset[i] = 0;
            helper(given_arr, subset, i + 1);
            subset[i] = given_arr[i];
            helper(given_arr, subset, i + 1);

        }
    }

    //iterative method
    static void subSets(int[] given_array) {
        String bString;
        int length = given_array.length;
        String formater = "%" + String.valueOf(length) + "s";
        for (int i = 0; i < Math.pow(2, length); i++) {
            bString = String.format(formater, Integer.toBinaryString(i)).replace(" ", "0");
            System.out.print("{ ");
            for (int j = 0; j < length; j++) {
                if (bString.charAt(j) == '1') {
                    System.out.print(String.valueOf(given_array[j]) + " ");
                }
            }
            System.out.print("}\n");
        }

    }

   
static void remove(int[] arr) {
         int end = arr.length;

    for (int i = 0; i < end; i++) {
        for (int j = i + 1; j < end; j++) {
            if (arr[i] == arr[j]) {                  
                int shiftLeft = j;
                for (int k = j+1; k < end; k++, shiftLeft++) {
                    arr[shiftLeft] = arr[k];
                }
                end--;
                j--;
            }
        }
    }

    int[] whitelist = new int[end];
    for(int i = 0; i < end; i++){
        whitelist[i] = arr[i];
    }
            subSets(whitelist);
}
}