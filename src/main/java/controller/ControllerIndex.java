package controller;

import dao.DaoContaPadrao;
import java.awt.event.ActionEvent;
import java.math.BigInteger;
import javax.swing.JOptionPane;
import model.Conta;
import view.TableModelConta;
import view.ViewIndex;

/**
 *
 * @author Ruan
 */
public class ControllerIndex {
    
    static private ControllerIndex instance;

    private ViewIndex viewIndex;
    
    private ControllerIndex() {
        this.viewIndex = new ViewIndex();
        this.adicionaAcoes();
    }

    public static ControllerIndex getInstance() {
        if (instance == null) {
            instance = new ControllerIndex();
        }
        return instance;
    }
    
    private void adicionaAcoes() {
        this.adicionaAcaoLancarValor();
        this.adicionaAcaoAdicionarConta();
        this.adicionaAcaoRemoverConta();
    }
    
    private void adicionaAcaoLancarValor() {
        this.viewIndex.adicionaAcaoLancarValor((ActionEvent e) -> {
            int indice = viewIndex.getTabelaContas().getSelectedRow();
            if (indice >= 0) {
                Conta conta = this.viewIndex.getTableModelConta().get(indice);
                float valor = Float.valueOf(String.valueOf(this.viewIndex.getTxtValorLancar().getText()).replace(".", "").replace(",", "."));
                if (this.viewIndex.getChkDeduzir().isSelected()) {
                    valor = valor * -1;
                }
                conta.addValor(valor);
                this.viewIndex.getTableModelConta().update(indice);
                do {
                    conta = conta.getContaPai();
                    indice = this.viewIndex.getTableModelConta().getContas().indexOf(conta);
                    this.viewIndex.getTableModelConta().update(indice);
                } while (!conta.isContaMestre());
                this.viewIndex.getTxtValorLancar().setText("");
            }
            else {
                JOptionPane.showMessageDialog(viewIndex, "Selecione uma conta para lançar um valor", "Atenção", JOptionPane.WARNING_MESSAGE);
            }
        });
    }
    
    private void adicionaAcaoAdicionarConta() {
        this.viewIndex.adicionaAcaoAdicionarConta((ActionEvent e) -> {
            int indice = viewIndex.getTabelaContas().getSelectedRow();
            if (indice >= 0) {
                Conta conta = this.viewIndex.getTableModelConta().get(indice);
                if (conta.isAnalitica() && conta.getValor() != 0) {
                    if (JOptionPane.showConfirmDialog(this.viewIndex, "A conta selecionada é analítica e por isso a movimentação desta conta\nserá repassada para a conta que será criada agora. Deseja continuar?", "Atenção", JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        ControllerAdicionarConta.getInstance().montaTela(conta);
                    }
                }
                else {
                    ControllerAdicionarConta.getInstance().montaTela(conta);
                }
            }
            else {
                JOptionPane.showMessageDialog(this.viewIndex, "Selecione uma conta para criar uma conta filha", "Atenção", JOptionPane.WARNING_MESSAGE);
            }
        });
    }
    
    private void adicionaAcaoRemoverConta() {
        this.viewIndex.adicionaAcaoRemoverConta((ActionEvent e) -> {
            int indice = viewIndex.getTabelaContas().getSelectedRow();
            if (indice >= 0) {
                if (!this.viewIndex.getTableModelConta().get(indice).isLegado()) {
                    this.viewIndex.getTableModelConta().remove(indice);
                }
                else {
                    JOptionPane.showMessageDialog(this.viewIndex, "Não é possível remover uma conta legado!", "Atenção", JOptionPane.WARNING_MESSAGE);
                }
            }
            else {
                JOptionPane.showMessageDialog(this.viewIndex, "Selecione uma conta para removê-la", "Atenção", JOptionPane.WARNING_MESSAGE);
            }
        });
    }
    
    public void adicionarConta(Conta conta) {
        TableModelConta tableModel = this.viewIndex.getTableModelConta();
        
        conta.setValor(conta.getContaPai().getValor());
        tableModel.add(conta);
        
        tableModel.get(conta.getContaPai()).setAnalitica(false);
        tableModel.update(tableModel.getContas().indexOf(conta.getContaPai()));
        
        this.sortContas();
    }
    
    private void sortContas() {
        this.viewIndex.getTableModelConta().getContas().sort((Conta conta1, Conta conta2) -> {
            return conta1.getCodigo().compareTo(conta2.getCodigo());
        });
        this.viewIndex.getTableModelConta().fireTableRowsUpdated(0, this.viewIndex.getTableModelConta().getContas().size() - 1);
    }
    
    public void montaTela() {
        this.viewIndex.getTableModelConta().setContas(DaoContaPadrao.getInstance().getContasPadrao());
        this.sortContas();
        this.viewIndex.setVisible(true);
    }
    
}

//  Inconsistências
//
//  DaoContaPadrao.getInstance().getContasPadrao().forEach(conta -> {
//      if (!conta.isContaMestre()) {
//          Conta contaPai = conta.getContaPai();
//          if (!conta.getCodigoNivelCalculado().substring(0, contaPai.getCodigoNivelCalculado().length()).equals(contaPai.getCodigoNivelCalculado())) {
//              System.out.println(conta.getCodigo());
//          }
//      }
//  });