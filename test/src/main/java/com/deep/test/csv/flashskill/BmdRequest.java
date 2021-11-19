package com.deep.test.csv.flashskill;

import lombok.Data;

import java.util.List;

/**
 * Created with IntelliJ IDEA
 * Created By dingjianglei
 * Date: 2021/2/5
 * Time: 13:35
 */
@Data
public class BmdRequest extends BaseRequest {
    private List<BmdDTO> bmdList;

}
