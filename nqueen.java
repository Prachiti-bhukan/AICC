import java.io.* ;
import java.util.* ;

public class nqueen{
    public static void solve(boolean[][] board, int row,boolean[] cols, boolean[] ndig, boolean[] rdig, String asf)
    {
        if(board.length == row)
        {
            System.out.println(asf+".");
            return;
        }

        for(int col=0;col<board[0].length;col++)
        {
            if(cols[col]==false && ndig[row+col]==false && rdig[row-col+(board.length-1)]==false)
            {
                System.out.println("Lets begin this journey");
                board[row][col]= true;
                cols[col]= true;
                rdig[row-col+(board.length-1)]= true;
                ndig[row+col] = true;
                solve(board,row+1,cols,ndig,rdig,asf+row+"-"+col+",");
                board[row][col]= false;
                cols[col]= false;
                rdig[row-col+(board.length-1)]= false;
                ndig[row+col] = false;
            }
        }

    }
 public static void main(String[] args) throws Exception
 {
     Scanner scn= new Scanner(System.in);
     int n= scn.nextInt();
     boolean[][] board = new boolean[n][n];
     boolean[] cols = new boolean[n];
     boolean[] ndig = new boolean[2*n-1];
     boolean[] rdig = new boolean[2*n-1];

     solve(board,0,cols,ndig,rdig,"");

 }
}