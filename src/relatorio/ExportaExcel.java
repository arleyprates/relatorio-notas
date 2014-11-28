package relatorio;

import java.io.File;
import java.io.IOException;
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
		
		for(int i = 0; i < linhas; i++){			
			
			Cell a1 = sheet.getCell(0,i);
			String as1 = a1.getContents();
			
			if (as1.equals("1")){
				a = true;
			}
				
			if (a){
				Cell a2 = sheet.getCell(1,i);
				String as2 = a2.getContents();
				//instancia matricula
				Cell a3 = sheet.getCell(2,i);
				String as3 = a3.getContents();
				//instancia nome
				Cell a4 = sheet.getCell(3,i);
				String as4 = a4.getContents();
				
				Cell a5 = sheet.getCell(4,i);
				String as5 = a5.getContents();
				
				System.out.println("Matricula:" +  as2);
				System.out.println("Nome:" +  as3);
				System.out.println("Nota:" +  as4);
				System.out.println("Nota:" +  as5);
			}
						
		}
		
		workbook.close();
	
	}
	
}