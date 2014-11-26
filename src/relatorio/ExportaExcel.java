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
		
		Workbook workbook = Workbook.getWorkbook(new File("c:/teste.xls"));//Colocar o arquivo de excel correto
		
		Sheet sheet = workbook.getSheet(0);
		
		int linhas = sheet.getRows();
				
			for(int i = 0; i < linhas; i++){
			
				Cell a1 = sheet.getCell(0,i);
				Cell a2 = sheet.getCell(1,i);
				Cell a3 = sheet.getCell(2,i);			
				String as1 = a1.getContents();
				String as2 = a2.getContents();
				String as3 = a3.getContents();
				System.out.println("Valor da Coluna 1:" +  as1);
				System.out.println("Valor da Coluna 2:" +  as2);
				System.out.println("Valor da Coluna 3:" +  as3);		
			}
					
		workbook.close();
	}
}
