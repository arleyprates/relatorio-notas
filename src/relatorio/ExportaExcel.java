package relatorio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import jxl.Cell;
import jxl.NumberCell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

import javax.swing.JOptionPane;

public class ExportaExcel {
	
	public static void main(String[] args) throws IOException, BiffException {
		
		Workbook workbook = Workbook.getWorkbook(new File("files/planilha.xls"));//Colocar o arquivo de excel correto
		
		Sheet sheet = workbook.getSheet(0);
		
		int linhas = sheet.getRows();
		boolean a = false;
		
		ArrayList<Aluno> arrayAluno = new ArrayList<Aluno>();
		ArrayList<Avaliacao> arrayAvaliacao = new ArrayList<Avaliacao>();
		
		for(int i = 0; i < linhas; i++) {			
			
			Cell a1 = sheet.getCell(0,i);
			String as1 = a1.getContents();
			
			if (as1.equals("1")) {
				a = true;
			}
				
			if (a) {
				
				Aluno al = new Aluno();
				Avaliacao av = new Avaliacao();
				
				Cell a2 = sheet.getCell(1,i);
				String as2 = a2.getContents();
				al.setMatricula(Integer.parseInt(as2));				
				
				Cell a3 = sheet.getCell(2,i);
				String as3 = a3.getContents();
				al.setNome(as3);
				
				Cell a4 = sheet.getCell(3,i);
				String as4 = a4.getContents();
				av.setNota(Float.parseFloat(as4));				
				
				arrayAvaliacao.add(av);
				
				Cell a5 = sheet.getCell(4,i);
				String as5 = a5.getContents();
				av.setNota(Float.parseFloat(as5));				
				
				arrayAvaliacao.add(av);
				
				arrayAluno.add(al);
				
				al.setAvaliacao(arrayAvaliacao);
		
			}
						
		}
		
		workbook.close();
	
	}
	
}