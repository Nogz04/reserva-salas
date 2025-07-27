package com.matheus.reserva_salas.repository;

import com.matheus.reserva_salas.model.Reserva;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReservaRepository extends JpaRepository<Reserva,Long> {
}
