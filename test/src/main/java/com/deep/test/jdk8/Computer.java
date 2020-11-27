package com.deep.test.jdk8;

import lombok.Data;

import java.util.Optional;

/**
 * @author hudepin
 * @Description
 * @ClassName Computer
 * @create_date 2020.09.14 11:16
 * @since 1.2.0
 */
@Data
public class Computer {
    private Optional<SoundCard> soundCard;

    public Optional<SoundCard> getSoundCard() {
        return soundCard;
    }

    public void setSoundCard(Optional<SoundCard> soundCard) {
        this.soundCard = soundCard;
    }
}
