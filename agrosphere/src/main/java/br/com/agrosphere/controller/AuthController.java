package br.com.agrosphere.controller;

import br.com.agrosphere.dto.LoginDTO;
import br.com.agrosphere.dto.TokenDTO;
import br.com.agrosphere.entity.Usuario;
import br.com.agrosphere.repository.UsuarioRepository;
import br.com.agrosphere.security.JwtService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final UsuarioRepository usuarioRepository;
    private final JwtService jwtService;

    @PostMapping("/login")
    public TokenDTO login(
            @RequestBody LoginDTO dto
    ){

        Usuario usuario =
                usuarioRepository
                        .findByEmail(dto.email())
                        .orElseThrow();

        if(!usuario.getSenha()
                .equals(dto.senha())){

            throw new RuntimeException(
                    "Senha inválida"
            );
        }

        String token =
                jwtService.gerarToken(
                        usuario.getEmail()
                );

        return new TokenDTO(token);
    }
}