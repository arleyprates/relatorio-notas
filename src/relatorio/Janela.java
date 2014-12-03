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
	/**abrePath
	 * 
	 * Tudo o que esta janela faz é abrir uma janela pequena com apenas dois
	 * botões de funcoes específicas
	 * 
	 * O primeiro abre uma janela de dialogo de busca em diretório do sistema.
	 * Retorna uma String com o endereço do arquivo.
	 * 
	 * O segundo botão simplesmente cancela e fecha o programa.
	 * 
	 * @return
	 **/

	private String caminhoDoArquivo;

	public String getPalavra() {
		return caminhoDoArquivo;
	}

	public void setPalavra(String palavra) {
		this.caminhoDoArquivo = palavra;
	}

	/**
	 * Este eh o metodo responsavel por abrir um chooser file (escolhedor de
	 * arquivos) Basta procurar e clicar duas vezes ou clicar no arquivo e
	 * depois em abrir.
	 * 
	 * @return
	 */
	public File abrePath() {
		JFileChooser arquivo = new JFileChooser();

		// configurando para que somente arquivos seja abertos.
		arquivo.setFileSelectionMode(JFileChooser.FILES_ONLY);

		SwingUtilities.updateComponentTreeUI(arquivo);

		// definindo filtro de Extensao para abrir somente csv, xlsx, xls
		arquivo.setFileFilter(new javax.swing.filechooser.FileFilter() {

			@Override
			public boolean accept(File file) {
				return file.getName().toLowerCase().endsWith(".xls")
				/*
				 * || file.getName().toLowerCase().endsWith(".csv") ||
				 * file.getName().toLowerCase().endsWith(".xlsx")
				 */
				|| file.isDirectory();
			}

			@Override
			public String getDescription() {
				return "Planilhas (.xls)"; // , .csv, .xlsx)";
			}
		});

		// armazena a escolha do usuário.
		int resposta = arquivo.showOpenDialog(Janela.this);
		if (resposta == JFileChooser.APPROVE_OPTION) {
			return arquivo.getSelectedFile();
		}
		return null;
	}

	public Janela() {		
		// Tamanho da janela
		setSize(261, 186);
		// Fazer com que abra centralizado
		setLocationRelativeTo(null);

		setAutoRequestFocus(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Configuracao");
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
			@SuppressWarnings("static-access")
			@Override
			public void mouseClicked(MouseEvent e) {
				caminhoDoArquivo = abrePath().getAbsolutePath();
				int aceita = JOptionPane
						.showConfirmDialog(
								Janela.this,
								"Arquivo selecionado:\n"
										+ caminhoDoArquivo
										+ "\n\nClique sim para confirmar que é o arquivo correto.\nN" + String.valueOf("ã") + "o para escolher outro. ");
				if (aceita == JOptionPane.NO_OPTION) {
					JOptionPane.showMessageDialog(Janela.this,
							"Escolha outro arquivo.", "Confirmar",
							JOptionPane.QUESTION_MESSAGE);
					caminhoDoArquivo = abrePath().getAbsolutePath();
				}
				if (aceita == JOptionPane.YES_OPTION && caminhoDoArquivo != null) {
					/**
					 * Aqui entra o codigo que chama as funcoes basicas do
					 * programa;
					 **/
					setVisible(false);
					/*
					 *Aqui é onde o programa faz seu trabalho
					 */
					Principal prog = new Principal();
					prog.mainly(caminhoDoArquivo);					
					
					//System.out.println("Executar o programa aqui\n" + palavra);
					JOptionPane.showMessageDialog(Janela.this, "Relatorio gerado com sucesso", "Confirma",
							JOptionPane.INFORMATION_MESSAGE);
					System.exit(EXIT_ON_CLOSE);
				}
			}
		});
		btnEscolherArquivo
				.setToolTipText("Clique aqui e selecione o seu arquivo.");
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
