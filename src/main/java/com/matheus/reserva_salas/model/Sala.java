package com.matheus.reserva_salas.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Essas seguintes anotações são usáveis devido a dependência Lombok,
// elas são linhas de código embutidas em uma simples anotação, simplificando muito o código

@Entity //Define que sera uma entidade no banco de dados
@Table(name = "salas") //Define o nome dessa tabela
@Data //Cria os Getters e Setters, hashCode, ToString, etc...
@NoArgsConstructor //Cria um construtor sem argumentos
@AllArgsConstructor //Cria um construtor com todos os atributos
public class Sala {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private String nome;
    private String localizacao;
    private Integer capacidade;

}
