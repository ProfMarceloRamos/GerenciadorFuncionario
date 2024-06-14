package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Funcionario {

    private int cdFuncionario;

    private String nmFuncionario;

    private LocalDate dtNascimento;

    private Cargo cargo;

    public int getCdFuncionario() {
        return cdFuncionario;
    }

    public LocalDate getDtNascimento() {
        return dtNascimento;
    }

    public String getNmFuncionario() {
        return nmFuncionario;
    }

    public void setCdFuncionario(int cdFuncionario) {
        this.cdFuncionario = cdFuncionario;
    }

    public void setDtNascimento(LocalDate dtNascimento) {
        this.dtNascimento = dtNascimento;
    }

    public void setNmFuncionario(String nmFuncionario) {
        this.nmFuncionario = nmFuncionario;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public String getDataNascimentoFormatado(){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dtNascimento.format(dtf);
    }

    public void setDataNascimentoFormatado(String data){
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        dtNascimento = LocalDate.parse(data, dtf);
    }

    
    public int idade(){

        LocalDate dtAtual = LocalDate.now();
        int anoAtual = dtAtual.getYear();

        int anoNascimento = this.getDtNascimento().getYear();
        int idade = anoAtual - anoNascimento;

        return idade;

    }

}