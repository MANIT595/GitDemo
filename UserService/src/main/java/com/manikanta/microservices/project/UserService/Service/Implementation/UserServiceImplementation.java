package com.manikanta.microservices.project.UserService.Service.Implementation;

import com.manikanta.microservices.project.UserService.DTO.UserDTO;
import com.manikanta.microservices.project.UserService.Entity.User;
import com.manikanta.microservices.project.UserService.Exception.EmailAlreadyFoundException;
import com.manikanta.microservices.project.UserService.Exception.UserNotFoundException;
import com.manikanta.microservices.project.UserService.Mapper.AutoUserMapper;
import com.manikanta.microservices.project.UserService.Repository.UserRepository;
import com.manikanta.microservices.project.UserService.Service.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
@NoArgsConstructor
public class UserServiceImplementation implements UserService {

    @Autowired
    private UserRepository userRepository;

    Logger logger = LoggerFactory.getLogger(UserServiceImplementation.class);

//    @Autowired
//    private ModelMapper mapper;

    @Override
    public List<UserDTO> getUsers() {
        logger.debug("entered into get all user method");
        List<User> users = userRepository.findAll();
        return users.stream()
                .map(AutoUserMapper.MAPPER::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public UserDTO getUser(Long userId){
        User user = userRepository.findById(userId).orElseThrow(()->new UserNotFoundException("No User Found with this userId: "+userId));
        return AutoUserMapper.MAPPER.mapToDTO(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userRepository.deleteById(userId);
        System.out.println("Deleted");
    }

    @Override
    public void addUser(User user) {
        User userOne = userRepository.findByEmail(user.getEmail());
        if(userOne != null){
            throw new EmailAlreadyFoundException("Email Already found in database");
        }
        userRepository.save(user);
        System.out.println("saved to db");
    }

}
