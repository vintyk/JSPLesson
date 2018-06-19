package entity;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Hero {
    private Long id;
    private String nameHero;
    private int age;

    public static final class HeroBuilder {
        private Long id;
        private String nameHero;
        private int age;

        private HeroBuilder() {
        }

        public static HeroBuilder aHero() {
            return new HeroBuilder();
        }

        public HeroBuilder withId(Long id) {
            this.id = id;
            return this;
        }

        public HeroBuilder withNameHero(String nameHero) {
            this.nameHero = nameHero;
            return this;
        }

        public HeroBuilder withAge(int age) {
            this.age = age;
            return this;
        }

        public HeroBuilder but() {
            return aHero().withId(id).withNameHero(nameHero).withAge(age);
        }

        public Hero build() {
            return new Hero(id, nameHero, age);
        }
    }
}
