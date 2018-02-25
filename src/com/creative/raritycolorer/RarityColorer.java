package com.creative.raritycolorer;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import javax.swing.SwingUtilities;

public class RarityColorer extends javax.swing.JFrame {

	public RarityColorer() {
		initComponents();
	}

	@SuppressWarnings("unchecked")                         
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        ouput = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        input = new javax.swing.JTextArea();
        pastePrompt = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        instructions = new javax.swing.JTextPane();
        commonSelect = new javax.swing.JComboBox<>();
        rareSelect = new javax.swing.JComboBox<>();
        epicSelect = new javax.swing.JComboBox<>();
        commonPrompt = new javax.swing.JLabel();
        rarePrompt = new javax.swing.JLabel();
        epicPrompt = new javax.swing.JLabel();
        legendarySelect = new javax.swing.JComboBox<>();
        legendaryPrompt = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Rarity Color Generator (Most creative title ever)");
        setBackground(new java.awt.Color(102, 102, 102));

        jScrollPane1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        ouput.setEditable(false);
        ouput.setColumns(20);
        ouput.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        ouput.setRows(5);
        ouput.setToolTipText("The result appears here");
        ouput.setWrapStyleWord(true);
        ouput.setCursor(new java.awt.Cursor(java.awt.Cursor.TEXT_CURSOR));
        ouput.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                generate();
            }
        });
        jScrollPane1.setViewportView(ouput);
        ouput.getAccessibleContext().setAccessibleDescription("Result will appear here");

        jScrollPane2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        input.setColumns(20);
        input.setFont(new java.awt.Font("Monospaced", 0, 12)); // NOI18N
        input.setRows(5);
        input.setToolTipText("Paste the SOURCE here");
        input.setWrapStyleWord(true);
        input.addKeyListener(new java.awt.event.KeyAdapter() {
			@Override
            public void keyTyped(java.awt.event.KeyEvent evt) {
                inputKeyTyped(evt);
            }
        });
        jScrollPane2.setViewportView(input);

        pastePrompt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        pastePrompt.setText("Please paste the source of your page below:");

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel2.setText("Result:");

        instructions.setEditable(false);
        instructions.setFont(new java.awt.Font("Candara", 1, 14)); // NOI18N
        instructions.setForeground(new java.awt.Color(0, 91, 39));
        instructions.setText("1. Select or type a replacement color for each "
				+ "rarity.\n2. Paste the source in the box below. "
				+ "The program will case-insensitively replace every occurance "
				+ "of \"common\", \"rare\", \"epic\" and \"legendary\" with "
				+ "its corresponding color. Any original color tags will be overrided."
				+ "\n3. Copy the result from the "
				+ "result field by hand or using the button.\n4. Paste the "
				+ "generated text back into the Wiki source editor. Pay "
				+ "attention to the things that are not meant to be changed. "
				+ "Example: [[File:legendarySpear.png]].");
        jScrollPane3.setViewportView(instructions);

        commonSelect.setEditable(true);
        commonSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DimGray", "Gray", "Black", "Custom" }));
        commonSelect.addActionListener(this::commonSelectActionPerformed);

        rareSelect.setEditable(true);
        rareSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "SteelBlue", "CornFlowerBlue", "Custom" }));
        rareSelect.addActionListener(this::rareSelectActionPerformed);

        epicSelect.setEditable(true);
        epicSelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Mahogany", "#CC5500", "Cinnamon", "Chocolate", "Custom" }));
        epicSelect.addActionListener(this::epicSelectActionPerformed);

        commonPrompt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        commonPrompt.setText("Common color");

        rarePrompt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rarePrompt.setText("Rare color");

        epicPrompt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        epicPrompt.setText("Epic color");

        legendarySelect.setEditable(true);
        legendarySelect.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "DarkGoldenRod", "GoldenRod", "Custom" }));
        legendarySelect.addActionListener(this::legendarySelectActionPerformed);

        legendaryPrompt.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        legendaryPrompt.setText("Legendary color");

        jButton1.setText("Copy");
        jButton1.setBorderPainted(false);
        jButton1.addActionListener(this::jButton1ActionPerformed);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pastePrompt)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 350, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jButton1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(legendarySelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(commonPrompt)
                            .addComponent(rarePrompt)
                            .addComponent(epicPrompt)
                            .addComponent(legendaryPrompt)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(rareSelect, 0, 0, Short.MAX_VALUE)
                                .addComponent(epicSelect, 0, 99, Short.MAX_VALUE)
                                .addComponent(commonSelect, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(pastePrompt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(commonPrompt)
                        .addGap(4, 4, 4)
                        .addComponent(commonSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rarePrompt)
                        .addGap(4, 4, 4)
                        .addComponent(rareSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(epicPrompt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(epicSelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(legendaryPrompt)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(legendarySelect, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(81, Short.MAX_VALUE))
        );

        pack();
    }                           

    private void inputKeyTyped(java.awt.event.KeyEvent evt) {                               
		SwingUtilities.invokeLater(this::generate);
    }                              

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        StringSelection str = new StringSelection(ouput.getText());
		Clipboard clprd = Toolkit.getDefaultToolkit().getSystemClipboard();
		clprd.setContents(str, null);
    }                                        

    private void commonSelectActionPerformed(java.awt.event.ActionEvent evt) {                                             
        SwingUtilities.invokeLater(this::generate);
    }                                            

    private void rareSelectActionPerformed(java.awt.event.ActionEvent evt) {                                           
        SwingUtilities.invokeLater(this::generate);
    }                                          

    private void epicSelectActionPerformed(java.awt.event.ActionEvent evt) {                                           
        SwingUtilities.invokeLater(this::generate);
    }                                          

    private void legendarySelectActionPerformed(java.awt.event.ActionEvent evt) {                                                
       SwingUtilities.invokeLater(this::generate);
    }                                               

	/**
	 * @param args the command line arguments
	 */
	public static void main(String args[]) {
		/* Set the Nimbus look and feel
		If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
		 */
		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(RarityColorer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}
		RarityColorer obj = new RarityColorer();
		java.awt.EventQueue.invokeLater(() -> obj.setVisible(true));
	}

	private static String colorify(String color, String content) {
		return String.format("<font color=\"%s\">%s</font>", color, content);
	}
	
	private void generate() {
		String result = input.getText().replaceAll(
				"(<[ \\n]*font[ \\n]*color[ \\n]*=[ \\n]*\".{2,}?"
						+ "[ \\n]*\"[ \\n]*>[ \\n]*)?(?i)common([ \\n]*<[ \\n]*\\/"
						+ "[ \\n]*font[ \\n]*>[ \\n]*)?",
				colorify(commonSelect.getSelectedItem().toString(), "Common"))
				.replaceAll(
				"(<[ \\n]*font[ \\n]*color[ \\n]*=[ \\n]*\".{2,}?"
						+ "[ \\n]*\"[ \\n]*>[ \\n]*)?(?i)rare([ \\n]*<[ \\n]*\\/"
						+ "[ \\n]*font[ \\n]*>[ \\n]*)?",
						colorify(rareSelect.getSelectedItem().toString(), "Rare"))
				.replaceAll(
				"(<[ \\n]*font[ \\n]*color[ \\n]*=[ \\n]*\".{2,}?"
						+ "[ \\n]*\"[ \\n]*>[ \\n]*)?(?i)epic([ \\n]*<[ \\n]*\\/"
						+ "[ \\n]*font[ \\n]*>[ \\n]*)?",
				colorify(epicSelect.getSelectedItem().toString(), "Epic"))
				.replaceAll(
				"(<[ \\n]*font[ \\n]*color[ \\n]*=[ \\n]*\".{2,}?"
						+ "[ \\n]*\"[ \\n]*>[ \\n]*)?(?i)legendary([ \\n]*<[ \\n]*\\/"
						+ "[ \\n]*font[ \\n]*>[ \\n]*)?",
				colorify(legendarySelect.getSelectedItem().toString(), "Legendary"));
		ouput.setText(result);
	}
                    
    private javax.swing.JLabel commonPrompt;
    private javax.swing.JComboBox<String> commonSelect;
    private javax.swing.JLabel epicPrompt;
    private javax.swing.JComboBox<String> epicSelect;
    private static javax.swing.JTextArea input;
    private javax.swing.JTextPane instructions;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel legendaryPrompt;
    private javax.swing.JComboBox<String> legendarySelect;
    private static javax.swing.JTextArea ouput;
    private javax.swing.JLabel pastePrompt;
    private javax.swing.JLabel rarePrompt;
    private javax.swing.JComboBox<String> rareSelect;              
}
