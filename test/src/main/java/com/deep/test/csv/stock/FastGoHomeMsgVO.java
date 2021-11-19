package com.deep.test.csv.stock;

import java.util.ArrayList;
import java.util.List;

/**
 * @author <a href="mailto:depin.hu@bl.com">hudepin</a>
 * @Description <p></p>
 * @ClassName FastGoHomeMsgVO
 * @create_date 2021.05.24 14:00
 * @since
 */
public class FastGoHomeMsgVO {
    private String uuid;
    private Long sendTime;
    private List<FastGoHomeMsgDTO> list = new ArrayList<FastGoHomeMsgDTO>();
    private List<PushToGoHomeMsgDTO> pushToHome = new ArrayList<PushToGoHomeMsgDTO>();

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Long getSendTime() {
        return sendTime;
    }

    public void setSendTime(Long sendTime) {
        this.sendTime = sendTime;
    }

    public List<FastGoHomeMsgDTO> getList() {
        return list;
    }

    public void setList(List<FastGoHomeMsgDTO> list) {
        this.list = list;
    }

    public List<PushToGoHomeMsgDTO> getPushToHome() {
        return pushToHome;
    }

    public void setPushToHome(List<PushToGoHomeMsgDTO> pushToHome) {
        this.pushToHome = pushToHome;
    }
}
