package cloud.web.simple.findJdbcDriver.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class DriverResponse {
    private String dbmsNameEng;
    private String dbmsNameKor;
    private String driverClass;
    private String driverUrl;
}
