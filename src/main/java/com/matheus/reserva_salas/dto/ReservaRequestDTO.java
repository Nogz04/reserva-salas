    package com.matheus.reserva_salas.dto;
    
    import com.matheus.reserva_salas.model.Sala;
    import com.matheus.reserva_salas.model.Usuario;
    import jakarta.validation.constraints.Future;
    import jakarta.validation.constraints.NotBlank;

    import java.time.LocalDate;
    import java.time.LocalDateTime;
    import java.time.LocalTime;

    public record ReservaRequestDTO(

            @NotBlank(message = "O ID do Usuário é obrigatório para reserva")
            Long usuario_id,

            @NotBlank(message = "O ID da Sala é obrigatório para reserva")
            Long sala_id,

            @NotBlank(message = "A data é obrigatória para reserva")
            @Future(message = "A data deve ser válida, no futuro.")
            LocalDate data,

            @NotBlank(message = "A hora de inicio é obrigatória")
            LocalTime horaInicio,

            @NotBlank(message = "A hora de fim é obrigatória")
            LocalTime horaFim

    )
    {}
