package net.javacode.repo;

import lombok.NonNull;
import net.javacode.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    public Optional<User> findByUsername(@NonNull String username);
}
