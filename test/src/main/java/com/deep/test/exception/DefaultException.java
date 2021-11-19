package com.deep.test.exception;

/**
 * @author <a href="mailto:depin.hu@bl.com">hudepin</a>
 * @Description <p></p>
 * @ClassName DefaultException
 * @create_date 2021.09.06 17:34
 * @since
 */
public class DefaultException extends AbstractException{
    @Override
    public void test() throws Exception {
        throw new Exception("ces");
    }
}
