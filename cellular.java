import java.util.Scanner;

public class cellular {

	static void show() {
		int a = 0;
		for (int i = 0; i < 30; i++) {
			if (i % 2 != 0)
				System.out.print("\t");

			for (int j = 0; j < 10; j++) {
				System.out.print(a++ + "\t\t");
			}
			System.out.println();
		}

	}

	static int cell1(int base, int i, int j) {
		int a = base;
		int sub = 10;
		for (int k = 0; k < i; k++) {
			a = a - sub;
			sub--;
		}
		for (int k = 0; k < j; k++) {
			a = a - 20;
		}

		return a;
	}

	static int cell2(int base, int i, int j) {
		int a = base;
		for (int k = 0; k < i; k++) {
			a = a - 20;
		}

		for (int k = 0; k < j; k++) {
			a = a - 11;
		}

		return a;
	}

	static int cell3(int base, int i, int j) {
		int a = base;
		int sub = 11;
		for (int k = 0; k < i; k++) {
			a = a - sub;
			sub--;
		}

		for (int k = 0; k < j; k++) {
			a = a + 9;
		}

		return a;
	}

	static int cell4(int base, int i, int j) {
		int a = base;
		int add = 9;
		for (int k = 0; k < i; k++) {
			a = a + add;
			add++;
		}
		for (int k = 0; k < j; k++) {
			a = a + 20;
		}

		return a;
	}

	static int cell5(int base, int i, int j) {
		int a = base;
		for (int k = 0; k < i; k++) {
			a = a + 20;
		}
		for (int k = 0; k < j; k++) {
			a = a + 10;
		}
		return a;
	}

	static int cell6(int base, int i, int j) {
		int a = base;
		int add = 10;
		for (int k = 0; k < i; k++) {
			a = a + add;
			add++;
		}
		for (int k = 0; k < j; k++) {
			a = a - 10;
		}

		return a;
	}

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int i, j, n;
		int base;
		show();
		System.out.println("Enter values of i :");
		i = sc.nextInt();
		System.out.println("Enter values of j :");
		j = sc.nextInt();
		n = i * i + i * j + j * j;
		System.out.println("N(i^2+ij+j^2) = " + n);
		System.out.println("Enter value of base cell:");
		base = sc.nextInt();
		System.out.println("base " + base);

		int c1 = cell1(base, i, j);
		System.out.println("c1 " + c1);
		int c2 = cell2(base, i, j);
		System.out.println("c2 " + c2);
		int c3 = cell3(base, i, j);
		System.out.println("c3 " + c3);
		int c4 = cell4(base, i, j);
		System.out.println("c4 " + c4);
		int c5 = cell5(base, i, j);
		System.out.println("c5 " + c5);
		int c6 = cell6(base, i, j);
		System.out.println("c6 " + c6);

	}
}