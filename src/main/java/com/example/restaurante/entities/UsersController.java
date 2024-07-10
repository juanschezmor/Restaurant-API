package com.example.restaurante.entities;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UsersController {

    @Autowired
    private UsersRepository UsersRepository;


    @PostMapping ("/register")
    public Users addUser(@RequestBody Users user){

        UsersRepository.save(user);
        return user;
    }

    @GetMapping("/all-users")
    public Iterable<Users> getAllUsers(){
        return UsersRepository.findAll();
    }

    @GetMapping("/user")
    public Users getUser(@RequestParam int id){
        return UsersRepository.findById(id).get();
    }

    @GetMapping("/login")
    public int login(@RequestParam String email, @RequestParam String password){
        Users foundUser = null;
        for (Users user:UsersRepository.findAll()
             ) {
            if (user.getEmail().equals(email)){
                foundUser = user;
                break;
            }
        }
        if(foundUser!=null){
            if(foundUser.getPassword().equals(password)){
                return foundUser.getUserId();
            }
        }
        return -1;
    }
}
