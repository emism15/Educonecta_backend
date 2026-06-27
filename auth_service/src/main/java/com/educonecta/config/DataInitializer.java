package com.educonecta.config;


import com.educonecta.entity.Role;
import com.educonecta.entity.Usuario;
import com.educonecta.repository.RoleRepository;
import com.educonecta.repository.UsuarioRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class DataInitializer implements CommandLineRunner {

    private final RoleRepository roleRepository;
    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(
            RoleRepository roleRepository,
            UsuarioRepository usuarioRepository,
            PasswordEncoder passwordEncoder) {

        this.roleRepository = roleRepository;
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {

        Role adminRole = roleRepository
                .findByNombre("ADMIN")
                .orElseGet(() -> {
                    Role role = new Role();
                    role.setNombre("ADMIN");
                    return roleRepository.save(role);
                });

        roleRepository
                .findByNombre("APODERADO")
                .orElseGet(() -> {
                    Role role = new Role();
                    role.setNombre("APODERADO");
                    return roleRepository.save(role);
                });

        if (usuarioRepository.findByUsername("admin").isEmpty()) {

            Usuario admin = new Usuario();

            admin.setUsername("admin");

            admin.setPassword(
                    passwordEncoder.encode("Admin123")
            );

            admin.setActivo(true);

            admin.setRoles(Set.of(adminRole));

            usuarioRepository.save(admin);
        }
    }
}
