package com.deep.test.reflect;

import com.deep.test.entity.User;

/**
 * @author <a href="mailto:depin.hu@bl.com">hudepin</a>
 * @Description <p></p>
 * @ClassName Test
 * @create_date 2021.03.23 17:11
 * @since
 */
public class Test {
    public static void main(String[] args) {
        System.out.println(new BaseService<User>().getEntityClass());// 控制台输出：null
    }
}
