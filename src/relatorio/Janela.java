package relatorio;

import java.awt.BorderLayout;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;
import javax.swing.SwingConstants;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

@SuppressWarnings("serial")
public class Janela extends JFrame {

	public Janela() {
		BorderLayout borderLayout = (BorderLayout) getContentPane().getLayout();
		borderLayout.setVgap(30);
		borderLayout.setHgap(30);
		setTitle("Configuração");
		
		JTextPane txtpnCliqueNoBoto = new JTextPane();
		txtpnCliqueNoBoto.setToolTipText("Aqui vai o endereço para a sua planilha de notas. \nVocê pode digitar ou clicar no botão escolher arquivos para selecioná-lo.\nOu clique em fechar para cancelar.");
		txtpnCliqueNoBoto.setText("Clique no botão escolher arquivo");
		txtpnCliqueNoBoto.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
			}
		});
		getContentPane().add(txtpnCliqueNoBoto, BorderLayout.CENTER);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		getContentPane().add(btnOk, BorderLayout.SOUTH);
		
		JButton btnEscolher = new JButton("Escolher");
		btnEscolher.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseReleased(MouseEvent e) {
			}
		});
		getContentPane().add(btnEscolher, BorderLayout.EAST);
		
		JLabel lblEscolhaOArquivo = new JLabel("Escolha o arquivo:");
		lblEscolhaOArquivo.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblEscolhaOArquivo, BorderLayout.NORTH);
		
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				Janela pp;
				pp = new Janela();
				pp.setVisible(true);
			}
		});
	}
}
