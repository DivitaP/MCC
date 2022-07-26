
import java.util.*;
import java.net.*;
import java.io.*;

public class client {
    private static int[][] w;
    private static int[][] temp;
    private static int[] c;
    public static void main(String[] args) throws IOException{
        Socket s = new Socket("localhost", 5555);
        System.out.println("Client side connected");
        DataInputStream in = new DataInputStream(s.getInputStream());
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        Scanner sc = new Scanner(System.in);
        int n;
        n = in.readInt();
        int wc = in.readInt();
        int k=0;
        for (int i = 1; i <= 100; i++) {
            if (n <= Math.pow(2, i)) {
                k = (int) Math.pow(2, i);
                break;
            }
        }
        w = new int[k][k];
        temp = new int[n][k];
        c = new int[k];
        System.out.println("\nSuperimposed values of signal c: ");
        for(int i=0; i<k; i++) {
            c[i] = in.readInt();
            System.out.print(c[i] + " ");
        }
        if(wc==0){
            getWalshCode(k, 0, k-1, 0, k-1, true);
        }else{
            getWalshCode(k, 0, k-1, 0, k-1, false);
        }
        System.out.println();
        System.out.println("\nWalsh matrix with bipolar values is: ");
        printWalshCode(k);
        System.out.println("Recovering the data from superimposed signals...");
        System.out.println();
        for(int i=0; i<n; i++) {
            int sum = 0;
            for(int j=0; j<n; j++) {
                sum += c[j] * w[i][j];
            }
            if(sum>0) {
                System.out.println("Data of sender "+(i+1)+" is: 1");
            }
            else if(sum<0) {
                System.out.println("Data of sender "+(i+1)+" is: 0");
            }
        }
        System.out.println();
    }

    private static void printWalshCode(int n) {
        System.out.println();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(w[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int getWalshCode(int n, int i1, int i2, int j1, int j2, boolean b) {
        if (n == 2) {
            if (!b) {
                w[i1][j1] = 1;
                w[i1][j2] = 1;
                w[i2][j1] = 1;
                w[i2][j2] = -1;
            }
            else {
                w[i1][j1] = -1;
                w[i1][j2] = -1;
                w[i2][j1] = -1;
                w[i2][j2] = +1;
            }
            return 0;
        }
        int midi = (i1 + i2) / 2;
        int midj = (j1 + j2) / 2;
        getWalshCode(n / 2, i1, midi, j1, midj, b);
        getWalshCode(n / 2, i1, midi, midj + 1, j2, b);
        getWalshCode(n / 2, midi + 1, i2, j1, midj, b);
        getWalshCode(n / 2, midi + 1, i2, midj + 1, j2, !b);
        return 0;
    }
}