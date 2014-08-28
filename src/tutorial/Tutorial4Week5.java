package tutorial;

import java.util.Calendar;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Pattern;

import dto.Person;

public class Tutorial4Week5 {
	
	private static String paragraph="Write a program to check whether an input date matches the format of ¡°(d)d-(m)m-(yy)yy¡±. If\n"+
								"an input date matches the format, display ¡°true¡± on the console; otherwise display ¡°false¡±.\n"+
								"For example: an input date 11-07-2014 or 2-2-14 matches the format, and ¡°true¡± will be\n"+
								"displayed on the console as the output.";


	public static void personInfo(){
		String firstname="",surname="",dateOfBirth="";
		System.out.println("please input your first name");
		Scanner sc=new Scanner(System.in);
		firstname=sc.nextLine();
		System.out.println("please input your surname");
		surname=sc.nextLine();
		System.out.println("please input your date of birth in a format of dd,mm,yyyy");
		dateOfBirth=sc.nextLine();
		sc.close();
		Person person=new Person(firstname, surname, dateOfBirth);
		Calendar dob=Calendar.getInstance();
		dob.setTime(person.getDateOfBirth());
		System.out.println(person.getFirstname() + " " + person.getSurname()
				+ " was born on " + dob.get(Calendar.DAY_OF_MONTH) + " "
				+ dob.get(Calendar.MONTH) + " "
				+ dob.get(Calendar.YEAR));
	}

	
	public static void dataEntry(){
		int arrLen=0;
		System.out.println("please enter a size of array bigger than zero");
		Scanner sc=new Scanner(System.in);
		try {
			arrLen=Integer.parseInt(sc.nextLine());
			if (arrLen<=0){
				System.out.println("please input a integer number bigger than zero");
				return;
			}
			String[] strArr=new String[arrLen];
			System.out.println("please enter some text for array,separate by a single space");
			String[] input=sc.nextLine().split(" ");
			for (int j=0;j<arrLen&&j<input.length;j++){
				strArr[j]=input[j];
			}
			System.out.println("retrive a text from the array by entering the index");
			int i=sc.nextInt();
			if (i>=arrLen){System.out.println("index beyond the array");return;}
			if (strArr[i]!=null) {
				System.out.println(strArr[i]);
			}else{
				System.out.println("no text found on index "+i+", possibly not giving a text before");
			}
		} catch (NumberFormatException e) {
			System.out.println("please input a integer number");
		}finally{sc.close();}
	}

	public static void displayInterest(int year,String[] args){
		if (args.length<2){System.out.println("please type 2 number in the command-line");return;}
		Scanner sc=new Scanner(System.in);
		try {
			double principle=sc.nextDouble();
			if (principle<=0){
				System.out.println("please enter a positive principle");
				return;
			}
			double interestRate=sc.nextDouble();
			if (interestRate<=0){
				System.out.println("please enter a positive interest rate");
				return;
			}
			double interest=0;
			double total=0;
			for (int i=1;i<=year;i++){
				interest=principle*interestRate;
				total=principle+interest;
				System.out.println("Year " + i + "-principle: $" + principle
						+ " Interest: $" + interest+" Total: $"+total);
				principle=total;
			}
		} catch (InputMismatchException e) {
			System.out.println("please enter a proper double number");
		}finally{sc.close();}
	}

	
	public static void countWords(){
		System.out.println("type some text");
		Scanner sc=new Scanner(System.in);
		String text=sc.nextLine();
		sc.close();
		sc=new Scanner(text);
		String word="";
		int i=0;
		while(sc.hasNext()){
			word=sc.next().replaceAll("[.,?;]*", "");
			if (word.length() <= 4) {
				if (i>0){System.out.print("|");}
				System.out.print(word);
				i++;
			}
		}
		sc.close();
	}

	public static void countWordsInParagraph(String paragraph,String gWord){
		Scanner sc=new Scanner(paragraph);
		Scanner scLine;
		String line;
		int count=0;
		while(sc.hasNextLine()){
			line=sc.nextLine();
			scLine=new Scanner(line);
			while(scLine.hasNext()){
				if (gWord.equals(scLine.next().replaceAll("[.,?;]*", ""))){count++;}
			}
			scLine.close();
		}
		sc.close();
		System.out.println("the word '"+gWord+"' appear "+count+" times");
	}

	public static void patternMatching(String date){
		Pattern dateP = Pattern.compile("[0-9]{1,2}-[0-9]{1,2}-[0-9]{2,4}");
		System.out.println(dateP.matcher(date).matches());
	}


	public static void main(String[] args) {
//		personInfo();
//		dataEntry();
//		displayInterest(10,args);
//		countWords();
//		countWordsInParagraph(paragraph,"the");
		patternMatching("2-2-14");
	}

}
