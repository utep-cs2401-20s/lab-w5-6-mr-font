import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SnakeGameTest {

    @org.junit.jupiter.api.Test
    //First test case. This one is a soft ball, as all parts of the snake are in the middle of the board, so our methods don't have to worry about out of bounds indexes.
    //This easy test will give us a good baseline for the tests to follow(and see if the code-as-written even works, even of the simplest test case).
    public void testFindTailExhaustive1(){

      SnakeGame test = new SnakeGame();
      boolean[][] boardA = {{false,false,false,false,false,false,false,false},
                           {false,false,true,false,false,false,false,false},
                           {false,false,true,false,false,false,false,false},
                           {false,false,true,false,false,false,false,false},
                           {false,false,true,false,false,false,false,false},
                           {false,false,true,true,true,true,false,false},
                           {false,false,false,false,false,false,false,false},
                           {false,false,false,false,false,false,false,false}};

      int[] tailLocation = {5,5,8};

      int x = 1;
      int y = 2;

      test.SnakeHead(boardA, x, y);

      assertArrayEquals(tailLocation, test.findTailExhaustive());


    }

}