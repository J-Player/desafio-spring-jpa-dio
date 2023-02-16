package br.com.example.services.impl;

import br.com.example.models.User;
import br.com.example.repositories.UserRepository;
import br.com.example.services.IService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IService<User> {

    private final UserRepository userRepository;

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow();
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User save(User user) {
        return userRepository.save(user);
    }

    @Override
    public void update(User user) {
        User userSaved = findById(user.getId());
        if (userSaved != null) {
            userRepository.save(user);
        }
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

}
