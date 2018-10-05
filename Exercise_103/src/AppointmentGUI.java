
import java.io.File;
import java.time.LocalDateTime;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author mwimm
 */
public class AppointmentGUI extends javax.swing.JFrame {

    private AppointmentModell am = new AppointmentModell();

    public AppointmentGUI() {
        initComponents();
        ListAppointment.setModel(am);
               try {
            am.load(new File("C:/Users/mwimm/OneDrive/1819_Schule/POS/Exercise_201/termine.bin"));

        } catch (Exception e) {
            e.printStackTrace();
        }
        am.add(new Appointment(LocalDateTime.of(2002, 3, 10, 10, 10), "Pos"));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPopupMenu1 = new javax.swing.JPopupMenu();
        miAdd = new javax.swing.JMenuItem();
        miDelete = new javax.swing.JMenuItem();
        miUpdate = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        ListAppointment = new javax.swing.JList<>();

        miAdd.setText("hinzufügen");
        miAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miAddActionPerformed(evt);
            }
        });
        jPopupMenu1.add(miAdd);

        miDelete.setText("löschen");
        miDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miDeleteActionPerformed(evt);
            }
        });
        jPopupMenu1.add(miDelete);

        miUpdate.setText("ändern");
        miUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                miUpdateActionPerformed(evt);
            }
        });
        jPopupMenu1.add(miUpdate);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });
        getContentPane().setLayout(new java.awt.GridBagLayout());

        ListAppointment.setBorder(javax.swing.BorderFactory.createTitledBorder("Termine"));
        ListAppointment.setModel(new javax.swing.AbstractListModel<String>() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public String getElementAt(int i) { return strings[i]; }
        });
        ListAppointment.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setViewportView(ListAppointment);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 1.0;
        gridBagConstraints.weighty = 1.0;
        getContentPane().add(jScrollPane1, gridBagConstraints);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void miAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miAddActionPerformed
        AppointmentDlg dlg = new AppointmentDlg(this, true);
        dlg.setVisible(true);

        if (dlg.isOk()) {
            Appointment a = dlg.getAppointment();
            am.add(a);
        }
        dlg.setVisible(false);
    }//GEN-LAST:event_miAddActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        try{
                    am.save(new File("C:/Users/mwimm/OneDrive/1819_Schule/POS/Exercise_201/termine.bin"));
                    
                }catch(Exception e){
                    e.printStackTrace();
                }
    }//GEN-LAST:event_formWindowClosing

    private void miDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miDeleteActionPerformed
        int i=ListAppointment.getSelectedIndex();
        am.remove(i);
    }//GEN-LAST:event_miDeleteActionPerformed

    private void miUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_miUpdateActionPerformed
        int i=ListAppointment.getSelectedIndex();
         
        AppointmentDlg dlg = new AppointmentDlg(this, true);
        dlg.setDlg(am.getElementAt(i));
        dlg.setVisible(true);

        if (dlg.isOk()) {
            
            Appointment a = dlg.getAppointment();
            am.update(i,a);
        }
        dlg.setVisible(false);
        
    }//GEN-LAST:event_miUpdateActionPerformed

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
            java.util.logging.Logger.getLogger(AppointmentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppointmentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppointmentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppointmentGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppointmentGUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JList<String> ListAppointment;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JMenuItem miAdd;
    private javax.swing.JMenuItem miDelete;
    private javax.swing.JMenuItem miUpdate;
    // End of variables declaration//GEN-END:variables
}
