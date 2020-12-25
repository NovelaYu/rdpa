package com.yzw.rdpa.entity;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class TransferReceipt {
    private List<Integer> ProjectSysNoList;
    private String DataDateBegin;
    private String DataDateEnd;
    private Integer PageSize;
    private Integer PageIndex;
    private String FromProjectName;
    private String ToProjectName;
    private String Code;
    private Integer ReceiptStatus;

    public static TransferReceipt getTransferReceipt(boolean online) {
        TransferReceipt transferReceipt = new TransferReceipt();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        transferReceipt.setDataDateBegin("2012-12-23 15:35:32");
        transferReceipt.setDataDateEnd(sdf.format(date));
        transferReceipt.setPageSize(10);
        transferReceipt.setPageIndex(0);
        if (online) {
            List<Integer> list = new ArrayList<>();
            list.add(24661);
            list.add(1);
            transferReceipt.setProjectSysNoList(list);
            transferReceipt.setReceiptStatus(15);
            transferReceipt.setCode("db-24661-yd-201204180000099");
            transferReceipt.setFromProjectName("运营测试项目");
            transferReceipt.setToProjectName("prdtest-一级项目2");
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(47369);
            list.add(1);
            transferReceipt.setProjectSysNoList(list);
            transferReceipt.setReceiptStatus(15);
            transferReceipt.setCode("db-47369-yd-201215171100023");
            transferReceipt.setFromProjectName("向宇的测试项目");
            transferReceipt.setToProjectName("Amy王收验货测试项目");
        }


        return transferReceipt;
    }
}
