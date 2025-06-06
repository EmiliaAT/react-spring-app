package com.csc340_group_one.brain_dump.comment;

/* import java.util.List; */
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
/* import org.springframework.data.jpa.repository.Query; */
import org.springframework.stereotype.Repository;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    Optional<Comment> findById(long commentid);

}
