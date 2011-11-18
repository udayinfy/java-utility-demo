package tool.url;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * Frame视图，提供Url编码UI
 * 
 * @author zhc 2011.11.17
 * 
 */
public class FrameView extends JFrame {

	private static final long serialVersionUID = 8363292649411360494L;

	// 布局Panel
	private JPanel northPanel;
	private JScrollPane centerPane;
	private JPanel southPanel;

	// Swing 控件
	private JTextField srcTextField;
	private JTextArea resultTextArea;
	private ButtonGroup typeButtonGroup;
	private ButtonGroup encodeButtonGroup;

	// button text 常量
	private static final String typeTotalValue = "整体";
	private static final String typeFieldValue = "字段";
	private static final String utf8EncodeValue = "UTF-8";
	private static final String gbkEncodeValue = "GBK";
	private static final String otherEncodeValue = "其他";

	public FrameView() {

		this.makeNorthPanel();
		this.makeCenterPanel();
		this.makeSouthPanel();

		Container contentPane = this.getContentPane();
		contentPane.setLayout(new BorderLayout());

		contentPane.add(northPanel, BorderLayout.NORTH);
		contentPane.add(centerPane, BorderLayout.CENTER);
		contentPane.add(southPanel, BorderLayout.SOUTH);

		this.setVisible(true);
		this.setTitle("URL Tool");
		this.setSize(new Dimension(650, 450));
		this.setLocation(400, 150);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}

	/**
	 * 构建north panel
	 */
	private void makeNorthPanel() {

		northPanel = new JPanel(new GridLayout(2, 1));

		JPanel innerUpPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JPanel innerDownPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

		// 填充上部Panel
		JLabel typeLabel = new JLabel("方式：");
		JRadioButton fieldTypeButton = new JRadioButton(typeFieldValue);
		JRadioButton totalTypeButton = new JRadioButton(typeTotalValue);
		typeButtonGroup = new ButtonGroup();
		typeButtonGroup.add(fieldTypeButton);
		typeButtonGroup.add(totalTypeButton);
		typeButtonGroup.setSelected(fieldTypeButton.getModel(), true);

		JLabel sepratorLabel = new JLabel("      ||      ");

		JLabel encodeLabel = new JLabel("编码：");
		JRadioButton utf8EncodeButton = new JRadioButton(utf8EncodeValue);
		JRadioButton gbkEncodeButton = new JRadioButton(gbkEncodeValue);
		JRadioButton otherEncodeButton = new JRadioButton(otherEncodeValue);
		encodeButtonGroup = new ButtonGroup();
		encodeButtonGroup.add(utf8EncodeButton);
		encodeButtonGroup.add(gbkEncodeButton);
		encodeButtonGroup.add(otherEncodeButton);

		// 取消编码指定功能
		// encodeButtonGroup.setSelected(utf8EncodeButton.getModel(), true);
		sepratorLabel.setEnabled(false);
		encodeLabel.setEnabled(false);
		utf8EncodeButton.setEnabled(false);
		gbkEncodeButton.setEnabled(false);
		otherEncodeButton.setEnabled(false);

		innerUpPanel.add(typeLabel);
		innerUpPanel.add(fieldTypeButton);
		innerUpPanel.add(totalTypeButton);
		innerUpPanel.add(sepratorLabel);
		innerUpPanel.add(encodeLabel);
		innerUpPanel.add(utf8EncodeButton);
		innerUpPanel.add(gbkEncodeButton);
		innerUpPanel.add(otherEncodeButton);

		// 填充下部Panel
		JLabel srcLabel = new JLabel("源：");
		srcTextField = new JTextField(53);

		innerDownPanel.add(srcLabel);
		innerDownPanel.add(srcTextField);

		// 填充主Panel
		northPanel.add(innerUpPanel);
		northPanel.add(innerDownPanel);

	}

	/**
	 * 构建center panel
	 */
	private void makeCenterPanel() {

		resultTextArea = new JTextArea();
		resultTextArea.setEditable(false);
		centerPane = new JScrollPane(resultTextArea);

	}

	/**
	 * 构建south panel
	 */
	private void makeSouthPanel() {

		southPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		JButton encodeButton = new JButton("Encode");
		JButton decodeButton = new JButton("Decode");

		southPanel.add(encodeButton);
		southPanel.add(decodeButton);

		encodeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JRadioButton typeButton = getSelection(typeButtonGroup);
				JRadioButton encodeButton = getSelection(encodeButtonGroup);

				String srcText = srcTextField.getText().trim();

				String typeText = typeButton.getText();

				try {
					// 整体编码
					if (typeTotalValue.equals(typeText)) {
						StringBuilder builder = new StringBuilder();
						builder.append("编码结果\n");

						String decodeValue = null;
						decodeValue = urlTotalEncode(srcText, "UTF-8");
						builder.append("UTF-8 : " + decodeValue + "\n");
						decodeValue = urlTotalEncode(srcText, "GBK");
						builder.append("GBK : " + decodeValue + "\n");
						decodeValue = urlTotalEncode(srcText, "UTF-8+");
						builder.append("UTF-8(+) : " + decodeValue + "\n");
						decodeValue = urlTotalEncode(srcText, "GBK+");
						builder.append("GBK(+) : " + decodeValue + "\n");

						resultTextArea.setText(builder.toString());
					}

					// 字段编码
					if (typeFieldValue.equals(typeText)) {
						StringBuilder builder = new StringBuilder();
						builder.append("解码结果\n");

						String encodeValue = null;
						encodeValue = java.net.URLEncoder.encode(srcText, "UTF-8");
						builder.append("UTF-8 : " + encodeValue + "\n");
						encodeValue = java.net.URLEncoder.encode(srcText, "GBK");
						builder.append("GBK : " + encodeValue + "\n");
						encodeValue = java.net.URLEncoder.encode(srcText, "UTF-8").replaceAll("\\+", "%20");
						builder.append("UTF-8(+) : " + encodeValue + "\n");
						encodeValue = java.net.URLEncoder.encode(srcText, "GBK").replaceAll("\\+", "%20");
						builder.append("GBK(+) : " + encodeValue + "\n");

						resultTextArea.setText(builder.toString());
					}
				} catch (UnsupportedEncodingException ex) {

				}

			}
		});

		decodeButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JRadioButton typeButton = getSelection(typeButtonGroup);
				JRadioButton encodeButton = getSelection(encodeButtonGroup);

				String srcText = srcTextField.getText().trim();

				String typeText = typeButton.getText();

				try {
					// 整体解编
					if (typeTotalValue.equals(typeText)) {
						StringBuilder builder = new StringBuilder();
						builder.append("解码结果\n");

						String decodeValue = null;
						decodeValue = urlTotalDecode(srcText, "UTF-8");
						builder.append("UTF-8 : " + decodeValue + "\n");
						decodeValue = urlTotalDecode(srcText, "GBK");
						builder.append("GBK : " + decodeValue + "\n");
						decodeValue = urlTotalDecode(srcText, "UTF-8");
						builder.append("UTF-8(+) : " + decodeValue + "\n");
						decodeValue = urlTotalDecode(srcText, "GBK");
						builder.append("GBK(+) : " + decodeValue + "\n");

						resultTextArea.setText(builder.toString());
					}

					// 字段解编
					if (typeFieldValue.equals(typeText)) {
						StringBuilder builder = new StringBuilder();
						builder.append("编码结果\n");

						String decodeValue = null;
						decodeValue = java.net.URLDecoder.decode(srcText, "UTF-8");
						builder.append("UTF-8 : " + decodeValue + "\n");
						decodeValue = java.net.URLDecoder.decode(srcText, "GBK");
						builder.append("GBK : " + decodeValue + "\n");
						decodeValue = java.net.URLDecoder.decode(srcText, "UTF-8");
						builder.append("UTF-8(+) : " + decodeValue + "\n");
						decodeValue = java.net.URLDecoder.decode(srcText, "GBK");
						builder.append("GBK(+) : " + decodeValue + "\n");

						resultTextArea.setText(builder.toString());
					}
				} catch (UnsupportedEncodingException ex) {

				}

			}
		});

	}

	/**
	 * 获取GourpButton选择的JRadioButton
	 * 
	 * @param group
	 * @return
	 */
	private JRadioButton getSelection(ButtonGroup group) {
		for (Enumeration<AbstractButton> e = group.getElements(); e.hasMoreElements();) {
			JRadioButton button = (JRadioButton) e.nextElement();
			if (button.getModel() == group.getSelection())
				return button;
		}
		return null;
	}
	
	/**
	 * 对整个URL编码  完成于2011.11.18
	 * @param sec
	 * @param encode
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	private static String urlTotalEncode(String url, String enc) throws UnsupportedEncodingException{
		
		if( !url.contains("?") )
			return url;
		
		String[] parts = url.split("\\?");
		
		String hostPart = parts[0];
		String prams = parts[1];
		StringBuilder pramPart = new StringBuilder();
		
		String[] subPrams = prams.split("&+");
		for( int i=0; i<subPrams.length; i++ ){
			String[] keyValue = subPrams[i].split("=");
			String key = keyValue[0];
			String value = keyValue[1];
			if( !enc.contains("+") )
				value = java.net.URLEncoder.encode(value, enc);
			else  	// 空格编码处理
				value = java.net.URLEncoder.encode(value, enc.substring(0, enc.length()-1)).replaceAll("\\+", "%20");
			pramPart.append( key + "=" + value + "&" );
		}

		String encodeUrl = hostPart + "?" + pramPart.toString();
		
		if( encodeUrl.endsWith("&") )
			encodeUrl = encodeUrl.substring(0, encodeUrl.length()-1);

		return encodeUrl;
	}
	
	/**
	 * 对整个URL解码   完成于2011.11.18
	 * @param src
	 * @param decode
	 * @return
	 * @throws UnsupportedEncodingException 
	 */
	private static String urlTotalDecode(String url, String enc) throws UnsupportedEncodingException{
		
		if( !url.contains("?") )
			return url;
		
		String[] parts = url.split("\\?");
		
		String hostPart = parts[0];
		String prams = parts[1];
		StringBuilder pramPart = new StringBuilder();
		
		String[] subPrams = prams.split("&+");
		for( int i=0; i<subPrams.length; i++ ){
			String[] keyValue = subPrams[i].split("=");
			String key = keyValue[0];
			String value = keyValue[1];
			value = java.net.URLDecoder.decode(value, enc);
			pramPart.append( key + "=" + value + "&" );
		}

		String decodeUrl = hostPart + "?" + pramPart.toString();

		if( decodeUrl.endsWith("&") )
			decodeUrl = decodeUrl.substring(0, decodeUrl.length()-1);
		
		return decodeUrl;
		
	}

	public static void main(String[] args) {

		new FrameView();
//		
//		String url = "http://localhost:8080/sis3server?a=213&b=def%E5%93%88%20%E5%93%88";
//		try {
//			String urlTotalDecode = urlTotalDecode(url, "utf-8");
//			System.out.println(urlTotalDecode);
//		} catch (UnsupportedEncodingException e) {
//			e.printStackTrace();
//		}

	}

}
