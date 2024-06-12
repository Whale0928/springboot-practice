package app.practice.monkey;

import app.practice.monkey.value.BeanProduct;
import app.practice.monkey.value.Product;
import app.practice.monkey.value.UserEntity;
import com.navercorp.fixturemonkey.FixtureMonkey;
import com.navercorp.fixturemonkey.api.instantiator.Instantiator;
import com.navercorp.fixturemonkey.api.introspector.BuilderArbitraryIntrospector;
import com.navercorp.fixturemonkey.api.introspector.ConstructorPropertiesArbitraryIntrospector;
import com.navercorp.fixturemonkey.api.introspector.FailoverIntrospector;
import com.navercorp.fixturemonkey.jakarta.validation.plugin.JakartaValidationPlugin;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.BDDAssertions.then;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@DisplayName("Fixture Monkey Application Test")
public class FixtureMonkeyApplicationTest {

    @Test
    @DisplayName("몽키가 setter 기반 픽스처를 생성한다")
    void test_1() {

        // given
        FixtureMonkey fixtureMonkey = FixtureMonkey.create();

        // when
        Product actual = fixtureMonkey.giveMeOne(Product.class);

        // then
        System.out.println(actual);
        assertNotNull(actual);
    }


    @Test
    @DisplayName("몽키가 빈 유효성 기반 픽스처를 생성한다")
    void test_2() {

        // given
        FixtureMonkey fixtureMonkey = FixtureMonkey.builder()
                .objectIntrospector(new FailoverIntrospector(
                        Arrays.asList(
                                BuilderArbitraryIntrospector.INSTANCE,
                                ConstructorPropertiesArbitraryIntrospector.INSTANCE
                        )
                ))
                .build();

        // when
        BeanProduct actual = fixtureMonkey.giveMeBuilder(BeanProduct.class)
                .instantiate(Instantiator.factoryMethod("from"))
                .sample();

        // then
        then(actual).isNotNull();
        System.out.println(actual);
    }

    @Test
    @DisplayName("엔티티를 생성한다")
    void test_3() {

        // given
        FixtureMonkey fixtureMonkey = FixtureMonkey.builder()
                .objectIntrospector(ConstructorPropertiesArbitraryIntrospector.INSTANCE)
                .plugin(new JakartaValidationPlugin())
                .build();

        // when
        UserEntity userEntity = fixtureMonkey.giveMeOne(UserEntity.class);

        // then
        System.out.println(userEntity);
        assertNotNull(userEntity);
    }

    @Test
    @DisplayName("커스텀 엔티티를 생성한다")
    void test_4() {

        // given
        FixtureMonkey fixtureMonkey = FixtureMonkey.builder()
                .objectIntrospector(ConstructorPropertiesArbitraryIntrospector.INSTANCE)
                .plugin(new JakartaValidationPlugin())
                .build();

        // when
        UserEntity userEntity = fixtureMonkey.giveMeBuilder(UserEntity.class)
                .set("id", 1000L)
                .build().sample();


        // then
        System.out.println(userEntity);
        assertNotNull(userEntity);
    }
}
