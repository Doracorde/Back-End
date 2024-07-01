package com.cadastro.cadastro.controller;

import com.cadastro.cadastro.dto.BodyLogin;
import com.cadastro.cadastro.dto.Message;
import com.cadastro.cadastro.model.User;
import com.cadastro.cadastro.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@RestController
@RequestMapping("/usuario")  // Alterado para "/usuario"
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @CrossOrigin
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody BodyLogin bodyLogin) {
        Optional<Object> userOptional = userRepository.findByEmail(bodyLogin.getEmail());

        if (userOptional.isPresent()) {
            User user = (User) userOptional.get();
            if (user.getSenha().equals(bodyLogin.getSenha())) {
                return ResponseEntity.ok().body(user);
            } else {
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                        .body(new Message("Usuário ou senha incorreto."));
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new Message("Usuário ou senha incorreto."));
        }
    }

    @CrossOrigin
    @PostMapping("/cadastro")
    public ResponseEntity<?> createUser(@RequestBody User user) throws URISyntaxException {
        if (userRepository.findByEmail(user.getEmail()).isPresent()) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                    .body(new Message("Usuário já existe"));
        }

        User newUser = userRepository.save(user);
        return ResponseEntity.created(new URI("/usuario/" + newUser.getId()))
                .body(newUser);
    }

    @CrossOrigin
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            userRepository.delete(user.get());
            return ResponseEntity.ok(new Message("Usuário deletado com sucesso"));
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new Message("Usuário não encontrado"));
        }
    }
}
