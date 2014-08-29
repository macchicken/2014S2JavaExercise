package tutorial;

public class Tutorial1Week2 {
	
	
	private static String generateElement(char c,int num){
		char[] arr=new char[num*2-1];
		for (int i=0;i<arr.length-2;i+=2){arr[i]=c;arr[i+1]=' ';}
		arr[arr.length-1]=c;
		return String.valueOf(arr);
	}

	public static void drawRectangle(int width,int height){
		String[] rectangle=new String[height];
		String temp=generateElement('*',width);
		rectangle[0]=temp;
		rectangle[height-1]=temp;
		String temp2=generateElement(' ',width-2);
		temp2="* "+temp2+" *";
		for (int i=1;i<height-1;i++){rectangle[i]=temp2;}
		for (String str:rectangle){System.out.println(str);}
		System.out.println("perimeter of this rectangle: "+(width+height)*2);
		System.out.println("area of this rectangle: "+(width*height));
		System.out.println("length of the diagonal: "+Math.sqrt((width*width+height*height)));
	}


	public static void main(String[] args) {
		drawRectangle(10,5);
	}

}
