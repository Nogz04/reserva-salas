package com.matheus.reserva_salas.dto;

public record SalaResponseDTO(

        Long id,
        String nome,
        String localizacao,
        Integer capacidade

)
{}
