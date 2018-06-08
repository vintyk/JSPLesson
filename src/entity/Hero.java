package entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Hero {
    private Long id;
    private String nameHero;
    private int age;
}
