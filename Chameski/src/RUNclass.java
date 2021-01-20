import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class RUNclass {
	public static String mainVar[] = new String[1000];
	public static int cm = 0;
	public static String Svar[] = new String[1000];
	public static int cs = 0;
	public static String var[] = new String[1000];
	public static int cv = 0;
	public static String Answer = "";
	public static String FAnswer = "";
	public static String Zvar[] = new String[1000];
	public static int cz = 0;
	public static int number = 1;
	public static String FZvar[] = new String[1000];
	public static int Fcz = 0;

	public static void main(String[] args) throws IOException {
		String path = "";
		String trash = "";

		ALGORITMES chameski = new ALGORITMES();
		final JPanel panel = new JPanel();
		String file = "";
		String format = "";
		while (true) {
			JFileChooser chooser = new JFileChooser();

			FileDialog dialog = new FileDialog((Frame) null, "Select txt File to Open");
			dialog.setMode(FileDialog.LOAD);
			dialog.setVisible(true);
			file = dialog.getFile();

			path = dialog.getDirectory();
			trash = path;

			int i = 0;
			format = "";
			if (file == null) {
				JOptionPane.showMessageDialog(null, "You choose nothing \n Program is terminetade", "error", 2);
				System.exit(0);

			}
			while (i < file.length()) {
				if (file.charAt(i) == '.')

					break;
				i++;
			}
			i++;
			format = file.substring(i);
			if (!format.equalsIgnoreCase("txt")) {
				JOptionPane.showMessageDialog(panel, "please choose a txt file", "Alert", JOptionPane.ERROR_MESSAGE);

				continue;
			} else {
				System.out.println("programmer : Amirhoseyn.K.Khabbazi");
				System.out.println("Email : sptamirhoseyn@gmail.com");
				System.out.println("-_-_-_-_-__-_-_-__-_-_-__-_-_-__-_-_-__-_-_-__-_-_-__-_-_-_");
				System.out.println();
				path += file;
				ALGORITMES.sTest = path;
				Methods t = new Methods();
				Trim(path);
				t.AddSplit(path);
				System.out.println("Your file location: " + path);

				break;
			}

		}

		ALGORITMES.sAnswer = trash + "\\Trash-File.txt";
		DeletingLambeda L = new DeletingLambeda(path, file, format);
		TheRulesAreTheSame T = new TheRulesAreTheSame(path, file, format);
		DeletingUnusebleRules U = new DeletingUnusebleRules(path, file, format);
		chameski.runChameski();
		File file1 = new File(trash + "\\Trash-File.txt");
		file1.delete();

//		ALGORITMES GribaKh = new ALGORITMES();
//		Graibajh.runGraibajh();
//		
//		
//		
//
//		ALGORITMES Grammer = new ALGORITMES();
//		Grammer.Grammer();
	}

	private static void Trim(String problem) throws FileNotFoundException {
		File file = new File(problem);
		Scanner sc = new Scanner(file);
		int i = 0;
		String Line = "";
		String helper = "";
		while (sc.hasNextLine()) {
			Line = sc.nextLine();
			if (Line.equals(""))
				continue;
			Line = Line.trim();
			if (Line.equals(""))
				continue;
			Line = fullTrim(Line);
			helper += Line;
			helper += "\n";
		}

		PrintWriter bic = new PrintWriter(file);
		bic.write(helper);
		bic.close();
	}

	private static String fullTrim(String Line) {
		int i = 0;
		String helper = "";
		while (i < Line.length()) {
			if (Line.charAt(i) == ' ') {
				i++;
			} else if (Line.charAt(i) != ' ') {
				helper += Line.charAt(i);
				i++;
			}

		}
		return helper;
	}

}
