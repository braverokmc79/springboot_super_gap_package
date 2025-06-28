package kr.ac.macaronics.web.domain;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@EqualsAndHashCode(of = "id")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Embedded
  private UserInfo info;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "count", column = @Column(name = "following_count"))
  })
  private UserRelationCounter followingCount;

  @Embedded
  @AttributeOverrides({
      @AttributeOverride(name = "count", column = @Column(name = "follower_count"))
  })
  private UserRelationCounter followerCount;


  @Builder
  public User(Long id, UserInfo info) {
    this.id = id;
    this.info = info;
    this.followerCount = new UserRelationCounter();
    this.followingCount = new UserRelationCounter();
  }


  public void follow(User targetUser){
    if (targetUser == null || targetUser.getId() == null || this.id == null) {
      throw new IllegalArgumentException("Invalid user or id");
    }

    if (this.id.equals(targetUser.getId())) {
      throw new IllegalArgumentException("자신을 팔로우할 수 없습니다.");
    }

    followingCount.increase();
    targetUser.increaseFollowerCount();
  }



  public void unfollow(User targetUser) {
    if (targetUser == null || targetUser.getId() == null || this.id == null) {
      throw new IllegalArgumentException("Invalid user or id");
    }

    if (targetUser.equals(this)) {
      throw new IllegalArgumentException("자신을 언팔로우할 수 없습니다.");
    }
    followingCount.decrease();
    targetUser.decreaseFollowerCount();
  }


  private void increaseFollowerCount() {
    followerCount.increase();
  }

  private void decreaseFollowerCount() {
    followerCount.decrease();
  }






}





