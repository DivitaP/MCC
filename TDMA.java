import java.util.*;
import java.io.*;

public class TDMA {
    public static void main(String Args[]) {
        Scanner sc = new Scanner(System.in);
        int i, t = 0;
        int a[] = new int[10];
        for (i = 0; i < 10; i++) {
            System.out.print("Enter delay for channel " + (i + 1) + ": ");
            a[i] = sc.nextInt();
        }
        System.out.println();
        System.out.println("Cycle 1");
        for (i = 0; i < 10; i++) {
            if (a[i] > 10) {
                System.out.println("Channel " + (i + 1) + " has not been assigned any slot");
                continue;
            }
            System.out.println("Channel " + (i + 1) + " has been assigned slot " + t + " to " + (t + 417));
            t += 418;
        }
        t = 0;
        System.out.println();
        System.out.println();
        System.out.println("Cycle 2");
        for (i = 0; i < 10; i++) {
            if (a[i] < 10)
                System.out.println("Time slot " + t + " to " + (t + 417) + ": Idle");
            else
                System.out.println("Channel " + (i + 1) + " has been assigned slot " + t + " to " + (t + 417));
            t += 418;
        }
    }
}
/*
Divitas-MacBook-Air:MCC divita$ javac TDMA.java
Divitas-MacBook-Air:MCC divita$ java TDMA
Enter delay for channel 1: 2
Enter delay for channel 2: 4
Enter delay for channel 3: 1
Enter delay for channel 4: 58
Enter delay for channel 5: 134
Enter delay for channel 6: 431
Enter delay for channel 7: 10
Enter delay for channel 8: 9
Enter delay for channel 9: 12
Enter delay for channel 10: 7

Cycle 1
Channel 1 has been assigned slot 0 to 417
Channel 2 has been assigned slot 418 to 835
Channel 3 has been assigned slot 836 to 1253
Channel 4 has not been assigned any slot
Channel 5 has not been assigned any slot
Channel 6 has not been assigned any slot
Channel 7 has been assigned slot 1254 to 1671
Channel 8 has been assigned slot 1672 to 2089
Channel 9 has not been assigned any slot
Channel 10 has been assigned slot 2090 to 2507


Cycle 2
Time slot 0 to 417: Idle
Time slot 418 to 835: Idle
Time slot 836 to 1253: Idle
Channel 4 has been assigned slot 1254 to 1671
Channel 5 has been assigned slot 1672 to 2089
Channel 6 has been assigned slot 2090 to 2507
Channel 7 has been assigned slot 2508 to 2925
Time slot 2926 to 3343: Idle
Channel 9 has been assigned slot 3344 to 3761
Time slot 3762 to 4179: Idle
Divitas-MacBook-Air:MCC divita$ 
*/