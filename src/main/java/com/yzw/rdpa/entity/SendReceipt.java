package com.yzw.rdpa.entity;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class SendReceipt {
    private List<Integer> ProjectSysNoList;
    private String DataDateBegin;
    private String DataDateEnd;
    private Integer PageSize;
    private  Integer PageIndex;
    private  Integer Status;
    private String ReceiptCode;
    private String SupplierName;
    private int ReceiptMode;

    public static SendReceipt getSendReceipt(boolean online) {
        SendReceipt sendReceipt = new SendReceipt();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        sendReceipt.setDataDateBegin("2012-12-23 15:35:32");
        Date date = new Date();
        sendReceipt.setDataDateEnd(sdf.format(date));
        sendReceipt.setPageSize(10);
        sendReceipt.setPageIndex(0);
        if (online) {
            List<Integer> list = new ArrayList<>();
            list.add(24661);
            list.add(1);
            sendReceipt.setProjectSysNoList(list);
            sendReceipt.setReceiptCode("fl-24661-CE54-201224090000028");
            sendReceipt.setStatus(15);
            sendReceipt.setSupplierName("天安");
            sendReceipt.setReceiptMode(0);
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(47369);
            list.add(1);
            sendReceipt.setProjectSysNoList(list);
            sendReceipt.setReceiptCode("fl-47369-0001-201209172500022");
            sendReceipt.setStatus(20);
            sendReceipt.setSupplierName("noah_002");
            sendReceipt.setReceiptMode(0);
        }


        return sendReceipt;
    }
}
