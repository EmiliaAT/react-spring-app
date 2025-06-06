package com.csc340_group_one.brain_dump.comment;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * CommentController is a REST controller that handles HTTP requests related to
 * Comments.
 * It provides endpoints for CRUD operations on Comment data.
 */
@RestController
public class CommentController {

  @Autowired
  private CommentService CommentService;

  /**
   * Endpoint to pull back an individual comment
   *
   * @param commentid the id of the comment to pull
   * @return the comment
   */
  @GetMapping("/comment/{id}")
  public Optional<Comment> getCommentById(@PathVariable long id) {
    return CommentService.getCommentById(id);
  }

  /**
   * Endpoint to add a comment to an article
   *
   * @param Comment the comment to add
   * @return the comment
   */
  @PostMapping("/comment")
  public Object addComment(@RequestBody Comment Comment) {
    return CommentService.addComment(Comment);
  }

  /**
   * Endpoint to mark a comment as deleted
   *
   * @param commentid The ID of the comment to erase
   * @return the comment with prior text removed
   */
  @DeleteMapping("/comment/{commentid}")
  public Object deleteComment(@PathVariable long commentid, @RequestBody Comment Comment) {
    CommentService.deleteComment(Comment);
    return CommentService.getCommentById(commentid);
  }

  /**
   * Endpoint to update the text of a comment
   *
   * @param commentid The ID of the comment to update
   * @return the comment with updated text
   */
  @PutMapping("/comment/{commentid}")
  public Optional<Comment> updateComment(@PathVariable long commentid, @RequestBody Comment Comment) {
    CommentService.updateComment(commentid,Comment);
    return CommentService.getCommentById(commentid);
  }

}