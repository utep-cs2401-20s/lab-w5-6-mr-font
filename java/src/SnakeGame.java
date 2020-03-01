public class SnakeGame {

    private boolean[][] game;
    private int[] headPosition = new int [2];
    private static int exhaustiveChecks;
    private static int recursiveChecks;
    private static int exhaustiveLength;
    private static int  recursiveLength;
    private int[] exhaustiveTailArray = new int[3];
    private int[] recursiveTailArray = new int[3];

    //default constructor:
    public SnakeGame(){
        this.game = new boolean[1][1];
    }



    public void SnakeHead(boolean[][] b, int x, int y){

        this.game = new boolean[b[0].length][b.length];

        for(int i = 0; i < b.length; ++i){
            for(int j = 0; j < b[0].length; ++j){
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

               if(i < 0 || i > game[0].length -1 || j < 0 || j > game.length-1){
                   continue;
               }

               if(i + j < (r + c) -1 || i + j == r + c || i + j > (r + c) + 1){
                   continue;
               }

               if(game[i][j]){
                   ++count;
               }
           }
       }

       if(count == 1){
           return true;
       }
       return false;

    }

    public int[] findTailExhaustive() {

        boolean tailFound = false;

        for (int i = 0; i < game[0].length; ++i) {
            for (int j = 0; j < game.length; ++j) {

                if (!tailFound) {
                    ++exhaustiveChecks;

                    if (game[i][j]) {
                        ++exhaustiveLength;
                        if (i == headPosition[0] && j == headPosition[1]) {

                            continue;
                        }

                        if (neighbors(i, j)) {
                            exhaustiveTailArray[0] = i;
                            exhaustiveTailArray[1] = j;
                            tailFound = true;
                        }

                    }

                }

                //this is needed to continue counting the length of the snake after the tail is found.
                if (game[i][j] && tailFound){
                    ++exhaustiveLength;
                }

            }


        }
        exhaustiveTailArray[2] = exhaustiveLength;
        return exhaustiveTailArray;
    }

    public int[] findTailRecursive(){

        resetCounters();

        //int i = headPosition[0];
        //int j = headPosition[1];

        //Base case
        //if(game[i+1][j] == true && !game[i-1][j] && !game[i][j+1] && !game[i][j-1] && i != headPosition[0] && j != headPosition[1] || game[i][j+1] == true && !game[i+1][j] && !game[i-1][j] && !game[i][j-1] && i != headPosition[0] && j != headPosition[1] || game[i][j-1] == true && !game[i][j+1] && !game[i+1][j] && !game[i-1][j] && i != headPosition[0] && j != headPosition[1] || game[i-1][j] == true && !game[i+1][j] && !game[i][j+1] && !game[i][j-1] && i != headPosition[0] && j != headPosition[1]){

        return findTailRecursive(headPosition, headPosition);
            
        //}

    }


    //@Override
    public int[] findTailRecursive(int[] currentPosition, int[] previousPosition){

        recursiveChecks++;

        recursiveLength++;



        //base case
        for(int i = currentPosition[0]-1; i < currentPosition[0]+2; ++i){
            for(int j = currentPosition[1]-1; j < currentPosition[1] +2; ++j){

                if(i < 0 || i > game.length-1 || j < 0 || j > game.length-1){
                    continue;
                }

                if(i + j < (currentPosition[0] + currentPosition[1]) -1 || i + j == currentPosition[0] + currentPosition[1] || i + currentPosition[0] > (currentPosition[0] + currentPosition[1]) + 1){
                    continue;
                }

                if(i == previousPosition[0] && j == previousPosition[1]){
                    continue;
                }

                if(game[i][j]){

                    previousPosition[0] = currentPosition[0];
                    previousPosition[1] = currentPosition[1];

                    currentPosition[0] = i;
                    currentPosition[1] = j;
                    return findTailRecursive(currentPosition, previousPosition);
                }


            }
        }

        recursiveTailArray[0] = currentPosition[0];
        recursiveTailArray[1] = currentPosition[1];
        recursiveTailArray[2] = recursiveLength;
        return recursiveTailArray;

    }

    private void resetCounters(){
        exhaustiveChecks = 0;
        recursiveChecks = 0;
        exhaustiveLength = 0;
        recursiveLength = 0;
       //int[] exhaustiveTailArray = {0,0,0};
       //int[] recursiveTailArray = {0,0,0};
    }

    private static int getRecursiveChecks(){

        return recursiveChecks;
    }

    private static int getExhaustiveChecks(){

        return exhaustiveChecks;
    }


}
