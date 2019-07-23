package model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Version;
import java.io.Serializable;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Customers")
@Cache(region = "customerCache", usage = CacheConcurrencyStrategy.READ_WRITE)
public class Customer implements Serializable {

    public static final String PROP_USER_NAME = "userName";
    public static final String PROP_ID = "id";

    @Id
    @GenericGenerator(name = "customGenerator", strategy = "model.CustomIdGenerator")
    @GeneratedValue(generator = "customGenerator", strategy = GenerationType.SEQUENCE)
    @Column(name = "ID", unique = true)
    private String id;

    @Version
    @Column(name = "VERSION", nullable = false)
    private Long version;

    @Column(name = "USER NAME", nullable = false, length = 64)
    private String userName;


    @Column(name = "EMAIL", nullable = false, length = 64, unique = true)
    private String email;

}