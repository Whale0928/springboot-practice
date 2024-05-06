package app.practice.springbootpractice.rating;

import jakarta.persistence.Embeddable;
import lombok.Getter;

@Getter
@Embeddable
public class StarRating {
	
	private final double rating;
	
	
	public StarRating() {
		this(0.0);
	}
	
	public StarRating(double rating) {
		if (!isValidRating(rating))
			throw new IllegalArgumentException("숫자 범위가 잘못되었습니다. 0.0 ~ 5.0 사이의 숫자여야 합니다.");
		this.rating = rating;
	}
	
	private boolean isValidRating(double rating) {
		return rating >= 0.0 && rating <= 5.0 && (rating * 2) % 1 == 0;
	}
	
	@Override
	public String toString() {
		return String.format("%.1f", rating);
	}
}
