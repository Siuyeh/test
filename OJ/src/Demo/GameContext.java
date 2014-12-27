package Demo;

/**
 * Created by Administrator on 2014/12/27.
 */
public class GameContext {
    public static int[][] board = new int[9][9];

    public static int line = board.length;

    public static int column = board[0].length;

    public static void main(String args[]){
        System.out.print("this num is : "+board[0][1]);
    }

    public static void init(){
        for (int i=0;i<4;i++){
            board[0][i] = 1;
        }
    }

}
