package tutorial;

public class Tutorial3Week4 {
	
	public static void reversedOrder(String[] args){
		double[] nArr=new double[args.length];
		double n=0;
		double average=0;
		double total=0;
		for (int i=0;i<nArr.length;i++){
			n=Double.parseDouble(args[i]);
			total+=n;
			nArr[i]=n;
		}
		average=total/nArr.length;
		System.out.println("printing reverse order");
		for (int i=nArr.length-1;i>=0;i--){
			System.out.print(nArr[i]+" ");
		}
		System.out.println("\naverage: "+average);
		System.out.println("following indices of the numbers that are below the average");
		for (int i=0;i<nArr.length;i++){
			if (nArr[i]<average){System.out.print(i+" ");}
		}
	}

	private static int hasIntRoot(int totalLen){
		double n=Math.sqrt(totalLen);
		int rint=(int)n;
		return n==rint?rint:0;
	}

	public static void basicStatistics(String[] args){
		int totalLen=args.length;
		int len=hasIntRoot(totalLen);
		if (len==0){System.out.println("must input some numbers with total equal to N*N");return;}
		int[][] numTable=new int[len][len];
		int total=0,min=0,max=0,leftDiagonal=0,rightDiagonal=0;
		for (int i=0;i<len;i++){
			for (int j=0;j<len;j++){
				numTable[i][j]=Integer.parseInt(args[i*len+j]);
			}
		}
		for (int i=0;i<len;i++){
			for (int j=0;j<len;j++){
				total+=numTable[i][j];
				if (numTable[i][j]<=min){min=numTable[i][j];}
				if (numTable[i][j]>=max){max=numTable[i][j];}
				if (i==j){leftDiagonal+=numTable[i][j];}
				if (i+j==totalLen-1){leftDiagonal+=numTable[i][j];}
			}
		}
		System.out.println("average "+total/totalLen);
		System.out.println("minimum "+min);
		System.out.println("maximum "+max);
		System.out.println("sum on both diagonals "+(leftDiagonal+rightDiagonal));
	}

	public static void columnRowSums(int height,int width){
		if (height<=0||width<=0){System.out.println("please input two integer bigger than 0");return;}
		int[][] numTable=new int[height][width];
		int[] rowSums=new int[height];
		int[] colSums=new int[width];
		for (int i=0;i<height;i++){
			for (int j=0;j<width;j++){
				numTable[i][j]=i*width+j;
			}
		}
		for (int i=0;i<height;i++){
			for (int j=0;j<width;j++){
				colSums[j]+=numTable[i][j];
				rowSums[i]+=numTable[i][j];
			}
		}
		for (int i=0;i<height;i++){System.out.println(i+1+" row sum is "+rowSums[i]);}
		for (int i=0;i<width;i++){System.out.println(i+1+" column sum is "+colSums[i]);}
	}
	
	/*
	 * Pascal's triangle, an n-by-n 2D array has the binomial coefficient c ij for its element at row i
	 * and column j (j<=i). Each interior number in the triangle is the sum of the number directly
	 * above it and the number above and to the left
	 */
	public static void pascalTriangle(int n){
		if (n<=0){System.out.println("please enter the size bigger than zero");return;}
		int[][] numTable=new int[n][n];
		for (int i=0;i<n;i++) {numTable[i][0]=1;}//initialise the first column
		for (int i=1;i<n;i++){//start from second row
			for (int j=1;j<n;j++){//start from second column
				numTable[i][j]=numTable[i-1][j]+numTable[i-1][j-1];
			}
		}
		for (int i=0;i<n;i++){
			for (int j=0;j<n;j++){
				if (numTable[i][j]!=0) {
					if (numTable[i][j]>=10){System.out.print(numTable[i][j] + "  ");
					}else{System.out.print(numTable[i][j] + "   ");}
				}
			}
			System.out.println();
		}
	}

	public static void countLetter(String str){
		
	}

	public static void main(String[] args) {
//		reversedOrder(args);
//		basicStatistics(args);
//		columnRowSums(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
//		System.out.println("please enter the size for a Pascal Triangle(bigger than zero):");
//		java.util.Scanner sc = new java.util.Scanner(System.in);
//		pascalTriangle(Integer.parseInt(sc.nextLine()));
//		sc.close();
	}

}
