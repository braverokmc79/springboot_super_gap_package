package kr.ac.macaronics.web.user.domain;

import jakarta.persistence.Embeddable;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
public class UserInfo {

  private String name;
  private String profileImageUrl;

  protected UserInfo() {
    // JPA 기본 생성자
  }

  public UserInfo(String name, String profileImageUrl) {
    if (name == null || profileImageUrl == null) {
      throw new IllegalArgumentException("name과 profileImageUrl은 null일 수 없습니다.");
    }
    this.name = name;
    this.profileImageUrl = profileImageUrl;
  }


}
