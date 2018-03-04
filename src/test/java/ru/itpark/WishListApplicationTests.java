package ru.itpark;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import ru.itpark.entity.WishList;
import ru.itpark.repository.WishListJpaRepository;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class EmTest {
	@Autowired
	private WishListJpaRepository repository;

	@Test
	public void contextLoads() {
	}

	@Test
	public void testRepository () {
		{
			Assertions.assertNull(repository.findById(1));
		}

		WishList wishList =
				repository.create(new WishList(0, "Vasya"));

		{
			Assertions.assertNotEquals(0, wishList.getId());
		}

		{
			Assertions.assertNotNull(
					repository.findById(wishList.getId())
			);
		}

		repository.deleteById(wishList.getId());

		{
			Assertions.assertNull(repository.findById(1));
		}
	}
}
