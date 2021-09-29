import java.util.Random;
import java.util.Scanner;

public class Dice {

    static{
    
        System.out.println("\nLet's roll the DICE... ");
    }
    public static void main(String[] args){
    
        Random dice = new Random();
        int roll = 1+dice.nextInt(6);

        System.out.print(roll); // ROLL
        key();
    }

    public static void key() {
        
        System.out.print("\nPress 1 to roll again. 0 to exit. ");
        Scanner scan = new Scanner(System.in);
        int key = scan.nextInt();
        
        if(key==1){
            main(null);
        }
        else if(key==0){
            System.out.println("DICE exiting...");
            return;
        }
        else{
            System.out.println("Enter only 0[EXIT] or 1[DICE ROLL].");
            key();
        }
    }
}