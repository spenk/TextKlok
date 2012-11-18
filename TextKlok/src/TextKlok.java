/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sergen
 */
public class TextKlok extends javax.swing.JFrame {
	private static final long serialVersionUID = 1L;
	    public TextKlok() {
	        initComponents();
	    }

	    private void initComponents() {

	        jTextField1 = new javax.swing.JTextField();
	        jButton1 = new javax.swing.JButton();
	        jScrollPane1 = new javax.swing.JScrollPane();
	        jEditorPane1 = new javax.swing.JEditorPane("text/html", "");
	        setTitle("TextKlok\n");
			String text1 = "het is <br>";
			String text2 = " Een Twee Drie Vier <br> Vijf Zes Zeven Acht <br> Negen Tien Elf Twaalf <br> Dertien Veertien <br>";
			String text3 = " kwart voor over half <br>";
			String text4 = " Een Twee Drie Vier <br> Vijf Zes Zeven Acht <br> Negen Tien Elf Twaalf uur";
			jEditorPane1.setText(text1+text2+text3+text4);

	        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

	        jTextField1.setText("");//zet text van bar
	        jTextField1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jTextField1ActionPerformed(evt);
	            }
	        });

	        jButton1.setText("Berekenen");
	        jButton1.addActionListener(new java.awt.event.ActionListener() {
	            public void actionPerformed(java.awt.event.ActionEvent evt) {
	                jButton1ActionPerformed(evt);
	            }
	        });

	        jEditorPane1.setEditable(false);
	        jScrollPane1.setViewportView(jEditorPane1);

	        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
	        getContentPane().setLayout(layout);
	        layout.setHorizontalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 300, Short.MAX_VALUE)
	                    .addGroup(layout.createSequentialGroup()
	                        .addComponent(jTextField1)
	                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
	                .addContainerGap())
	        );
	        layout.setVerticalGroup(
	            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
	            .addGroup(layout.createSequentialGroup()
	                .addContainerGap()
	                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
	                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
	                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
	                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
	                    .addComponent(jButton1))
	                .addContainerGap())
	        );

	        pack();
	    }// </editor-fold>

	    private void jTextField1ActionPerformed(java.awt.event.ActionEvent evt) {
	    	this.setText(jTextField1.getText());
	    }

	    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {
	    	this.setText(jTextField1.getText());
	    }

	    /**
	     * @param args the command line arguments
	     */
	    public static void main(String args[]) {
	        try {
	            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
	                if ("Nimbus".equals(info.getName())) {
	                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
	                    break;
	                }
	            }
	        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | javax.swing.UnsupportedLookAndFeelException ex) {
	            java.util.logging.Logger.getLogger(TextKlok.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
	        }
	        //</editor-fold>

	        /* Create and display the form */
	        java.awt.EventQueue.invokeLater(new Runnable() {
	            public void run() {
	                new TextKlok().setVisible(true);
	            }
	        });
	    }
	    // Variables declaration - do not modify
	    private javax.swing.JButton jButton1;
	    private javax.swing.JEditorPane jEditorPane1;
	    private javax.swing.JScrollPane jScrollPane1;
	    private javax.swing.JTextField jTextField1;
	    // End of variables declaration

    public void setText(String in){
    	KlokBerekenen klok = new KlokBerekenen();
    	String[] a = klok.process(in);
    	if (a == null){jEditorPane1.setText("The time notation you filled in appears to be invalid please try again!"); jTextField1.setText(""); return;}
		String text1 = "<font color=red><b>het is</b></font> <br>";
		String text2 = " EenpTweeqDriezViers <br> VijfIZesLZevenNAchte <br> NegenTienElfTwaalfz <br> DertientwintVeertien <br>";
		String text3 = " kwartvoorhoverhalf <br>";
		String text4 = " EenYTweeLDriesOVier <br> VijfZesZevenAchtTien <br> NegenElfTwaalfsuur";
    	String text11 = null;
    	String text21 = null;
    	String text31 = null;
    	String text41 = null;
    	text11 = text1;
    	if(a[0].equalsIgnoreCase("1")){
    		text21 = text2.replace(a[1], "<font color=red><b>"+a[1]+"</b></font>");
    		text31 = text3;
    		text41 = text4.replace("uur", "<font color=red><b>uur</b></font>");
		}
    	
		if (a[0].equalsIgnoreCase("2")) {
    		text21 = text2;
    		if (a[1].contains(" ")){
    			String[] aa = a[1].split(" ");
    			text31 = text3.replace(aa[0], "<font color=red><b>"+aa[0]+"</b></font>");
    			text31 = text31.replace(aa[1], "<font color=red><b>"+aa[1]+"</b></font>");
    		}else{
    		text31 = text3.replace(a[1], "<font color=red><b>"+a[1]+"</b></font>");
    		}
    		text41 = text4.replace(a[2], "<font color=red><b>"+a[2]+"</b></font>");
		}
		
		if (a[0].equalsIgnoreCase("3")) {
    		text21 = text2.replace(a[1], "<font color=red><b>"+a[1]+"</b></font>");
    		if (a[2].contains(" ")){
    			String[] aa = a[2].split(" ");
    			text31 = text3.replace(aa[0], "<font color=red><b>"+aa[0]+"</b></font>");
    			text31 = text31.replace(aa[1], "<font color=red><b>"+aa[1]+"</b></font>");
    		}else{
    		text31 = text3.replace(a[2], "<font color=red><b>"+a[2]+"</b></font>");
    		}
    		text41 = text4.replace(a[3], "<font color=red><b>"+a[3]+"</b></font>");
		}
		String s = text11+text21+text31+text41;
		jEditorPane1.setText(s.toUpperCase());
		jTextField1.setText("");
    }
}
