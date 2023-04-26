package funcionario;

import java.math.BigDecimal;
import java.math.MathContext;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ListFuncionario {

    private List<Funcionario> listFuncionarios;
    private Map<String, List<Funcionario>> map;

    public ListFuncionario() { 
        this.listFuncionarios = new ArrayList<Funcionario>();
    }

    public void inserir(Funcionario funcionario){
        this.listFuncionarios.add(funcionario);
    }

    public void excluir(String nome) throws Exception{
        try{
            for (Funcionario funcionario : listFuncionarios) {
                if (funcionario.getNome() == nome){
                    this.listFuncionarios.remove(funcionario);
                    break;
                }
            }
        }catch(Exception e){
            throw new Exception("Erro ao excluir funcionario "+e.getMessage());
        }
        
    }

    public void imprimir(){
        System.out.println("************Imprimindo funcionários************");
        listFuncionarios.forEach(funcionario -> System.out.println(funcionario.toString()));
        System.out.println("***********************************************");
    }

    public void atualizarSalarios(int porcentagem){
        listFuncionarios.forEach(funcionario -> funcionario.setSalario(funcionario.getSalario().multiply(new BigDecimal((porcentagem/100)+1))));
    }

    public void agruparFuncionarios(){
        map = listFuncionarios.stream().collect(Collectors.groupingBy(Funcionario::getFuncao));
    }

    public void imprimirFuncionariosPorFuncao(){
        System.out.println("************Imprimindo funcionários************");
        map.entrySet().stream().sorted(Map.Entry.comparingByKey()).forEach(funcionario -> System.out.println(funcionario.toString()));
        System.out.println("***********************************************");
    }
    
    public void imprimirFuncionariosNascidosMes10e12(){
        System.out.println("************Imprimindo funcionários nascidos mês 10 e 12************");
        listFuncionarios.stream().filter(funcionario -> funcionario.getDataNascimento().getMonthValue() == 10 || funcionario.getDataNascimento().getMonthValue() == 12).findAny().ifPresent(funcionario -> System.out.println(funcionario.toString()));
        System.out.println("***********************************************");
    }

    public void imprimirFuncionarioMaisVelho(){
        System.out.println("************Funcionário mais velho*************");
        Funcionario funcionario = listFuncionarios.stream().min(Comparator.comparing(Funcionario::getDataNascimento)).get();
        int idade = Period.between(funcionario.getDataNascimento(), LocalDate.now()).getYears();
        System.out.println(funcionario.getNome()+" tem "+idade+" anos");
        System.out.println("***********************************************");
    }

    public void imprimirFuncionariosOrdemAlfaberica(){
        System.out.println("************Imprimindo funcionários ordem alfabética************");
        listFuncionarios.stream().sorted(Comparator.comparing(Funcionario::getNome)).forEach(funcionario -> System.out.println(funcionario.toString()));
        System.out.println("***********************************************");
    }
    
    public void imprimirTotalSalarios(){
        System.out.println("************Imprimindo soma salários************");
        BigDecimal soma = listFuncionarios.stream().map(funcionario -> funcionario.getSalario()).reduce(BigDecimal.ZERO, BigDecimal::add);
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator(',');
        decimalFormatSymbols.setGroupingSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", decimalFormatSymbols);
        System.out.println(decimalFormat.format(soma));
        System.out.println("***********************************************");
    }

    public void imprimirQuantidadeSalarioMinimoPorFuncionario(){
        System.out.println("**********Imprimindo salários mínimos**********");
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator(',');
        decimalFormatSymbols.setGroupingSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", decimalFormatSymbols);
        listFuncionarios.forEach(funcionario -> System.out.println(funcionario.getNome()+" recebe "+decimalFormat.format(funcionario.getSalario().divide(new BigDecimal(1212.00), MathContext.DECIMAL32))+" salários mínimos"));
        System.out.println("***********************************************");
    }
}
