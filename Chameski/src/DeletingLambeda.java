import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DeletingLambeda {
	private String path = "";
	private String name="";
	private String format = "";
	private String Varibles[] = new String[2000];
	private int cV=0; 
	private String VGrammer[] = new String[2000];
	private int cVG=0; 
	private int lambeda =0;
	
	public DeletingLambeda(String path , String name , String format) throws FileNotFoundException {
		this.path = path;
		this.name = name;
		this.format = format;
		setVaribles();
		start();
	}
	
	private void Print() throws FileNotFoundException {
		PrintWriter bic = new PrintWriter(this.path);
		String helper ="";int p=0;int g=0;
//		Trim();
//		for(int i =0; i< this.cVG ; i++) {
//			Public.VGrammer[i] = this.VGrammer[i];
//			Public.Varibles[i] = this.Varibles[i];
//		}
//		Public.cV = this.cV;
//		Public.cVG = this.cVG;
//		for(int i =0; i< this.cVG ; i++) {
//			System.out.println(Public.VGrammer[i]);
//			System.out.println(Public.Varibles[i]);
//			System.out.println(i);
//		}
		
		for(int i =0; i< this.cVG ; i++) {
			helper += this.Varibles[i]+"->" + this.VGrammer[i];
			helper += "\n";
		}
		helper.trim();
		bic.write(helper);
		bic.close();
		//System.out.println(helper);
	}
	
	private void setVaribles () throws FileNotFoundException {
		File file = new File(this.path);
		Scanner sc = new Scanner (file);
		String var="" ; String help =""; int i=0;
		while(sc.hasNextLine())
		{
			help =""; i=0;var="";
			help +=sc.nextLine();
			while(help.charAt(i) != '-') {
				var+=help.charAt(i);
				
				i++;
			}
			int s=i;
			s+=2;
			help = help.substring(s);
			this.Varibles[this.cV++] = var;
			this.VGrammer[this.cVG++] = help;
		}
	}
	
	
	private void start() throws FileNotFoundException {
		File file = new File(this.path);
		Scanner sc = new Scanner(file);
		String Line = "";int line =0;int i=0;
		while(i < this.cVG)
		{
			Line = this.VGrammer[i];
			delelam(Line , line);
			line++;
			i++;
		}
		Print();
		
		
	}
	
	private void delelam(String Line , int line) throws FileNotFoundException {
		int i=0;
		
		
		for(int q=0; q<Line.length();q++) {
			if(Line.charAt(q) == '%')
			{
				deletLambeda(Varibles[line]);
			}
		}
	}
	
	
	private void deletLambeda(String var) throws FileNotFoundException {
		File file = new File(this.path);
		Scanner sc = new Scanner(file);int i=0;
		String Line = "";int line =0;
		while(i < this.cVG)
		{
			Line = this.VGrammer[i];
			deletLambeda2(Line , var , line);
			line++;
			i++;
		}
		
	}
	
	private void deletLambeda2(String Line , String var ,int line) {
		int i=0;
		String Final="";
		Line = Line.substring(i);
		i=0;String part="";
		while(i < Line.length()) {
			part += Line.charAt(i);
			if(Line.charAt((i+1)) == '|') {
				if(found(part , var) == true) {

						 Final=part.replaceAll(var, "");
						 Line+=Final + "|";
						Line = deletSplit(Line);

				}
				part="";
				i++;
			}
			
			i++;

		}//while
		String lam = "%";
		int home = del(var);
		if(home == line)
			Line = Line.replaceAll(lam, "");
		Line = deletSplit(Line);
		this.VGrammer[line] =Line;	
	}
	
	private int del(String var) {
		int home=-1;
		for(int i =0;i<this.cV;i++)
			if(this.Varibles[i].equals(var))
			{
				home=i;
				break;
			}
		return home;
	}
	
	
	private boolean found(String part , String var) {
		int i=0;boolean found = false;char s= var.charAt(0);
		while(i<part.length()) {
			if(part.charAt(i) == s)
			{
				found =true;
				break;
			}
			i++;
		}
		return found;
	}
	
	private String deletSplit(String Line) {
		int i=0;String helper="";
		while(i<Line.length()) {
			if(i!=Line.length()-1&&Line.charAt(i) == '|')
				if(Line.charAt(i+1) == '|')
				{
					i++;
					continue;
				}
			helper+=Line.charAt(i);
			i++;
		}
		return helper;
	}
	
}
