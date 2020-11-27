package com.deep.test.jdk8;

import lombok.Data;

import java.util.Optional;

/**
 * @author hudepin
 * @Description
 * @ClassName SoundCard
 * @create_date 2020.09.14 11:17
 * @since 1.2.0
 */
@Data
public class SoundCard {
    private Optional<Usb> usb;

    public Optional<Usb> getUsb() {
        return usb;
    }

    public void setUsb(Optional<Usb> usb) {
        this.usb = usb;
    }
}
