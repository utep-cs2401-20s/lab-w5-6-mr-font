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

    }

    public int[] findTailExhaustive(){

        int counter = 0;
        int length= 0;
        int tailArray[] = {0,0,0};

        for(int i = 0; i < game.length; i++){
            for (int j = 0; j <game[0].length; j++){

                if(i == headPosition[0] && j == headPosition[1]){

                    length++;
                    counter++;
                    //continue;
                }

                if(game[i][j] == true){
                  length++;
                  counter++;
                  if(game[i+1][j] == true && !game[i-1][j] && !game[i][j+1] && !game[i][j-1] || game[i][j+1] == true && !game[i+1][j] && !game[i-1][j] && !game[i][j-1] || game[i][j-1] == true && !game[i][j+1] && !game[i+1][j] && !game[i-1][j] || game[i-1][j] == true && !game[i+1][j] && !game[i][j+1] && !game[i][j-1] ){
                      tailArray[0] = i;
                      tailArray[1] = j;
                  }
                  //if(i > 0 && i < game.length -1 && j > 0 && j < game[0].length){
                     // if(){}
                    //}

                }
                counter++;

            }
        }

        tailArray[2] = counter;
        return tailArray;
    }


}
