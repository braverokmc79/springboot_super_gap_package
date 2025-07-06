package kr.ac.macaronics.web.post.domain.content;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
public class PostContent {

  private String content;

  public PostContent(String content) {
    ContentValidator.validate(content);
    this.content = content;
  }
}
