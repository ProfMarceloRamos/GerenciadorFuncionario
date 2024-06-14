package repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import model.Empresa;

public class EmpresaRepository {

    // Informações do banco de dados
    static final String URL = "jdbc:postgresql://localhost:5432/postgres";
    static final String USUARIO = "postgres";
    static final String SENHA = "root";
    
    public Empresa inserirEmpresa(Empresa emp){

        try {
            // Registrar o driver JDBC
            Class.forName("org.postgresql.Driver");

            // Estabelecer a conexão com o banco de dados
            Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);

            // Criar uma declaração para executar consultas
            Statement statement = connection.createStatement();

            // Exemplo: inserir dados na tabela
            String inserirQuery = "INSERT INTO empresa (nmempresa, tiporamo) VALUES ('"+emp.getNmEmpresa()+"',"+emp.getTipoRamo().getCodigo()+")";
            System.out.println(inserirQuery);
            statement.executeUpdate(inserirQuery);
            System.out.println("Empresa inserida com sucesso!!");
            
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver PostgreSQL não encontrado!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Erro ao acessar o banco de dados!");
            e.printStackTrace();
        }

        return emp;
    }

    public void listarEmpresa(){

        try {
            // Registrar o driver JDBC
            Class.forName("org.postgresql.Driver");

            // Estabelecer a conexão com o banco de dados
            Connection connection = DriverManager.getConnection(URL, USUARIO, SENHA);

            // Criar uma declaração para executar consultas
            Statement statement = connection.createStatement();

            // Exemplo: inserir dados na tabela
            String consultarQuery = "SELECT * FROM empresa";
            ResultSet resultSet = statement.executeQuery(consultarQuery);

            // Exibir os resultados da consulta
            while (resultSet.next()) {
                String campo1 = resultSet.getString("cdEmpresa");
                String campo2 = resultSet.getString("nmempresa");
                String campo3 = resultSet.getString("tiporamo");
                System.out.println("Campo1: " + campo1 + ", Campo2: " + campo2 + ", Campo3: "+campo3);
            }
            
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException e) {
            System.out.println("Driver PostgreSQL não encontrado!");
            e.printStackTrace();
        } catch (SQLException e) {
            System.out.println("Erro ao acessar o banco de dados!");
            e.printStackTrace();
        }

    }

}
