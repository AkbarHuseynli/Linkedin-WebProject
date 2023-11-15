package org.example.service;

import org.example.model.entity.User;
import org.example.repository.IUserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private IUserRepository iUserRepository;

    public UserService(IUserRepository iUserRepository) {
        this.iUserRepository = iUserRepository;
    }

    public void save(User user) {
        iUserRepository.save(user);
    }
}
