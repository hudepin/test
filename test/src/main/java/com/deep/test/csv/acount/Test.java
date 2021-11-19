package com.deep.test.csv.acount;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author <a href="mailto:depin.hu@bl.com">hudepin</a>
 * @Description <p></p>
 * @ClassName Test
 * @create_date 2021.08.16 17:17
 * @since
 */
public class Test {
    public static void main(String[] args) {
        List<AccountRoleDTO> list =new ArrayList<>();
        list.add(new AccountRoleDTO(1L));
        setList(list);
        list.forEach(e->{
            System.out.println(e.getAccountId());
        });
        Map<String,String> hashMap = new HashMap<>();
        System.out.println(hashMap.containsKey("1231"));
    }

    private static void setList(List<AccountRoleDTO> list) {
        list.forEach(e->{
            e.setAccountId(2L);
        });
        list.add(new AccountRoleDTO(4L));
    }
}
