package com.deep.test.exception;

/**
 * @author <a href="mailto:depin.hu@bl.com">hudepin</a>
 * @Description <p></p>
 * @ClassName AbstractException
 * @create_date 2021.09.06 17:33
 * @since
 */
public abstract class AbstractException implements ExceptionInterface {
    public void process() {
        try {
            test();
        } catch (Exception e) {
            System.out.println("AbstractException error");
        }

    }
}
