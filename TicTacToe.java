import java.util.Scanner;
import java.util.Random;

public class TicTacToe {
    static{
    
        System.out.println("Lets Tic Tac Toe!");
    }
    public static void main(String[] args){
    
        // Initialize board
        char[][] board = {{' ', ' ', ' '},
                          {' ', ' ', ' '},
                          {' ', ' ', ' '}};
        
        // Print empty board
        printBoard(board);

        // Scanning user input
        Scanner scan = new Scanner(System.in);

        while(true){
            // Player move
            playerMove(board, scan);
            // Checks game
            if(checkGame(board)){
                break;
            }
            // AI move
            AImove(board);
            // Checks game
            if(checkGame(board)){
                break;
            }
            // Print board
            printBoard(board);
        }

    }

    private static boolean checkGame(char[][] board) {
        if(winGame(board, 'X')){
            printBoard(board);
            System.out.println("Well played. YOU WIN!\n");
            return true;    
        }

        if(winGame(board, 'O')){
            printBoard(board);
            System.out.println("Computer wins!\n");
            return true;
        }
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] == ' '){
                    return false;
                }
            }
        }
        printBoard(board);
        System.out.println("Game tied!\n");
        return true;
    }

    private static boolean winGame(char[][] board, char symbol) {
        if(board[0][0] == symbol && board[0][1] == symbol && board[0][2] == symbol ||
           board[1][0] == symbol && board[1][1] == symbol && board[1][2] == symbol ||
           board[2][0] == symbol && board[2][1] == symbol && board[2][2] == symbol ||

           board[0][0] == symbol && board[1][0] == symbol && board[2][0] == symbol ||
           board[0][1] == symbol && board[1][1] == symbol && board[2][1] == symbol ||
           board[0][2] == symbol && board[1][2] == symbol && board[2][2] == symbol ||

           board[0][0] == symbol && board[1][1] == symbol && board[2][2] == symbol ||
           board[0][2] == symbol && board[1][1] == symbol && board[2][0] == symbol){
                return true;
        }
        return false;
    }

    private static void AImove(char[][] board) {
        Random randNum = new Random();
        int AIinput;
        while(true){
            AIinput = (randNum.nextInt(9)+1);
            if(moveValid(board, AIinput)){
                break;
            }
        }
        placeMove(board, Integer.toString(AIinput), 'O');
        System.out.println("Computer move: " + AIinput);
    }

    private static boolean moveValid(char[][] board, int move){
        switch(move){
            case 1:
                return (board[0][0] == ' ');
            case 2:
                return (board[0][1] == ' ');
            case 3:
                return (board[0][2] == ' ');
            case 4:
                return (board[1][0] == ' ');
            case 5:
                return (board[1][1] == ' ');
            case 6:
                return (board[1][2] == ' ');
            case 7:
                return (board[2][0] == ' ');
            case 8:
                return (board[2][1] == ' ');
            case 9:
                return (board[2][2] == ' ');
            default:
                return false;
        }
    }

    private static void playerMove(char[][] board, Scanner scan) {
        String userInput;
        while(true){
            System.out.print("Your move? (1-9) ");
            userInput = scan.nextLine();
            if(moveValid(board, Integer.parseInt(userInput))){
                break;
            }
            else{
                System.out.println("Invalid move!\n");
            }
        }
        placeMove(board, userInput, 'X');
    }

    private static void placeMove(char[][] board, String position, char symbol) {
        switch(position){
            case "1":
                board[0][0] = symbol;
                break;
            case "2":
                board[0][1] = symbol;
                break;
            case "3":
                board[0][2] = symbol;
                break;
            case "4":
                board[1][0] = symbol;
                break;
            case "5":
                board[1][1] = symbol;
                break;
            case "6":
                board[1][2] = symbol;
                break;
            case "7":
                board[2][0] = symbol;
                break;
            case "8":
                board[2][1] = symbol;
                break;
            case "9":
                board[2][2] = symbol;
                break;
            default:
                System.out.println("Invalid move!\n");
        }
    }
    private static void printBoard(char[][] board) {
        System.out.print("\n");
        System.out.println(board[0][0] + " | " + board[0][1] + " | " + board[0][2]);
        System.out.println("--+---+--");
        System.out.println(board[1][0] + " | " + board[1][1] + " | " + board[1][2]);
        System.out.println("--+---+--");
        System.out.println(board[2][0] + " | " + board[2][1] + " | " + board[2][2]);
        System.out.print("\n");
    }
}
