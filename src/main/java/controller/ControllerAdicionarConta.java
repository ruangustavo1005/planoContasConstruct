package controller;

import java.awt.event.ActionEvent;
import javax.swing.JOptionPane;
import model.Conta;
import view.ViewAdicionarConta;

/**
 *
 * @author Ruan
 */
public class ControllerAdicionarConta {
    
    static private ControllerAdicionarConta instance;

    private ViewAdicionarConta viewAdicionarConta;
    
    private ControllerAdicionarConta() {
        
    }

    public static ControllerAdicionarConta getInstance() {
        if (instance == null) {
            instance = new ControllerAdicionarConta();
        }
        return instance;
    }
    
    private void adicionaAcoes() {
        this.adicionaAcaoAdicionar();
        this.adicionaAcaoCancelar();
    }
    
    private void adicionaAcaoAdicionar() {
        this.viewAdicionarConta.adicionaAcaoAdicionar((ActionEvent e) -> {
            Conta conta  = this.viewAdicionarConta.getContaFromView();
            if (conta != null) {
                ControllerIndex.getInstance().adicionarConta(conta);
                this.viewAdicionarConta.dispose();
            }
            else {
                JOptionPane.showMessageDialog(this.viewAdicionarConta, "Houve um erro ao inserir, verifique os dados cadastrais da conta", "Atenção", JOptionPane.WARNING_MESSAGE);
            }
        });
    }
    
    private void adicionaAcaoCancelar() {
        this.viewAdicionarConta.adicionaAcaoCancelar((ActionEvent e) -> {
            this.viewAdicionarConta.dispose();
        });
    }
    
    public void montaTela(Conta conta) {
        this.viewAdicionarConta = new ViewAdicionarConta();
        this.adicionaAcoes();
        this.viewAdicionarConta.setContaPai(conta);
        this.viewAdicionarConta.setVisible(true);
    }
    
}