import java.util.*;

public class walshCode {

    private static int[][] wtable;

    // private static List<Integer> getWalshCode() {
    //     List<Integer> result = new ArrayList<>();
    //     List<Integer> two = new ArrayList<>();

    //     two.add(0);
    //     two.add(0);

    //     return result;
    // }

    public static int buildWalshTable(int len, int i1, int i2, int j1, 
                                            int j2, boolean isBar)
    {
        // len = size of matrix. (i1, j1), (i2, j2) are
        // starting and ending indices of wtable.
          
        // isBar represents whether we want to add simple entry
        // or complement(southeast submatrix) to wtable.
  
        if (len == 2) {
  
            if (!isBar) {
  
                wtable[i1][j1] = 1;
                wtable[i1][j2] = 1;
                wtable[i2][j1] = 1;
                wtable[i2][j2] = -1;
            }
            else {
  
                wtable[i1][j1] = -1;
                wtable[i1][j2] = -1;
                wtable[i2][j1] = -1;
                wtable[i2][j2] = +1;
            }
  
            return 0;
        }
          
        int midi = (i1 + i2) / 2;
        int midj = (j1 + j2) / 2;
  
        buildWalshTable(len / 2, i1, midi, j1, midj, isBar);
        buildWalshTable(len / 2, i1, midi, midj + 1, j2, isBar);
        buildWalshTable(len / 2, midi + 1, i2, j1, midj, isBar);
        buildWalshTable(len / 2, midi + 1, i2, midj + 1, j2, !isBar);
  
        return 0;
    }
  
    public static void showWalshTable(int num_stations)
    {
  
        System.out.print("\n");
  
        for (int i = 0; i < num_stations; i++) {
            for (int j = 0; j < num_stations; j++) {
                System.out.print(wtable[i][j] + " ");
            }
            System.out.print("\n");
        }
        System.out.println("-------------------------");
        System.out.print("\n");
    }

    public static void main(String[] args) {
        wtable = new int[8][8];
        buildWalshTable(8, 0, 7, 0, 7, false);
        showWalshTable(8);
    }
}
