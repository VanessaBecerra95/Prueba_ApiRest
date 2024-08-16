package cl.praxis.reportes_inmobiliaria.models.services;

import cl.praxis.reportes_inmobiliaria.models.entities.User;
import cl.praxis.reportes_inmobiliaria.models.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(Integer id) {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public boolean create(User user) {
        User u = userRepository.save(user);
        return u != null;
    }

    @Override
    public boolean update(User user) {
        return userRepository.save(user) != null;
    }

    @Override
    public boolean delete(Integer id) {
        boolean exist = userRepository.existsById(id);
        if (exist){
            userRepository.deleteById(id);
        }
        return exist;
    }
}
