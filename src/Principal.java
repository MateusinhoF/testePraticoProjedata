import java.math.BigDecimal;
import java.time.LocalDate;

import funcionario.Funcionario;
import funcionario.ListFuncionario;

public class Principal {
    public static void main(String[] args) throws Exception {
        ListFuncionario listfuncionario = new ListFuncionario();

        listfuncionario.inserir(new Funcionario("Maria", LocalDate.of(2000,10,18), new BigDecimal(2009.44), "Operador"));
        listfuncionario.inserir(new Funcionario("João", LocalDate.of(1990,05,12), new BigDecimal(2284.38), "Operador"));
        listfuncionario.inserir(new Funcionario("Caio", LocalDate.of(1961,05,02), new BigDecimal(9836.14), "Coordenador"));
        listfuncionario.inserir(new Funcionario("Miguel", LocalDate.of(1988,10,14), new BigDecimal(19119.88), "Diretor"));
        listfuncionario.inserir(new Funcionario("Alice", LocalDate.of(1995,01,05), new BigDecimal(2234.68), "Recepcionista"));
        listfuncionario.inserir(new Funcionario("Heitor", LocalDate.of(1999,11,19), new BigDecimal(1582.72), "Operador"));
        listfuncionario.inserir(new Funcionario("Arthur", LocalDate.of(1993,03,31), new BigDecimal(4071.84), "Contador"));
        listfuncionario.inserir(new Funcionario("Laura", LocalDate.of(1994,07,8), new BigDecimal(3017.45), "Gerente"));
        listfuncionario.inserir(new Funcionario("Heloísa", LocalDate.of(2003,05,24), new BigDecimal(1606.85), "Eletrecista"));
        listfuncionario.inserir(new Funcionario("Helena", LocalDate.of(1996,9,02), new BigDecimal(2799.93), "Gerente"));

        listfuncionario.excluir("João");

        listfuncionario.imprimir();

        listfuncionario.atualizarSalarios(10);

        listfuncionario.agruparFuncionarios();

        listfuncionario.imprimirFuncionariosPorFuncao();

        listfuncionario.imprimirFuncionariosNascidosMes10e12();

        listfuncionario.imprimirFuncionarioMaisVelho();

        listfuncionario.imprimirFuncionariosOrdemAlfaberica();

        listfuncionario.imprimirTotalSalarios();

        listfuncionario.imprimirQuantidadeSalarioMinimoPorFuncionario();
    }
}
