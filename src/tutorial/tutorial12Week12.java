package tutorial;

import java.util.Arrays;

public class tutorial12Week12 {

	// greatest common divisor
	public static int GCD(int p, int q) {
		if (q == 0) return p;
		else return GCD(q, p % q);
	}
	
	public static int power(int base, int exponent) {
		if (exponent==0){return 1;}
		return base * power(base, exponent - 1);
	}
	
	public static int seriesFn(int n){
		if (n==1){return 1;}
		return n*n+seriesFn(n-1);
	}
	
	public static double minimum(double[] arr,double x,int start){
		double min=arr[start]<=x?arr[start]:x;
		if (start==arr.length-1){return min;}
		start++;
		return minimum(arr, min, start);
	}

	public static int[] merge(int[] left, int[] right) {
		int l = 0, r = 0;
		int i = 0;
		int[] result = new int[left.length + right.length];
		while (l < left.length && r < right.length) {
			if (left[l] < right[r]) {
				result[i] = left[l];
				l++;
			} else {
				result[i] = right[r];
				r++;
			}
			i++;
		}
		if (l < left.length) {
			for (; l < left.length; l++) {
				result[i++] = left[l];
			}
		} else if (r < right.length) {
			for (; r < right.length; r++) {
				result[i++] = right[r];
			}
		}
		return result;
	}

	/**
	 * find a given target value in an array
	 * checking the middle value and recursively reducing the array
	 * into two halves and checking the left half if the target is less than the middle value, 
	 * or the right half if the target is greater than the middle value
	 * @param arr sorted in ascending order
	 * @param target
	 * @return the index of the value if found or -1 if not found
	 */
	public static int findValue(int[] arr,int target){
		return findValueInetnal(arr,target,0);
	}
	private static int findValueInetnal(int[] arr,int target,int increment){
		int len=arr.length;
		if (len>0){
			int pivot=len/2;int middle=arr[pivot];
			if (len==1){return target==middle?0:-1;}
			if (target==middle){return increment+pivot;}
			if (target<middle){return findValueInetnal(Arrays.copyOfRange(arr, 0,pivot),target,increment);}
			if (target>middle){return findValueInetnal(Arrays.copyOfRange(arr, pivot,len),target,increment+pivot);}}
		return -1;
	}
	

	public static int[] mergeSort(int[] arr) {
		// base case:
		if (arr.length < 2) return arr;
		// divide into halves
		int pivot = arr.length / 2;
		int[] left = new int[pivot];
		int[] right = new int[arr.length - pivot];
		for (int l = 0; l < left.length; l++) {
			left[l] = arr[l];
		}
		for (int r = 0; r < right.length; r++) {
			right[r] = arr[pivot + r];
		}
		// sort the two halves recursively
		left = mergeSort(left);
		right = mergeSort(right);
		// merge the sorted halves into one sorted array
		return merge(left, right);
	}

	/**
	 * drawing a database tree
	 * @param X the number of node for each sub-tree
	 * @param x0 the x coordinate of the root
	 * @param y0 the y coordinate of the root
	 * @param stemLength
	 * @param theta the degree for the stem would bend to
	 */
	public static void dbt(int X, double x0, double y0, double stemLength,
			double theta) {
		if (X > 0) {
			double x1 = x0 + stemLength * Math.cos(theta);
			double y1 = y0 + stemLength * Math.sin(theta);
			StdDraw.line(x0, y0, x1, y1); // root stem
			dbt(X - 1, x1, y1, 0.75 * stemLength, theta * Math.random());
			dbt(X - 1, x1, y1, 0.75 * stemLength, theta + (Math.PI - theta)* Math.random());
		}
	}


	public static void main(String[] args) {
//		dbt(10, 0.5, 0.0, 0.25, 0.5*Math.PI);
//		System.out.println(power(7,3));
//		System.out.println(seriesFn(3));
//		double[] arr={2.0,3.0,1.0,-100.0};
//		System.out.println(minimum(arr,arr[0],0));
		int[] intArr={1,2,4,6,7,9};
		System.out.println(findValue(intArr,1));
		System.out.println(findValue(intArr,2));
		System.out.println(findValue(intArr,3));
		System.out.println(findValue(intArr,4));
		System.out.println(findValue(intArr,5));
		System.out.println(findValue(intArr,7));
	}

}
