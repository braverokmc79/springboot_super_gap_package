package kr.ac.macaronics.web.post.domain.content;

public class ContentValidator {

  public static void validate(String content) {
    if (content == null || content.length() < 5 || content.length() > 500) {
      throw new IllegalArgumentException("내용은 5자 이상 500자 이하이어야 합니다.");
    }
  }

}