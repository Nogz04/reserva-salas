package com.matheus.reserva_salas.service;

import com.matheus.reserva_salas.dto.ReservaRequestDTO;
import com.matheus.reserva_salas.dto.ReservaResponseDTO;
import com.matheus.reserva_salas.model.Reserva;
import com.matheus.reserva_salas.model.Sala;
import com.matheus.reserva_salas.model.Usuario;
import com.matheus.reserva_salas.repository.ReservaRepository;
import com.matheus.reserva_salas.repository.SalaRepository;
import com.matheus.reserva_salas.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReservaService {

    @Autowired
    ReservaRepository reservaRepository;

    @Autowired
    SalaRepository salaRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    public ReservaResponseDTO criarReserva(ReservaRequestDTO reservaRequestDTO) {

        Sala sala = salaRepository.findById(reservaRequestDTO.sala_id()).orElseThrow(() -> new RuntimeException("Sala não encontrada com id: " + reservaRequestDTO.sala_id()));
        Usuario usuario = usuarioRepository.findById(reservaRequestDTO.usuario_id()).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado com id: " + reservaRequestDTO.usuario_id()));


        Reserva reserva = new Reserva();

        reserva.setData(reservaRequestDTO.data());
        reserva.setSala(sala);
        reserva.setHoraFim(reservaRequestDTO.horaFim());
        reserva.setHoraInicio(reservaRequestDTO.horaInicio());
        reserva.setUsuario(usuario);

        Reserva salva = reservaRepository.save(reserva);

        return new ReservaResponseDTO(
                salva.getId(),
                sala.getNome(),
                usuario.getNome(),
                salva.getData(),
                salva.getHoraInicio(),
                salva.getHoraFim(),
                salva.getStatus()
        );
    }
}


