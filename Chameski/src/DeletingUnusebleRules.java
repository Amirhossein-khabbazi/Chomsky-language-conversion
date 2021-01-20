import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class DeletingUnusebleRules {
	private String path ="";
	private String format="";
	private String name="";
	private String Varibles[] = new String[2000];
	private int cV=0;
	private String VGrammer[] = new String[2000];
	private int cVG=0; 
	private int found = 0;
	
	public DeletingUnusebleRules(String path , String name , String format) throws FileNotFoundException{
		this.path = path;
		this.name = name;
		this.format=format;
		setVaribles();
		Start();
		Print();
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
	
	
	private void Start() {
		String checkVar ="";
		int varPath =1;int path =0;
		while (varPath < this.cV) {
			checkVar = this.Varibles[varPath];
			path = thisVarPath(checkVar);
			check(path ,checkVar);/////////////////////////////////////////////////////////
				
		
			varPath++;
		}
		
		
	}
	
	private void check(int varPath , String var) {
		int i=0;String grammer="";int k=0;
		while(i < this.cVG){
			if(varPath != i) {
				grammer = this.VGrammer[i];
				if(checkgrammrt(var , grammer)==true) {
					k++;
				}
			}
			
			i++;
		}
		if(k==0) {
			this.Varibles[varPath] = "";
			this.VGrammer[varPath]="";
		}
	}
	
	private boolean checkgrammrt(String var , String grammer) {
		int i=0;boolean has=false;
		while(i < grammer.length()) {
			if(grammer.charAt(i) == var.charAt(0)) {
				
				has = true;
				i++;
				break;
			}
			i++;
		}
		
		return has;
	}
	
	
	
	private int thisVarPath(String var) {
		int i=0;int path=0;
		while(i<this.cV) {
			if(this.Varibles[i].equals(var))
			{
				path = i;
				break;
			}
			i++;
		}
		return path;
	}
	
	
	
	private void Print() throws FileNotFoundException {
		PrintWriter bic = new PrintWriter(this.path);
		String helper ="";int p=0;int g=0;
//		Trim();
		for(int i =0; i< this.cVG ; i++) {
			if(this.Varibles[i].equals(""))
				continue;
			helper += this.Varibles[i]+"->" + this.VGrammer[i];
			helper += "\n";
		}
		helper.trim();
		bic.write(helper);
		bic.close();
//		System.out.println(helper);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
