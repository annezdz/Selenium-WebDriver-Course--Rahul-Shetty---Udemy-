package CoreJava;

public class CoreJavarushUp2 {
    public static void main(String[] args) {

        int[] array2 = {1,2,3,4,5,6,7,8,9,99,22,89};

        //2,4,6,8
        //check if array has multple of 2

        System.out.println("----------  ---------------");
        /**
         * Quando queremos achar apenas 1 valor par, por exemplo,
         * incluir o break deixa o script de automação mais rápido.
         * **/
        for(int i = 0; i < array2.length; i++) {
            if(array2[i] % 2 == 0) {
                System.out.println(array2[i]);
            } else {
                System.out.println(array2[i] + " isn't multyple of 2.");
            }
        }
    }
}
