package com.xavier.sprbootmongodb.services;

import com.xavier.sprbootmongodb.domain.User;
import com.xavier.sprbootmongodb.dto.UserDTO;
import com.xavier.sprbootmongodb.repository.UserRepository;
import com.xavier.sprbootmongodb.services.exception.ObjectNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    //Anotação de injeção de dependencias
    @Autowired
    private UserRepository repo;

    public List<User> findAll() {
        return repo.findAll();


    }

    public User findById(String id) {

        User user = repo.findById(id).orElse(null);

        if (user == null){
            throw new ObjectNotFoundException("User not found");
        }
        return user;
    }

    public User insert(User user) {
        return repo.insert(user);
    }

    public User fromDTO(UserDTO userDTO){
        return new User(null, userDTO.getName(), userDTO.getEmail());
    }
}
