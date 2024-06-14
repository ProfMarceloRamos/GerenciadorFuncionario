import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.Empresa;
import model.Funcionario;

public class Principalv3 {
    
    public static void main(String[] args) {

        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        List<Empresa> empresas = new ArrayList<Empresa>();
        
        Scanner s = new Scanner(System.in);

        System.out.println("*******************");
        System.out.println("1 - Criar Funcionário");
        System.out.println("2 - Criar Empresa");
        System.out.println("3 - Imprimir Funcionário");
        System.out.println("4 - Imprimir Empresa");
        System.out.println("*******************");
        System.out.print("Digite uma opção: ");
        int opcao = s.nextInt();

        s.nextLine();

        switch (opcao) {
            case 1:
                Funcionario f = criarFuncionario(s);
                funcionarios.add(f);
                break;
            case 2:
                Empresa e = criarEmpresa(s);
                empresas.add(e);
                break;
            case 3:
                System.out.print("Digite o indice do funcionário: ");
                int index = s.nextInt();
                imprimirFuncionario(funcionarios, index);
                break;
            case 4:
                //imprimirEmpresa(e);
            default:
                System.out.println("Opção desconhecida!!!");
        }

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
