package bare.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "config")
public class Config {

    @Id
    private String parameter;

    @Column
    private String value;

    @Column
    private String comment;
}
