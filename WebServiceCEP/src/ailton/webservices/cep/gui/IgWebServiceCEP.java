package ailton.webservices.cep.gui;

import java.awt.BorderLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

import org.json.JSONException;
import org.json.JSONObject;

import ailton.webservices.cep.WebServiceCEP;
import net.miginfocom.swing.MigLayout;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

public class IgWebServiceCEP extends JFrame {
	private JTextField consultarTextField;
	private JTextField longradouroTextField;
	private JTextField complementoTextField;
	private JTextField bairroTextField;
	private JTextField localidadeTextField;
	private JTextField ufTextField;
	private JTextField ibgeTextField;
	private JTextField giaTextField;
	private JTextField dddTextField;
	private JTextField siafiTextField;
	private JTextField cepTextField;
	
	public IgWebServiceCEP() {
		getContentPane().setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new MigLayout("", "[90px][grow][]", "[]"));
		
		JLabel consultarLabel = new JLabel("Digite o CEP: ");
		consultarLabel.setDisplayedMnemonic(KeyEvent.VK_D);
		consultarLabel.setToolTipText("Cep no formato \"XXXXX-XXX\" ou \"\"XXXXXXXX\"\".");
		consultarLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		panel.add(consultarLabel, "cell 0 0,alignx left,aligny center");
		
		consultarTextField = new JTextField();
		consultarLabel.setLabelFor(consultarTextField);
		consultarTextField.setToolTipText("Cep no formato \"XXXXX-XXX\" ou \"\"XXXXXXXX\"\".");
		consultarTextField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				realizarConsulta();
			}
		});
		consultarTextField.setSize(new Dimension(50, 0));
		consultarTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		panel.add(consultarTextField, "cell 1 0,growx,aligny center");
		consultarTextField.setColumns(10);
		
		JButton consultarButton = new JButton("Consultar");
		consultarButton.setMnemonic(KeyEvent.VK_C);
		consultarButton.setToolTipText("Realizar a consulta.");
		consultarButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				realizarConsulta();
			}
		});
		consultarButton.setFont(new Font("Arial", Font.PLAIN, 12));
		panel.add(consultarButton, "cell 2 0,grow");
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new MigLayout("", "[90px][grow]", "[][grow][grow][grow][grow][grow][grow][grow][grow][grow]"));
		
		JLabel cepLabel = new JLabel("CEP:");
		cepLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_1.add(cepLabel, "cell 0 0,alignx left");
		
		cepTextField = new JTextField();
		cepTextField.setEditable(false);
		panel_1.add(cepTextField, "cell 1 0,growx");
		cepTextField.setColumns(10);
		
		JLabel longradouroLabel = new JLabel("Logradouro: ");
		longradouroLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_1.add(longradouroLabel, "cell 0 1,alignx left");
		
		longradouroTextField = new JTextField();
		longradouroTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		longradouroTextField.setEditable(false);
		panel_1.add(longradouroTextField, "cell 1 1,growx");
		longradouroTextField.setColumns(10);
		
		JLabel complementoLabel = new JLabel("Complemento: ");
		complementoLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_1.add(complementoLabel, "cell 0 2,alignx left");
		
		complementoTextField = new JTextField();
		complementoTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		complementoTextField.setEditable(false);
		panel_1.add(complementoTextField, "cell 1 2,growx");
		complementoTextField.setColumns(10);
		
		JLabel bairroLabel = new JLabel("Bairro: ");
		bairroLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_1.add(bairroLabel, "cell 0 3,alignx left");
		
		bairroTextField = new JTextField();
		bairroTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		bairroTextField.setEditable(false);
		panel_1.add(bairroTextField, "cell 1 3,growx");
		bairroTextField.setColumns(10);
		
		JLabel localidadeLabel = new JLabel("Localidade: ");
		localidadeLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_1.add(localidadeLabel, "cell 0 4,alignx left");
		
		localidadeTextField = new JTextField();
		localidadeTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		localidadeTextField.setEditable(false);
		panel_1.add(localidadeTextField, "cell 1 4,growx");
		localidadeTextField.setColumns(10);
		
		JLabel ufLabel = new JLabel("UF: ");
		ufLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_1.add(ufLabel, "cell 0 5,alignx left");
		
		ufTextField = new JTextField();
		ufTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		ufTextField.setEditable(false);
		panel_1.add(ufTextField, "cell 1 5,growx");
		ufTextField.setColumns(10);
		
		JLabel ibgeLabel = new JLabel("IBGE: ");
		ibgeLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_1.add(ibgeLabel, "cell 0 6,alignx left");
		
		ibgeTextField = new JTextField();
		ibgeTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		ibgeTextField.setEditable(false);
		panel_1.add(ibgeTextField, "cell 1 6,growx");
		ibgeTextField.setColumns(10);
		
		JLabel giaLabel = new JLabel("GIA: ");
		giaLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_1.add(giaLabel, "cell 0 7,alignx left");
		
		giaTextField = new JTextField();
		giaTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		giaTextField.setEditable(false);
		panel_1.add(giaTextField, "cell 1 7,growx");
		giaTextField.setColumns(10);
		
		JLabel dddLabel = new JLabel("DDD: ");
		dddLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_1.add(dddLabel, "cell 0 8,alignx left");
		
		dddTextField = new JTextField();
		dddTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		dddTextField.setEditable(false);
		panel_1.add(dddTextField, "cell 1 8,growx");
		dddTextField.setColumns(10);
		
		JLabel siafiLabel = new JLabel("SIAFI: ");
		siafiLabel.setFont(new Font("Arial", Font.PLAIN, 12));
		panel_1.add(siafiLabel, "cell 0 9,alignx left");
		
		siafiTextField = new JTextField();
		siafiTextField.setFont(new Font("Arial", Font.PLAIN, 12));
		siafiTextField.setEditable(false);
		panel_1.add(siafiTextField, "cell 1 9,growx");
		siafiTextField.setColumns(10);
		
		setResizable(false);
		setTitle("Consultar CEP");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(400, 400);
		setLocationRelativeTo(null);
		
		setVisible(true);
	}
	
	/**
	 * Valida se o cep está no formato correto ("XXXXX-XXX" ou "XXXXXXXX") e contém somente números.
	 */
	private boolean validarCEP(String cep) {
		return cep.matches("\\d{5}-\\d{3}") || cep.matches("\\d{8}");
	}
	
	/**
	 * Realiza a consulta e atualiza a GUI de acordo com o resultado.
	 */
	private void realizarConsulta(){
		String cep = consultarTextField.getText();
		if(validarCEP(cep)) {
			JSONObject result = WebServiceCEP.consultar(cep);
			if(result != null) {
				preencherCampos(result);
				consultarTextField.setText("");
			} else {
				WebServiceCEP.msgErro(this, "CEP não encontrado!", WebServiceCEP.NOME_PROGRAMA);
				limparCampos();
			}
		} else {
			WebServiceCEP.msgErro(this, "CEP incorreto!", WebServiceCEP.NOME_PROGRAMA);
			limparCampos();
		}
	}
	
	/**
	 * Preenche os campos da GUI com os dados contidos em um JSON resultante de um consulta. 
	 */
	private void preencherCampos(JSONObject dados) {
		try {
			cepTextField.setText(dados.getString("cep"));
			longradouroTextField.setText(dados.getString("logradouro"));
			complementoTextField.setText(dados.getString("complemento"));
			bairroTextField.setText(dados.getString("bairro"));
			localidadeTextField.setText(dados.getString("localidade"));
			ufTextField.setText(dados.getString("uf"));
			ibgeTextField.setText(dados.getString("ibge"));
			giaTextField.setText(dados.getString("gia"));
			dddTextField.setText(dados.getString("ddd"));
			siafiTextField.setText(dados.getString("siafi"));
		} catch (JSONException e) {}
	}
	
	/**
	 * Limpa os campos da GUI.
	 */
	private void limparCampos() {
		cepTextField.setText("");
		longradouroTextField.setText("");
		complementoTextField.setText("");
		bairroTextField.setText("");
		localidadeTextField.setText("");
		ufTextField.setText("");
		ibgeTextField.setText("");
		giaTextField.setText("");
		dddTextField.setText("");
		siafiTextField.setText("");
	}

}
