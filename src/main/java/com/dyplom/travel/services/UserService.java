package com.dyplom.travel.services;

import com.dyplom.travel.configuration.JwtProvider;
import com.dyplom.travel.exceptions.NotAuthenticatedException;
import com.dyplom.travel.exceptions.UserExistsException;
import com.dyplom.travel.models.user.User;
import com.dyplom.travel.repositories.UserRepository;
import com.dyplom.travel.services.mappers.UserMapper;
import com.dyplom.travel.services.models.CreateUserRequest;
import com.dyplom.travel.services.models.ResponseUserDto;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.dyplom.travel.exceptions.ErrorMessages.*;

@RequiredArgsConstructor
@Service
public class UserService extends BasePersistenceService<User> {

    private final UserRepository repository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;
    private final UserMapper mapper;

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return Optional.ofNullable(repository.findByUsername(username))
                .orElseThrow(() -> new UsernameNotFoundException(INVALID_CREDENTIALS));
    }

    public ResponseUserDto login(String username, String password) {
        User user = Optional.ofNullable(repository.findByUsernameAndPassword(username, passwordEncoder.encode(password)))
                .orElseThrow(() -> new UsernameNotFoundException(INVALID_CREDENTIALS));
        ResponseUserDto convertedUser = mapper.asResponse(user);
        return populateWithToken(convertedUser);
    }

    @Transactional
    public ResponseUserDto register(CreateUserRequest request) {
        String password = passwordEncoder.encode(request.getPassword());
        if (repository.findByUsername(request.getUsername()) != null) {
            throw new UserExistsException(USERNAME_ALREADY_EXISTS);
        }
        User savedUser = save(mapper.asUser(request.getUsername(), password));
        ResponseUserDto convertedUser = mapper.asResponse(savedUser);
        return populateWithToken(convertedUser);
    }

    public ResponseUserDto checkLogin(Authentication authentication) {
        if (authentication.isAuthenticated()) {
            User user = (User) loadUserByUsername(authentication.getPrincipal().toString());
            ResponseUserDto convertedClient = mapper.asResponse(user);
            return populateWithToken(convertedClient);
        }
        throw new NotAuthenticatedException(NOT_AUTH);
    }

    private ResponseUserDto populateWithToken(ResponseUserDto user) {
        user.setToken(jwtProvider.generateToken(user));
        return user;
    }

    @Override
    protected JpaRepository<User, Long> getRepository() {
        return repository;
    }
}
