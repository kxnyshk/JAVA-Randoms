public class Sudoku {

    static{
    
        System.out.println("\nLets Sudoku!");
    }
    public static void main(String[] args){
    
        // Start Time
        long startTime = System.nanoTime();
        
        // Initializing Sudoko
        int n = 9;
        int[][] sudoku = {{0,0,0,5,6,3,0,1,0},
                          {6,0,3,1,4,9,8,7,0},
                          {0,1,0,0,8,7,9,0,3},
                          {0,3,0,4,9,0,6,0,0},
                          {0,0,6,3,7,1,4,0,0},
                          {1,4,0,0,0,0,0,9,0},
                          {0,0,9,0,1,2,0,3,0},
                          {2,7,0,0,3,0,0,4,0},
                          {3,0,0,9,5,0,0,2,8}};

        // Un-solved Sukoku
        System.out.println("\nUnsolved:");
        printSudoku(n, sudoku);

        // Solving Sudoku
        solveSudoku(sudoku, n);

        // Solved Sudoku
        System.out.println("Solved:");
        printSudoku(n, sudoku);

        // End Time
        long endTime = System.nanoTime();

        // Time elapsed
        Double conv = Math.pow(10, 6);
        // System.out.println("Start time : " + startTime);
        // System.out.println("End time   : " + endTime);
        long duration = (endTime - startTime);
        // System.out.println("Total time elapsed : " + duration + "nanoseconds");
        System.out.println("Total time elapsed : " + duration/conv + " milliseconds\n");
    }

    private static boolean solveSudoku(int[][] sudoku, int n){
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(sudoku[i][j] == 0){
                    for(int num = 1; num<=n; num++){
                        if(validMove(sudoku, n, i, j, num)){
                            sudoku[i][j] = num;
                            if(solveSudoku(sudoku, n)){
                                return true;
                            }
                            else{
                                sudoku[i][j] = 0;
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean validMove(int[][] sudoku, int n, int row, int col, int num){
        return !gridCheck(sudoku, n, row, col, num) &&
                     !rowCheck(sudoku, n, row, num) &&
                     !colCheck(sudoku, n, col, num);
    }

    private static boolean gridCheck(int[][] sudoku, int n, int row, int col, int num){
        int gridRow = row - row%3;
        int gridCol = col - col%3;
        for(int i=gridRow; i<gridRow+3; i++){
            for(int j=gridCol; j<gridCol+3; j++){
                if(sudoku[i][j] == num){
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean colCheck(int[][] sudoku, int n, int col, int num){
        for(int i=0; i<n; i++){
            if(sudoku[i][col] == num){
                return true;
            }
        }
        return false;
    }

    private static boolean rowCheck(int[][] sudoku, int n, int row, int num){
        for(int i=0; i<n; i++){
            if(sudoku[row][i] == num){
                return true;
            }
        }
        return false;
    }

    private static void printSudoku(int n, int[][] sudoku) {
        System.out.print("\n");
        for(int i=0; i<n; i++){
            if(i%3 == 0 && i>0){
                System.out.print("------------------------------------\n");
            }
            for(int j=0; j<n; j++){
                if(j%3 == 0 && j>0){
                    System.out.print(" | ");
                }
                System.out.print(" " + sudoku[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("\n");
    }    
}