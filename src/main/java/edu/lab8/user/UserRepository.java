package ua.edu.ucu.apps.flowerstore.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<AppUser, Integer> {
    public Optional<AppUser> findAppUserByEmail(String email);
}