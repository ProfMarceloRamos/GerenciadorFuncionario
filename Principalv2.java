import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Empresa;
import model.Funcionario;

public class Principalv2 {
    
    public static void main(String[] args) {
        
        Scanner s = new Scanner(System.in);

        // List<Funcionario> funcionarios = new ArrayList<Funcionario>();

        // Funcionario f1 = criarFuncionario(s);
        // funcionarios.add(f1);
        // //imprimirFuncionario(f1);

        // Funcionario f2 = criarFuncionario(s);
        // funcionarios.add(f2);
        // //imprimirFuncionario(f2);

        // System.out.print("Qual o índice do funcionário: ");
        // int index = s.nextInt();

        // imprimirFuncionario(funcionarios, index);

        Empresa e1 = criarEmpresa(s);

        imprimirEmpresa(e1);

        s.close();

    }

    public static Empresa criarEmpresa(Scanner s){

        Empresa emp = new Empresa();

        System.out.print("Digite o nome da empresa: ");
        String nmEmp = s.nextLine();

        emp.setNmEmpresa(nmEmp);

        return emp;

    }

    public static Funcionario criarFuncionario(Scanner s){

        System.out.print("Digite o nome do funcionário: ");
        String nmFuncionario = s.nextLine();

        System.out.print("Digite a data de nascimento do funcionário(dd/MM/yyyy): ");
        String dtNascimento = s.nextLine();

        Funcionario f = new Funcionario();
        f.setNmFuncionario(nmFuncionario);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate ldDtNascimento = LocalDate.parse(dtNascimento, dtf);
        f.setDtNascimento(ldDtNascimento);

        return f;

    }

    public static void imprimirFuncionario(Funcionario f){
        System.out.printf("Funcionário: %s com nascimento(%s) tem %d anos.\n",
        f.getNmFuncionario(), f.getDataNascimentoFormatado(), f.idade());
    }

    public static void imprimirFuncionario(List<Funcionario> f, int index){
        System.out.printf("Funcionário: %s com nascimento(%s) tem %d anos.\n",
        f.get(index).getNmFuncionario(), f.get(index).getDataNascimentoFormatado(), 
        f.get(index).idade());
    }

    public static void imprimirEmpresa(Empresa e){
        System.out.println(e);
    }

}
