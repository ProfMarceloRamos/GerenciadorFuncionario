package model;

public class Gerente extends Cargo {
    
    private int numFuncionarios;

    private String projetoSupervisionado;

    public int getNumFuncionarios() {
        return numFuncionarios;
    }

    public String getProjetoSupervisionado() {
        return projetoSupervisionado;
    }

    public void setNumFuncionarios(int numFuncionarios) {
        this.numFuncionarios = numFuncionarios;
    }

    public void setProjetoSupervisionado(String projetoSupervisionado) {
        this.projetoSupervisionado = projetoSupervisionado;
    }

}
