/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import Gestion.GestionHistoriasClinicas;
import Modelo.Cita;
import Modelo.Consulta;
import Modelo.EstadoCita;
import Modelo.Medico;
import Modelo.Orden;
import Modelo.Receta;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author ALARCON
 */
public class AtencionPanel extends javax.swing.JPanel {

    private Medico medico;
    private Cita citaActual;
    private GestionHistoriasClinicas gestionHistorias;
    private MedicoPanel medicoPanel;
    
    private ArrayList<Receta> recetasDeLaSesion = new ArrayList<>();
    private ArrayList<Orden> ordenesDeLaSesion = new ArrayList<>();

    /**
     * Creates new form AtencionPanel
     */
    public AtencionPanel() {
        initComponents();
    }
    
    public AtencionPanel(GestionHistoriasClinicas gestionHistorias, MedicoPanel medicoPanel) {
        this.gestionHistorias = gestionHistorias;
        this.medicoPanel = medicoPanel;
        initComponents();
        
        
    }
    
    public void iniciarAtencion(Cita cita, Medico medico) {
        this.citaActual = cita;
        this.medico = medico;
        jLabel1.setText("Atendiendo a:" + cita.getPaciente().getNombres() + " " + cita.getPaciente().getApellidos());
        limpiarCampos();
    }
    
    private void agregarRecetaALista() {
        String med = medicamentoField.getText();
        String dosis = dosisField.getText();
        if (med.isEmpty() || dosis.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Medicamento y Dosis son obligatorios.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        Receta nuevaReceta = new Receta("", med, dosis, frecuenciaField.getText(), duracionField.getText(), null);
        recetasDeLaSesion.add(nuevaReceta);
        actualizarResumenRecetas();
        
        medicamentoField.setText("");
        dosisField.setText("");
        frecuenciaField.setText("");
        duracionField.setText("");
    }
    
    private void agregarOrdenALista() {
        String desc = ordenDescripcionField.getText();
        if (desc.isEmpty()) {
            JOptionPane.showMessageDialog(this, "La descripción es obligatoria.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        String tipo = (String) tipoOrdenComboBox.getSelectedItem();
        Orden nuevaOrden = new Orden("", tipo, desc, null);
        ordenesDeLaSesion.add(nuevaOrden);
        actualizarResumenOrdenes();
        ordenDescripcionField.setText("");
    }
    
    private void finalizarConsulta() {
        if (citaActual == null) return;

        Consulta nuevaConsulta = new Consulta(
            citaActual.getFechaHora().substring(0, 10),
            motivoArea.getText(),
            antecedentesArea.getText(),
            signosVitalesArea.getText(),
            examenFisicoArea.getText(),
            diagnosticoArea.getText(),
            planArea.getText(),
            this.medico
        );
        gestionHistorias.agregarConsulta(citaActual.getPaciente(), nuevaConsulta);

        for (Receta r : recetasDeLaSesion) {
            r.setFecha(citaActual.getFechaHora().substring(0, 10));
            r.setMedico(this.medico);
            gestionHistorias.agregarReceta(citaActual.getPaciente(), r);
        }

        for (Orden o : ordenesDeLaSesion) {
            o.setFecha(citaActual.getFechaHora().substring(0, 10));
            o.setMedico(this.medico);
            gestionHistorias.agregarOrden(citaActual.getPaciente(), o);
        }

        citaActual.setEstado(EstadoCita.ATENDIDA);
        JOptionPane.showMessageDialog(this, "Consulta, recetas y órdenes guardadas exitosamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
        
        medicoPanel.mostrarAgenda();
    }
    
    private void limpiarCampos() {
        motivoArea.setText("");
        antecedentesArea.setText("");
        signosVitalesArea.setText("");
        examenFisicoArea.setText("");
        diagnosticoArea.setText("");
        planArea.setText("");
        medicamentoField.setText("");
        dosisField.setText("");
        frecuenciaField.setText("");
        duracionField.setText("");
        ordenDescripcionField.setText("");
        recetasResumenArea.setText("");
        ordenResumenArea.setText("");
        recetasDeLaSesion.clear();
        ordenesDeLaSesion.clear();
    }
    
    private void actualizarResumenRecetas() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < recetasDeLaSesion.size(); i++) {
            Receta r = recetasDeLaSesion.get(i);
            sb.append(String.format("%d. %s - %s - %s - %s\n", i + 1, r.getMedicamento(), r.getDosis(), r.getFrecuencia(), r.getDuracion()));
        }
        recetasResumenArea.setText(sb.toString());
    }

    private void actualizarResumenOrdenes() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ordenesDeLaSesion.size(); i++) {
            Orden o = ordenesDeLaSesion.get(i);
            sb.append(String.format("%d. [%s] %s\n", i + 1, o.getTipo(), o.getDescripcion()));
        }
        ordenResumenArea.setText(sb.toString());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 32767));
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        antecedentesArea = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        motivoArea = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        signosVitalesArea = new javax.swing.JTextArea();
        jScrollPane4 = new javax.swing.JScrollPane();
        examenFisicoArea = new javax.swing.JTextArea();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        diagnosticoArea = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        planArea = new javax.swing.JTextArea();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        medicamentoField = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        dosisField = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        frecuenciaField = new javax.swing.JTextField();
        duracionField = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane7 = new javax.swing.JScrollPane();
        ordenResumenArea = new javax.swing.JTextArea();
        anadirRecetaButton = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        tipoOrdenComboBox = new javax.swing.JComboBox<>();
        jLabel16 = new javax.swing.JLabel();
        ordenDescripcionField = new javax.swing.JTextField();
        anadirOrdenButton = new javax.swing.JButton();
        jScrollPane8 = new javax.swing.JScrollPane();
        recetasResumenArea = new javax.swing.JTextArea();
        finalizarConsultaButton = new javax.swing.JButton();

        jLabel1.setText("Paciente");

        jLabel2.setText("Registrar Consulta");

        jLabel3.setText("Motivo:");

        antecedentesArea.setColumns(20);
        antecedentesArea.setRows(5);
        antecedentesArea.setMaximumSize(new java.awt.Dimension(380, 38));
        jScrollPane1.setViewportView(antecedentesArea);

        jLabel4.setText("Antescedentes:");

        motivoArea.setColumns(20);
        motivoArea.setRows(5);
        motivoArea.setMaximumSize(new java.awt.Dimension(380, 38));
        jScrollPane2.setViewportView(motivoArea);

        jLabel5.setText("Signos Vitales:");

        signosVitalesArea.setColumns(20);
        signosVitalesArea.setRows(5);
        signosVitalesArea.setMaximumSize(new java.awt.Dimension(380, 38));
        jScrollPane3.setViewportView(signosVitalesArea);

        examenFisicoArea.setColumns(20);
        examenFisicoArea.setRows(5);
        examenFisicoArea.setMaximumSize(new java.awt.Dimension(380, 38));
        jScrollPane4.setViewportView(examenFisicoArea);

        jLabel6.setText("Examen Fisico:");

        diagnosticoArea.setColumns(20);
        diagnosticoArea.setRows(5);
        diagnosticoArea.setMaximumSize(new java.awt.Dimension(380, 38));
        jScrollPane5.setViewportView(diagnosticoArea);

        jLabel7.setText("Diagnostico:");

        planArea.setColumns(20);
        planArea.setRows(5);
        planArea.setMaximumSize(new java.awt.Dimension(380, 38));
        jScrollPane6.setViewportView(planArea);

        jLabel8.setText("Plan:");

        jLabel9.setText("Emitir Recetas");

        jLabel10.setText("Medicamento:");

        jLabel11.setText("Dosis:");

        jLabel12.setText("Frecuencia:");

        duracionField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                duracionFieldActionPerformed(evt);
            }
        });

        jLabel13.setText("Duracion:");

        jScrollPane7.setMaximumSize(new java.awt.Dimension(960, 32767));

        ordenResumenArea.setColumns(20);
        ordenResumenArea.setRows(5);
        ordenResumenArea.setMaximumSize(new java.awt.Dimension(962, 84));
        jScrollPane7.setViewportView(ordenResumenArea);

        anadirRecetaButton.setText("Añadir Receta");
        anadirRecetaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anadirRecetaButtonActionPerformed(evt);
            }
        });

        jLabel14.setText("Emitir Ordenes");

        jLabel15.setText("Tipo:");

        tipoOrdenComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel16.setText("Descripción:");

        anadirOrdenButton.setText("Añadir Orden");
        anadirOrdenButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anadirOrdenButtonActionPerformed(evt);
            }
        });

        jScrollPane8.setMaximumSize(new java.awt.Dimension(960, 74));

        recetasResumenArea.setColumns(20);
        recetasResumenArea.setRows(5);
        recetasResumenArea.setMaximumSize(new java.awt.Dimension(962, 84));
        jScrollPane8.setViewportView(recetasResumenArea);

        finalizarConsultaButton.setText("Finalizar Consulta");
        finalizarConsultaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                finalizarConsultaButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(11, 11, 11)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 85, Short.MAX_VALUE)
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                                    .addComponent(jScrollPane3)
                                    .addComponent(jScrollPane5)))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel9)
                                .addComponent(jLabel14)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGap(6, 6, 6)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel15)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(tipoOrdenComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel16)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(ordenDescripcionField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                            .addComponent(anadirOrdenButton, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(6, 6, 6)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 940, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(medicamentoField, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(dosisField, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel12)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addGap(26, 26, 26)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                    .addComponent(jScrollPane4, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                                                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                                    .addComponent(jScrollPane6)))
                                            .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(frecuenciaField, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel13)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(duracionField, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(anadirRecetaButton))))))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(423, 423, 423)
                        .addComponent(finalizarConsultaButton)))
                .addContainerGap(18, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(medicamentoField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(dosisField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(frecuenciaField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel13)
                    .addComponent(duracionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anadirRecetaButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel15)
                    .addComponent(tipoOrdenComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel16)
                    .addComponent(ordenDescripcionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(anadirOrdenButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(finalizarConsultaButton)
                .addContainerGap(12, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void anadirRecetaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anadirRecetaButtonActionPerformed
        agregarRecetaALista();
    }//GEN-LAST:event_anadirRecetaButtonActionPerformed

    private void anadirOrdenButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anadirOrdenButtonActionPerformed
        agregarOrdenALista();
    }//GEN-LAST:event_anadirOrdenButtonActionPerformed

    private void finalizarConsultaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_finalizarConsultaButtonActionPerformed
        finalizarConsulta();
    }//GEN-LAST:event_finalizarConsultaButtonActionPerformed

    private void duracionFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_duracionFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_duracionFieldActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton anadirOrdenButton;
    private javax.swing.JButton anadirRecetaButton;
    private javax.swing.JTextArea antecedentesArea;
    private javax.swing.JTextArea diagnosticoArea;
    private javax.swing.JTextField dosisField;
    private javax.swing.JTextField duracionField;
    private javax.swing.JTextArea examenFisicoArea;
    private javax.swing.Box.Filler filler1;
    private javax.swing.JButton finalizarConsultaButton;
    private javax.swing.JTextField frecuenciaField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JTextField medicamentoField;
    private javax.swing.JTextArea motivoArea;
    private javax.swing.JTextField ordenDescripcionField;
    private javax.swing.JTextArea ordenResumenArea;
    private javax.swing.JTextArea planArea;
    private javax.swing.JTextArea recetasResumenArea;
    private javax.swing.JTextArea signosVitalesArea;
    private javax.swing.JComboBox<String> tipoOrdenComboBox;
    // End of variables declaration//GEN-END:variables
}
