package mountainsSecret;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class DialogUtility {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter input file name:");
		String inputFileName = scan.nextLine();
		System.out.println("Enter output file name:");
		String outputFileName = scan.nextLine();
		scan.close();
		createOutputFile(inputFileName, outputFileName);
	}
	
	public static void createOutputFile(String input, String output) {
		File outputFile = new File(output);
		try {
			outputFile.createNewFile();
			BufferedWriter writer = new BufferedWriter(new FileWriter(output));
			Scanner fileScan = new Scanner(new File(input));
			int numConvos = Integer.parseInt(fileScan.nextLine());
			for (int i = 0; i < numConvos; i++) {
				HashMap<Integer, String> targets = new HashMap<>();
				boolean hasResponses = !fileScan.nextLine().contains("END");
				writer.write("public void conversation" + (i+1) + "()" + " {\n");
				writer.write("\tsay(\"" + fileScan.nextLine() + "\");\n");
				//System.out.println((i+1) + ": " + hasResponses);
				if (hasResponses) {
					writer.write("\tString[] responses = {\n");
					String line = fileScan.nextLine();
					while (!line.equals("#")) {
						writer.write("\t\"");
						int chr = 0;
						char check = line.charAt(chr);
						while (check != ">".charAt(0)) {
							writer.write(check);
							chr++;
							check = line.charAt(chr);
						}
						chr++;
						String targetStr = "";
						while (Character.isDigit(line.charAt(chr))) {
							targetStr += line.charAt(chr);
							chr++;
						}
						int targetNum = Integer.parseInt(targetStr);
						String targetResponse = "";
						while (chr < line.length()) {
							targetResponse += line.charAt(chr);
							chr++;
						}
						//System.out.println(targetNum + ": " + targetResponse);
						targets.put(targetNum, targetResponse);
						writer.write("\",\n");
						line = fileScan.nextLine();
					} // end while loop
					writer.write("\t};\n");
					writer.write("int choice = getResponse(responses);\n");
					writer.write("switch(choice) {\n");
					int caseNum = 1;
					for (Integer j : targets.keySet()) {
						//System.out.println(j);
						writer.write("case " + caseNum + ":\n");
						writer.write("\tsay(\"" + targets.get(j) + "\");\n");
						writer.write("\tdialogState = " + j + ";\n\tbreak;\n");
						caseNum++;
					}
					writer.write("default:\n\t");
					writer.write("say(\"Your speech baffles me.\");\n");
					writer.write("}\n");
				}
				else
					fileScan.nextLine();
				writer.write("}\n");
			} // end for loop
			writer.write("public void talk() {\n\tswitch(dialogState) {\n\t\t");
			for (int i = 0; i < numConvos; i++) {
				writer.write("case " + (i+1) + ":\n\t\t\t");
				writer.write("conversation" + (i+1) + "();\n\t\t\tbreak;\n");
			}
			writer.write("\t}\n}");
			writer.close();
			fileScan.close();
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	

}
