package com.deep.test;

import com.deep.test.entity.AihuishouOrderListDTO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author hudepin
 * @Description
 * @ClassName Test1212
 * @create_date 2020.10.12 17:41
 * @since 1.2.0
 */
public class Test1212 {
//    public static void main(String[] args) {
//        String s="hudeo/1221/12.html";
//        System.out.println(s.substring(0,s.indexOf("/")));
//        System.out.println(5/2);
//    }
public static void main(String[] args) {
    List<AihuishouOrderListDTO> orderList =new ArrayList<>();
    AihuishouOrderListDTO ss = new AihuishouOrderListDTO();
    ss.setStoreId("100");
    ss.setAbnInfo("21313");
    orderList.add(ss);
    AihuishouOrderListDTO s2 = new AihuishouOrderListDTO();
    s2.setStoreId("100");
    s2.setAbnInfo("21313");
    orderList.add(s2);
    List<String> storeIds = orderList.stream().map(e->e.getStoreId()).distinct().collect(Collectors.toList());
    storeIds.stream().forEach(System.out::println);
    storeIds.add(0,null);
}
}
