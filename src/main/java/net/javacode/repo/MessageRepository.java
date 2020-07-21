package net.javacode.repo;

import net.javacode.domain.Message;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {
    public List<Message> findByTag(String tag);
}
