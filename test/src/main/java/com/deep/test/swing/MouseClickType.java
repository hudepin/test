package com.deep.test.swing;

/**
 * @author <a href="mailto:depin.hu@bl.com">hudepin</a>
 * @Description <p></p>
 * @ClassName MouseClickType
 * @create_date 2021.09.10 15:33
 * @since
 */
public enum MouseClickType {
    convertBtn(1,"转换"),copy(2,"复制");
    private Integer code;
    private String desc;

    MouseClickType(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
