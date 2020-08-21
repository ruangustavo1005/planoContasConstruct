package view;

import java.awt.event.ActionListener;
import java.text.ParseException;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import model.Conta;

/**
 *
 * @author Ruan
 */
public class ViewAdicionarConta extends javax.swing.JFrame {

    private Conta contaPai;
    
    public ViewAdicionarConta() {
        initComponents();
        this.txtContaBase.setHorizontalAlignment(JTextField.RIGHT);
    }

    public void setContaPai(Conta contaPai) {
        this.contaPai = contaPai;
        this.formataCampoConta();
    }
    
    private void formataCampoConta() {
        try {
            StringBuilder mascara = new StringBuilder();
            while (mascara.length() < (Conta.TAMANHO_CONTA - contaPai.getCodigoNivelCalculado().length())) {
                mascara.append("#");
            }
            MaskFormatter mask = new MaskFormatter(mascara.toString());
            mask.setPlaceholderCharacter('0');
            mask.install(this.txtConta);
        }
        catch (ParseException ex) {
            JOptionPane.showMessageDialog(this, "Erro ao formar um campo!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public Conta getContaFromView() {
        Conta conta = null;
        if (!this.txtConta.getText().equals("")
         && !this.txtDescricao.getText().equals("")) {
            conta = new Conta();
            conta.setCodigo(this.txtContaBase.getText() + this.txtConta.getText());
            conta.setDescricao(this.txtDescricao.getText());
            conta.setDedutora(this.chkDedutora.isSelected());
            conta.setContaPai(this.contaPai);
        }
        return conta;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        chkDedutora = new javax.swing.JCheckBox();
        txtContaBase = new javax.swing.JTextField();
        txtConta = new javax.swing.JFormattedTextField();
        txtDescricao = new javax.swing.JTextField();
        btnAdicionar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Nova conta");

        jLabel1.setText("Código:");

        jLabel2.setText("Descrição:");

        chkDedutora.setText(" Dedutora:");
        chkDedutora.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);

        txtContaBase.setEditable(false);

        btnAdicionar.setText("Adicionar conta");

        btnCancelar.setText("Cancelar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnAdicionar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(txtContaBase, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtConta, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(chkDedutora)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(txtDescricao))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtContaBase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(chkDedutora))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnAdicionar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    public void adicionaAcaoAdicionar(ActionListener actionListener) {
        this.btnAdicionar.addActionListener(actionListener);
    }

    public void adicionaAcaoCancelar(ActionListener actionListener) {
        this.btnCancelar.addActionListener(actionListener);
    }
    
    @Override
    public void setVisible(boolean visibility) {
        if (visibility) {
            if (this.contaPai != null) {
                this.txtContaBase.setText(this.contaPai.getCodigoNivelCalculado());
                this.txtDescricao.setText(this.contaPai.getDescricao() + " - ");
            }
        }
        super.setVisible(visibility);
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdicionar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JCheckBox chkDedutora;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JFormattedTextField txtConta;
    private javax.swing.JTextField txtContaBase;
    private javax.swing.JTextField txtDescricao;
    // End of variables declaration//GEN-END:variables
}
