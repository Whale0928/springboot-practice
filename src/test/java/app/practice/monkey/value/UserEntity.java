package app.practice.monkey.value;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Comment;

import java.util.Objects;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Comment("사용자 정보 테이블")
@Entity(name = "users")
public class UserEntity {

    @Id
    @Comment("사용자 id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Comment("사용자 이메일")
    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Comment("사용자 닉네임")
    @Column(name = "nick_name", nullable = false, unique = true)
    private String nickName;

    @Comment("사용자 연령")
    @Column(name = "age")
    private Integer age;

    @Comment("사용자 성별")
    @Column(name = "gender")
    private String gender;

    @Comment("사용자 프로필 썸네일")
    @Column(name = "image_url")
    private String imageUrl;

    @Comment("사용자 리프레시토큰")
    @Column(name = "refresh_token")
    private String refreshToken;

    @Builder
    public UserEntity(Long id, String email, String nickName, Integer age, String gender, String imageUrl, String refreshToken) {
        this.id = id;
        this.email = email;
        this.nickName = nickName;
        this.age = age;
        this.gender = gender;
        this.imageUrl = imageUrl;
        this.refreshToken = refreshToken;
    }

    public void updateRefreshToken(String refreshToken) {
        Objects.requireNonNull(refreshToken, "refreshToken은 null이 될 수 없습니다.");
        this.refreshToken = refreshToken;
    }

    public void changeNickName(String nickName) {
        Objects.requireNonNull(nickName, "nickName은 null이 될 수 없습니다.");
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", nickName='" + nickName + '\'' +
                ", age=" + age + '\'';
    }
}
