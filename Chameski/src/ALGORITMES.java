import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

public class ALGORITMES {
	public static String sAnswer ;
	public static String sTest = "C:\\MyWorckSpace//Test.txt";
	
	
   
	
	public void runChameski () throws IOException {
		System.out.println("The Trash-File.txt location: "+sAnswer);
		
		Methods test = new Methods();
		RUNclass.FAnswer ="";
		File Answer = new File (sAnswer);
		Answer.createNewFile();
		PrintWriter bic = new PrintWriter(Answer);
		test.getVar(sTest);	
		int lineNumber = test.getLineNumber(sTest);		
		for(int line = 1 ; line<= lineNumber /*lineNumber*/ ; line++)
		{
			int partNumber = test.getPartNumber(line,sTest);
			for (int part = 1 ; part <= partNumber ; part++)
			{
				 test.makeStandard(line, part);
			}//for of parts
			RUNclass.cm++;
		}//for of lines
		test.printMainVar();
		test.printSVar();
		bic.write(RUNclass.Answer);
		bic.close();
		RUNclass.Answer = "";
		for(int l=0;l<RUNclass.Zvar.length;l++)
			RUNclass.Zvar[l]="";
		String saveSvar=saveSvar();	
		RUNclass.cm = 0;
		int FlineNumber = test.getLineNumber(sAnswer);		
		for(int line = 1 ; line<= FlineNumber /*lineNumber*/ ; line++)
		{	
			RUNclass.Answer = "";
			int FpartNumber = test.getPartNumber(line , sAnswer);
			for (int part = 1 ; part <= FpartNumber ; part++)
			{
				 test.makeVar( line , part);
			}//for of parts
			RUNclass.mainVar[RUNclass.cm] = RUNclass.Answer;
			RUNclass.cm++;		
		}//for of lines
		
		
		
		System.out.println("The Grammer is: ");
		for(int l=0;l<RUNclass.cm;l++)
		{
			System.out.print(RUNclass.var[l] +""+ ">");
			System.out.println(RUNclass.mainVar[l]);
			RUNclass.FAnswer +=RUNclass.var[l] +""+ ">";
			RUNclass.FAnswer +=RUNclass.mainVar[l];
			RUNclass.FAnswer +="\n";
		}
		System.out.println();	
		System.out.println(saveSvar);
		RUNclass.FAnswer +=saveSvar;
		RUNclass.FAnswer +="\n";
		for(int l=0;l<RUNclass.cz;l++) {
			System.out.println(RUNclass.Zvar[l]);
			RUNclass.FAnswer +=RUNclass.Zvar[l];
			RUNclass.FAnswer +="\n";
		}
		
		String path = Answer.getCanonicalPath();
		File filePath = new File(path);
		filePath.delete();
		int input =0;
		System.out.println();
		while (true) {
			

			  input = JOptionPane.showConfirmDialog(null, "Do you like to save answer? \n if you dont you can see in consol");
			if(input==0)
			{
				
				
				
		        FileDialog dialog = new FileDialog((Frame)null, "Select Directory to save");
			    dialog.setMode(FileDialog.SAVE);
			    dialog.setVisible(true);
			    String file = dialog.getFile();
			    
			    String address = dialog.getDirectory();
//		        
		        
				File saveAnswer = new File (address +file + ".txt");
				saveAnswer.createNewFile();
				PrintWriter sc = new PrintWriter(saveAnswer);
				sc.write(RUNclass.FAnswer);
				sc.close();
				 JOptionPane.showMessageDialog(null,"The answer has saved \n please select ok","alert",3);
				break;
			}
			else if(input == 1) {
				break;
			}
			else {
				break;
			}
		}
		System.exit(0);
		

	}
		
		


	
	
	public void runGraibajh () throws FileNotFoundException{
		System.out.println("not complet");
	}
	
	public void Grammer () throws FileNotFoundException{
		System.out.println("not complet");
	}
	public String saveSvar() {
		String s ="";int i=0;
		while(i < RUNclass.cs) {
			s+=RUNclass.Svar[i];
			s+="\n";
			i++;
		}
		return s;
	}
}




