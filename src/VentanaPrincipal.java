
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

public class VentanaPrincipal extends javax.swing.JFrame {
    Arbol arbolPrincipal = new Arbol();
    ArrayList<Nodo> temporal = new ArrayList<Nodo>(); //la primera cola que sera creada al momento de subir un .txt, esta cola la va a recibir el arbolPrincipal para poder empezar su construccion
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
        jScrollPane4 = new javax.swing.JScrollPane();
        jtable_info = new javax.swing.JTable();
        jbt_abrirBinario = new javax.swing.JButton();
        jtxt_porcentaje = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtxt_bitsInicio = new javax.swing.JTextField();
        jtxt_bitsFinales = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jbutton_cargar.setText("Cargar Archivo de Texto (Codificar)");
        jbutton_cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbutton_cargarActionPerformed(evt);
            }
        });

        jLabel1.setText("Texto del archivo");

        jtxt_area_codificado.setEditable(false);
        jtxt_area_codificado.setColumns(20);
        jtxt_area_codificado.setRows(5);
        jScrollPane1.setViewportView(jtxt_area_codificado);

        jLabel2.setText("Texto codificado");

        jLabel3.setText("Texto decodificado");

        jtxt_area_decodificado.setEditable(false);
        jtxt_area_decodificado.setColumns(20);
        jtxt_area_decodificado.setRows(5);
        jScrollPane2.setViewportView(jtxt_area_decodificado);

        jtxt_area_inicio.setEditable(false);
        jtxt_area_inicio.setColumns(20);
        jtxt_area_inicio.setRows(5);
        jScrollPane3.setViewportView(jtxt_area_inicio);

        jtable_info.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Caracter", "Frecuencia", "Codigo Binario", "% de Compresion"
            }
        ));
        jScrollPane4.setViewportView(jtable_info);

        jbt_abrirBinario.setText("Cargar Archivo Binario (Decodificarlo)");

        jtxt_porcentaje.setEditable(false);

        jLabel4.setText("Compression Rate:");

        jLabel5.setText("Original File:");

        jLabel6.setText("Compressed File:");

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
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(115, 115, 115)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 114, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(60, 60, 60))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(265, 265, 265)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jtxt_bitsFinales, javax.swing.GroupLayout.DEFAULT_SIZE, 108, Short.MAX_VALUE)
                                .addComponent(jtxt_bitsInicio)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jtxt_porcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(340, 340, 340)
                        .addComponent(jbutton_cargar, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbt_abrirBinario, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(42, 42, 42))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbutton_cargar, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbt_abrirBinario, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 331, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 315, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(58, 58, 58)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtxt_porcentaje, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtxt_bitsInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(15, 15, 15)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtxt_bitsFinales, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(78, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    String texto = "";
    public void imprimirTemporal() { //imprime la lista de nodos creados, verificando que no exista repeticion de chars
        for (int i = 0; i < temporal.size(); i++) {
            System.out.println(temporal.get(i));
        }
    }
    
    public void textoCodificado() { //metodo que pide la direccion de un nodo segun el char que se esta recorriendo en el texto
        int longitud = 10;
        int charDeMas = 0;
        int contadorBitsOri = texto.length()*8;
        String directionChar = "";
        for (int i = 0; i < texto.length(); i++) {
            directionChar += arbolPrincipal.direccionNodo(texto.charAt(i), arbolPrincipal.getRaiz(), "");
            if(i >= longitud) {
                directionChar += "\n";
                charDeMas++;
                longitud+=10;
            }
        }
        int contadorBitsComp = directionChar.length();
        contadorBitsComp-=charDeMas;
        this.jtxt_area_codificado.append(directionChar);
        this.jtxt_bitsInicio.setText(contadorBitsOri+"");
        this.jtxt_bitsFinales.setText(contadorBitsComp+"");
        float sinPorc = (float) contadorBitsComp/contadorBitsOri;
        float porcentajeCompresion = 100 * sinPorc;
        this.jtxt_porcentaje.setText(porcentajeCompresion+"%");
    }
    
    public void modificarTabla() {
        DefaultTableModel tabla = (DefaultTableModel) this.jtable_info.getModel();
        ArrayList<Nodo> soloLeafs = new ArrayList<Nodo>(); //esta lista solo va a obtener las hojas del arbol, puesto que solo nos interesa los chars del texto, y estos son las hojas
        soloLeafs = arbolPrincipal.retornarSoloLeafs(soloLeafs, arbolPrincipal.getRaiz()); //modificacion, aqui ya se obtiene solamente las hojas del arbol principal
        for (int i = 0; i < soloLeafs.size(); i++) {
            char caracterText = soloLeafs.get(i).getCaracter();
            String direccion = arbolPrincipal.direccionNodo(caracterText, arbolPrincipal.getRaiz(), "");
            float porcentajeCompressed = ((float) direccion.length()/8)*100;
            tabla.addRow(new Object[] {caracterText, soloLeafs.get(i).getFrecuencia(), direccion, porcentajeCompressed});
        }
        this.jtable_info.setModel(tabla);
    }
    
    public boolean repeticion(char caracter) { //evitar que existan dos nodos o mas con el mismo char
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
    public void caracteresYfrecuencia() { //crea nodo con su respectivo caracter y la frecuencia en que este aparece en el texto
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
        //arbolPrincipal.imprimiendoArbol(arbolPrincipal.getRaiz());
        textoCodificado();
        modificarTabla();
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
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton jbt_abrirBinario;
    private javax.swing.JButton jbutton_cargar;
    private javax.swing.JTable jtable_info;
    private javax.swing.JTextArea jtxt_area_codificado;
    private javax.swing.JTextArea jtxt_area_decodificado;
    private javax.swing.JTextArea jtxt_area_inicio;
    private javax.swing.JTextField jtxt_bitsFinales;
    private javax.swing.JTextField jtxt_bitsInicio;
    private javax.swing.JTextField jtxt_porcentaje;
    // End of variables declaration//GEN-END:variables
}
