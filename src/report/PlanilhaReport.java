package report;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.WindowConstants;

import relatorio.Aluno;
import relatorio.ExportaExcel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.view.JasperViewer;

import net.sf.jasperreports.engine.JasperExportManager;

public class PlanilhaReport {
	
	private String diretorioPDF;
	private JasperReport report;
	//private static final String pathSubRel = "report/subreport.jasper";
	
	public void Planilha(String diretorioXLS){
		try{
			String caminhoRelJasper = "planilha.jrxml";
			InputStream relJasper = getClass().getResourceAsStream(caminhoRelJasper);
			
			report = JasperCompileManager.compileReport(relJasper);

			PlanilhaDataSource planilhaDataSource = new PlanilhaDataSource(diretorioXLS);
			
			JasperPrint jp;
			//Map<String, Object> parametros = new HashMap<String, Object>();
			//parametros.put("pathSubRel", pathSubRel);
			jp = JasperFillManager.fillReport(report,null,planilhaDataSource);
			
			diretorioPDF = diretorioXLS.replaceAll(".xls", ".pdf");
			JasperExportManager.exportReportToPdfFile(jp, diretorioPDF);
			
			JasperRunManager.runReportToPdf (report, null, planilhaDataSource);
			JasperViewer viewer = new JasperViewer(jp, false);
			//viewer.setTitle(titulo);
			//viewer.setIconImage(Toolkit.getDefaultToolkit().getImage(MarcaView.class.getResource("/charmoza/imagens/shopping-bag.png")));
			viewer.setSize(970,650);
			viewer.setExtendedState(viewer.MAXIMIZED_BOTH);
			viewer.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
			viewer.setLocationRelativeTo(null); 
			viewer.show();
		}catch(Exception e){
			JOptionPane.showMessageDialog(null, e.getMessage());
			System.exit(-1);
		}
	}
}
