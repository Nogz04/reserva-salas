package com.matheus.reserva_salas.service;

import com.matheus.reserva_salas.dto.UsuarioRequestDTO;
import com.matheus.reserva_salas.dto.UsuarioResponseDTO;
import com.matheus.reserva_salas.model.Usuario;
import com.matheus.reserva_salas.repository.UsuarioRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UsuarioService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    //Cadastrar um novo usuário no sistema
    public UsuarioResponseDTO cadastrarUsuario(UsuarioRequestDTO usuarioRequestDTO){
        Usuario usuario = new Usuario();
        usuario.setNome(usuarioRequestDTO.nome());
        usuario.setEmail(usuarioRequestDTO.email());
        usuario.setCpf(usuarioRequestDTO.cpf());

        Usuario salvo = usuarioRepository.save(usuario);

        return new UsuarioResponseDTO(salvo.getId(),salvo.getNome(),salvo.getEmail(),salvo.getCpf());
    }

    public List<UsuarioResponseDTO> listarTodos() {
        return usuarioRepository.findAll().stream().map(usuario -> new UsuarioResponseDTO(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getCpf())).collect(Collectors.toList());
    }

    public UsuarioResponseDTO listarPorId(Long id){
        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuário não encotrado"));

        return new UsuarioResponseDTO(usuario.getId(), usuario.getNome(), usuario.getEmail(), usuario.getCpf());
    }

    public UsuarioResponseDTO atualizarUsuario(Long id, UsuarioRequestDTO usuarioRequestDTO){

        Usuario usuario = usuarioRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Usuário não encontrado"));
        usuario.setNome(usuarioRequestDTO.nome());
        usuario.setEmail(usuarioRequestDTO.email());
        usuario.setCpf(usuarioRequestDTO.cpf());

        Usuario atualizado = usuarioRepository.save(usuario);

        return new UsuarioResponseDTO(atualizado.getId(), atualizado.getNome(), atualizado.getEmail(), atualizado.getCpf());

    }

    public void deletar(Long id){
        if(!usuarioRepository.existsById(id)){
            throw new EntityNotFoundException("Usuario nao encontrado");
        }
        usuarioRepository.deleteById(id);
    }


}
