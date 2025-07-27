package com.matheus.reserva_salas.dto;

import com.matheus.reserva_salas.enums.StatusReserva;

import java.time.LocalDate;
import java.time.LocalTime;

public record ReservaResponseDTO (

        Long id,
        String nomeSala,
        String nomeUsuario,
        LocalDate data,
        LocalTime horaInicio,
        LocalTime horaFim,
        StatusReserva status

)

{}
