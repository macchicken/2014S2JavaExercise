package tutorial;

import java.util.HashMap;

public class Tutorial2Week3 {
	
	private static final int scissors=0;
	private static final int paper=1;
	private static final int rock=2;
	private static final int lizard=3;
	private static final int spock=4;
	private static HashMap<String,Integer> mapper=new HashMap<String,Integer>(){
		{put("scissors",scissors);
		put("paper",paper);
		put("rock",rock);
		put("lizard",lizard);
		put("spock",spock);}
	};


	public static void printEven(int num){
		boolean result=false;
		if (num%2==0){result=true;}
		if (result){
			System.out.println(num+" is even number");
		}else{
			System.out.println(num+" is odd number");
		}
	}
	
	public static void gradeClassification(int mark){
		String grade="";
		if (mark>=85&&mark<=100){grade="HD";}
		else if (mark>=75&&mark<=84){grade="D";}
		else if (mark>=65&&mark<=74){grade="C";}
		else if (mark>=50&&mark<=64){grade="P";}
		else{grade="F";}
		System.out.println("the grade is "+grade);
	}
	
	public static void healthAssessment(double mass,double height){
		double bmi=mass/(height*height);
		String health="";
		if (bmi<18.5){health="Underweight";}
		else if(bmi>=18.5&&bmi<25){health="Normal weight";}
		else if(bmi>=25&&bmi<30){health="Overweight";}
		else{health="Obese";}
		System.out.println("you are "+health);
	}
	
	public static void ConvertGrade(String grade){
		String markRange="";
		if ("H".equals(grade)){markRange="85！100";}
		else if ("D".equals(grade)){markRange="75！84";}
		else if ("C".equals(grade)){markRange="74！65";}
		else if ("P".equals(grade)){markRange="64！50";}
		else if ("F".equals(grade)){markRange="49！0";}
		System.out.println("mark range is "+markRange);
	}
	
	public static int Factorial(int num){
		if (num>=1){
			int result=1;
			for (int i=2;i<=num;i++){result*=i;}
			return result;
		}
		return 0;
	}
	
	public static void printRectangle(int height,int width){
		if (height>0&&width>0){
			for (int i=0;i<height-1;i++){
				System.out.print(appendStr("* ",width-1));
				System.out.print("*\n");
			}
			System.out.print(appendStr("* ",width-1));
			System.out.print("*");
		}
	}
	
	public static void rockPaperScissorsGame(String userInput){
		int computer=new java.util.Random().nextInt(5);
		Integer user=mapper.get((userInput.trim()).toLowerCase());
		if (user!=null){
			String result="lose";
			switch(user.intValue()){
				case rock:
					if (computer==scissors||computer==lizard){result="win";}
					else if(computer==rock){result="draw";}
					break;
				case paper:
					if (computer==rock||computer==spock){result="win";}
					else if(computer==paper){result="draw";}
					break;
				case scissors:
					if (computer==paper||computer==lizard){result="win";}
					else if(computer==scissors){result="draw";}
					break;
				case lizard:
					if (computer==paper||computer==spock){result="win";}
					else if(computer==lizard){result="draw";}
					break;
				case spock:
					if (computer==scissors||computer==rock){result="win";}
					else if(computer==spock){result="draw";}
					break;
				default:
					break;
			}
			System.out.println("you "+result);
		}else{
			System.out.println("unregonize user input "+userInput);
		}
	}
	
	public static void printPyramid(int num){
		if (num%2==0){System.out.println("must be odd integer");}
		else{
			int n=1;
			String str="*";
			String space=appendStr(" ",(num-n)/2);
			do{
				System.out.println(space+str+space);
				n+=2;
				str=appendStr("*",n);
				space=appendStr(" ",(num-n)/2);
			}while(n<=num);
		}
	}

	private static String appendStr(String str,int num){
		String result="";
		for (int i=0;i<num;i++){result+=str;}
		return result;
	}

	public static void main(String[] args){
//		printRectangle(Integer.parseInt(args[0]),Integer.parseInt(args[1]));
//		java.util.Scanner sc = new java.util.Scanner(System.in);
//		System.out.println("Please enter your choice(scissors, paper, rock, lizard, or Spock)");
//		rockPaperScissorsGame(sc.nextLine());
//		sc.close();
		printPyramid(Integer.parseInt(args[0]));
	}
}
