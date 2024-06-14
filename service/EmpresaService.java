package service;

import model.Empresa;
import repository.EmpresaRepository;

public class EmpresaService {

    public EmpresaRepository empresaRepository;

    public EmpresaService(){
        this.empresaRepository = new EmpresaRepository();
    }

    public boolean validacaoEmpresa(Empresa emp){

        if(emp.getNmEmpresa() == null || emp.getNmEmpresa().equals("")){
            System.out.println("Precisa do nome!");
            return false;
        }

        return true;

    }

    public Empresa inserirEmpresa(Empresa emp){
        return empresaRepository.inserirEmpresa(emp);
    }

    public void listaEmpresas(){
        empresaRepository.listarEmpresa();
    }

}