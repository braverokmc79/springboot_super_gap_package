package org.fastcampus.student_management.domain;

public class CourseFee {

  private int fee;

  public CourseFee(int fee) {
    validateFee(fee);
    this.fee = fee;
  }

  public void changeFee(int fee) {
    validateFee(fee);
    this.fee = fee;
  }

  public int getFee() {
    return this.fee;
  }

  private static void validateFee(int fee) {
    if (fee < 0) {
      throw new IllegalArgumentException("수강료는 0원 이상이어야 합니다");
    }
  }

  @Override
  public String toString() {
    return fee + "원";
  }
}
