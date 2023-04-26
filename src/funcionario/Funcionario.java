package funcionario;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import pessoa.Pessoa;

public class Funcionario extends Pessoa {
    
    private BigDecimal salario;
    private String funcao;

    public Funcionario() { }

    public Funcionario(BigDecimal salario, String funcao){
        this.salario = salario;
        this.funcao = funcao;
    }

    public Funcionario(String nome, LocalDate dataNascimento, BigDecimal salario, String funcao){
        super(nome, dataNascimento);
        this.salario = salario;
        this.funcao = funcao;
    }

    public BigDecimal getSalario(){
        return this.salario;
    }

    protected void setSalario(BigDecimal salario){
        this.salario = salario;
    }
    
    public String getFuncao(){
        return this.funcao;
    }

    protected void setFuncao(String funcao){
        this.funcao = funcao;
    }

    @Override
    public String toString() {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("d/MM/uuuu");
        String dataNascimentoFormatada = this.getDataNascimento().format(dateTimeFormatter);
        DecimalFormatSymbols decimalFormatSymbols = new DecimalFormatSymbols();
        decimalFormatSymbols.setDecimalSeparator(',');
        decimalFormatSymbols.setGroupingSeparator('.');
        DecimalFormat decimalFormat = new DecimalFormat("#,##0.00", decimalFormatSymbols);
        String salarioFormatado = decimalFormat.format(this.salario);
        return this.getNome()+" "+dataNascimentoFormatada+" "+salarioFormatado+" "+this.funcao;
    }
    
}
