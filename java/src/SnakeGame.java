public class SnakeGame {

    private boolean[][] game;
    private int[] headPosition;
    private static int exhaustiveChecks;
    private static int recursiveChecks;

    //default constructor:
    public SnakeGame(){
        game = new boolean[1][1];
    }

    public void SnakeHead(boolean[][] b, int x, int y){

        for(int i =0; i < b.length; i++){
            for(int j = 0; j < b[0].length; j++){
                game[i][i] = b[i][j];
            }
        }

        headPosition[0] = 

    }

    public boolean neighbors (int c, int r){
       int count = 0;


    }

    public int[] findTailExhaustive(){

        //exhaustiveChecks = 0;

        resetCounters();

        int length= 0;
        int tailArray[] = {0,0,0};

        for(int i = 0; i < game.length; i++){
            for (int j = 0; j <game[0].length; j++){
                exhaustiveChecks++;



                if(game[i][j]){
                    if(i == headPosition[0] && j == headPosition[1]){
                        length++;
                        continue;
                    }
                    length++;
                    //todo: check if i+/i-, j+/j- is off the board
                    //
                    //if
                    if(game[i+1][j] && !game[i-1][j] && !game[i][j+1] && !game[i][j-1] || game[i][j+1] == true && !game[i+1][j] && !game[i-1][j] && !game[i][j-1] || game[i][j-1] == true && !game[i][j+1] && !game[i+1][j] && !game[i-1][j] || game[i-1][j] == true && !game[i+1][j] && !game[i][j+1] && !game[i][j-1] ){
                        tailArray[0] = i;
                        tailArray[1] = j;
                    }
                  //if(i > 0 && i < game.length -1 && j > 0 && j < game[0].length){
                     // if(){}
                    //}
                }


            }
        }

        tailArray[2] = length;
        return tailArray;
    }

    public int[] findTailRecursive(){

        resetCounters();

        //int i = headPosition[0];
        //int j = headPosition[1];

        //Base case
        //if(game[i+1][j] == true && !game[i-1][j] && !game[i][j+1] && !game[i][j-1] && i != headPosition[0] && j != headPosition[1] || game[i][j+1] == true && !game[i+1][j] && !game[i-1][j] && !game[i][j-1] && i != headPosition[0] && j != headPosition[1] || game[i][j-1] == true && !game[i][j+1] && !game[i+1][j] && !game[i-1][j] && i != headPosition[0] && j != headPosition[1] || game[i-1][j] == true && !game[i+1][j] && !game[i][j+1] && !game[i][j-1] && i != headPosition[0] && j != headPosition[1]){

        return findTailRecursive();
            
        }

    }


    //@Override
    public int[][] findTailRecursive(int[] currentPosition, int[] previousPosition){

    }

    private void resetCounters()({
        exhaustiveChecks = 0;
        recursiveChecks = 0;
    }

    private static int getRecursiveChecks(){

        return recursiveChecks;
    }

    private static int getExhaustiveChecks(){

        return exhaustiveChecks;
    }


}
