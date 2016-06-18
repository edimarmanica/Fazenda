/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edimarmanica.fazenda.view;

/**
 *
 * @author edimar
 */
public class MenuView extends javax.swing.JFrame {

    /**
     * Creates new form MenuView
     */
    public MenuView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        desktopPane = new javax.swing.JDesktopPane();
        menuBar = new javax.swing.JMenuBar();
        jmnList = new javax.swing.JMenu();
        jmiAnimal = new javax.swing.JMenuItem();
        jmiCaixa = new javax.swing.JMenuItem();
        jmiListPessoa = new javax.swing.JMenuItem();
        jmiTipoCaixa = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Manica Farm 2016");
        setLocationByPlatform(true);
        setResizable(false);

        jmnList.setMnemonic('e');
        jmnList.setText("Cadastros");

        jmiAnimal.setText("Animal");
        jmiAnimal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiAnimalActionPerformed(evt);
            }
        });
        jmnList.add(jmiAnimal);

        jmiCaixa.setText("Caixa");
        jmiCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiCaixaActionPerformed(evt);
            }
        });
        jmnList.add(jmiCaixa);

        jmiListPessoa.setMnemonic('t');
        jmiListPessoa.setText("Pessoa");
        jmiListPessoa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiListPessoaActionPerformed(evt);
            }
        });
        jmnList.add(jmiListPessoa);

        jmiTipoCaixa.setText("Tipo de Caixa");
        jmiTipoCaixa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmiTipoCaixaActionPerformed(evt);
            }
        });
        jmnList.add(jmiTipoCaixa);

        menuBar.add(jmnList);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 942, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(desktopPane, javax.swing.GroupLayout.PREFERRED_SIZE, 680, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jmiListPessoaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiListPessoaActionPerformed
        // TODO add your handling code here:
        PessoaView view = new PessoaView();
        this.desktopPane.add(view);
        view.setVisible(true);
    }//GEN-LAST:event_jmiListPessoaActionPerformed

    private void jmiAnimalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiAnimalActionPerformed
        // TODO add your handling code here:
        AnimalView view = new AnimalView();
        this.desktopPane.add(view);
        view.setVisible(true);
    }//GEN-LAST:event_jmiAnimalActionPerformed

    private void jmiTipoCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiTipoCaixaActionPerformed
        // TODO add your handling code here:
        TipoCaixaView view = new TipoCaixaView();
        this.desktopPane.add(view);
        view.setVisible(true);
    }//GEN-LAST:event_jmiTipoCaixaActionPerformed

    private void jmiCaixaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmiCaixaActionPerformed
        // TODO add your handling code here:
        CaixaView view = new CaixaView();
        this.desktopPane.add(view);
        view.setVisible(true);
    }//GEN-LAST:event_jmiCaixaActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JDesktopPane desktopPane;
    private javax.swing.JMenuItem jmiAnimal;
    private javax.swing.JMenuItem jmiCaixa;
    private javax.swing.JMenuItem jmiListPessoa;
    private javax.swing.JMenuItem jmiTipoCaixa;
    private javax.swing.JMenu jmnList;
    private javax.swing.JMenuBar menuBar;
    // End of variables declaration//GEN-END:variables

}
