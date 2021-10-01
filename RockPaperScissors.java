import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    static{
    
        System.out.println("\nLets Rock Paper Scissors!");
    }
    public static void main(String[] args){
    
        String[] game = {"r", "p", "s"};
        String AImove = game[new Random().nextInt(game.length)];

        Scanner scan = new Scanner(System.in);

        while(true){
            System.out.print("Enter input: ");
            String playerInput = scan.nextLine();
            if(playerInput.equals("r")){
                System.out.println("\nYou played: Rock");
                break;
            }
            else if(playerInput.equals("p")){
                System.out.println("\nYou played: Paper");
                break;
            }
            else if(playerInput.equals("s")){
                System.out.println("\nYou played: Scissors");
                break;
            }
            System.out.println("Enter valid input! [r/p/s].");
        }

        AImove(AImove);
    }

    private static void AImove(String AImove) {
        if(AImove.equals("r")){
            System.out.println("You played: Rock\n");
        }
        else if(AImove.equals("p")){
            System.out.println("You played: Paper\n");
        }
        else if(AImove.equals("s")){
            System.out.println("You played: Scissors\n");
        }
    }
}