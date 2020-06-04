import java.util.Scanner;

public class Aravind_2d_easy {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int arr[][] = new int[6][6];
		int sum[][] = new int[4][4];
		int largest=Integer.MIN_VALUE;
        for (int i = 0; i < 6; i++) {
            String[] arrRowItems = sc.nextLine().split(" ");
            sc.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            for (int j = 0; j < 6; j++) {
                int arrItem = Integer.parseInt(arrRowItems[j]);
                arr[i][j] = arrItem;
            }
        }

		largest = fillHourSum(arr,sum,largest);
		System.out.println(largest);
		sc.close();
	}
	
	public static int fillHourSum(int[][] a, int[][] s, int larg) {
		for(int i=0; i<=3; i++) {
			for(int j=0; j<=3; j++) {
				int sum =0;
				for(int k=i; k<i+3; k++) {
					for(int l=j; l<j+3; l++) {
						if(isToSkip(i, j, k, l))
							try {
								sum = sum + a[k][l];								
							} catch (Exception e) {
								System.out.println(String.format("%s--%s--%s--%s", i, j, k, l));
							}
					}
				}
				s[i][j] = sum;
				larg = sum>larg? sum : larg;
			}
		}
		//printArray(s);
		return larg;
		}
	
	public static void printArray(int[][] a) {
		for(int i=0;i <a.length ;i++) {
			for(int j=0; j<a.length; j++) {
				System.out.print(a[i][j] + "  ");
			}
			System.out.println();
		}
	}

	private static boolean isToSkip(int i, int j, int k, int l) {
		return !(k==i+1 && (l==j || l==j+2));
	}
}
