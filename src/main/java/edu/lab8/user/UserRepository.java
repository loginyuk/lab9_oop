package edu.lab8.user;

import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Integer> {
    @Query("SELECT s FROM Flower s WHERE s.id = ?1")
    public Optional<AppUser> findAppUserByEmail(String email);

    public void save(User user);
}