package cloud.web.simple.findJdbcDriver;

import cloud.web.simple.entity.driver.JdbcDriver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<JdbcDriver, Integer> {
}
