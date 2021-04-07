package com.hwt.bean.dict;

import com.hwt.annotation.QueryTable;
import lombok.Data;
import lombok.ToString;

@QueryTable("cctime")
@Data
@ToString
public class TestBean {
    public static String tempString = "testString";
    private String name;

}
