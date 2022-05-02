package CoreJava;

public class CoreJavaBrushUp1 {
    public static void main(String[] args) {

        int myNum = 5;
        String website = "Rahul Shettu Academy";
        char letter = 'r';
        double dec = 5.99;
        boolean myCard = true;

        System.out.println(myNum + " this is the value stored in the myNum variable");
        System.out.println(website);

        //Arrays
        //when we dont know the values

        int[] arr = new int[5];
        arr[0] = 1;
        arr[1] = 2;
        arr[2] = 3;
        arr[3] = 4;
        arr[4] = 5;

        //when we known the values

        int[] array2 = {1,2,3,4,5,6,7,8, 9,99};
        System.out.println(array2[0]);

        //for loop
        for (int i = 0; i < arr.length;i++) {
            System.out.println(arr[i]);
        }

        for (int i = 0; i < array2.length; i++ ) {
            System.out.println(array2[i]);
        }

        String[] names = {"rahul", "shetty","selenium"};
        for (int i = 0; i < names.length; i++) {
            System.out.println(names[i]);
        }

        for(String name : names) {
            System.out.println("for " + name);
        }
    }
}
