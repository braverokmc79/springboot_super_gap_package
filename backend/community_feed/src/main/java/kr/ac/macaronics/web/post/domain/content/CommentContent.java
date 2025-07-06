package kr.ac.macaronics.web.post.domain.content;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
public class CommentContent {

  private String content;

  public CommentContent(String content) {
    ContentValidator.validate(content);
    this.content = content;
  }
}
