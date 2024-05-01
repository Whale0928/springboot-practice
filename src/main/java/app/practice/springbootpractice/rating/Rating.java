package app.practice.springbootpractice.rating;

import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Rating {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Embedded
	private StarRating rating;
	
	@Builder
	public Rating(Long id, StarRating rating) {
		this.id = id;
		this.rating = rating;
	}
	
	@Override
	public String toString() {
		return "Rating [id=" + id + ", rating=" + rating + "]";
	}
}
