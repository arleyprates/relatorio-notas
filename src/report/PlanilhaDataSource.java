package report;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import jxl.read.biff.BiffException;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRField;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import relatorio.Aluno;
import relatorio.ExportaExcel;

public class PlanilhaDataSource implements JRDataSource {
	List<Aluno> alunos = null;
	JRBeanCollectionDataSource beanCollection;
	
	//private Iterator itrAlunos;
	//private Object valorAtual;
	//private boolean irParaProximoAluno = true;

	//public PlanilhaDataSource(List lista) {
	//	super();
	//	this.itrAlunos = lista.iterator();
	//}
	public PlanilhaDataSource(String diretorioXLS) throws BiffException, IOException {
		ExportaExcel exportarExcel = new ExportaExcel(diretorioXLS);
		alunos = exportarExcel.todosAlunos();
		beanCollection = new JRBeanCollectionDataSource(alunos);
	}

	@Override
	public Object getFieldValue(JRField arg0) throws JRException {
		// TODO Auto-generated method stub
		//Object valor = null;
        //Aluno aluno = (Aluno) valorAtual;

        //if ("nome".equals(aluno.getNome())) {
          //  valor = aluno.getNome();
      //  }// else if ("ListaDisciplinas".equals(aluno.getMatricula())) {
           // valor = new JRBeanCollectionDataSource(aluno.getMatricula());
        //} else if ("curso".equals(campo.getName())) {
         //   valor = aluno.getCurso();
       // }

        //return valor;
		return beanCollection.getFieldValue(arg0);
	}

	public boolean next() throws JRException {
		//valorAtual = itrAlunos.hasNext() ? itrAlunos.next() : null;
		//irParaProximoAluno = (valorAtual != null);
		//return irParaProximoAluno;
		return beanCollection.next();
	}
}
