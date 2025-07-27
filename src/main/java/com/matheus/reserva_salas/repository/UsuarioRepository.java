package com.matheus.reserva_salas.repository;

import com.matheus.reserva_salas.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
}
