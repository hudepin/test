package com.deep.test.reflect;

/**
 * @author <a href="mailto:depin.hu@bl.com">hudepin</a>
 * @Description <p></p>
 * @ClassName BaseService
 * @create_date 2021.03.23 17:10
 * @since
 */
public class BaseService <E>{
    public Class<?> getEntityClass() {
        return GenericSuperclassUtil.getActualTypeArgument(this.getClass());
    }
}
