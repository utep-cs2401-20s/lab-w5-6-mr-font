import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SnakeGameTest {

    //findTailExhaustive tests:

    @org.junit.jupiter.api.Test
    //First test case. This one is a soft ball, as all parts of the snake are in the middle of the board, so our methods don't have to worry about out of bounds indexes.
    //This easy test will give us a good baseline for the tests to follow(and see if the code-as-written even works, even of the simplest test case).
    //
    //Result: The method passed the test with the given values, and given board.
    public void testFindTailExhaustive1(){

      SnakeGame testEx1 = new SnakeGame();
      boolean[][] boardA = {{false,false,false,false,false,false,false,false},
                           {false,false,true,false,false,false,false,false},
                           {false,false,true,false,false,false,false,false},
                           {false,false,true,false,false,false,false,false},
                           {false,false,true,false,false,false,false,false},
                           {false,false,true,true,true,true,false,false},
                           {false,false,false,false,false,false,false,false},
                           {false,false,false,false,false,false,false,false}};

      int[] tailLocation = {5,5,8};

      //Head indexes
      int y = 1;
      int x = 2;

      testEx1.SnakeHead(boardA, y, x);

      assertArrayEquals(tailLocation, testEx1.findTailExhaustive());


    }

    @org.junit.jupiter.api.Test
    //Second test case, this time the snake is on the 0th row of the board,
    // so our method now has to deal with some possible indexes being out of bounds
    //
    //Result: The method passed the test with the given values, and given board.
    public void testFindTailExhaustive2(){

        SnakeGame testEx2 = new SnakeGame();
        boolean[][] boardB = {{true,true,true,true,false,false,false,false},
                              {false,false,false,false,false,false,false,false},
                              {false,false,false,false,false,false,false,false},
                              {false,false,false,false,false,false,false,false},
                              {false,false,false,false,false,false,false,false},
                              {false,false,false,false,false,false,false,false},
                              {false,false,false,false,false,false,false,false},
                              {false,false,false,false,false,false,false,false}};

        int[] tailLocation = {0,3,4};

        //head indexes
        int y = 0;
        int x = 0;

        testEx2.SnakeHead(boardB, y,x);

        assertArrayEquals(tailLocation, testEx2.findTailExhaustive());


    }

    @org.junit.jupiter.api.Test
    //Third test case: This time the snake's head is on the 0th row of the board,
    //and the snake's body runs along the top of the board, down the right hand side,
    // through the middle, then down to the bottom and finely running to the left side of the board.
    // Our method now has to deal with the tail ending at the 7th row, 0th column, but the snakes's body "continues" to the 7th row, 4th column.
    //
    //Result: The method passed the test with the given values, and given board.
    public void testFindTailExhaustive3(){

        SnakeGame testEx3 = new SnakeGame();
        boolean[][] boardC = {{true,true,true,true,true,true,true,true},
                              {false,false,false,false,false,false,false,true},
                              {false,false,false,false,false,false,false,true},
                              {false,false,false,false,true,true,true,true},
                              {false,false,false,false,true,false,false,false},
                              {false,false,false,false,true,false,false,false},
                              {false,false,false,false,true,false,false,false},
                              {true,true,true,true,true,false,false,false}};

        int[] tailLocation = {7,0,23};

        //head indexes
        int y = 0;
        int x = 0;

        testEx3.SnakeHead(boardC, y, x);

        assertArrayEquals(tailLocation, testEx3.findTailExhaustive());


    }

    @org.junit.jupiter.api.Test
    //Forth test case: In this test the snake's tail is on the 0th row, 0th column of the board,
    //and the head is on the 4th row, 3rd column. In addition, the board is 4 by 4 in this test.
    // The intent is to test if the method will work with the tail on the first cell
    // Our method now has to deal with the tail ending at the 7th row, 0th column, but the snakes's body "continues" to the 7th row, 4th column.
    //
    //Result: The method did not pass the test with the given values, and given board.
    //The length of the snake is 6 cells, but the method returned a length of 7.
    public void testFindTailExhaustive4(){

        SnakeGame testEx4 = new SnakeGame();
        boolean[][] boardD = {{true,true,false,false},
                              {false,true,false,false},
                              {false,true,false,false},
                              {false,true,true,false},};


        int[] tailLocation = {0,0,6};

        //head indexes
        int y = 3;
        int x = 2;

        testEx4.SnakeHead(boardD, y, x);

        assertArrayEquals(tailLocation, testEx4.findTailExhaustive());


    }

    @org.junit.jupiter.api.Test
    //Fifth test case: The tail is on the 0th row, 0th column again, but the board is back to being 8 by 8.
    //This test is intended to see if the size of the board is the problem.
    //
    //Result: The method did not pass the test with the given values, and given board.
    //The method is still returning the wrong value, so we know it's not the size of the board causing the issue.
    //Looking at the code for findTailExhaustive, it looks like if the tail is on the first cell of the board,
    // findTailExhaustive will count the tail cell twice when summing the length of the snake.
    //One way to fix it would be to change line 89 from: if (game[i][j] && tailFound), to: if (game[i][j] && tailFound && exhaustiveLength < 1)
    public void testFindTailExhaustive5(){

        SnakeGame testEx5 = new SnakeGame();
        boolean[][] boardE = {{true,true,true,true,false,false,false,false},
                              {false,false,false,true,false,false,false,false},
                              {false,false,false,true,false,false,false,false},
                              {false,false,false,true,false,false,false,false},
                              {false,false,false,true,false,false,false,false},
                              {false,false,false,true,false,false,false,false},
                              {false,false,false,true,false,false,false,false},
                              {false,false,false,true,true,true,true,false}};

        int[] tailLocation = {0,0,14};

        //head indexes
        int y = 7;
        int x = 6;

        testEx5.SnakeHead(boardE, y, x);

        assertArrayEquals(tailLocation, testEx5.findTailExhaustive());


    }



    //findTailRecursive tests:


    @org.junit.jupiter.api.Test
    //First Recursive test case. Same board as exhaustive test number 2.
    // At this point, 2/29/2020, I'm out of time for doing the full set of tests, so I'm going to reuse the boards from the exhaustive test. I'm going to put in what work I can.
    //
    //Result: The method failed with a buffer overflow.
    public void testFindTailRecursive1(){

        SnakeGame testRecA = new SnakeGame();
        boolean[][] boardA = {{false,false,false,false,false,false,false,false},
                              {false,false,true,false,false,false,false,false},
                              {false,false,true,false,false,false,false,false},
                              {false,false,true,false,false,false,false,false},
                              {false,false,true,false,false,false,false,false},
                              {false,false,true,true,true,true,false,false},
                              {false,false,false,false,false,false,false,false},
                              {false,false,false,false,false,false,false,false}};

        int[] tailLocation = {5,5,8};

        //Head indexes
        int y = 1;
        int x = 2;

        testRecA.SnakeHead(boardA, y, x);

        assertArrayEquals(tailLocation, testRecA.findTailRecursive());


    }

    @org.junit.jupiter.api.Test
    //Second recursive test case. Same board as exhaustive test number 2
    //
    //
    //Result: The method passed the test with the given values, and given board.
    public void testFindTailRecursive2(){

        SnakeGame testRecB = new SnakeGame();
        boolean[][] boardB = {{true,true,true,true,false,false,false,false},
                              {false,false,false,false,false,false,false,false},
                              {false,false,false,false,false,false,false,false},
                              {false,false,false,false,false,false,false,false},
                              {false,false,false,false,false,false,false,false},
                              {false,false,false,false,false,false,false,false},
                              {false,false,false,false,false,false,false,false},
                              {false,false,false,false,false,false,false,false}};

        int[] tailLocation = {0,3,4};

        //Head indexes
        int y = 0;
        int x = 0;

        testRecB.SnakeHead(boardB, y, x);

        assertArrayEquals(tailLocation, testRecB.findTailExhaustive());


    }

    @org.junit.jupiter.api.Test
    //Second recursive test case. Same board as exhaustive test number 2
    //
    //
    //Result: The method passed the test with the given values, and given board.
    public void testFindTailRecursive3(){

        SnakeGame testRecC = new SnakeGame();
        boolean[][] boardC = {{true,true,true,true,true,true,true,true},
                              {false,false,false,false,false,false,false,true},
                              {false,false,false,false,false,false,false,true},
                              {false,false,false,false,true,true,true,true},
                              {false,false,false,false,true,false,false,false},
                              {false,false,false,false,true,false,false,false},
                              {false,false,false,false,true,false,false,false},
                              {true,true,true,true,true,false,false,false}};

        int[] tailLocation = {7,0,23};

        //Head indexes
        int y = 0;
        int x = 0;

        testRecC.SnakeHead(boardC, y, x);

        assertArrayEquals(tailLocation, testRecC.findTailRecursive());


    }
}