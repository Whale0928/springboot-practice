package app.practice.springbootpractice.rating;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/ratings")
public class RatingController {
	
	private final RatingRepo ratingRepo;
	
	@GetMapping
	public Object getRatings(@RequestParam("star") StarRating rating) {
		log.info("Rating: {}", rating);
		Rating rat = Rating.builder().rating(rating).build();
		Rating save = ratingRepo.save(rat);
		return save.toString();
	}
	
}

