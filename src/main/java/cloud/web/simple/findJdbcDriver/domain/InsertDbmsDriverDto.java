package cloud.web.simple.findJdbcDriver.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class InsertDbmsDriverDto {
    private String dbmsNameEng;
    private String dbmsNameKor;
    private String driverClass;
    private String driverUrl;
}
