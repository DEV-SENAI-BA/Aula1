package com.senai.senai.application;

import com.senai.senai.dao.PessoaDAO;
import com.senai.senai.entities.Cidade;
import com.senai.senai.entities.enums.Cargo;
import com.senai.senai.entities.Endereco;
import com.senai.senai.entities.Estado;
import com.senai.senai.entities.Pessoa;

public class Application {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa("Carlos", Cargo.DESENVOLVEDOR);
        String t1 = new String("98465488");
        Endereco e1 = new Endereco("Rua A","25");
        Estado est1 = new Estado("Bahia");
        Cidade c1 = new Cidade("Salvador");

        p1.setEndereco(e1);
        p1.getEndereco().setCidade(c1);
        p1.getEndereco().getCidade().setEstado(est1);
        p1.setTelefones(t1);
        
        new PessoaDAO().salvar(p1);
        
        Pessoa p2 = new Pessoa("Carlos", Cargo.DBA);
        Endereco e2 = new Endereco("Rua B","50");
        String t2 = new String("84683515");
        String t3 = new String("465135");
        Cidade c2 = new Cidade("São Paulo");
        Estado est2 = new Estado("São Paulo");
        
        p2.setEndereco(e2);
        p2.setTelefones(t2, t3);
        p2.getEndereco().setCidade(c2);
        p2.getEndereco().getCidade().setEstado(est2);
        
        new PessoaDAO().salvar(p2);
    }
}
