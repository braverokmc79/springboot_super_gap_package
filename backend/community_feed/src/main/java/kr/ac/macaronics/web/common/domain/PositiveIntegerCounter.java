package kr.ac.macaronics.web.common.domain;


import jakarta.persistence.Embeddable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Embeddable
@EqualsAndHashCode
public class PositiveIntegerCounter {

  private int count;

  public PositiveIntegerCounter() {
    this.count = 0;
  }

  public void increase() {
    this.count += 1;
  }

  public void decrease() {
    if (this.count <= 0) {
      throw new IllegalStateException("0 이하로 감소할 수 없습니다.");
    }
    this.count -= 1;
  }

}
