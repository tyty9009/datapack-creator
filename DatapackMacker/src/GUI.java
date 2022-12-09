import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.awt.Choice;
import java.io.*;
import java.awt.event.InputMethodListener;
import java.awt.event.InputMethodEvent;
import javax.swing.GroupLayout.Alignment;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.io.FileReader;
import java.util.*;


@SuppressWarnings("unused")
public class GUI implements ActionListener {
	int count = 0;
	private String filename;
	private JFrame frame;
	private JButton btnDownload;
	private JPanel panel;
	private JTextField txtDatapackName;
	private JTextField txtDescription;
	private JLabel lblOutput_1;
	private JButton BtnAdvancedDatapacksButton;
	public GUI( ) {
		
		 
		
		
		frame = new JFrame();
		
		
		
		 btnDownload = new JButton("download");
		btnDownload.addActionListener(this);
		
		
		panel =new JPanel();
		panel.setBorder(BorderFactory.createEmptyBorder(30, 130, 10, 30));
		
		txtDatapackName = new JTextField();
		txtDatapackName.setToolTipText("name of you datapack");
		txtDatapackName.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				String NameOfDatapack = txtDatapackName.getText();
				
				
				
				
				
			}
			
		});
		txtDatapackName.setColumns(10);
		
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("datapack name");
		
		JLabel description = new JLabel("description");
		
		txtDescription = new JTextField();
		txtDescription.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String discripion = txtDescription.getText();
			}
		});
		txtDescription.setColumns(10);
		
		lblOutput_1 = new JLabel("");
		
		BtnAdvancedDatapacksButton = new JButton("advanced");
		BtnAdvancedDatapacksButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(btnDownload, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE)
						.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
							.addGroup(gl_panel.createSequentialGroup()
								.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE)
								.addGap(18)
								.addComponent(txtDatapackName, GroupLayout.PREFERRED_SIZE, 114, GroupLayout.PREFERRED_SIZE))
							.addGroup(gl_panel.createSequentialGroup()
								.addGap(10)
								.addComponent(description, GroupLayout.PREFERRED_SIZE, 66, GroupLayout.PREFERRED_SIZE)
								.addGap(41)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
									.addComponent(lblOutput_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
									.addComponent(txtDescription, GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE)))))
					.addContainerGap(246, Short.MAX_VALUE))
				.addGroup(Alignment.TRAILING, gl_panel.createSequentialGroup()
					.addContainerGap(428, Short.MAX_VALUE)
					.addComponent(BtnAdvancedDatapacksButton)
					.addContainerGap())
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(92)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(4)
							.addComponent(lblNewLabel))
						.addComponent(txtDatapackName, GroupLayout.PREFERRED_SIZE, 23, GroupLayout.PREFERRED_SIZE))
					.addGap(6)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addGap(3)
							.addComponent(description))
						.addComponent(txtDescription, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(lblOutput_1)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addComponent(btnDownload)
					.addPreferredGap(ComponentPlacement.RELATED, 119, Short.MAX_VALUE)
					.addComponent(BtnAdvancedDatapacksButton)
					.addContainerGap())
		);
		panel.setLayout(gl_panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("datapack maker");
		frame.pack();
		frame.setVisible(true);
		
		
	}
	
	
	public static void main(String[] args) throws IOException{
		new GUI();
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String NameOfDatapack = txtDatapackName.getText();
		String discripion = txtDescription.getText();
		
		

		File mainName = new File(NameOfDatapack);
		File data = new File(NameOfDatapack+"/data");
		File Name = new File(NameOfDatapack+"/data/"+NameOfDatapack);
		File minecraft = new File(NameOfDatapack+"/data/minecraft");
		File mTags = new File(NameOfDatapack+"/data/minecraft/tags");
		File mfunctions = new File(NameOfDatapack+"/data/minecraft/tags/functions");
		File loadjson = new File(NameOfDatapack+"/data/minecraft/tags/functions/load.json");
		File tickjson = new File(NameOfDatapack+"/data/minecraft/tags/functions/tick.json");
		File packmcmeta = new File(NameOfDatapack+"/pack.mcmeta");
		File DPfunctions = new File(NameOfDatapack+"/data/"+NameOfDatapack+"/functions");
		File DPmain = new File(NameOfDatapack+"/data/"+NameOfDatapack+"/functions/main.mcfunction");
		File DPload = new File(NameOfDatapack+"/data/"+NameOfDatapack+"/functions/load.mcfunction");
		
		
		mainName.mkdir();
		data.mkdir();
		Name.mkdir();
		minecraft.mkdir();
		mTags.mkdir();
		mfunctions.mkdir();
		DPfunctions.mkdir();
		
		try {
			loadjson.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try {
			FileWriter fw = new FileWriter(loadjson);
			fw.write ("{\r\n"
					+ "	\"values\": ");
			fw.write ("[\"" + NameOfDatapack + ":load\"]\r\n"
					+ "}");
			
			fw.flush();
			fw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try {
			tickjson.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			FileWriter fw = new FileWriter(tickjson);
			fw.write ("{\r\n"
					+ "	\"values\": ");
			fw.write ("[\"" + NameOfDatapack + ":main\"]\r\n"
					+ "}");
			fw.flush();
			fw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		try {
			FileWriter fw = new FileWriter(packmcmeta);
			fw.write ("{\r\n"
					+ "	\"pack\": {\r\n"
					+ "  	\"pack_format\": 7,\r\n"
					+ "  	\"description\": ");
			fw.write ("\"" +discripion + "\"\r\n"
					+ "	}\r\n"
					+ "}");
			fw.flush();
			fw.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			DPmain.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		try {
			DPload.createNewFile();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
		
		
		
		
		
		
		System.out.println("Folder and File "+ NameOfDatapack +" Created");

		
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
