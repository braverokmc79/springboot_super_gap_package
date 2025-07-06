package kr.ac.macaronics.web.post.domain.comment;

import jakarta.persistence.*;
import kr.ac.macaronics.web.post.domain.Post;
import kr.ac.macaronics.web.post.domain.content.CommentContent;
import kr.ac.macaronics.web.user.domain.User;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "comments")
@Getter
@EqualsAndHashCode(of = "id")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "post_id", nullable = false)
  private Post post;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "author_id", nullable = false)
  private User author;

  @Embedded
  private CommentContent content;

  public Comment(Post post, User author, String content) {
    if (post == null || author == null) {
      throw new IllegalArgumentException("Post와 Author는 null일 수 없습니다.");
    }

    this.post = post;
    this.author = author;
    this.content = new CommentContent(content);
  }
}
