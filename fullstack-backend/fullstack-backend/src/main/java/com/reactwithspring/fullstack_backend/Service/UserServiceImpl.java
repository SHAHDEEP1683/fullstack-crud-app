package com.reactwithspring.fullstack_backend.Service;

import com.reactwithspring.fullstack_backend.Entity.User;
import com.reactwithspring.fullstack_backend.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class UserServiceImpl {

    private final UserRepository userRepository;

    public User createUser(User user){
        User saveUser = new User();
        saveUser.setFullName(user.getFullName());
        saveUser.setCity(user.getCity());
        return userRepository.save(saveUser);
    }

    // READ - Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // READ - Get user by ID
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    // UPDATE
    public User updateUser(Long id, User updatedUser) {
        return userRepository.findById(id).map(user -> {
            user.setFullName(updatedUser.getFullName());
            user.setCity(updatedUser.getCity());
            return userRepository.save(user);
        }).orElseThrow(() -> new RuntimeException("User not found with ID: " + id));
    }

    // DELETE
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
