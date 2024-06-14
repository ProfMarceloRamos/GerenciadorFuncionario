import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import enumaration.TipoRamoEnum;
import model.Empresa;
import model.Funcionario;
import service.EmpresaService;

public class Principalv5 {
    public static int cdFuncionario = 1;
    
    public static void main(String[] args) {

        List<Funcionario> funcionarios = new ArrayList<Funcionario>();
        List<Empresa> empresas = new ArrayList<Empresa>();
        
        Scanner s = new Scanner(System.in);

        int opcao = 0;
        do {
            
            opcao = menu(s);

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
                    System.out.println("######LISTA FUNCIONARIOS######");
                    imprimirTodosFuncionarios(funcionarios);
                    System.out.println("###############################");
                    System.out.print("Digite o código do funcionário para excluir: ");
                    int cdFuncionarioExcluir = s.nextInt();
                    excluirFuncionario(funcionarios, cdFuncionarioExcluir);
                    break;
                case 4:
                    imprimirEmpresa(empresas);
                case 5:
                    imprimirTodosFuncionarios(funcionarios);
                    break;
                default:
                    System.out.println("Opção desconhecida!!!");
            }

        } while (opcao != 99);

        s.close();

    }

    public static int menu(Scanner s){
        System.out.println("*******************");
        System.out.println("1 - Criar Funcionário");
        System.out.println("2 - Criar Empresa");
        System.out.println("3 - Excluir Funcionário");
        System.out.println("4 - Imprimir Empresa");
        System.out.println("5 - Imprimir todos os funcionários");
        System.out.println("99 - Sair do sistema");
        System.out.println("*******************");
        System.out.print("Digite uma opção: ");
        int opcao = s.nextInt();
        return opcao;
    }

    public static Empresa criarEmpresa(Scanner s){

        Empresa emp = new Empresa();

        System.out.print("Digite o nome da empresa: ");
        String nmEmp = s.nextLine();

        emp.setNmEmpresa(nmEmp);
        emp.setTipoRamo(TipoRamoEnum.ELETRODOMESTICO);

        EmpresaService empService = new EmpresaService();
        
        Empresa empInseri = null;
        if(empService.validacaoEmpresa(emp)){
            empInseri = empService.inserirEmpresa(emp);
        }

        return empInseri;

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

        f.setCdFuncionario(cdFuncionario);

        cdFuncionario++;

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

    public static void imprimirTodosFuncionarios(List<Funcionario> listaFuncionario){
        for(Funcionario f : listaFuncionario){
            System.out.printf("%d - Funcionário: %s com nascimento(%s) tem %d anos.\n",
            f.getCdFuncionario(), f.getNmFuncionario(), f.getDataNascimentoFormatado(), 
            f.idade());
        }

    }

    public static void imprimirEmpresa(List<Empresa> listaEmpresa){
        EmpresaService empresaService = new EmpresaService();
        empresaService.listaEmpresas();
    }

    public static void excluirFuncionario(List<Funcionario> f, int cdFuncionarioExcluir){

        for (Funcionario funcionario : f) {
            if(funcionario.getCdFuncionario() == cdFuncionarioExcluir){
                f.remove(funcionario);
            }
        }

    }
}
