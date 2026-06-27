package com.educonecta.service;

import java.util.Set;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.educonecta.dto.LoginRequest;
import com.educonecta.dto.RegisterRequest;
import com.educonecta.entity.Role;
import com.educonecta.entity.Usuario;
import com.educonecta.repository.RoleRepository;
import com.educonecta.repository.UsuarioRepository;
import com.educonecta.segurity.JwtService;

@Service
public class AuthService {

    private final UsuarioRepository usuarioRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthService(
            UsuarioRepository usuarioRepository,
            RoleRepository roleRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService) {

        this.usuarioRepository = usuarioRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    public void register(RegisterRequest request) {

        if (usuarioRepository.findByUsername(
                request.getUsername()).isPresent()) {

            throw new RuntimeException("Usuario ya existe");
        }

        Role role = roleRepository.findByNombre(
                request.getRol())
                .orElseThrow(() ->
                        new RuntimeException("Rol no existe"));

        Usuario usuario = new Usuario();

        usuario.setUsername(request.getUsername());

        usuario.setPassword(
                passwordEncoder.encode(
                        request.getPassword()
                ));

        usuario.setActivo(true);

        usuario.setRoles(Set.of(role));

        usuarioRepository.save(usuario);
    }

    public String login(LoginRequest request) {

        Usuario usuario = usuarioRepository
                .findByUsername(
                        request.getUsername()
                )
                .orElseThrow(() ->
                        new RuntimeException(
                                "Usuario no encontrado"));

        if (!passwordEncoder.matches(
                request.getPassword(),
                usuario.getPassword())) {

            throw new RuntimeException(
                    "Credenciales incorrectas");
        }

        return jwtService.generateToken(
                usuario.getUsername()
        );
    }
}
