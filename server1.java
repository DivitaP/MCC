

import java.util.*;
import java.lang.*;
import java.net.*;
import java.io.*;

public class server1 {
    public static void main(String[] args) {
        int n, k = 8, i, j, a = 0, msg;
        String key;
        try {
            ServerSocket ss = new ServerSocket(5555);
            System.out.println("Server side connected..");
            Socket s = ss.accept();
            System.out.println("Client accepted...");
            DataInputStream in = new DataInputStream(s.getInputStream());
            DataOutputStream out = new DataOutputStream(s.getOutputStream());
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter number of users : ");
            n = sc.nextInt();
            while (true) {
                if (n >= 8) {
                    for (i = 4; i <= 100; i++) {
                        if (n < Math.pow(2, i)) {
                            k = (int) Math.pow(2, i);
                            break;
                        }
                    }
                }
                ArrayList<ArrayList<Integer>> codes = new ArrayList<ArrayList<Integer>>(n);
                ArrayList<ArrayList<Integer>> enc_codes = new ArrayList<ArrayList<Integer>>(n);
                ArrayList<Integer> messages = new ArrayList<Integer>(n);
                ArrayList<Integer> enc_msg = new ArrayList<Integer>(k);
                for (i = 0; i < n; i++) {
                    System.out.print("Enter " + k + "-bit binary key for user " + (i + 1) + ": ");
                    key = sc.next();
                    ArrayList<Integer> temp = new ArrayList<Integer>(k);
                    for (j = 0; j < k; j++) {
                        a = key.charAt(j);
                        if (a == '0') {
                            temp.add(-1);
                            continue;
                        }
                        temp.add(1);
                    }
                    codes.add(temp);
                }
                for (i = 0; i < n; i++) {
                    System.out.print("Enter message of user " + (i + 1) + ":");
                    msg = sc.nextInt();
                    if (msg == 0) {
                        messages.add(-1);
                        continue;
                    }
                    messages.add(1);
                }
                a = 0;
                for (i = 0; i < n; i++) {
                    ArrayList<Integer> temp = new ArrayList<Integer>(k);
                    for (j = 0; j < k; j++) {
                        a = messages.get(i) * codes.get(i).get(j);
                        if (a <= 0) {
                            temp.add(-1);
                            continue;
                        }
                        temp.add(1);
                    }
                    enc_codes.add(temp);
                }
                for (i = 0; i < k; i++) {
                    a = 0;
                    for (j = 0; j < n; j++) {
                        a = a + enc_codes.get(j).get(i);
                    }
                    enc_msg.add(a);
                }
                System.out.println("Sending n, ak, c to the client...");
                out.writeInt(n);
                out.writeInt(k);
                for (i = 0; i < n; i++) {
                    for (j = 0; j < k; j++) {
                        out.writeInt(codes.get(i).get(j));
                    }
                }
                for (i = 0; i < k; i++) {
                    out.writeInt(enc_msg.get(i));
                }
                if (in.readInt() == -1) {
                    s.close();
                    System.exit(0);
                }
            }
        } catch (Exception e) {
            System.out.println("done!");
        }
    }
}