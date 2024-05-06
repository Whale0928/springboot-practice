package app.practice.springbootpractice.config;

import app.practice.springbootpractice.rating.StarRating;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class StringToStarRatingConverter implements Converter<String, StarRating> {
	@Override
	public StarRating convert(String source) {
		try {
			double rating = Double.parseDouble(source);
			return new StarRating(rating);
		} catch (NumberFormatException e) {
			throw new IllegalArgumentException("입력된 값이 숫자가 아닙니다: " + source);
		} catch (IllegalArgumentException e) {
			System.out.println("유효하지 않은 별점 값: " + source + ". 별점은 0.0부터 5.0 사이이며, 0.5 단위로 증가해야 합니다.");
			throw new IllegalArgumentException("유효하지 않은 별점 값: " + source + ". 별점은 0.0부터 5.0 사이이며, 0.5 단위로 증가해야 합니다.");
		}
	}
}
