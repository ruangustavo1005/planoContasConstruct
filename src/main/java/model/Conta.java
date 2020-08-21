package model;

/**
 *
 * @author Ruan
 */
public class Conta {
    
    static public int TAMANHO_CONTA = 15;
    
    private String  codigo;
    private String  descricao;
    private boolean dedutora;
    private float   valor;
    private Conta   contaPai;
    private boolean legado;
    private boolean analitica;

    public Conta() {
        this.valor = 0f;
        this.legado = false;
        this.analitica = true;
    }

    public Conta(String codigo, String descricao, boolean dedutora, float valor, Conta contaPai, boolean legado, boolean analitica) {
        this.setCodigo(codigo);
        this.setDescricao(descricao);
        this.setDedutora(dedutora);
        this.valor = valor;
        this.setContaPai(contaPai);
        this.setLegado(legado);
        this.setAnalitica(analitica);
    }

    public Conta(String codigo, String descricao, boolean dedutora, float valor, Conta contaPai) {
        this.setCodigo(codigo);
        this.setDescricao(descricao);
        this.setDedutora(dedutora);
        this.valor = valor;
        this.setContaPai(contaPai);
        this.setLegado(false);
        this.setAnalitica(true);
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = rpad(codigo, TAMANHO_CONTA);
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public boolean isDedutora() {
        return dedutora;
    }

    public void setDedutora(boolean dedutora) {
        this.dedutora = dedutora;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public void addValor(float valor) {
        this.valor += valor;
        if (this.isDedutora()) {
            valor = valor * -1;
        }
        if (!this.isContaMestre()) {
            this.contaPai.addValor(valor);
        }
    }

    public Conta getContaPai() {
        if (contaPai == null) {
            contaPai = new Conta();
            contaPai.setAnalitica(false);
        }
        return contaPai;
    }

    public void setContaPai(Conta contaPai) {
        this.contaPai = contaPai;
    }

    public boolean isLegado() {
        return legado;
    }

    public void setLegado(boolean legado) {
        this.legado = legado;
    }

    public boolean isAnalitica() {
        return analitica;
    }

    public void setAnalitica(boolean analitica) {
        this.analitica = analitica;
    }
    
    public String getCodigoWithHierarquia() {
        StringBuilder retorno = new StringBuilder("");
        int tamanhoCodigoNivelCalculado = this.getCodigoNivelCalculado().length() - 1;
        while (retorno.length() < tamanhoCodigoNivelCalculado) {
            retorno.append(" ");
        }
        return retorno + this.getCodigo();
    }
    
    public String getCodigoNivelCalculado() {
        return new StringBuilder(
            String.valueOf(
                Double.valueOf(
                    new StringBuilder(
                        this.getCodigo()
                    ).reverse().toString()
                )
            )
        ).reverse().toString().substring(2);
    }
    
    public boolean isContaMestre() {
        return Float.valueOf(this.getCodigo().substring(1, TAMANHO_CONTA - 1)) == 0;
    }

    static public String rpad(String inputString, int length) {
        if (inputString.length() > length) {
            return inputString;
        }
        if (inputString.length() > length) {
            return inputString.substring(0, TAMANHO_CONTA - 1);
        }
        return String.format("%-" + TAMANHO_CONTA + "s", inputString).replace(' ', '0');
    }
}