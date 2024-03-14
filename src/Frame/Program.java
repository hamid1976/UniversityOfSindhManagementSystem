/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Frame;


import beanClass.*;
import databaseManager.DatabaseManager;
import java.awt.event.ActionEvent;
import java.util.Vector;
import javax.swing.JOptionPane;

/**
 *
 * @author HP
 */
public class Program extends javax.swing.JFrame {

    /**
     * Creates new form Program
     */
    public Program() {
        initComponents();
                getFaculty();
    }
     public void actionPerformed(ActionEvent e){
        if(e.getSource()==progrmAddButton)
            addRecord();
        if(e.getSource()==progrmAddButton){
        // hide();
         dispose();
         } 
        if(e.getSource()==progrmAddButton)
            clear();
    }
     private void clear(){
         //facultyComboBox.setItem("");
        progrmIdTextField.setText("");
        progrmNameTextField.setText("");
        progrmDurInSemTextField.setText("");
        progrmRemarksTextArea.setText("");
        
    }
     private void addRecord(){
         departmentBean bean=(departmentBean)departmentComboBox.getSelectedItem();
         if(bean==null)return;
            String  deptName = progrmNameTextField.getText();
            String durationInSem = progrmDurInSemTextField.getText();
            String remarks = progrmRemarksTextArea.getText();
            try{
                int rows=DatabaseManager.addProgram(bean.getDeptId(),deptName,durationInSem,remarks);
                if(rows>=1)
                    JOptionPane.showMessageDialog(this, rows+"Record Insert ");
                clear();
                getProgram();
            }catch(Exception e){
                   JOptionPane.showMessageDialog(this,"Error"+e.getMessage());
                   e.printStackTrace();
            }
    }
     private void updateRecord(){
        programBean bean=(programBean)progrmsList.getSelectedValue();
         if(bean==null)return ;
         try{
          int rows=DatabaseManager.updateProgram( bean.getDeptId(),bean.getProgId(),progrmNameTextField.getText(),progrmDurInSemTextField.getText(),progrmRemarksTextArea.getText());
            
                if(rows>=1)
                    JOptionPane.showMessageDialog(this, rows+"update ");
                clear();
                getProgram();
            }catch(Exception e){
                   JOptionPane.showMessageDialog(this,"Error"+e.getMessage());
                   e.printStackTrace();
            }
         }
      private void deleteRecord(){
    programBean bean = (programBean)progrmsList.getSelectedValue();
    if(bean==null)return;
    try{
        int rows = DatabaseManager.deleteProgram(bean.getProgId());
          if(rows>=1)
                    JOptionPane.showMessageDialog(this, rows+" Delete ");
                clear();
                  getProgram();
            }catch(Exception e){
                   JOptionPane.showMessageDialog(this,"Error"+e.getMessage());
                   e.printStackTrace();
            }
         } 
    private void getFaculty(){
        try{
    Vector v  = DatabaseManager.getFaculty();
   facultyComboBox.removeAllItems();
    for(int i=0; i<v.size();  i++ ){ 
        facultyBean bean =(facultyBean)v.elementAt(i);
        facultyComboBox.addItem(bean);
    } 
        }catch(Exception e){
            e.printStackTrace();
    //         JOptionPane.showMessageDialog(this,"Error"+e.getMessage());
        }
        }
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        programLabel = new javax.swing.JLabel();
        progrmFacultyLabel = new javax.swing.JLabel();
        progrmDepartmentLabel = new javax.swing.JLabel();
        progrmIdLabel = new javax.swing.JLabel();
        progrmNameLabel = new javax.swing.JLabel();
        progrmDurationInSemmesterLabel = new javax.swing.JLabel();
        progrmRemarks = new javax.swing.JLabel();
        progrmNameTextField = new javax.swing.JTextField();
        progrmDurInSemTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        progrmRemarksTextArea = new javax.swing.JTextArea();
        progrmAddButton = new javax.swing.JButton();
        progrmUpdateButton = new javax.swing.JButton();
        progrmDeleteButton = new javax.swing.JButton();
        progrmBackButton = new javax.swing.JButton();
        progrmsLabel = new javax.swing.JLabel();
        progrmClearButton = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        progrmsList = new javax.swing.JList();
        progrmIdTextField = new javax.swing.JTextField();
        facultyComboBox = new javax.swing.JComboBox();
        departmentComboBox = new javax.swing.JComboBox();

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        setMaximumSize(new java.awt.Dimension(800, 800));
        setMinimumSize(new java.awt.Dimension(790, 600));
        getContentPane().setLayout(null);

        programLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        programLabel.setText("PROGRAM");
        getContentPane().add(programLabel);
        programLabel.setBounds(340, 20, 59, 30);

        progrmFacultyLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        progrmFacultyLabel.setText("FACULTY");
        getContentPane().add(progrmFacultyLabel);
        progrmFacultyLabel.setBounds(90, 90, 60, 40);

        progrmDepartmentLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        progrmDepartmentLabel.setText("DEPARTMENT");
        getContentPane().add(progrmDepartmentLabel);
        progrmDepartmentLabel.setBounds(60, 140, 90, 40);

        progrmIdLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        progrmIdLabel.setText("PROGRAM ID");
        getContentPane().add(progrmIdLabel);
        progrmIdLabel.setBounds(70, 230, 80, 40);

        progrmNameLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        progrmNameLabel.setText("PROGRAM NAME");
        getContentPane().add(progrmNameLabel);
        progrmNameLabel.setBounds(50, 280, 100, 40);

        progrmDurationInSemmesterLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        progrmDurationInSemmesterLabel.setText("DURATION IN SEMESTER");
        getContentPane().add(progrmDurationInSemmesterLabel);
        progrmDurationInSemmesterLabel.setBounds(282, 230, 138, 40);

        progrmRemarks.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        progrmRemarks.setText("REMARKS");
        getContentPane().add(progrmRemarks);
        progrmRemarks.setBounds(170, 380, 70, 15);

        progrmNameTextField.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        progrmNameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                progrmNameTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(progrmNameTextField);
        progrmNameTextField.setBounds(170, 280, 330, 40);

        progrmDurInSemTextField.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        progrmDurInSemTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                progrmDurInSemTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(progrmDurInSemTextField);
        progrmDurInSemTextField.setBounds(420, 230, 80, 40);

        progrmRemarksTextArea.setColumns(20);
        progrmRemarksTextArea.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        progrmRemarksTextArea.setRows(5);
        jScrollPane2.setViewportView(progrmRemarksTextArea);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(170, 400, 330, 90);

        progrmAddButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        progrmAddButton.setText("ADD");
        progrmAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                progrmAddButtonActionPerformed(evt);
            }
        });
        getContentPane().add(progrmAddButton);
        progrmAddButton.setBounds(170, 510, 60, 30);

        progrmUpdateButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        progrmUpdateButton.setText("UPDATE");
        progrmUpdateButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                progrmUpdateButtonActionPerformed(evt);
            }
        });
        getContentPane().add(progrmUpdateButton);
        progrmUpdateButton.setBounds(250, 510, 80, 30);

        progrmDeleteButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        progrmDeleteButton.setText("DELETE");
        progrmDeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                progrmDeleteButtonActionPerformed(evt);
            }
        });
        getContentPane().add(progrmDeleteButton);
        progrmDeleteButton.setBounds(450, 510, 140, 30);

        progrmBackButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        progrmBackButton.setText("BACK");
        progrmBackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                progrmBackButtonActionPerformed(evt);
            }
        });
        getContentPane().add(progrmBackButton);
        progrmBackButton.setBounds(610, 510, 150, 30);

        progrmsLabel.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        progrmsLabel.setText("PROGRAMS");
        getContentPane().add(progrmsLabel);
        progrmsLabel.setBounds(510, 70, 80, 15);

        progrmClearButton.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        progrmClearButton.setText("CLEAR");
        progrmClearButton.setMaximumSize(new java.awt.Dimension(85, 25));
        progrmClearButton.setMinimumSize(new java.awt.Dimension(85, 25));
        progrmClearButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                progrmClearButtonActionPerformed(evt);
            }
        });
        getContentPane().add(progrmClearButton);
        progrmClearButton.setBounds(350, 510, 71, 30);

        progrmsList.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        progrmsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                progrmsListValueChanged(evt);
            }
        });
        jScrollPane4.setViewportView(progrmsList);

        getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(510, 90, 250, 400);

        progrmIdTextField.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        progrmIdTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                progrmIdTextFieldActionPerformed(evt);
            }
        });
        getContentPane().add(progrmIdTextField);
        progrmIdTextField.setBounds(170, 230, 90, 40);

        facultyComboBox.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        facultyComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                facultyComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(facultyComboBox);
        facultyComboBox.setBounds(170, 90, 330, 40);

        departmentComboBox.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        departmentComboBox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                departmentComboBoxActionPerformed(evt);
            }
        });
        getContentPane().add(departmentComboBox);
        departmentComboBox.setBounds(170, 140, 330, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void progrmUpdateButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_progrmUpdateButtonActionPerformed
        // TODO add your handling code here:
        updateRecord();
    }//GEN-LAST:event_progrmUpdateButtonActionPerformed

    private void facultyComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_facultyComboBoxActionPerformed
        // TODO add your handling code here:
        getDepartment();
    }//GEN-LAST:event_facultyComboBoxActionPerformed

    private void departmentComboBoxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_departmentComboBoxActionPerformed
        // TODO add your handling code here:
        getProgram(); 
    }//GEN-LAST:event_departmentComboBoxActionPerformed

    private void progrmNameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_progrmNameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_progrmNameTextFieldActionPerformed

    private void progrmsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_progrmsListValueChanged
        // TODO add your handling code here:
         programBean bean =(programBean)progrmsList.getSelectedValue();
        if(bean==null)return;{
        progrmIdTextField.setText(""+bean.getProgId());
        progrmNameTextField.setText(bean.getProgName());
        progrmDurInSemTextField.setText(bean.getDurationInSem());
        progrmRemarksTextArea.setText(bean.getRemarks());
    }
    }//GEN-LAST:event_progrmsListValueChanged

    private void progrmBackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_progrmBackButtonActionPerformed
        // TODO add your handling code here:
        this.hide();
        this.dispose();
    }//GEN-LAST:event_progrmBackButtonActionPerformed

    private void progrmDurInSemTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_progrmDurInSemTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_progrmDurInSemTextFieldActionPerformed

    private void progrmAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_progrmAddButtonActionPerformed
        // TODO add your handling code here:
        addRecord();
    }//GEN-LAST:event_progrmAddButtonActionPerformed

    private void progrmIdTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_progrmIdTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_progrmIdTextFieldActionPerformed

    private void progrmClearButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_progrmClearButtonActionPerformed
        // TODO add your handling code here:
        clear();
    }//GEN-LAST:event_progrmClearButtonActionPerformed

    private void progrmDeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_progrmDeleteButtonActionPerformed
        // TODO add your handling code here:
        deleteRecord();
    }//GEN-LAST:event_progrmDeleteButtonActionPerformed
        private void getProgram(){
            departmentBean bean=(departmentBean) departmentComboBox.getSelectedItem();
            if(bean==null)return;
            try{
            Vector v=DatabaseManager.getProgram(bean.getDeptId());
            progrmsList.setListData(v);

            }//end try-block
            catch(Exception e){
                e.printStackTrace();
                JOptionPane.showMessageDialog(this," Error : "+e.getMessage());
            }//end  catch

        }//end getProgram();




        private void getDepartment(){
            facultyBean bean=(facultyBean) facultyComboBox.getSelectedItem();
            if(bean==null) return;
            try{
                departmentComboBox.removeAllItems();
                 Vector v=DatabaseManager.getDepartment(bean.getFacId());

            for(int i=0;i<v.size();i++){
                departmentBean bean1=(departmentBean)v.elementAt(i);
                departmentComboBox.addItem(bean1);

            }
        }//end try block
        catch(Exception e){
            e.printStackTrace();
            JOptionPane.showMessageDialog(this,"Error : "+e.getMessage());
        }//end catch
        }
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
            java.util.logging.Logger.getLogger(Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Program.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Program().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox departmentComboBox;
    private javax.swing.JComboBox facultyComboBox;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JLabel programLabel;
    private javax.swing.JButton progrmAddButton;
    private javax.swing.JButton progrmBackButton;
    private javax.swing.JButton progrmClearButton;
    private javax.swing.JButton progrmDeleteButton;
    private javax.swing.JLabel progrmDepartmentLabel;
    private javax.swing.JTextField progrmDurInSemTextField;
    private javax.swing.JLabel progrmDurationInSemmesterLabel;
    private javax.swing.JLabel progrmFacultyLabel;
    private javax.swing.JLabel progrmIdLabel;
    private javax.swing.JTextField progrmIdTextField;
    private javax.swing.JLabel progrmNameLabel;
    private javax.swing.JTextField progrmNameTextField;
    private javax.swing.JLabel progrmRemarks;
    private javax.swing.JTextArea progrmRemarksTextArea;
    private javax.swing.JButton progrmUpdateButton;
    private javax.swing.JLabel progrmsLabel;
    private javax.swing.JList progrmsList;
    // End of variables declaration//GEN-END:variables
}
