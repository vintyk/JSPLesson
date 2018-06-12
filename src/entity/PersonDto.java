package entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

@Getter
@Setter
@ToString
public class PersonDto implements Serializable {
    private static final long serialVersionUID = -8482091735370831638L;
    private String name;
    private String family;
}
