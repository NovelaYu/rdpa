package com.yzw.rdpa.entity;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class ReceiveReceipt {
    private List<Integer> ProjectSysNoList;
    private String DataDateBegin;
    private String DataDateEnd;
    private Integer PageSize;
    private  Integer PageIndex;
    private Integer Status;
    private String ReceiveReceiptCode;
    private String DeliveryReceiptCode;
    private String OrderCode;
    private String OrderName;
    private String ContractCode;
    private String ContractName;
    private String SupplierName;
    private int ReceiptMode;

    public static ReceiveReceipt getReceiveReceipt(Boolean online) {
        ReceiveReceipt receiveReceipt = new ReceiveReceipt();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        receiveReceipt.setDataDateBegin("2012-12-23 15:35:32");
        receiveReceipt.setDataDateEnd(sdf.format(date));
        receiveReceipt.setPageSize(10);
        receiveReceipt.setPageIndex(0);
        if (online) {
            List<Integer> list = new ArrayList<>();
            list.add(24661);
            list.add(1);
            receiveReceipt.setProjectSysNoList(list);
            receiveReceipt.setContractCode("cscec-ht-2018033000463");
            receiveReceipt.setContractName("prdtest-租赁多区域多清单-原合同-无签订日期");
            receiveReceipt.setDeliveryReceiptCode("cscec-fh-2020121803615");
            receiveReceipt.setOrderCode("cscec-dd-2020121801554");
            receiveReceipt.setOrderName("prdtest租赁测试收验货");
            receiveReceipt.setStatus(15);
            receiveReceipt.setSupplierName("prdtest--test003");
            receiveReceipt.setReceiptMode(1);
            receiveReceipt.setReceiveReceiptCode("sl-24661-yd-201218183900487");
        } else {
            List<Integer> list = new ArrayList<>();
            list.add(47369);
            list.add(1);
            receiveReceipt.setProjectSysNoList(list);
            receiveReceipt.setContractCode("cscec-ht-2020070700002");
            receiveReceipt.setContractName("向宇项目测试招标");
            receiveReceipt.setDeliveryReceiptCode("cscec-fh-2020112500012");
            receiveReceipt.setOrderCode("cscec-dd-2020091500004");
            receiveReceipt.setOrderName("向宇的测试计划");
            receiveReceipt.setStatus(15);
            receiveReceipt.setSupplierName("noah_002");
            receiveReceipt.setReceiptMode(0);
            receiveReceipt.setReceiveReceiptCode("sl-47369-0001-201218100000136");

        }

        return receiveReceipt;
    }
}
