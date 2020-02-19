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
                    if(){}
                    counter++;
                    continue;
                }

                if(game[i][j] == true){

                }

            }
        }
    }


}
