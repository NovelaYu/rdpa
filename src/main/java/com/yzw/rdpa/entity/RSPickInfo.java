package com.yzw.rdpa.entity;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class RSPickInfo {
    private List<Integer> ProjectSysNoList;
    private String DataDateBegin;
    private String DataDateEnd;
    private Integer PageSize;
    private  Integer PageIndex;
    private Integer ReceiptStatus;
    private String Code;
    private String PickDeptName;
    private String BuildingPartName;
    private String InUserName;

    public static RSPickInfo getRSPickInfo(boolean online) {
        RSPickInfo rSPickInfo = new RSPickInfo();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        rSPickInfo.setDataDateBegin("2012-12-23 15:35:32");
        rSPickInfo.setDataDateEnd(sdf.format(date));
        rSPickInfo.setPageSize(10);
        rSPickInfo.setPageIndex(0);
        if (online) {
            List<Integer> list = new ArrayList<>();
            list.add(24661);
            list.add(1);
            rSPickInfo.setProjectSysNoList(list);
            rSPickInfo.setReceiptStatus(15);
            rSPickInfo.setCode("ll-24661-yd-201218134900201");
            rSPickInfo.setPickDeptName("noah_001测试领料单位");
            rSPickInfo.setBuildingPartName("二楼影院");
            rSPickInfo.setInUserName("test6");
        } else  {
            List<Integer> list = new ArrayList<>();
            list.add(47369);
            list.add(1);
            rSPickInfo.setProjectSysNoList(list);
            rSPickInfo.setReceiptStatus(20);
            rSPickInfo.setCode("ll-47369-yd-201125161000044");
            rSPickInfo.setPickDeptName("金科玉律有限公司");
            rSPickInfo.setBuildingPartName("楼梯");
            rSPickInfo.setInUserName("李朗审批专sd");
        }

        return rSPickInfo;
    }
}
