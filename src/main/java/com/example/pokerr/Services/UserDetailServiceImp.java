package com.example.pokerr.Services;

import com.example.pokerr.Repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service

public class UserDetailServiceImp implements UserDetailsService {

    private  final UserRepository repository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return repository.findByEmail(username).orElseThrow(()-> new UsernameNotFoundException("User not found "));

    }


}
