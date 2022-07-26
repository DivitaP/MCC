import java.util.*;
import java.net.*;
import java.io.*;

public class server {
    private static int[][] w;
    private static int[][] temp;
    private static int[] c;
    public static void main(String[] args)  throws IOException {
        int k=0;
        ServerSocket ss = new ServerSocket(5555);
        System.out.println("Server side connected");
        Socket s = ss.accept();
        System.out.println("Client accepted");
        DataInputStream in = new DataInputStream(s.getInputStream());
        DataOutputStream out = new DataOutputStream(s.getOutputStream());
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.print("Enter number of users : ");
        int n = sc.nextInt();
        int[] data = new int[n];
        System.out.println();
        System.out.println("Enter the data of each user:");
        for(int i=0; i<n; i++) {
            data[i] = sc.nextInt();
        }
        System.out.println("\nConverting into bipolar...");
        for(int i=0; i<n; i++) {
            data[i] = getBipolar(data[i]);
        }
        for(int i=0; i<n; i++) {
            System.out.println("Sender " + (i+1) + " data is: " + data[i]);
        }
        for (int i = 1; i <= 100; i++) {
            if (n <= Math.pow(2, i)) {
                k = (int) Math.pow(2, i);
                break;
            }
        }
        w = new int[k][k];
        temp = new int[n][k];
        c = new int[k];
        System.out.println();
        System.out.println("Enter the value of walsh matrix for 0th order : ");
        int wc = sc.nextInt();
        if(wc==0){
            getWalshCode(k, 0, k-1, 0, k-1, true);
        }else{
            getWalshCode(k, 0, k-1, 0, k-1, false);
        }
        System.out.println("Walsh matrix with bipolar values is: ");
        printWalshCode(k);
        System.out.println("Spreading the signal...");
        System.out.println();
        for (int i = 0; i < n; i++) {
            System.out.print("Sender "+ (i+1) + " data is ");
            for (int j = 0; j < k; j++) {
                temp[i][j] = w[i][j];
                temp[i][j] *= data[i];
                System.out.print(temp[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("\nSuperimposing all the signals...");
        System.out.println();
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < n; j++) {
                c[i] += temp[j][i]; 
            }
            System.out.print(c[i] + " ");
        }
        System.out.println();
        System.out.println("Sending n and c to the client...");
        System.out.println();
        out.writeInt(n);
        out.writeInt(wc);
        for(int i=0; i<k; i++) {
            out.writeInt(c[i]);
        }
    }

    static int getBipolar(int data) {
        if(data == 1) {
            return 1;
        }
        else if(data == 0) {
            return -1;
        }
        else {
            return 0;
        }
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
                w[i1][j1] = +1;
                w[i1][j2] = +1;
                w[i2][j1] = +1;
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