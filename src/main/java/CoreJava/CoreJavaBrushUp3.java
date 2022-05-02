package CoreJava;

public class CoreJavaBrushUp3 {
    public static void main(String[] args) {

        //String is an object
        /**
         * aqui declarando uma string literal, se tivermos os mesmos
         * valores multiplos, não será criado um novo objeto pois vai se
         * referir ao existente
         *
         * */
        String s = "Rahul Shetty Academy";
        String s1 = "Rahul Shetty Academy";

        /**
         * Aqui ele cria objeto diferente, mesmo com o mesmo conteudo
         * */

        String s3 = new String("Welcome");
        String s4 = new String("Welcome");

        //Split
        String phrase = "The  book is on the table.";
        String[] splittedPhrase = phrase.split(" ");

        System.out.println(splittedPhrase[0]);
        //System.out.println(splittedPhrase[1]);
        System.out.println(splittedPhrase[1].trim());
        System.out.println(splittedPhrase[2]);

        System.out.println("-----------------------------------");
        for(String split : splittedPhrase) {
            System.out.println(split);
        }

        //imprimindo cada caracter da frase

        for(int i = 0; i < phrase.length(); i++) {
            System.out.println(phrase.charAt(i));
        }

        for(int i = phrase.length()-1; i >= 0; i--) {
            System.out.println(phrase.charAt(i));
        }
    }
}
