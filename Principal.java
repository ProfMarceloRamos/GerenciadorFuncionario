import java.util.Scanner;

import enumaration.TipoRamoEnum;
import model.Cargo;
import model.Departamento;
import model.Empresa;
import model.Funcionario;
import model.Gerente;

public class Principal {
    
    public static void main(String[] args) {
        
        Principal p = new Principal();
        Scanner s = new Scanner(System.in);

        Funcionario f = p.criarFuncionario(s);
        
        imprimirFuncionario(f);

        Empresa e = p.criarEmpresa(s);

        System.out.printf("A empresa %s foi criada com sucesso! \n",e.getNmEmpresa());

        
        s.close();

    }

    public Funcionario criarFuncionario(Scanner s){
        Funcionario func = new Funcionario();
        func.setCdFuncionario(1);

        System.out.print("Digite o nome do Funcionário: ");
        String nome = s.nextLine();

        System.out.println("Digite a data de nascimento do Funcionário");
        String dtNascimento = s.nextLine();

        func.setNmFuncionario(nome);
        func.setDataNascimentoFormatado(dtNascimento);

        Cargo c = new Gerente();
        c.setCdCargo(1);
        c.setNmCargo("Gerente de Infra");
        Gerente g = (Gerente)c;
        g.setNumFuncionarios(5);
        g.setProjetoSupervisionado("Gestão de Funcionários");

        func.setCargo(c);

        return func;
    }

    public Empresa criarEmpresa(Scanner s){
        Empresa emp = new Empresa();

        System.out.print("Digite o nome da empresa: ");
        String nomeEmpresa = s.nextLine();

        emp.setNmEmpresa(nomeEmpresa);
        emp.setTipoRamo(TipoRamoEnum.ELETRODOMESTICO);

        return emp;
    }

    public Departamento criarDepartamento(Scanner s){
        Departamento dep = new Departamento();

        System.out.print("Digite o nome do departamento: ");
        String nomeDepartamento = s.nextLine();

        dep.setNmDepartamento(nomeDepartamento);

        return dep;
    }

    public static void imprimirFuncionario(Funcionario f){
        System.out.printf("O funcionário %s tem o cargo de %s e nasceu em %s.\n",f.getNmFuncionario(),f.getCargo().getNmCargo(),f.getDataNascimentoFormatado());
    }

}
