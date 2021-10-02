import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {

    static{
    
        System.out.println("\nLets Rock Paper Scissors!");
    }
    public static void main(String[] args){
    
        // Game & AI input
        String[] game = {"r", "p", "s"};
        String AIinput = game[new Random().nextInt(game.length)];
        
        // Player input
        Scanner scan = new Scanner(System.in);
        String playerInput;

        // Player move
        while(true){
            System.out.print("Enter input [r/p/s]: ");
            playerInput = scan.nextLine();
            
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
            System.out.println("Enter valid input [r/p/s].\n");
        }
        
        // AI move
        AImove(AIinput);

        // Check Player/AI moves
        checkGame(AIinput, playerInput);

        // Re-play/exit
        reRunExit(scan);
        
        // Close scanning
        scan.close();
    }

    private static void reRunExit(Scanner scan){
        System.out.print("Press 1 to Re-play. 0 to Exit. ");
        int key = scan.nextInt();
        if(key==1){
            main(null);
        }
        else if(key==0){
            return;
        }
        else{
            System.out.println("Enter valid input [0/1].");
            reRunExit(scan);
        }
    }
    
    private static void AImove(String AIinput) {
        if(AIinput.equals("r")){
            System.out.println("Computer played: Rock\n");
        }
        else if(AIinput.equals("p")){
            System.out.println("Computer played: Paper\n");
        }
        else if(AIinput.equals("s")){
            System.out.println("Computer played: Scissors\n");
        }
    }

    private static void checkGame(String AIinput, String playerInput) {
        if(playerInput.equals(AIinput)){
            System.out.println("Ooff! Game tied.\n");
        }
        else if(playerInput.equals("r")){
            if(AIinput.equals("p")){
                System.out.println("Computer wins!\n");
            }
            else if(AIinput.equals("s")){
                System.out.println("Damn! YOU WIN!\n");
            }
        }
        else if(playerInput.equals("p")){
            if(AIinput.equals("r")){
                System.out.println("Damn! YOU WIN!\n");
            }
            else if(AIinput.equals("s")){
                System.out.println("Computer wins!\n");
            }
        }
        else if(playerInput.equals("s")){
            if(AIinput.equals("p")){
                System.out.println("Damn! YOU WIN!\n");
            }
            else if(AIinput.equals("r")){
                System.out.println("Computer wins!\n");
            }
        }
    }
}