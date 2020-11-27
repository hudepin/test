package com.deep.test.jdk8;

import com.deep.test.entity.User;

import java.util.Optional;

/**
 * @author hudepin
 * @Description
 *    电脑里【有可能】有声卡
 *    声卡【有可能】有USB接口
 * @ClassName OptinalTest1
 * @create_date 2020.09.14 11:21
 * @since 1.2.0

 */
public class OptionalTest1 {
    public static void main(String[] args) {
        test();
        test2();
    }
    public static void test(){
        // 没有声卡，没有 Usb 的电脑
        Computer computerNoUsb = new Computer();
        computerNoUsb.setSoundCard(Optional.empty());
        // 获取 usb 版本
        Optional<Computer> computerOptional = Optional.ofNullable(computerNoUsb);
        String version = computerOptional.flatMap(Computer::getSoundCard).flatMap(SoundCard::getUsb)
                .map(Usb::getVersion).orElse("UNKNOWN");
        System.out.println(version);
        System.out.println("-----------------");

        // 如果有值，则输出
        SoundCard soundCard = new SoundCard();
        Usb usb = new Usb();
        usb.setVersion("2.0");
        soundCard.setUsb(Optional.ofNullable(usb));
        Optional<SoundCard> optionalSoundCard = Optional.ofNullable(soundCard);
        optionalSoundCard.ifPresent(System.out::println);
        // 如果有值，则输出
        if (optionalSoundCard.isPresent()) {
            System.out.println(optionalSoundCard.get());
        }

        // 输出没有值，则没有输出
        Optional<SoundCard> optionalSoundCardEmpty = Optional.ofNullable(null);
        optionalSoundCardEmpty.ifPresent(System.out::println);
        System.out.println("-----------------");

        // 筛选 Usb2.0
        optionalSoundCard.map(SoundCard::getUsb)
                .filter(usb1 -> "3.0".equals(usb1.map(Usb::getVersion)
                        .orElse("UBKNOW")))
                .ifPresent(System.out::println);

    }
    public static void test2(){
        // filter 过滤
        Optional<Integer> optional123 = Optional.of(123);
        optional123.filter(num -> num == 123).ifPresent(num -> System.out.println(num));

        Optional<Integer> optional456 = Optional.of(456);
        optional456.filter(num -> num == 123).ifPresent(num -> System.out.println(num));

        // map 转换
        Optional<Integer> optional789 = Optional.of(789);
        System.out.println(optional789.map(String::valueOf).get());
        optional789.map(String::valueOf).map(String::length).ifPresent(length -> System.out.println(length));
    }
}
