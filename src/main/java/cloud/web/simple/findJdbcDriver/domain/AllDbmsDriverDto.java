package cloud.web.simple.findJdbcDriver.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class AllDbmsDriverDto {
    private int dbmsId;
    private String dbmsNameKor;
    private String dbmsNameEng;
    private String driverClass;
    private String driverUrl;
}
