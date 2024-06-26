package htwberlin.webtech.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class StatId implements Serializable {

    protected Integer id;
    protected Integer rating;

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null || o.getClass() != this.getClass()) return false;
        StatId that = (StatId) o;
        return Objects.equals(this.id, that.id) &&
                Objects.equals(this.rating, that.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, rating);
    }
}
