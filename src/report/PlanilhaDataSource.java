package report;

import java.io.IOException;
import java.util.ArrayList;

import jxl.read.biff.BiffException;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import relatorio.Aluno;
import relatorio.ExportaExcel;

public class PlanilhaDataSource implements JRDataSource {
	ArrayList<Aluno> alunos = null;
	JRBeanCollectionDataSource beanCollection;

	public PlanilhaDataSource() throws BiffException, IOException {
		ExportaExcel exportarExcel = new ExportaExcel();
		alunos = exportarExcel.todosAlunos();
		beanCollection = new JRBeanCollectionDataSource(alunos);
	}

	@Override
	public Object getFieldValue(JRField arg0) throws JRException {
		// TODO Auto-generated method stub
		return beanCollection.getFieldValue(arg0);
	}

	public boolean next() throws JRException {
		return beanCollection.next();
	}
}