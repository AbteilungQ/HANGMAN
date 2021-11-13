//Programmed by XToodyX and AbteilungQ
import java.util.Scanner;

public class main {

    private static Scanner scanner = new Scanner(System.in);
    private static String rWord;
    private static String[] aWord, rAWord, ausgabe;
    private static int f,r;
    private static String tipp;
    private static boolean b=false;
    private static String[] storage = {"/","\\","|","\\","/","O","|" };


    public static void main(String[] args) {
        System.out.println("Welcome to HANGMAN: \nPlease enter Word: >");
        rWord = scanner.nextLine().toUpperCase();
        rAWord = rWord.split("");
        ausgabe = new String[7];

        aWord = new String[rWord.length()];
        for (int i = 0; i < aWord.length; i++) {
            aWord[i] = "_";
        }

        for (int i = 0; i < 7; i++) {
            ausgabe[i] = " ";
        }

        while (f < 7 && r != aWord.length){
            System.out.print("Lösungswort: ");
            for (String s: aWord) {
                System.out.print(s);
            }
            System.out.println("\nTipp: ");
            b = false;
            tipp = scanner.nextLine().toUpperCase();
            for(int i = 0;i < aWord.length; i++){
                if(rAWord[i].equals(tipp)){
                    aWord[i] = tipp;
                    r++;
                    b = true;
                }
            }

            if (!b){
                f++;
                System.out.println("Du hast noch "+(7-f)+" Fehlversuche übrig");
                ausgabe[f-1] = storage[f-1];
                System.out.println("_____");
                System.out.println("|   " + ausgabe[6]); // Seil oben
                System.out.println("|  "  + ausgabe[3] + ausgabe[5] + ausgabe[4]); // linke Hand, Kopf, rechte Hand
                System.out.println("|   " + ausgabe[2] ); // Körper
                System.out.println("|  "  + ausgabe[0] + " " + ausgabe[1] ); // linker Fuß, rechter Fuß
                }
            }

            if (r == rWord.length()){
                System.out.println("Du hast gewonnen, Glückwunsch ;-)");
            }else if(f == 10){
                System.out.println("Du hast verloren, probiere es noch einmal");
            }
        }


    }

