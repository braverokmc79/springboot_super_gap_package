package kr.ac.macaronics.web.user.domain;


import jakarta.persistence.Embeddable;
import lombok.Getter;

@Embeddable
@Getter
public class UserRelationCounter {

  private int count;
  public UserRelationCounter() {
    this.count = 0;
  }

  public void increase() {
    this.count++;
  }

  public void decrease() {
    if(this.count <= 0) {
      return;
    }
    this.count--;
  }


}
