package com.deep.test.lock;

/**
 * @author <a href="mailto:depin.hu@bl.com">hudepin</a>
 * @Description <p></p>
 * @ClassName Test
 * @create_date 2021.10.13 11:23
 * @since
 */
public class Test {
    public static void main(String[] args) {
        String fileNamePath="/opt/ftp/cpos-business/ftpbc2050/var/CPOS_FTP_ROOT/STOCK/2050/CPOS_STOCK_D_2050_001050_20211013111809.zip";
        String branchCode ="2050";
        for(int i=0;i<10;i++){
            Thread thread = new Thread(()->{
                CposFileNameAnalizer ana = CposFileNameAnalizer.newInstance(fileNamePath, CposMessageConstants.MSG_TYPE_STOCK,
                        branchCode);
                System.out.println(Thread.currentThread().getName()+":"+ana);
            },"thread"+i);
            thread.start();

        }

    }
}
