import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class Methods  {
	
	public void AddSplit (String address) throws FileNotFoundException {
		File file = new File(address);
		Scanner sc = new Scanner(file);
		String helper = ""; int i=0; String Line="";
		while(sc.hasNextLine()) {
			Line=sc.nextLine();
			helper += Line;
			
			if(helper.charAt(helper.length() -1) != '|')
				helper += "|";
			
			helper += "\n";
			Line="";
		}
		sc.close();
		PrintWriter bic = new PrintWriter(file);
		bic.write(helper);
		bic.close();
	//	return helper;
	}
	
	
	//------------------------------------------------------------------------------------

	//number of lines
	public int getLineNumber(String address) throws FileNotFoundException {
		delNull(1 , 1);
		File Grammer = new File (address);
		Scanner sc = new Scanner(Grammer);
		int n=0;String line ="";
		while (sc.hasNextLine())
		{
			n++;
			line = getLine(n, address);
			if(line.equalsIgnoreCase(" ")) {
				n--;
				break;	
			}
			 
			 sc.nextLine();
//			
		}
		sc.close();
		return n;
	}
	//------------------------------------------------------------------------------------
	
	
	
	public void getVar(String address) throws FileNotFoundException {
		File Grammer = new File (address);
		Scanner sc = new Scanner(Grammer);
		String help="";String var="";int i=0;
		while(sc.hasNextLine())
		{
			help =""; i=0;var="";
			help +=sc.nextLine();
			while(help.charAt(i) != '>') {
				var+=help.charAt(i);
				i++;
			}
			RUNclass.var[RUNclass.cv++] = var;
			//sc.nextLine();
		}
		sc.close();
	}
	
	
	
	//------------------------------------------------------------------------------------
	//Get a special line
	public String getLine (int line , String address) throws FileNotFoundException {
		File Grammer = new File (address);
		Scanner sc = new Scanner(Grammer);
		
		int cout =1;
		String help =""; int i=0;
		int n=1;String Line ="";
		while (sc.hasNextLine())
		{
			if(cout == line)
			{
				Line+= sc.nextLine();
				break;
			}
			sc.nextLine();
			cout++;
		}
		sc.close();
		
		if(Line.equalsIgnoreCase(""))
			return " ";
		while(Line.charAt(i) != '>')i++;
		i++;
		
		help=Line.substring(i);
		return help;
	}
	//------------------------------------------------------------------------------------
	//get the number of parts in line
	public int getPartNumber(int lineNumber ,String address) throws FileNotFoundException{
		String line = getLine(lineNumber ,  address);
		int length = 0;int counter = 0;
		while (length < line.length()) {
			if(line.charAt(length) == '|')
			{
				counter++;
			}
			length++;
		}
		return counter;
	}
	//------------------------------------------------------------------------------------
	//get a spesial part in the line
	public String getPart (int line , int part , String address) throws FileNotFoundException {
		String theLine = getLine(line , address);
		
		int counter = 1;int i=0;String thePart = "";
		if (part == 1) {
			while(theLine.charAt(i) != '|'){
				thePart += theLine.charAt(i);
				i++;
			}
		}
		else {
			i=0;
			while(i < theLine.length()) {
				if(counter == part)
					break;
				if(theLine.charAt(i) == '|')
					counter++;
				i++;
			}
			while(theLine.charAt(i) != '|') {
				thePart += theLine.charAt(i);
				i++;
			}
		}
		return thePart;
	}
	//------------------------------------------------------------------------------------

	//check the part and make standard
	public void makeStandard (int line , int part) throws FileNotFoundException {
		String thePart = getPart(line, part , ALGORITMES.sTest);
		String help="";
		//حال اگر پارت طولش بیشتر از دو باشد
		RUNclass.Svar[0]="";
		int count = thePart.length();
		if(thePart.length()==1)
		{
			if(thePart.charAt(0) >= 97 && thePart.charAt(0) <= 122) {
				RUNclass.mainVar[RUNclass.cm] += thePart.charAt(0) +" ";
			}
			
		}
		
		if(thePart.length() > 1) {

			for(int i =0; i<count ;i++) {
				if(thePart.charAt(i) >= 97 && thePart.charAt(i) <= 122) {
					help = "B_" + thePart.charAt(i) +"->" + thePart.charAt(i);
					if (found(help) == false) {
						RUNclass.Svar[RUNclass.cs] += "B_" + thePart.charAt(i) +"->" + thePart.charAt(i);
						RUNclass.cs++;
					}
					RUNclass.mainVar[RUNclass.cm] += "B_" + thePart.charAt(i) +" ";

					
				}
				else {
					RUNclass.mainVar[RUNclass.cm] += thePart.charAt(i) +" ";
				}
			
		}
		
		}
		RUNclass.mainVar[RUNclass.cm] +="| ";

		return;
		
	}
	//------------------------------------------------------------------------------------
	
	//hazf gavanin yekke
	
	//------------------------------------------------------------------------------------

	
	public void delNull(int l , int p) {
		if(l==1) {
			for(int i=0 ; i<1000 ; i++) {
				RUNclass.mainVar[i]="";
			}
			RUNclass.cm=0;
		}
		if(p==1) {
			for(int i=0 ; i<1000 ; i++) {
				RUNclass.Svar[i]="";
			}
			RUNclass.cs=0;
	
		
		}
		
	}
	//------------------------------------------------------------------------------------

	public boolean found (String part) {
		boolean found = false;
		for (int i=0; i<RUNclass.cs ; i++) {
			if(RUNclass.Svar[i].equalsIgnoreCase(part)) {
				found = true;
				break;
			}
		}
		return found;
	}
	//------------------------------------------------------------------------------------

	public void printMainVar() {
		for (int i = 0 ; i<RUNclass.cm; i++) {
			RUNclass.Answer+=RUNclass.var[i] + ">" + " ";
			RUNclass.Answer+=RUNclass.mainVar[i];
			RUNclass.Answer+="\n";
		}
	}
	//------------------------------------------------------------------------------------
	
	public void printSVar() {
		for (int i = 0 ; i<RUNclass.cs; i++) {
			RUNclass.Answer+=RUNclass.Svar[i];
			RUNclass.Answer+="\n";
		}
	}
	//------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------
	//------------------------------------------------------------------------------------


	
	//------------------------------------------------------------------------------------
	public void makeVar (int line , int part) throws FileNotFoundException {
		ALGORITMES alg = new ALGORITMES();
		File FAnswer = new File (alg.sAnswer);
		Scanner sc = new Scanner(FAnswer);
		String thePart = getPart(line, part , ALGORITMES.sAnswer);
		String theLine = getLine(line , ALGORITMES.sAnswer);
		int partLength = partlength(thePart);
		//RUNclass.Answer += RUNclass.var[line - 1] + "->";
		if(partLength <= 2) {
			
			RUNclass.Answer += thePart + " | ";
		}
		else {
			String firstChar = getFirstChartOfPart(thePart);
			RUNclass.Answer += firstChar + " " + "D" + RUNclass.number + " | ";
			makeZvar(thePart);
			
			
		}
			
		}
		
	//------------------------------------------------------------------------------------
	
	public int partlength (String part) {
		
		int i = 0 ;int count = 0; String s=" ";
		while(i < part.length()) {
			if (part.charAt(i) == ' ')
				count++;
			i++;
		}
		
		return (count-1);
	}
	//------------------------------------------------------------------------------------
	public String getFirstChartOfPart (String part) {
		int i =1;String answer = "";
		while(part.charAt(i) != ' ')
		{
			answer += part.charAt(i);
			i++;
		}
		return answer;
	}
	//------------------------------------------------------------------------------------
	public String getChartOfPart (String part , int i) {
		String answer = "";
		if(i == part.length())
			return null;
		while(part.charAt(i) != ' ')
		{
			answer += part.charAt(i);
			i++;
		}
		return answer;
	}
	//------------------------------------------------------------------------------------
	public void makeZvar(String part){
		int partLength = partlength(part);
		int loop = partLength - 2;int x=1;String help ="";
		int i = 1;int go =1;
		while(go != 2) {
			
			if(part.charAt(i) == ' ')
				go++;
			i++;
		}

		String var = getChartOfPart(part , i);
		while(x < loop) {

//			go=0;
//			while(go != 2) {
//				
//				if(part.charAt(i) == ' ')
//					go++;
//				i++;
//			}

			
			help = "D" + "->" + part.substring(i);
			RUNclass.FZvar[RUNclass.Fcz++] = help;
			if(!(x==loop)) {
				RUNclass.Zvar[RUNclass.cz++] +="D" +RUNclass.number +  "->" + var + "D" + (RUNclass.number+1);
				RUNclass.number++;
			}
			else {
				RUNclass.Zvar[RUNclass.cz++] +="D" +RUNclass.number +  "->" + part.substring(i);
				RUNclass.number++;
			}
			
			//i+=2;
			while(part.charAt(i) != ' ')i++;
			i++;
			var = getChartOfPart(part , i);
			x++;
		}
		//RUNclass.number--;
		help = "D" + "->" + part.substring(i);
		RUNclass.FZvar[RUNclass.Fcz++] = help;
		RUNclass.Zvar[RUNclass.cz++] +="D" +RUNclass.number +  "->" + part.substring(i);
		RUNclass.number++;
	}
	
	public boolean foundZvar (String part) {
		boolean found = false;int d=0;
		for (int i=0; i<RUNclass.Fcz ; i++) {
			if(RUNclass.FZvar[i].equalsIgnoreCase(part)) {
				d++;
			}
		}
		if(d==2)
			found = true;

		return found;
	}
}



















