package net.javacode.repo;

import net.javacode.domain.Specialty;
import org.springframework.data.repository.CrudRepository;

public interface SpecialtyRepository extends CrudRepository<Specialty, Long> {
    Specialty findByName(String name);
}
