package com.matheus.reserva_salas.repository;

import com.matheus.reserva_salas.model.Sala;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SalaRepository extends JpaRepository<Sala,Long> {
}
