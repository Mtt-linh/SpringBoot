package com.example.Springboot.respository;

import com.example.Springboot.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRespository extends CrudRepository<User,Long> {

}
