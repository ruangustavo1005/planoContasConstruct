package dao;

import java.util.ArrayList;
import model.Conta;

/**
 *
 * @author Ruan
 */
public class DaoContaPadrao {
    
    static private DaoContaPadrao instance;
    
    final static private ArrayList<Conta> contasPadrao = new ArrayList<>();
    
    //<editor-fold defaultstate="collapsed" desc="Definição de contas, código bruto.">
    final static private Conta Ativo                    = new Conta("100000000000000", "ATIVO",                      false, 0, null,               true, false);
    final static private Conta AtivoCirculante          = new Conta("110000000000000", "ATIVO CIRCULANTE",           false, 0, Ativo,              true, false);
    final static private Conta Caixa                    = new Conta("111000000000000", "Caixa",                      false, 0, AtivoCirculante,    true, false);
    final static private Conta CaixaGeral               = new Conta("111010000000000", "Caixa Geral",                false, 0, Caixa,              true, true);
    final static private Conta BancosComMovimento       = new Conta("112000000000000", "Bancos C/Movimento",         false, 0, AtivoCirculante,    true, false);
    final static private Conta BancoAlfa                = new Conta("112010000000000", "Banco Alfa",                 false, 0, BancosComMovimento, true, true);
    final static private Conta ContasAReceber           = new Conta("113000000000000", "Contas a Receber",           false, 0, AtivoCirculante,    true, false);
    final static private Conta Clientes                 = new Conta("113010000000000", "Clientes",                   false, 0, ContasAReceber,     true, true);
    final static private Conta OutrasContasAReceber     = new Conta("113020000000000", "Outras Contas a Receber",    false, 0, ContasAReceber,     true, true);
    final static private Conta DuplicatasDescontadas    = new Conta("113090000000000", "(-) Duplicatas Descontadas", true,  0, ContasAReceber,     true, true);
    final static private Conta Estoques                 = new Conta("114000000000000", "Estoques",                   false, 0, AtivoCirculante,    true, false);
    final static private Conta Mercadorias              = new Conta("114010000000000", "Mercadorias",                false, 0, Estoques,           true, true);
    final static private Conta ProdutosAcabados         = new Conta("114020000000000", "Produtos Acabados",          false, 0, Estoques,           true, true);
    final static private Conta Insumos                  = new Conta("114030000000000", "Insumos",                    false, 0, Estoques,           true, true);
    final static private Conta Outros                   = new Conta("114040000000000", "Outros",                     false, 0, Estoques,           true, true);
    final static private Conta NaoCirculante            = new Conta("120000000000000", "NÃO CIRCULANTE",             false, 0, Ativo,              true, false);
    final static private Conta ContasAReceber2          = new Conta("121000000000000", "Contas a Receber",           false, 0, NaoCirculante,      true, false);
    final static private Conta Clientes2                = new Conta("121010000000000", "Clientes",                   false, 0, ContasAReceber2,    true, true);
    final static private Conta OutrasContas             = new Conta("121020000000000", "Outras Contas",              false, 0, ContasAReceber2,    true, true);
    final static private Conta Investimentos            = new Conta("122000000000000", "INVESTIMENTOS",              false, 0, NaoCirculante,      true, false);
    final static private Conta ParticipacoesSocietarias = new Conta("122010000000000", "Participações Societárias",  false, 0, Investimentos,      true, true);
    final static private Conta Imobilizado              = new Conta("123000000000000", "IMOBILIZADO",                false, 0, NaoCirculante,      true, false);
    final static private Conta Terrenos                 = new Conta("123010000000000", "Terrenos",                   false, 0, Imobilizado,        true, true);
    final static private Conta ConstrucoesEBenfeitorias = new Conta("123020000000000", "Construções e Benfeitorias", false, 0, Imobilizado,        true, true);
    final static private Conta MaquinasEFerramentas     = new Conta("123030000000000", "Máquinas e Ferramentas",     false, 0, Imobilizado,        true, true);
    final static private Conta Veiculos                 = new Conta("123040000000000", "Veículos",                   false, 0, Imobilizado,        true, true);
    final static private Conta Moveis                   = new Conta("123050000000000", "Móveis",                     false, 0, Imobilizado,        true, true);
    final static private Conta DepreciacaoAcumulada     = new Conta("123980000000000", "(-) Depreciação Acumulada",  true,  0, Imobilizado,        true, true);
    final static private Conta AmortizacaoAcumulada     = new Conta("123990000000000", "(-) Amortização Acumulada",  true,  0, Imobilizado,        true, true);
    final static private Conta Intangivel               = new Conta("124000000000000", "INTANGÍVEL",                 false, 0, NaoCirculante,      true, false);
    final static private Conta Marcas                   = new Conta("124010000000000", "Marcas",                     false, 0, Intangivel,         true, true);
    final static private Conta Softwares                = new Conta("124020000000000", "Softwares",                  false, 0, Intangivel,         true, true);
    final static private Conta AmortizacaoAcumulada2    = new Conta("124990000000000", "(-) Amortização Acumulada",  true,  0, Intangivel,         true, true);

    final static private Conta Passivo                                   = new Conta("200000000000000", "PASSIVO",                                       false, 0, null,                            true, false);
    final static private Conta Circulante                                = new Conta("210000000000000", "CIRCULANTE",                                    false, 0, Passivo,                         true, false);
    final static private Conta ImpostosEContribuicoesARecolher           = new Conta("211000000000000", "Impostos e Contribuições a Recolher",           false, 0, Circulante,                      true, false);
    final static private Conta SimplesARecolher                          = new Conta("211010000000000", "Simples a Recolher",                            false, 0, ImpostosEContribuicoesARecolher, true, true);
    final static private Conta Inss                                      = new Conta("211020000000000", "INSS",                                          false, 0, ImpostosEContribuicoesARecolher, true, true);
    final static private Conta Fgts                                      = new Conta("211030000000000", "FGTS",                                          false, 0, ImpostosEContribuicoesARecolher, true, true);
    final static private Conta ContasAPagar                              = new Conta("212000000000000", "Contas a Pagar",                                false, 0, Circulante,                      true, false);
    final static private Conta Fornecedores                              = new Conta("212010000000000", "Fornecedores",                                  false, 0, ContasAPagar,                    true, true);
    final static private Conta OutrasContas2                             = new Conta("212020000000000", "Outras Contas",                                 false, 0, ContasAPagar,                    true, true);
    final static private Conta EmprestimosBancarios                      = new Conta("213000000000000", "Empréstimos Bancários",                         false, 0, Circulante,                      true, false);
    final static private Conta BancoAOperacaoX                           = new Conta("213010000000000", "Banco A - Operação X",                          false, 0, EmprestimosBancarios,            true, true);
    final static private Conta NaoCirculante2                            = new Conta("220000000000000", "NÃO CIRCULANTE",                                false, 0, Passivo,                         true, false);
    final static private Conta EmprestimosBancarios2                     = new Conta("221000000000000", "Empréstimos Bancários",                         false, 0, NaoCirculante2,                  true, false);
    final static private Conta BancoAOperacaoX2                          = new Conta("221010000000000", "Banco A - Operação X",                          false, 0, EmprestimosBancarios2,           true, true);
    final static private Conta PatrimonioLiquido                         = new Conta("230000000000000", "PATRIMÔNIO LÍQUIDO",                            false, 0, Passivo,                         true, false);
    final static private Conta CapitalSocial                             = new Conta("231000000000000", "Capital Social",                                false, 0, PatrimonioLiquido,               true, false);
    final static private Conta CapitalSocialSubscrito                    = new Conta("231010000000000", "Capital Social Subscrito",                      false, 0, CapitalSocial,                   true, true);
    final static private Conta CapitalSocialARealizar                    = new Conta("231020000000000", "Capital Social a Realizar",                     false, 0, CapitalSocial,                   true, true);
    final static private Conta Reservas                                  = new Conta("232000000000000", "Reservas",                                      false, 0, PatrimonioLiquido,               true, false);
    final static private Conta ReservasDeCapital                         = new Conta("232010000000000", "Reservas de Capital",                           false, 0, Reservas,                        true, true);
    final static private Conta ReservasDeLucros                          = new Conta("232020000000000", "Reservas de Lucros",                            false, 0, Reservas,                        true, true);
    final static private Conta PrejuizosAcumulados                       = new Conta("233000000000000", "Prejuízos Acumulados",                          false, 0, PatrimonioLiquido,               true, false);
    final static private Conta PrejuizosAcumuladosDeExerciciosAnteriores = new Conta("233010000000000", "Prejuízos Acumulados de Exercícios Anteriores", false, 0, PrejuizosAcumulados,             true, true);
    final static private Conta PrejuizosDoExercicioAtual                 = new Conta("233020000000000", "Prejuízos do Exercício Atual",                  false, 0, PrejuizosAcumulados,             true, true);

    final static private Conta CustosEDespesas                  = new Conta("300000000000000", "CUSTOS E DESPESAS",                     false, 0, null,                            true, false);
    final static private Conta CustosDosProdutosVendidos        = new Conta("310000000000000", "Custos dos Produtos Vendidos",          false, 0, CustosEDespesas,                 true, false);
    final static private Conta CustosDosMateriais               = new Conta("311000000000000", "Custos dos Materiais",                  false, 0, CustosDosProdutosVendidos,       true, false);
    final static private Conta CustosDosMateriaisAplicados      = new Conta("311010000000000", "Custos dos Materiais Aplicados",        false, 0, CustosDosMateriais,              true, true);
    final static private Conta CustosDaMaoDeObra                = new Conta("312000000000000", "Custos da Mão-de-Obra",                 false, 0, CustosDosProdutosVendidos,       true, false);
    final static private Conta Salarios                         = new Conta("312010000000000", "Salários",                              false, 0, CustosDaMaoDeObra,               true, true);
    final static private Conta EncargosSociais                  = new Conta("312020000000000", "Encargos Sociais",                      false, 0, CustosDaMaoDeObra,               true, true);
    final static private Conta CustoDasMercadoriasVendidas      = new Conta("320000000000000", "Custo das Mercadorias Vendidas",        false, 0, CustosEDespesas,                 true, false);
    final static private Conta CustoDasMercadorias              = new Conta("321000000000000", "Custo das Mercadorias",                 false, 0, CustoDasMercadoriasVendidas,     true, false);
    final static private Conta CustoDasMercadoriasVendidas2     = new Conta("321010000000000", "Custo das Mercadorias Vendidas",        false, 0, CustoDasMercadorias,             true, true);
    final static private Conta CustoDosServicosPrestados        = new Conta("330000000000000", "Custo dos Serviços Prestados",          false, 0, CustosEDespesas,                 true, false);
    final static private Conta CustoDosServicos                 = new Conta("331000000000000", "Custo dos Serviços",                    false, 0, CustoDosServicosPrestados,       true, false);
    final static private Conta MateriaisAplicados               = new Conta("331010000000000", "Materiais Aplicados",                   false, 0, CustoDosServicos,                true, true);
    final static private Conta MaoDeObra                        = new Conta("331020000000000", "Mão-de-Obra",                           false, 0, CustoDosServicos,                true, true);
    final static private Conta EncargosSociais2                 = new Conta("331030000000000", "Encargos Sociais",                      false, 0, CustoDosServicos,                true, true);
    final static private Conta DespesasOperacionais             = new Conta("340000000000000", "Despesas Operacionais",                 false, 0, CustosEDespesas,                 true, false);
    final static private Conta DespesasGerais                   = new Conta("341000000000000", "Despesas Gerais",                       false, 0, DespesasOperacionais,            true, false);
    final static private Conta MaoDeObra2                       = new Conta("341010000000000", "Mão-de-Obra",                           false, 0, DespesasGerais,                  true, true);
    final static private Conta EncargosSociais3                 = new Conta("341020000000000", "Encargos Sociais",                      false, 0, DespesasGerais,                  true, true);
    final static private Conta Alugueis                         = new Conta("341030000000000", "Aluguéis",                              false, 0, DespesasGerais,                  true, true);
    final static private Conta PerdasDeCapital                  = new Conta("350000000000000", "Perdas de Capital",                     false, 0, CustosEDespesas,                 true, false);
    final static private Conta BaixaDeBensDoAtivoNaoCirculante  = new Conta("351000000000000", "Baixa de Bens do Ativo Não Circulante", false, 0, PerdasDeCapital,                 true, false);
    final static private Conta CustosDeAlienacaoDeInvestimentos = new Conta("351010000000000", "Custos de Alienação de Investimentos",  false, 0, BaixaDeBensDoAtivoNaoCirculante, true, true);
    final static private Conta CustosDeAlienacaoDoImobilizado   = new Conta("351020000000000", "Custos de Alienação do Imobilizado",    false, 0, BaixaDeBensDoAtivoNaoCirculante, true, true);

    final static private Conta Receitas                           = new Conta("400000000000000", "RECEITAS",                               false, 0, null,                         true, false);
    final static private Conta ReceitaLiquida                     = new Conta("410000000000000", "Receita Líquida",                        false, 0, Receitas,                     true, false);
    final static private Conta ReceitaBrutaDeVendas               = new Conta("411000000000000", "Receita Bruta de Vendas",                false, 0, ReceitaLiquida,               true, false);
    final static private Conta DeMercadorias                      = new Conta("411010000000000", "De Mercadorias",                         false, 0, ReceitaBrutaDeVendas,         true, true);
    final static private Conta DeProdutos                         = new Conta("411020000000000", "De Produtos",                            false, 0, ReceitaBrutaDeVendas,         true, true);
    final static private Conta DeServiçosPrestados                = new Conta("411030000000000", "De Serviços Prestados",                  false, 0, ReceitaBrutaDeVendas,         true, true);
    final static private Conta DeducoesDaReceitaBruta             = new Conta("412000000000000", "Deduções da Receita Bruta",              false, 0, ReceitaLiquida,               true, false);
    final static private Conta Devolucoes                         = new Conta("412010000000000", "Devoluções",                             false, 0, DeducoesDaReceitaBruta,       true, true);
    final static private Conta ServicosCancelados                 = new Conta("412020000000000", "Serviços Cancelados",                    false, 0, DeducoesDaReceitaBruta,       true, true);
    final static private Conta OutrasReceitasOperacionais         = new Conta("420000000000000", "Outras Receitas Operacionais",           false, 0, Receitas,                     true, false);
    final static private Conta VendasDeAtivosNaoCirculantes       = new Conta("421000000000000", "Vendas de Ativos Não Circulantes",       false, 0, OutrasReceitasOperacionais,   true, false);
    final static private Conta ReceitasDeAlienacaoDeInvestimentos = new Conta("421010000000000", "Receitas de Alienação de Investimentos", false, 0, VendasDeAtivosNaoCirculantes, true, true);
    final static private Conta ReceitasDeAlienacaoDoImobilizado   = new Conta("421020000000000", "Receitas de Alienação do Imobilizado",   false, 0, VendasDeAtivosNaoCirculantes, true, true);

    public DaoContaPadrao() {
        contasPadrao.add(Ativo);
        contasPadrao.add(AtivoCirculante);
        contasPadrao.add(Caixa);
        contasPadrao.add(CaixaGeral);
        contasPadrao.add(BancosComMovimento);
        contasPadrao.add(BancoAlfa);
        contasPadrao.add(ContasAReceber);
        contasPadrao.add(Clientes);
        contasPadrao.add(OutrasContasAReceber);
        contasPadrao.add(DuplicatasDescontadas);
        contasPadrao.add(Estoques);
        contasPadrao.add(Mercadorias);
        contasPadrao.add(ProdutosAcabados);
        contasPadrao.add(Insumos);
        contasPadrao.add(Outros);
        contasPadrao.add(NaoCirculante);
        contasPadrao.add(ContasAReceber2);
        contasPadrao.add(Clientes2);
        contasPadrao.add(OutrasContas);
        contasPadrao.add(Investimentos);
        contasPadrao.add(ParticipacoesSocietarias);
        contasPadrao.add(Imobilizado);
        contasPadrao.add(Terrenos);
        contasPadrao.add(ConstrucoesEBenfeitorias);
        contasPadrao.add(MaquinasEFerramentas);
        contasPadrao.add(Veiculos);
        contasPadrao.add(Moveis);
        contasPadrao.add(DepreciacaoAcumulada);
        contasPadrao.add(AmortizacaoAcumulada);
        contasPadrao.add(Intangivel);
        contasPadrao.add(Marcas);
        contasPadrao.add(Softwares);
        contasPadrao.add(AmortizacaoAcumulada2);
        contasPadrao.add(Passivo);
        contasPadrao.add(Circulante);
        contasPadrao.add(ImpostosEContribuicoesARecolher);
        contasPadrao.add(SimplesARecolher);
        contasPadrao.add(Inss);
        contasPadrao.add(Fgts);
        contasPadrao.add(ContasAPagar);
        contasPadrao.add(Fornecedores);
        contasPadrao.add(OutrasContas2);
        contasPadrao.add(EmprestimosBancarios);
        contasPadrao.add(BancoAOperacaoX);
        contasPadrao.add(NaoCirculante2);
        contasPadrao.add(EmprestimosBancarios2);
        contasPadrao.add(BancoAOperacaoX2);
        contasPadrao.add(PatrimonioLiquido);
        contasPadrao.add(CapitalSocial);
        contasPadrao.add(CapitalSocialSubscrito);
        contasPadrao.add(CapitalSocialARealizar);
        contasPadrao.add(Reservas);
        contasPadrao.add(ReservasDeCapital);
        contasPadrao.add(ReservasDeLucros);
        contasPadrao.add(PrejuizosAcumulados);
        contasPadrao.add(PrejuizosAcumuladosDeExerciciosAnteriores);
        contasPadrao.add(PrejuizosDoExercicioAtual);
        contasPadrao.add(CustosEDespesas);
        contasPadrao.add(CustosDosProdutosVendidos);
        contasPadrao.add(CustosDosMateriais);
        contasPadrao.add(CustosDosMateriaisAplicados);
        contasPadrao.add(CustosDaMaoDeObra);
        contasPadrao.add(Salarios);
        contasPadrao.add(EncargosSociais);
        contasPadrao.add(CustoDasMercadoriasVendidas);
        contasPadrao.add(CustoDasMercadorias);
        contasPadrao.add(CustoDasMercadoriasVendidas2);
        contasPadrao.add(CustoDosServicosPrestados);
        contasPadrao.add(CustoDosServicos);
        contasPadrao.add(MateriaisAplicados);
        contasPadrao.add(MaoDeObra);
        contasPadrao.add(EncargosSociais2);
        contasPadrao.add(DespesasOperacionais);
        contasPadrao.add(DespesasGerais);
        contasPadrao.add(MaoDeObra2);
        contasPadrao.add(EncargosSociais3);
        contasPadrao.add(Alugueis);
        contasPadrao.add(PerdasDeCapital);
        contasPadrao.add(BaixaDeBensDoAtivoNaoCirculante);
        contasPadrao.add(CustosDeAlienacaoDeInvestimentos);
        contasPadrao.add(CustosDeAlienacaoDoImobilizado);
        contasPadrao.add(Receitas);
        contasPadrao.add(ReceitaLiquida);
        contasPadrao.add(ReceitaBrutaDeVendas);
        contasPadrao.add(DeMercadorias);
        contasPadrao.add(DeProdutos);
        contasPadrao.add(DeServiçosPrestados);
        contasPadrao.add(DeducoesDaReceitaBruta);
        contasPadrao.add(Devolucoes);
        contasPadrao.add(ServicosCancelados);
        contasPadrao.add(OutrasReceitasOperacionais);
        contasPadrao.add(VendasDeAtivosNaoCirculantes);
        contasPadrao.add(ReceitasDeAlienacaoDeInvestimentos);
        contasPadrao.add(ReceitasDeAlienacaoDoImobilizado);
    }
    //</editor-fold>
    
    public static DaoContaPadrao getInstance() {
        if (instance == null) {
            instance = new DaoContaPadrao();
        }
        return instance;
    }

    public ArrayList<Conta> getContasPadrao() {
        return contasPadrao;
    }
    
}