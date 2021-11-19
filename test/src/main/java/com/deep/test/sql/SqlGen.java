package com.deep.test.sql;

/**
 * @author <a href="mailto:depin.hu@bl.com">hudepin</a>
 * @Description <p></p>
 * @ClassName SqlGen
 * @create_date 2021.04.23 10:06
 * @since
 */
public class SqlGen {
    static String sql="ALTER TABLE `t_offline_order_%d` MODIFY COLUMN `card_no`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL COMMENT '会员卡号（百联通ID，会员识别时，中台返回该ID。checkType是1 这个字段not null卡号，checkType是2这个字段not null手机号，checkType是3这个字段not null根据二维码扫出来的memberId）';";
    static String sql2="ALTER TABLE `t_offline_order_%d` MODIFY COLUMN `ticket_id`  varchar(64) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL COMMENT '小票ID';";
    static String sql3="ALTER TABLE `t_memberid_order_no_index_%d` ADD INDEX `indx_member_id_order_no_%d` (`member_id`, `order_no`) USING BTREE;";
    static String sql4="ALTER TABLE `t_order_id_order_no_index_%d` ADD INDEX `idx_order_id_order_no_%d` (`order_id`, `order_no`) USING BTREE;";
    public static void main(String[] args) {
        for(int i=0;i<=63;i++){
            System.out.println(String.format(sql3,i,i));
        }
        for(int i=0;i<=63;i++){
            System.out.println(String.format(sql4,i,i));
        }
    }
}
