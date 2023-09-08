package cloud.web.simple.findJdbcDriver;

import cloud.web.simple.findJdbcDriver.domain.InsertDbmsDriverDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import javax.transaction.TransactionScoped;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class DriverServiceTest {

    @Autowired
    private DriverService driverService;

    @Test
    void insertDriver() {
        InsertDbmsDriverDto insertDbmsDriverDto = new InsertDbmsDriverDto(
                "오라클",
                "Oracle",
                "oracle.jdbc.driver.OracleDriver",
                "jdbc:oracle:thin:@[HOST][:PORT]:SID"
        );
        driverService.insertDriver(insertDbmsDriverDto);
    }

    @Test
    void findAllDbmsDriver() {
    }
}