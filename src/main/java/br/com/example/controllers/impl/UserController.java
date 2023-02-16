package br.com.example.controllers.impl;

import br.com.example.controllers.IController;
import br.com.example.mappers.UserMapper;
import br.com.example.models.User;
import br.com.example.models.dtos.UserDTO;
import br.com.example.services.impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController implements IController<User, UserDTO> {

    private final UserService userService;

    @Override
    @GetMapping("/{id}")
    public User findById(@PathVariable Long id) {
        return userService.findById(id);
    }

    @Override
    @GetMapping
    public List<User> findAll() {
        return userService.findAll();
    }

    @Override
    @PostMapping
    public User save(@RequestBody @Valid UserDTO userDTO) {
        return userService.save(UserMapper.INSTANCE.toUser(userDTO));
    }

    @Override
    @PutMapping
    public void update(@RequestBody @Valid UserDTO userDTO, @PathVariable Long id) {
        userService.update(UserMapper.INSTANCE.toUser(userDTO));
    }

    @Override
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userService.delete(id);
    }
}
