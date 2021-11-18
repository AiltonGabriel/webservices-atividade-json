package ailton.webservices.cep;

import static javax.swing.JOptionPane.ERROR_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;

import java.awt.Component;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;
import javax.swing.UnsupportedLookAndFeelException;

import org.json.JSONObject;

import ailton.webservices.cep.gui.IgWebServiceCEP;

public class WebServiceCEP {
	public static final String NOME_PROGRAMA = "Consultar CEP";

	public static void main(String[] args) {
		ativarLookAndFeel("Windows");
		new IgWebServiceCEP();
	}

	/**
	 *	Realiza a consulta na API pelo CEP informado. 
	 */
	public static JSONObject consultar(String cep) {
		URL url;
		try {
			url = new URL(String.format("https://viacep.com.br/ws/%s/json", cep));
			URLConnection con = url.openConnection();
			BufferedReader input = new BufferedReader(new InputStreamReader(con.getInputStream(), "utf-8"));
			String line;
			StringBuilder source = new StringBuilder();
			while ((line = input.readLine()) != null)
				source.append(line);
			input.close();
			
			return new JSONObject(source.toString());
		
		} catch (IOException e) {
			return null;
		}
		
	}

	public static void msgErro(Component parent, String msg, String titulo) {
		showMessageDialog(parent, msg, titulo, ERROR_MESSAGE);
	}

	/**
	 * Verifica se o LookAndFeel informado está disponível e caso esteja retorna o seu className. 
	 */
	private static String findLookAndFellClassName(String lookAndFeel) {
		for (LookAndFeelInfo laf : UIManager.getInstalledLookAndFeels()) {
			if (laf.getName().equals(lookAndFeel)) {
				return laf.getClassName();
			}
		}
		return null;
	}

	/**
	 * Ativa o look-and-feel com o nome informado caso ele esteja disponível, caso não esteja tenta ativar o look-and-feel Metal.
	 */
	private static boolean ativarLookAndFeel(String lookAndFeel) {
		String lookAndFellClassName = findLookAndFellClassName(lookAndFeel);
		if(lookAndFellClassName == null) {
			lookAndFellClassName = findLookAndFellClassName("Metal");
		}
		try {
			UIManager.setLookAndFeel(lookAndFellClassName);
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | 
				 UnsupportedLookAndFeelException | NullPointerException e) {
			msgErro(null, "Erro ao configurar o visual da interface!\nAlguns componentes podem não ser exibidos corretamente,\n"
					+ "recomendamos que reinicie o programa.", NOME_PROGRAMA);
			return false;
		}

		return true;
	}
}
