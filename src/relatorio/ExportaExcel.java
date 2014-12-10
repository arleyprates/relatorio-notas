package relatorio;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class ExportaExcel {
	
	private String diretorioPlanilha;
	
	public ExportaExcel(String diretorioXLS){
		this.diretorioPlanilha = diretorioXLS;		
	}
	
	public ArrayList<Aluno> todosAlunos()  throws IOException, BiffException{
		
		Workbook workbook = Workbook.getWorkbook(new File(diretorioPlanilha));//Colocar o arquivo de excel correto
		
		Sheet sheet = workbook.getSheet(0);
		
		int linhas = sheet.getRows();
		boolean a = false;
		
		ArrayList<Aluno> arrayAluno = new ArrayList<Aluno>();
		
		Aluno tit = new Aluno();
			
		Cell t1 = sheet.getCell(0,0);
		String ts1 = t1.getContents();
		tit.setUniversidade(ts1);
		
		Cell t2 = sheet.getCell(0,5);
		String ts2 = t2.getContents();
		tit.setPeriodoLetivo(ts2);
		
		Cell t3 = sheet.getCell(0,6);
		String ts3 = t3.getContents();
		tit.setNumeroDisciplina(ts3);

		Cell t4 = sheet.getCell(0,7);
		String ts4 = t4.getContents();
		tit.setCargaHoraria(ts4);
			
		Cell t5 = sheet.getCell(2,5);
		String ts5 = t5.getContents();
		tit.setDisciplina(ts5);
			
		arrayAluno.add(tit);
		
		for(int i = 0; i < linhas; i++) {			
			
			Cell a1 = sheet.getCell(0,i);
			String as1 = a1.getContents();
			
			if (as1.equals("1")) {
				a = true;
			}
				
			if (a) {
				
				Aluno al = new Aluno();
				//Avaliacao av = new Avaliacao();
				//List<Avaliacao> arrayAvaliacao = new ArrayList<Avaliacao>();
				
				Cell a2 = sheet.getCell(1,i);
				String as2 = a2.getContents();
				al.setMatricula(Integer.parseInt(as2));				
				
				Cell a3 = sheet.getCell(2,i);
				String as3 = a3.getContents();
				al.setNome(as3);
				
				Cell a4 = sheet.getCell(3,i);
				String as4 = a4.getContents();
				
				//av.setNota(Float.parseFloat(as4));				
				
				al.setAvaliacao(as4, 0);
				//arrayAvaliacao.add(av);
				
				
				Cell a5 = sheet.getCell(4,i);
				String as5 = a5.getContents();
				//av.setNota(Float.parseFloat(as5));
				
				al.setAvaliacao(as5, 1);
				
				
				Cell a6 = sheet.getCell(5,i);
				String as6 = a6.getContents();
				//av.setNota(Float.parseFloat(as6));
				
				al.setAvaliacao(as6, 2);
				
				
				Cell a7 = sheet.getCell(6,i);
				String as7 = a7.getContents();
				//av.setNota(Float.parseFloat(as7));
				
				al.setAvaliacao(as7, 3);
				
				
				Cell a8 = sheet.getCell(7, i);
				String as8 = a8.getContents();
				
				al.setAvaliacao(as8, 4);
				
				
				Cell a9 = sheet.getCell(8, i);
				String as9 = a9.getContents();
				
				al.setAvaliacao(as9, 5);
				
				
				Cell a10 = sheet.getCell(9,i);
				String as10 = a10.getContents();
				al.setMedia(as10);		
				
				
				System.out.println(al.getAvaliacao(0));
				System.out.println(al.getAvaliacao(1));
				System.out.println(al.getAvaliacao(2));
				System.out.println(al.getAvaliacao(3));
				System.out.println(al.getAvaliacao(4));
				System.out.println(al.getAvaliacao(5));
			
				//arrayAvaliacao.add(av);
				
				//Aluno aluno = new Aluno(as3, Integer.parseInt(as2), arrayAvaliacao);
				
				//al.setAvaliacao(arrayAvaliacao);				
				
				arrayAluno.add(al);
		
			}
						
		}
		
		//for (Aluno value : arrayAluno){
			//System.out.println(value.getMatricula());
			//System.out.println(value.getNome());
			//for (Avaliacao x : value.getAvaliacao()){
				//System.out.println(x.getNota());
			//}//
		//}
		
		System.err.println("Total de Alunos Importados: " + arrayAluno.size());
		workbook.close();
		
		return arrayAluno;
	}
	
}
