import java.util.*;

class mcCullochPitts {
    public static int[] x1 = new int[] { 0, 0, 1, 1 };
    public static int[] x2 = new int[] { 0, 1, 0, 1 };

    public static void and_gate(float w1, float w2, float b, float t) {
        System.out.println("AND Gate");
        for (int i = 0; i < 4; i++) {
            float n = w1 * x1[i] + w2 * x2[i] + b;
            if (n >= t)
                System.out.println(x1[i] + " " + x2[i] + " " + 1);
            else
                System.out.println(x1[i] + " " + x2[i] + " " + 0);
        }
    }

    public static void or_gate(float w1, float w2, float b, float t) {
        System.out.println("OR Gate");
        for (int i = 0; i < 4; i++) {
            float n = w1 * x1[i] + w2 * x2[i] + b;
            if (n >= t)
                System.out.println(x1[i] + " " + x2[i] + " " + 1);
            else
                System.out.println(x1[i] + " " + x2[i] + " " + 0);
        }
    }

    public static void not_gate(float w, float b, float t) {
        System.out.println("NOT Gate");
        int[] x = new int[] { 0, 1 };
        for (int i = 0; i < 2; i++) {
            float n = w * x[i] + b;
            if (n >= t)
                System.out.println(x[i] + " " + 1);
            else
                System.out.println(x[i] + " " + 0);
        }
    }

    public static void nor_gate(float w1, float w2, float b, float t) {
        System.out.println("NOR Gate");
        for (int i = 0; i < 4; i++) {
            float n = w1 * x1[i] + w2 * x2[i] + b;
            if (n >= t)
                System.out.println(x1[i] + " " + x2[i] + " " + 1);
            else
                System.out.println(x1[i] + " " + x2[i] + " " + 0);
        }
    }

    public static void nand_gate(float w1, float w2, float b, float t) {
        System.out.println("NAND Gate");
        for (int i = 0; i < 4; i++) {
            float n = w1 * x1[i] + w2 * x2[i] + b;
            if (n >= t)
                System.out.println(x1[i] + " " + x2[i] + " " + 1);
            else
                System.out.println(x1[i] + " " + x2[i] + " " + 0);
        }
    }

    public static void xor_gate(float w11, float w12, float b11, float w13, float w14, float b12, float w21, float w22,
            float b21, float t) {
        System.out.println("XOR Gate");
        for (int i = 0; i < 4; i++) {
            float n1 = w11 * x1[i] + w12 * x2[i] + b11;
            if (n1 >= t)
                n1 = 1;
            else
                n1 = 0;
            float n2 = w13 * x1[i] + w14 * x2[i] + b12;
            if (n2 >= t)
                n2 = 1;
            else
                n2 = 0;
            float n = w21 * n1 + w22 * n2 + b21;
            if (n >= t)
                System.out.println(x1[i] + " " + x2[i] + " " + 1);
            else
                System.out.println(x1[i] + " " + x2[i] + " " + 0);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        float w1, w2, b, t, w;
        int ch = 0;
        while (ch != 7) {
            System.out.println(
                    "Enter - \n1. AND Gate \n2. OR Gate \n3. NOT Gate \n4. NOR Gate \n5. NAND Gate \n6. XOR Gate \n7. Exit \n");
            ch = sc.nextInt();
            if (ch == 1) {
                System.out.println("Enter value for weight 1: ");
                w1 = sc.nextFloat();
                System.out.println("Enter value for weight 2: ");
                w2 = sc.nextFloat();
                System.out.println("Enter value for bias: ");
                b = sc.nextFloat();
                System.out.println("Enter value for threshold: ");
                t = sc.nextFloat();
                and_gate(w1, w2, b, t);
            } else if (ch == 2) {
                System.out.println("Enter value for weight 1: ");
                w1 = sc.nextFloat();
                System.out.println("Enter value for weight 2: ");
                w2 = sc.nextFloat();
                System.out.println("Enter value for bias: ");
                b = sc.nextFloat();
                System.out.println("Enter value for threshold: ");
                t = sc.nextFloat();
                or_gate(w1, w2, b, t);
            } else if (ch == 3) {
                System.out.println("Enter value for weight: ");
                w = sc.nextFloat();
                System.out.println("Enter value for bias: ");
                b = sc.nextFloat();
                System.out.println("Enter value for threshold: ");
                t = sc.nextFloat();
                not_gate(w, b, t);
            } else if (ch == 4) {
                System.out.println("Enter value for weight 1: ");
                w1 = sc.nextFloat();
                System.out.println("Enter value for weight 2: ");
                w2 = sc.nextFloat();
                System.out.println("Enter value for bias: ");
                b = sc.nextFloat();
                System.out.println("Enter value for threshold: ");
                t = sc.nextFloat();
                nor_gate(w1, w2, b, t);
            } else if (ch == 5) {
                System.out.println("Enter value for weight 1: ");
                w1 = sc.nextFloat();
                System.out.println("Enter value for weight 2: ");
                w2 = sc.nextFloat();
                System.out.println("Enter value for bias: ");
                b = sc.nextFloat();
                System.out.println("Enter value for threshold: ");
                t = sc.nextFloat();
                nand_gate(w1, w2, b, t);
            } else if (ch == 6) {
                System.out.println("Enter value for weight (1,1): ");
                float w11 = sc.nextFloat();
                System.out.println("Enter value for weight (1,2): ");
                float w12 = sc.nextFloat();
                System.out.println("Enter value for bias (1,1): ");
                float b11 = sc.nextFloat();
                System.out.println("Enter value for weight (1,3): ");
                float w13 = sc.nextFloat();
                System.out.println("Enter value for weight (1,4): ");
                float w14 = sc.nextFloat();
                System.out.println("Enter value for bias (1,2): ");
                float b12 = sc.nextFloat();
                System.out.println("Enter value for weight (2,1): ");
                float w21 = sc.nextFloat();
                System.out.println("Enter value for weight (2,2): ");
                float w22 = sc.nextFloat();
                System.out.println("Enter value for bias (2,1): ");
                float b21 = sc.nextFloat();
                System.out.println("Enter value for threshold: ");
                t = sc.nextFloat();
                xor_gate(w11, w12, b11, w13, w14, b12, w21, w22, b21, t);
            } else
                System.out.println("Invalid Entry\n");
            System.out.println("\n");
        }
    }
}
