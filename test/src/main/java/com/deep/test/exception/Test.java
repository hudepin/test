package com.deep.test.exception;

/**
 * @author <a href="mailto:depin.hu@bl.com">hudepin</a>
 * @Description <p></p>
 * @ClassName Test
 * @create_date 2021.09.06 17:37
 * @since
 */
public class Test {
    public static void main(String[] args) {
        AbstractException defaultException = new DefaultException();

        defaultException.process();

    }
}
