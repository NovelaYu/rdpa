package com.yzw.rdpa.entity;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class ReturnStockReceipt {
    private List<Integer> ProjectSysNoList;
    private String DataDateBegin;
    private String DataDateEnd;
    private Integer PageSize;
    private  Integer PageIndex;
    private  String ProjectName;
    private  String Code;
    private  Integer ReceiptStatus;

    public static ReturnStockReceipt getReturnStockReceipt(boolean online) {
        ReturnStockReceipt returnStockReceipt = new ReturnStockReceipt();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        returnStockReceipt.setDataDateBegin("2012-12-23 15:35:32");
        returnStockReceipt.setDataDateEnd(sdf.format(date));
        returnStockReceipt.setPageSize(10);
        returnStockReceipt.setPageIndex(0);
        if (online) {
            List<Integer> list = new ArrayList<>();
            list.add(24661);
            list.add(1);
            returnStockReceipt.setProjectSysNoList(list);
            returnStockReceipt.setReceiptStatus(15);
            returnStockReceipt.setCode("tk-24661-yd-201204175800108");
            returnStockReceipt.setProjectName("运营测试项目");
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(47369);
            list.add(1);
            returnStockReceipt.setProjectSysNoList(list);
            returnStockReceipt.setReceiptStatus(15);
            returnStockReceipt.setCode("tk-47369-yd-201125161800022");
            returnStockReceipt.setProjectName("向宇的测试项目");
        }

        return returnStockReceipt;
    }
}
