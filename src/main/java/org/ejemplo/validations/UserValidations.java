package org.ejemplo.validations;

import org.ejemplo.exceptions.UserRegistrationException;
import org.ejemplo.modelos.Usuario;
import org.ejemplo.repository.UsuarioRepository;

public class UserValidations {
    private final UsuarioRepository usuarioRepository;

    public UserValidations(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public void validateExistingUser(String username) {
        if (usuarioRepository.findByUser(username).isPresent()) {
            throw new UserRegistrationException("El nombre de usuario ya está registrado");
        }
    }

    public void validateRole(String role) {
        if (!role.equalsIgnoreCase("administrador") && !role.equalsIgnoreCase("vendedor")) {
            throw new UserRegistrationException("El rol del usuario es inválido");
        }
        if (role.isBlank()) {
            throw new UserRegistrationException("Debe ingresar un rol");
        }
    }
}


