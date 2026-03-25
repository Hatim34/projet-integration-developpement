package be.iccbxl.pid.reservationsspringboot.model;

import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@Entity
@Table(name = "artist_type")
public class ArtistType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artist;

    @ManyToOne
    @JoinColumn(name = "type_id", nullable = false)
    private Type type;

    @ManyToMany
    @JoinTable(
        name = "artist_type_show",
        joinColumns = @JoinColumn(name = "artist_type_id"),
        inverseJoinColumns = @JoinColumn(name = "show_id")
    )
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Show> shows = new HashSet<>();
}
