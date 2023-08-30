package cloud.web.simple.entity.driver;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter @Setter
@Table(name = "jdbc_driver")
@NoArgsConstructor
public class JdbcDriver {

    @Setter(value = AccessLevel.NONE)
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "driver_id")
    private int id;

    @Column(length = 50)
    private String dbmsNameKor;

    @Column(length = 50)
    private String dbmsNameEng;

    @Column(length = 500)
    private String driverUrl;

    @Column(length = 500)
    private String driverClass;
}
