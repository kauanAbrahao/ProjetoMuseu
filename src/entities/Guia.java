package entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Guia {
    private String nome;
    private String cpf;
    private List<LocalDate> datasAgendadas = new ArrayList<>();


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public List<LocalDate> getDatasAgendadas() {
        return datasAgendadas;
    }

    public void setDatasAgendadas(List<LocalDate> datasAgendadas) {
        this.datasAgendadas = datasAgendadas;
    }
}
