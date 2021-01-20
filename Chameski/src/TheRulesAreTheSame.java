import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.sql.Array;
import java.util.Scanner;
public class TheRulesAreTheSame {
	private String path = "";
	private String name="";
	private String format = "";
	public String Varibles[] = new String[2000];
	public int cV=0; 
	public String VGrammer[] = new String[2000];
	public int cVG=0; 
	private int found = 0;
	
	private String Hide ="";
	
	private String remmeberD[] = new String[2000];
	private int cr=0; 
	private String remmeberRemove[] = new String[2000];
	private int crr=0; 
	
	public TheRulesAreTheSame() {
		
	}
	public TheRulesAreTheSame(String path , String name , String format) throws FileNotFoundException {
		this.path = path;
		this.name = name;
		this.format = format;
		setVaribles();
		Start();
		
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
	
	
	
	private void Print() throws FileNotFoundException {
		PrintWriter bic = new PrintWriter(this.path);
		String helper ="";int p=0;int g=0;
//		Trim();
		for(int i =0; i< this.cVG ; i++) {
			helper += this.Varibles[i]+"->" + this.VGrammer[i];
			helper += "\n";
		}
		helper.trim();
		bic.write(helper);
		bic.close();
//		System.out.println(helper);
	}
	
	
	private void Trim() {
		int i=0;int j=0;
		while(i < this.cVG)
		{
			String helper = "";
			while(j < this.VGrammer[i] .length())
			{
				if(this.VGrammer[i].charAt(j) == ' ')
				{
					j++;
					continue;
				}
				helper += this.VGrammer[i].charAt(j);
				j++;
				
			}
			this.VGrammer[i] = helper;
			i++;
		}
		
	}
	
	
	
	private void Start() throws FileNotFoundException {
		File file = new File(this.path);
		Scanner sc = new Scanner (file);
		String Line = "";int line = 0;
		for(int f=0;f<this.remmeberD.length;f++)
			this.remmeberD[f] ="";
		while(sc.hasNextLine()) {
			Line = sc.nextLine();
			getPart(Line , line);
			line++;
		}
		line =0;
		for(int f=0;f<this.remmeberD.length;f++)
			this.remmeberD[f] ="";
		this.cr=0;
		Print();
		reapide(path);
		Print();	
	}
	
	private void reapide(String address ) throws FileNotFoundException {
		File file = new File(address);
		int line =0;String Line = "";
		Scanner sc = new Scanner(file);
		while(sc.hasNextLine()) {
			Line = sc.nextLine();
			delRip(Line, line);
			line++;
		}
	
	}	
	
	private void delRip(String Line , int line) {

		for(int i=0 ; i<this.cr;i++)
			this.remmeberD[i] ="";
		this.cr=0;
		int i=0;
		while(Line.charAt(i) != '>')i++;
		i++;
		Line = Line.substring(i);
		i=0;
		while(i < Line.length()) {
			if(Line.charAt(i) == '|')
			{
				i++;
				this.cr++;
			}
			else {
				this.remmeberD[this.cr] += Line.charAt(i);
				i++;
			}
		}
		String s="";int k=0;
		k=0;String answer ="";
		for(int q=0;q<this.cr;q++)
		{

			s = remmeberD[q];
			for(int w=q+1;w<this.cr;w++) {
				if(remmeberD[q].equals(remmeberD[w]))
					 remmeberD[w]="";
			}
			
		}
		
		for(int i1=0 ; i1<this.cr;i1++)
			if( remmeberD[i1] != "")
				answer +=  remmeberD[i1] + "|";
		this.VGrammer[line] = answer;
//		System.out.println(this.VGrammer[line]);
		
		
	}
	
	
	
	

	private void getPart(String Line , int line) throws FileNotFoundException {
		Methods t = new Methods();
//		if(line >= 1)
//			System.out.println(this.VGrammer[(line - 1)]);
		int linenumber = t.getLineNumber(this.path); 
		int i=0;
		while(Line.charAt(i) != '>')i++;
		i++;
		Line = Line.substring(i);
		i=0;String part = "";int k=0;
		this.remmeberD[line] = "";
			while(i < Line.length()) {
				part += Line.charAt(i);
				if(Line.charAt((i+1)) == '|') {
					if(part.length()==1 && (part.charAt(0) >= 64 && part.charAt(0) <= 90)) {
						if(found(part) == false)
						{
							String d=delete(part);
							this.remmeberD[line] += d;
							k++;
//							System.out.println(this.crr);
							this.remmeberRemove[this.crr++] = part;
							String Final = removeChar(Line,i);
							this.VGrammer[line] = Final;
//							System.out.println(line);
							Line = Final;
							i-=2;
//							System.out.println(this.VGrammer[line]);
//							System.out.println(line);
						}
						else
						{
							String Final = removeChar(Line,i);
							this.VGrammer[line] = Final;
//							System.out.println(this.found);
							Line = Final;
							i-=2;
//							System.out.println(this.VGrammer[line]);
//							System.out.println(line);
						}
						
					}
					if(i == (Line.length() - 2) && k>0)
					{
						k=0;
						this.VGrammer[line]+=this.remmeberD[line];
						Line += this.remmeberD[line];
						this.remmeberD[line]="";
					}
					part="";
					i++;
				}
				
				i++;

			}//while
			i=0;
			for(int f=0;f<this.remmeberRemove.length;f++)
				this.remmeberRemove[f] ="";
			//this.VGrammer[line]+=this.remmeberD[line];
			this.crr=0;
			this.remmeberRemove[this.crr] = this.Varibles[line+1];
			this.crr++;
		
	
//			System.out.println(this.Varibles[line]+"--->" + this.VGrammer[line]);
		

	}//method
	
	
	
	private boolean found(String part) {
		boolean found = false;
		for(int i=0;i<this.crr;i++) {
			if(this.remmeberRemove[i].equalsIgnoreCase(part))
			{
				found = true;
				break;
			}
		}
		return found;
			
		
	}
	
	
	
	
	
	
	private  String removeChar(String s, int c) {
	    String help = ""; 
	    String Final="";
	    int i =0;
	    while(i < c) {
	    	help += s.charAt(i);
	    	i++;
	    }
	    i+=2;
	    while(i < s.length()) {
	    	help += s.charAt(i);
	    	i++;
	    }
	    
	    return help;
	  }
	
	private String delete(String part) {
		this.found = 0;
		for(int i=0 ; i<this.cV;i++)
		{
			if(this.Varibles[i].equalsIgnoreCase(part))
			{
				this.found = i;
				break;
			}//if
		}//for
		String help = this.VGrammer[this.found];
		return help;
	}
	
	
	
	
	
	
	
	

}
