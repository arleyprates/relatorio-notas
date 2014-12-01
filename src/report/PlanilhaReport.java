package report;

import java.io.InputStream;

import javax.swing.WindowConstants;

import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.view.JasperViewer;

public class PlanilhaReport {
	
	private JasperReport report; 
	
	public void Planilha(){
		try{
			String caminhoRelJasper = "planilha.jrxml";
			InputStream relJasper = getClass().getResourceAsStream(caminhoRelJasper);
			
			report = JasperCompileManager.compileReport(relJasper);
			
			PlanilhaDataSource planilhaDataSource = new PlanilhaDataSource();
			
			JasperPrint jp;
			jp = JasperFillManager.fillReport(report,null,planilhaDataSource);
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
			e.printStackTrace();
		}
	}
}
