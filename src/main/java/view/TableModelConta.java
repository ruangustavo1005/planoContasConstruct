package view;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;
import model.Conta;

/**
 *
 * @author Ruan
 */
public class TableModelConta extends AbstractTableModel {

    private ArrayList<Conta> contas;

    public TableModelConta() {
        this.contas = new ArrayList<>();
    }
    
    public TableModelConta(ArrayList<Conta> contas) {
        this.contas = contas;
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }

    public void setContas(ArrayList<Conta> contas) {
        this.contas = contas;
    }

    public void add(Conta conta) {
        this.contas.add(conta);
        int i = this.contas.indexOf(conta);
        fireTableRowsInserted(i, i);
    }

    public void remove(int i) {
        this.contas.remove(i);
        fireTableRowsDeleted(i, i);
    }

    public void update(int i) {
        fireTableRowsUpdated(i, i);
    }

    public Conta get(int i) {
        return this.contas.get(i);
    }

    public Conta get(Conta conta) {
        return this.contas.get(this.contas.indexOf(conta));
    }
    
    @Override
    public int getRowCount() {
        return contas.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Object retorno = null;
        switch (columnIndex) {
            case 0 : retorno = contas.get(rowIndex).getCodigoWithHierarquia() + " - " + contas.get(rowIndex).getDescricao(); break;
            case 1 : retorno = contas.get(rowIndex).isDedutora() ? "Sim" : "Não";                                            break;
            case 2 : retorno = contas.get(rowIndex).getValor();                                                              break;
            case 3 : retorno = contas.get(rowIndex).isAnalitica() ? "Analítica" : "Sintética";                               break;
        }
        return retorno;
    }

    @Override
    public String getColumnName(int column) {
        String retorno = null;
        switch (column) {
            case 0 : retorno = "Descrição"; break;
            case 1 : retorno = "Dedutora";  break;
            case 2 : retorno = "Valor";     break;
            case 3 : retorno = "Juízo";     break;
        }
        return retorno;
    }
    
}