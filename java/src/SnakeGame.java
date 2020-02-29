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
                game[i][j] = b[i][j];
            }
        }

        headPosition[0] = x;
        headPosition[1] = y;

    }

    public boolean neighbors (int r, int c){
       int count = 0;

       for(int i = r-1; i < r+2; ++i){
           for(int j = c-1; j < c +2; ++j){

               if(i < 0 || i > game.length || j < 0 || j> game.length){
                   continue;
               }

               if(i + j < (r + c) -1 || i + j == r + c || i + c > (r + c) + 1){
                   continue;
               }

               if(game[i][j]){
                   count++;
               }
           }
       }

       if(count == 1){
           return true;
       }
       return false;

    }

    public int[] findTailExhaustive(){

        //exhaustiveChecks = 0;

        resetCounters();

        int length= 0;
        int tailArray[] = {0,0,0};

        boolean tailFound = false;

        for(int i = 0; i < game.length; i++){
            for (int j = 0; j <game[0].length; j++){

                if(!tailFound){
                  exhaustiveChecks++;



                  if(game[i][j]){
                      length++;
                      if(i == headPosition[0] && j == headPosition[1]){

                          continue;
                      }
                      //length++;
                      if(neighbors(i,j)){
                          tailArray[0] = i;
                          tailArray[1] = j;
                          tailFound = true;
                      }

                  }

                }
                if(game[i][j]){
                    length++;

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
