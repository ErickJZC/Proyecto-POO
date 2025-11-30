/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package GUI;

import Gestion.GestionCitas;
import Gestion.GestionFacturacion;
import Gestion.GestionHistoriasClinicas;
import Modelo.Cita;
import Modelo.EstadoCita;
import Modelo.HistoriaClinica;
import Modelo.Orden;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author erick
 */
public class CajeroPanel extends javax.swing.JPanel {

    private MainFrame mainFrame;
    private GestionCitas gestionCitas;
    private GestionFacturacion gestionFacturacion;
    private GestionHistoriasClinicas gestionHistorias;
    
    private DefaultTableModel tableModel;
    private ArrayList<Cita> citasPendientes;

    /**
     * Creates new form CajeroPanel
     */
    public CajeroPanel() {
        this(null, null, null, null);
    }
    
    public CajeroPanel(MainFrame mainFrame, GestionCitas gestionCitas, GestionFacturacion gestionFacturacion, GestionHistoriasClinicas gestionHistorias) {
        this.mainFrame = mainFrame;
        this.gestionCitas = gestionCitas;
        this.gestionFacturacion = gestionFacturacion;
        this.gestionHistorias = gestionHistorias;
        
        initComponents();
        metodoPagoComboBox.setModel(new DefaultComboBoxModel<>(new String[]{"Efectivo", "Tarjeta"})) ;
        
        String[] columnas = {"Fecha/Hora", "Paciente", "Médico"};
        tableModel = new DefaultTableModel(columnas, 0) {
            @Override
            public boolean isCellEditable(int row, int column) { return false; }
        };
        tablaCitasPendientes.setModel(tableModel);
        
        tablaCitasPendientes.getSelectionModel().addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting() && tablaCitasPendientes.getSelectedRow() != -1) {
                mostrarDetalleFactura();
            }
        });
        
        cargarCitasPendientes();
    }
    
    private void cargarCitasPendientes() {
        citasPendientes = new ArrayList<>();
        for (Cita cita : gestionCitas.getCitas()) {
            if (cita.getEstado() == EstadoCita.ATENDIDA) {
                citasPendientes.add(cita);
            }
        }

        tableModel.setRowCount(0);
        for (Cita cita : citasPendientes) {
            Object[] row = {
                cita.getFechaHora(),
                cita.getPaciente(),
                cita.getMedico()
            };
            tableModel.addRow(row);
        }
        detalleFacturaArea.setText("Seleccione una cita para ver el detalle.");
    }
    
    private void mostrarDetalleFactura() {
        int selectedRow = tablaCitasPendientes.getSelectedRow();
        if (selectedRow == -1) return;

        Cita cita = citasPendientes.get(selectedRow);
        HistoriaClinica historia = gestionHistorias.getHistoriaClinica(cita.getPaciente());
        double total = gestionFacturacion.calcularTotal(cita, historia);

        StringBuilder sb = new StringBuilder();
        sb.append("Paciente: ").append(cita.getPaciente().getNombres()).append(" ").append(cita.getPaciente().getApellidos()).append("\n");
        sb.append("Fecha: ").append(cita.getFechaHora()).append("\n\n");
        sb.append("--- Desglose ---\n");
        sb.append("Consulta con Dr. ").append(cita.getMedico().getApellidos()).append(": $50.0\n");
        
        if (historia != null) {
            for (Orden orden : historia.getOrdenes()) {
                if (orden.getFecha().equals(cita.getFechaHora().substring(0, 10))) {
                    if (orden.getTipo().equals("Laboratorio")) {
                        sb.append("Orden de Laboratorio: $25.0\n");
                    } else if (orden.getTipo().equals("Imagen")) {
                        sb.append("Orden de Imagen: $75.0\n");
                    }
                }
            }
        }
        
        sb.append("\n------------------\n");
        sb.append("TOTAL A PAGAR: $").append(total);
        detalleFacturaArea.setText(sb.toString());
    }
    
    private void registrarPago(String metodoPago) {
        int selectedRow = tablaCitasPendientes.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Por favor, seleccione una cita para registrar el pago.", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Cita cita = citasPendientes.get(selectedRow);
        HistoriaClinica historia = gestionHistorias.getHistoriaClinica(cita.getPaciente());
        double total = gestionFacturacion.calcularTotal(cita, historia);

        int confirm = JOptionPane.showConfirmDialog(this,
                "¿Confirmar el pago de $" + total + " para el paciente " + cita.getPaciente().getNombres() + "?",
                "Confirmar Pago",
                JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
            gestionFacturacion.crearFactura(cita, total, metodoPago);
            JOptionPane.showMessageDialog(this, "Pago registrado y factura generada. La cita ha sido completada.", "Éxito", JOptionPane.INFORMATION_MESSAGE);
            cargarCitasPendientes();
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

        jLabel1 = new javax.swing.JLabel();
        logoutButton = new java.awt.Button();
        jSplitPane1 = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaCitasPendientes = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        detalleFacturaArea = new javax.swing.JTextArea();
        jLabel4 = new javax.swing.JLabel();
        metodoPagoComboBox = new javax.swing.JComboBox<>();
        registrarPagoButton = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Módulo de Caja y Facturación");

        logoutButton.setLabel("Cerrar Sesion");
        logoutButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                logoutButtonActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel2.setText("Citas Atendidas Pendientes de Pago");

        tablaCitasPendientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tablaCitasPendientes);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(0, 302, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 560, Short.MAX_VALUE)
                .addContainerGap())
        );

        jSplitPane1.setLeftComponent(jPanel1);

        jPanel2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jLabel3.setText("Detalles de Factura");

        detalleFacturaArea.setColumns(20);
        detalleFacturaArea.setRows(5);
        jScrollPane2.setViewportView(detalleFacturaArea);

        jLabel4.setText("Metodo de Pago:");

        registrarPagoButton.setText("Registrar Pago y Generar Factura");
        registrarPagoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                registrarPagoButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(36, 36, 36)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(metodoPagoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(registrarPagoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 213, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 517, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(metodoPagoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(registrarPagoButton))
                .addGap(16, 16, 16))
        );

        jSplitPane1.setRightComponent(jPanel2);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(logoutButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jSplitPane1))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(362, 362, 362))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(jSplitPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 598, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(logoutButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void logoutButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_logoutButtonActionPerformed
        mainFrame.mostrarLoginPanel();
    }//GEN-LAST:event_logoutButtonActionPerformed

    private void registrarPagoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_registrarPagoButtonActionPerformed
        registrarPago((String)metodoPagoComboBox.getSelectedItem());
    }//GEN-LAST:event_registrarPagoButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea detalleFacturaArea;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSplitPane jSplitPane1;
    private java.awt.Button logoutButton;
    private javax.swing.JComboBox<String> metodoPagoComboBox;
    private javax.swing.JButton registrarPagoButton;
    private javax.swing.JTable tablaCitasPendientes;
    // End of variables declaration//GEN-END:variables
}
