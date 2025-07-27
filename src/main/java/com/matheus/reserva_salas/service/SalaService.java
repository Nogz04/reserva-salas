package com.matheus.reserva_salas.service;

import com.matheus.reserva_salas.dto.SalaRequestDTO;
import com.matheus.reserva_salas.dto.SalaResponseDTO;
import com.matheus.reserva_salas.model.Sala;
import com.matheus.reserva_salas.repository.SalaRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SalaService {

    @Autowired
    SalaRepository salaRepository;

    public SalaResponseDTO cadastrarSala(SalaRequestDTO salaRequestDTO) {
        Sala sala = new Sala();
        sala.setNome(salaRequestDTO.nome());
        sala.setCapacidade(salaRequestDTO.capacidade());
        sala.setLocalizacao(salaRequestDTO.localizacao());

        Sala salva = salaRepository.save(sala);

        return new SalaResponseDTO(salva.getId(), salva.getNome(), salva.getLocalizacao(), sala.getCapacidade());
    }

    public List<SalaResponseDTO> listarTodasSalas() {
        return salaRepository.findAll().stream().map(sala -> new SalaResponseDTO(sala.getId(), sala.getNome(), sala.getLocalizacao(), sala.getCapacidade())).collect(Collectors.toList());
    }

    public SalaResponseDTO buscarSalaPorId(Long id) {
        Sala sala = salaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Sala não encontrada"));
        return new SalaResponseDTO(sala.getId(), sala.getNome(), sala.getLocalizacao(), sala.getCapacidade());
    }

    public SalaResponseDTO atualizarSala(Long id, SalaRequestDTO salaRequestDTO) {
        Sala sala= salaRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Sala não encontrada"));
        sala.setNome(salaRequestDTO.nome());
        sala.setCapacidade(salaRequestDTO.capacidade());
        sala.setLocalizacao(salaRequestDTO.localizacao());

        Sala atualizada = salaRepository.save(sala);

        return new SalaResponseDTO(atualizada.getId(), atualizada.getNome(), atualizada.getLocalizacao(), atualizada.getCapacidade());
    }

    public void deletar(Long id) {
        if (!salaRepository.existsById(id)) {
            throw new EntityNotFoundException("Sala não encontrada");
        }
        salaRepository.deleteById(id);
    }

}
