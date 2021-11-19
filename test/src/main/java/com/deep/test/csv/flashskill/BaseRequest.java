package com.deep.test.csv.flashskill;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

@Slf4j
@Data
public class BaseRequest {
    private String activeCode;
    private Long goodsSid;
    private String maskCode;
}
