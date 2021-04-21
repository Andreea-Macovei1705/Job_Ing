package com.ING.Job.services;

import com.ING.Job.entities.UserEntity;
import com.ING.Job.exceptions.InvalidNameException;
import com.ING.Job.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<UserEntity> userOptional = userRepository.findByUsername(s);
        if (userOptional.isPresent()) {
            UserEntity userEntity = userOptional.get();

            String username = userEntity.getUsername();
            String password = userEntity.getPassword();
            List<GrantedAuthority> listadeRoluri = Arrays.asList(new SimpleGrantedAuthority(userEntity.getRole()));
            UserDetails userDetails = new User(username, password, listadeRoluri);
            return userDetails;
        }
        throw new UsernameNotFoundException("User not found!");
    }
    public void addCustomer(UserEntity user) {
        user.setRole("ROLE_CUSTOMER");
        String password = user.getPassword();
        String encodedPassword = passwordEncoder.encode(password);
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }

    public UserEntity getUserAccount(String username){
        Optional<UserEntity> userOptional = userRepository.findByUsername(username);
        return userOptional.get();
    }

    public void setUserRepository(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    public List<UserEntity> userL(){
        return userRepository.findAll();
    }

    public String getUsername(String username){
        if(username.length() == 0){
            throw new InvalidNameException("Invalid name!");
        }
        return username;
    }
}
