package com.deep.test.jdk8;

import lombok.Data;

/**
 * @author hudepin
 * @Description
 * @ClassName Usb
 * @create_date 2020.09.14 11:17
 * @since 1.2.0
 */
@Data
public class Usb {
    private String version;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }
}
