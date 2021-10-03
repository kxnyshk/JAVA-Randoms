import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Encryption {

    static{
    
        System.out.println("\nLets start Encrypting!");
    }
    private static Scanner scan;
    private static char character = ' ';
    private static List <Character> charList = new ArrayList<Character>();
    private static List <Character> shuffledCharList = new ArrayList<Character>();
    private static final int charMIN_LIMIT = 32;
    private static final int charMAX_LIMIT = 127;
    private static char[] textLetters;
    public static void main(String[] args){
    
        scan = new Scanner(System.in);
        getInput(scan);

    }

    private static void getInput(Scanner scan) {
        while(true){
        System.out.println("\nWhat would you like to do?");
        System.out.print("(N)ew key, (G)et key, (E)ncrypt, (D)ecrypt e(X)it: ");
        char input = Character.toUpperCase(scan.nextLine().charAt(0));
            switch (input) {
                case 'N':
                    newKey();
                    break;
                case 'G':
                    getKey();
                    break;
                case 'E':
                    encrypt();
                    break;
                case 'D':
                    decrypt();
                    break;
                case 'X':
                    exit();
                    break;
            
                default:
                    System.out.println("\nEnter valid key!");
            }
        }
    }

    private static void exit() {
        System.out.println("\nApplication exited successfully...");
        System.exit(0);
    }

    private static void decrypt() {
        if(charList.isEmpty() && shuffledCharList.isEmpty()){
            System.out.println("\nGenerate (N)ew key first.");
        }
        else{
            System.out.print("\nEnter text to be decrypted: ");
            String text = scan.nextLine();

            textLetters = text.toCharArray();
            for(int i=0; i<textLetters.length; i++){
                for(int j=0; j<shuffledCharList.size(); j++){
                    if(textLetters[i] == shuffledCharList.get(j)){
                        textLetters[i] = charList.get(j);
                        break;
                    }
                }
            }

            System.out.print("Text decrypted as: ");
            for(Character c: textLetters){
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static void encrypt() {
        if(charList.isEmpty() && shuffledCharList.isEmpty()){
            System.out.println("\nGenerate (N)ew key first.");
        }
        else{
            System.out.print("\nEnter text to be encrypted: ");
            String text = scan.nextLine();

            textLetters = text.toCharArray();
            for(int i=0; i<textLetters.length; i++){
                for(int j=0; j<charList.size(); j++){
                    if(textLetters[i] == charList.get(j)){
                        textLetters[i] = shuffledCharList.get(j);
                        break;
                    }
                }
            }

            System.out.print("Text encrypted as: ");
            for(Character c: textLetters){
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static void getKey() {
        if(charList.isEmpty() && shuffledCharList.isEmpty()){
            System.out.println("\nGenerate (N)ew key first.");
        }
        else{
            System.out.println("\nKey: ");
            for(Character c: charList){
                System.out.print(c);
            }
            System.out.println();
            for(Character c: shuffledCharList){
                System.out.print(c);
            }
            System.out.println();
        }
    }

    private static void newKey() {
        character = ' ';
        charList.clear();
        shuffledCharList.clear();

        for(int i=charMIN_LIMIT; i<charMAX_LIMIT; i++){
            charList.add(Character.valueOf(character++));
        }

        shuffledCharList = new ArrayList<Character>(charList);
        Collections.shuffle(shuffledCharList);
        System.out.println("\nNew key has been generated successfully..");
    }
}