
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFileChooser;

public class VentanaPrincipal extends javax.swing.JFrame {
    Arbol arbolPrincipal = new Arbol();
    ArrayList<Nodo> temporal = new ArrayList<Nodo>();
    public VentanaPrincipal() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbutton_cargar = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtxt_area_codificado = new javax.swing.JTextArea();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jtxt_area_decodificado = new javax.swing.JTextArea();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtxt_area_inicio = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbutton_cargar.setText("Cargar Archivo");
        jbutton_cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutton_cargarActionPerformed(evt);
            }
        });

        jLabel1.setText("Texto del archivo");

        jtxt_area_codificado.setColumns(20);
        jtxt_area_codificado.setRows(5);
        jScrollPane1.setViewportView(jtxt_area_codificado);

        jLabel2.setText("Texto codificado");

        jLabel3.setText("Texto decodificado");

        jtxt_area_decodificado.setColumns(20);
        jtxt_area_decodificado.setRows(5);
        jScrollPane2.setViewportView(jtxt_area_decodificado);

        jtxt_area_inicio.setColumns(20);
        jtxt_area_inicio.setRows(5);
        jScrollPane3.setViewportView(jtxt_area_inicio);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(91, 91, 91)
                .addComponent(jLabel1)
                .addGap(254, 254, 254)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(136, 136, 136))
            .addGroup(layout.createSequentialGroup()
                .addGap(115, 115, 115)
                .addComponent(jbutton_cargar, javax.swing.GroupLayout.PREFERRED_SIZE, 167, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jbutton_cargar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(61, 61, 61)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(41, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    String texto = "";
    public void imprimirTemporal() {
        for (int i = 0; i < temporal.size(); i++) {
            System.out.println(temporal.get(i));
        }
    }
    public boolean repeticion(char caracter) {
        for (int i = 0; i < temporal.size(); i++) {
            if(caracter == temporal.get(i).getCaracter()) {
                return true;
            }
        }
        return false;
    }
    public void insertarEnOrden(Nodo nuevo) {
        int contador = 0;
        if(temporal.size() > 0) {
            while(contador < temporal.size() && nuevo.getFrecuencia() > temporal.get(contador).getFrecuencia()) {
                contador++;
            }
            temporal.add(contador, nuevo);
        } else {
            temporal.add(nuevo);
        }
    }
    public void caracteresYfrecuencia() {
        for (int i = 0; i < texto.length(); i++) {
            Nodo nuevo = new Nodo();
            int frecuencia = 0;
            char caracter = texto.charAt(i);
            for (int j = 0; j < texto.length(); j++) {
                if(caracter == texto.charAt(j)) {
                    frecuencia++;
                }
            }
            if(!repeticion(caracter)) {
                nuevo.setCaracter(caracter);
                nuevo.setFrecuencia(frecuencia);
                insertarEnOrden(nuevo);
            }
        }
    }
    private void jbutton_cargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbutton_cargarActionPerformed
        // TODO add your handling code here:
        // abrir archivo de texto
        JFileChooser election = new JFileChooser();
        int state = election.showOpenDialog(this);
        if(JFileChooser.APPROVE_OPTION == state) {
            try {
            File archivo = election.getSelectedFile();
            BufferedReader br = new BufferedReader(new FileReader(archivo));
            String caracteres = "";
                while(caracteres != null) {
                    caracteres = br.readLine();
                    if(caracteres != null) {
                        this.jtxt_area_inicio.append(caracteres+"\n");
                        texto += caracteres;
                    }
                }
            } catch (IOException ex) {
            }
        }
        caracteresYfrecuencia();
        if(temporal.size() > 0) {
            arbolPrincipal.construyendoArbol(temporal);
        }
        arbolPrincipal.imprimiendoArbol(arbolPrincipal.getRaiz());
    }//GEN-LAST:event_jbutton_cargarActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VentanaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton jbutton_cargar;
    private javax.swing.JTextArea jtxt_area_codificado;
    private javax.swing.JTextArea jtxt_area_decodificado;
    private javax.swing.JTextArea jtxt_area_inicio;
    // End of variables declaration//GEN-END:variables
}
