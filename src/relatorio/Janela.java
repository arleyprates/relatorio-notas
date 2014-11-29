package relatorio;

import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;

@SuppressWarnings("serial")
public class Janela extends JFrame {
	/**
	 * Tudo o que esta janela faz é abrir uma janela pequena com apenas dois
	 * botões de funções específicas
	 * 
	 * O primeiro abre uma janela de diálogo de busca em diretório do sistema.
	 * Retorna uma String com o endereço do arquivo.
	 * 
	 * O segundo botão simplesmente cancela e fecha o programa.
	 **/

	private String palavra;

	public String getPalavra() {
		return palavra;
	}

	public void setPalavra(String palavra) {
		this.palavra = palavra;
	}

	public File abrePath() {
		JFileChooser arquivo = new JFileChooser();

		// configurando para que somente arquivos seja abertos.
		arquivo.setFileSelectionMode(JFileChooser.FILES_ONLY);

		SwingUtilities.updateComponentTreeUI(arquivo);

		// armazena a escolha do usuário.
		int resposta = arquivo.showOpenDialog(Janela.this);
		if (resposta == JFileChooser.APPROVE_OPTION) {
			return arquivo.getSelectedFile();
		}
		return null;
	}

	public Janela() {
		// final setsize(261,186)
		setSize(261, 186);
		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Configuração");
		getContentPane().setLayout(new GridLayout(0, 1, 20, 20));

		JLabel lblEscolhaOArquivo = new JLabel("Bem vindo ao programa.");
		lblEscolhaOArquivo.setVerticalAlignment(SwingConstants.BOTTOM);
		lblEscolhaOArquivo.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblEscolhaOArquivo.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblEscolhaOArquivo);
		JButton btnEscolherArquivo = new JButton("Escolher arquivo");
		btnEscolherArquivo.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblEscolhaOArquivo.setLabelFor(btnEscolherArquivo);
		btnEscolherArquivo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				palavra = abrePath().getAbsolutePath();
				int aceita = JOptionPane.showConfirmDialog(Janela.this,
						"Arquivo selecionado:\n" + palavra + "\nEnviar arquivo? ");
				if (aceita == JOptionPane.YES_OPTION) {
					JOptionPane.showMessageDialog(Janela.this, palavra + " selecionado. \nCarregando arquivo...", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
				} else if (aceita == JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(Janela.this,
							"Escolha outro arquivo.", "Confirmação", JOptionPane.QUESTION_MESSAGE);
					palavra = abrePath().getAbsolutePath();
				}
				if (palavra != null) {
					/**
					 * Aqui entra o código que chama as funções básicas do
					 * programa;
					 **/
					System.out.println("Executar o programa aqui");
					setVisible(false);
					JOptionPane.showMessageDialog(Janela.this, "Relatório gerado com sucesso", "Confirmação", JOptionPane.INFORMATION_MESSAGE);
					/*decidir: fechar o programa ou abrir o Jasper reports
					 * fechar o programa somente quando o Jaser for fechado?
					 * 
					 * Se for segunda opção:
					 * colocar um if para receber retorno de fechar do jasper.
					 */
					System.exit(EXIT_ON_CLOSE);
				}
			}
		});
		btnEscolherArquivo
				.setToolTipText("Clique aqui e selecione o seu arquivo. Ou feche para encerrar o programa.");
		getContentPane().add(btnEscolherArquivo);

		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(EXIT_ON_CLOSE);
			}
		});
		btnCancelar.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		getContentPane().add(btnCancelar);
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
