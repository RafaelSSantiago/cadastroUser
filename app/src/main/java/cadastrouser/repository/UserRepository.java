package main.java.cadastrouser.repository;

import cadastrouser.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

interface UserRepository extends JpaRepository<user, Long> {
  User findByUsername(String username);

}