package kr.ac.macaronics.web.post.domain;

import jakarta.persistence.*;
import kr.ac.macaronics.web.common.domain.BaseTimeEntity;
import kr.ac.macaronics.web.common.domain.PositiveIntegerCounter;
import kr.ac.macaronics.web.post.domain.content.PostContent;
import kr.ac.macaronics.web.user.domain.User;
import lombok.AccessLevel;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "posts")
@EqualsAndHashCode(of = "id")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseTimeEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "author_id", nullable = false)
  private User author;

  @Embedded
  private PostContent content;


  @Embedded
  private PositiveIntegerCounter likeCount = new PositiveIntegerCounter();


  public Post(User author, String content) {
    if (author == null) {
      throw new IllegalArgumentException("작성자는 null일 수 없습니다.");
    }
    this.author = author;
    this.content = new PostContent(content);
  }

}
