import java.util.*;
import java.lang.*;
import java.net.*;
import java.io.*;

public class client1 {
    public static void main(String[] args) {
        int n, k, i, j, a = 0;
        String key;
        try {
            while (true) {
                Socket c = new Socket("localhost", 5555);
                //System.out.println("Client side connected...");
                DataInputStream in = new DataInputStream(c.getInputStream());
                DataOutputStream out = new DataOutputStream(c.getOutputStream());
                Scanner sc = new Scanner(System.in);
                
                n = in.readInt();
                k = in.readInt();
                System.out.println("Client received n and k.");
                ArrayList<ArrayList<Integer>> codes = new ArrayList<ArrayList<Integer>>(n);
                ArrayList<Integer> enc_msg = new ArrayList<Integer>(k);
                System.out.println("Reading codes and superimposed message...");
                for (i = 0; i < n; i++) {
                    ArrayList<Integer> temp = new ArrayList<Integer>(k);
                    for (j = 0; j < k; j++) {
                        a = in.readInt();
                        temp.add(a);
                    }
                    codes.add(temp);
                }
                for (i = 0; i < k; i++) {
                    a = in.readInt();
                    enc_msg.add(a);
                }
                for (i = 0; i < n; i++) {
                    a = 0;
                    for (j = 0; j < k; j++)
                        a = a + enc_msg.get(j) * codes.get(i).get(j);
                    if (a <= 0) {
                        System.out.println("Message of user " + (i + 1) + ":" + 0);
                        continue;
                    } else {
                        System.out.println("Message of user " + (i + 1) + ":" + 1);
                    }
                }
                c.close();
            }
        } catch (Exception e) {
            System.out.println("Done!");
        }
    }
}