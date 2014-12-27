package Demo;

/**
 * Created by Administrator on 2014/12/27.
 */
public class Game {
    public static void main(String args[]){
        GameContext.init();
        System.out.println("this is :"+judge(1, 1, 5));
        for (int i=0;i<9;i++){
            System.out.println(GameContext.board[0][i]);
        }
    }

    /**
     * 判断下出此步棋后是否有五个子相连
     * @param piece [int]-1代表白棋，2代表黑棋
     * @param line [int]-落子行数
     * @param column [int]-落子列数
     * @return -1-白棋胜利，1-黑棋胜利，0-暂无胜负
     */
    public static int judge(int piece, int line, int column){
        GameContext.board[line-1][column-1] = piece;

        int flag = cross();
        if(flag != 0){
            return flag;
        }
        flag = vertical();
        if(flag != 0){
            return flag;
        }
//        flag = upword();
//        if(flag != 0){
//            return flag;
//        }
//        flag = downword();
//        if(flag != 0){
//            return flag;
//        }

        return 0;
    }

    /**
     * 判断横向是否有胜负
     * @return
     */
    public static int cross(){
        int cont = 0;
        for (int y=0;y<GameContext.line;y++){
            for(int x=0;x<GameContext.column-1;x++){
                if(GameContext.board[y][x+1] == 1 && GameContext.board[y][x] == 1){
                    cont--;
                }else if (GameContext.board[y][x+1] == 2 && GameContext.board[y][x] == 2){
                    cont++;
                }else{
                    cont = 0;
                }
            }
        }
        if (cont == -4){
            return -1;
        }else if (cont == 4){
            return 1;
        }else {
            return 0;
        }
    }

    /**
     * 判断纵向是否有胜负
     * @return
     */
    public static int vertical(){
        int cont = 0;
        for (int x=0;x<GameContext.column;x++){
            for(int y=0;y<GameContext.line-1;y++){
                if(GameContext.board[y+1][x] == 1 && GameContext.board[y][x] == 1){
                    cont--;
                }else if (GameContext.board[y+1][x] == 2 && GameContext.board[y][x] == 2){
                    cont++;
                }else{
                    cont = 0;
                }
            }
        }
        if (cont == -4){
            return -1;
        }else if (cont == 4){
            return 1;
        }else {
            return 0;
        }
    }

    /**
     * 斜向上判断是否有胜负
     * @return
     */
    public static int upword(){
        int cont = 0;
        for (int line=4;line<GameContext.line;line++){
            for (int column=0;column<=GameContext.column;column++){
                for (int x=column, y=line;x<GameContext.column-1;x++,y--){
                        if (GameContext.board[y-1][x+1] == 1&&GameContext.board[y][x] == 1){
                        cont--;
                    }else if (GameContext.board[y-1][x+1] == 2&&GameContext.board[y][x] == 2){
                        cont++;
                    }else {
                        cont = 0;
                    }
                }
            }
        }

        if (cont == -4){
            return -1;
        }else if (cont == 4){
            return 1;
        }else {
            return 0;
        }
    }

    public static int downword(){
        int cont = 0;
        for (int line=0;line<=GameContext.line-4;line++){
            for (int column=0;column<=(GameContext.column-4)+line;column++){
                for (int x=column,y=line;x<(GameContext.column-4)+line-1;x++,y++){
                    if(GameContext.board[y+1][x+1] == 1 && GameContext.board[y][x] == 1){
                        cont--;
                    }else if (GameContext.board[y+1][x+1] == 2 && GameContext.board[y][x] == 2){
                        cont++;
                    }else {
                        cont = 0;
                    }
                }
            }
        }

        if (cont == -4){
            return -1;
        }else if (cont == 4){
            return 1;
        }else {
            return 0;
        }
    }
}
