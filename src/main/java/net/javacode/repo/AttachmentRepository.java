package net.javacode.repo;

import net.javacode.domain.Attachment;
import net.javacode.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AttachmentRepository extends CrudRepository<Attachment, Long> {
    Attachment findByFileName(String fileName);

    List<Attachment> findByOwner(User owner);
}
