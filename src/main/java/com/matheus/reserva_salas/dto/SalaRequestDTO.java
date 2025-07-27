package com.matheus.reserva_salas.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record SalaRequestDTO(

        @NotBlank(message = "O Nome da sala é obrigatória")
        String nome,

        @NotBlank(message = "A localização da sala é obrigatória")
        String localizacao,

        @NotBlank(message = "A capacidade da sala é obrigatoria")
        @Size(min = 1, message = "A capacidade da sala deve ser no mínimo 1")
        Integer capacidade

)
{}
