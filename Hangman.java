import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    
    // static{
    
    //     System.out.println("");
    // }
    public static void main(String[] args) throws FileNotFoundException{
    
        Scanner file = new Scanner(new File("./static/dictionary.txt"));
        Scanner scan = new Scanner(System.in);

        List <String> dictionary = new ArrayList<String>();
        while(file.hasNext()){
            dictionary.add(file.nextLine());
        }

        Random num = new Random();
        String word = dictionary.get(num.nextInt(dictionary.size()));
        // System.out.println("\n" + word);
        System.out.println("\nLets Hangman! [HINT: " + word.length() + " letter word.]");

        List <Character> guess = new ArrayList<Character>();

        int hangmanCount = 0;
        int hangmanLimit = 6;
        printWord(word, guess);
        while(true){
            printHangman(hangmanCount);
            if(hangmanCount>=hangmanLimit){
                System.out.println("\nFUCKIN DIED! YOU LOSE!");
                System.out.println("Correct word: " + word);
                break;
            }
            if(!playerGuess(scan, word, guess)){
                hangmanCount++;
            }
            if(printWord(word, guess)){
                System.out.println("\nDAMN! YOU WIN!");
                break;
            }
        }

        scan.close();
    }

    private static void printHangman(int hangmanCount) {
        System.out.println(" _________ ");
        System.out.println(" |       | ");
        if(hangmanCount>=1){
            System.out.println(" O");
        }
        if(hangmanCount>=2){
            System.out.print("\\");
            if(hangmanCount>=3){
                System.out.println(" /");
            }
            else{
                System.out.println();
            }
        }
        if(hangmanCount>=4){
            System.out.println(" |");
        }
        if(hangmanCount>=5){
            System.out.print("/");
            if(hangmanCount>=6){
                System.out.println(" \\");
            }
            else{
                System.out.println();
            }
        }
    }

    private static boolean playerGuess(Scanner scan, String word, List<Character> guess) {
        System.out.print("\nEnter your guess! ");
        String letter = scan.nextLine();
        guess.add(letter.charAt(0));
        return word.contains(letter);
    }

    private static boolean printWord(String word, List<Character> guess) {
        int count = 0;
        System.out.print("\n");
        for(int i=0; i<word.length(); i++){
            if(guess.contains(word.charAt(i))){
                System.out.print(word.charAt(i) + " ");
                count++;
            }
            else{
                System.out.print("- ");
            }
        }
        System.out.println();
        return (count == word.length());
    }
}
