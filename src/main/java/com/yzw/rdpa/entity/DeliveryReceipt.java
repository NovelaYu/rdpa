package com.yzw.rdpa.entity;

import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
public class DeliveryReceipt {
    private List<Integer> ProjectSysNoList;
    private String DataDateBegin;
    private String DataDateEnd;
    private Integer PageSize;
    private  Integer PageIndex;
    private Integer Status;
    private Integer Source;
    private String SuplierName;
    private String DeliveryReceiptCode;
    private String ContractCode;
    private String ContractName;
    private String OrderCode;
    private String OrderName;


    public static DeliveryReceipt getDeliveryReceipt(Boolean online) {
        DeliveryReceipt deliveryReceipt = new DeliveryReceipt();
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        deliveryReceipt.setDataDateBegin("2012-12-23 15:35:32");
        deliveryReceipt.setDataDateEnd(sdf.format(date));
        deliveryReceipt.setPageSize(10);
        deliveryReceipt.setPageIndex(0);
        if (online) {
            List<Integer> list = new ArrayList<>();
            list.add(24661);
            list.add(1);
            deliveryReceipt.setProjectSysNoList(list);
            deliveryReceipt.setContractCode("cscec-ht-2018062800893");
            deliveryReceipt.setContractName("prdtest:偏态单商品");
            deliveryReceipt.setDeliveryReceiptCode("cscec-fh-2018082300550");
            deliveryReceipt.setOrderCode("cscec-dd-2018062802762");
            deliveryReceipt.setOrderName("prdtest-订单");
            deliveryReceipt.setSuplierName("sup100");
            deliveryReceipt.setSource(3);
            deliveryReceipt.setStatus(2);
        }else {
            List<Integer> list = new ArrayList<>();
            list.add(47369);
            list.add(1);
            deliveryReceipt.setProjectSysNoList(list);
            deliveryReceipt.setContractCode("cscec-ht-2020070700002");
            deliveryReceipt.setContractName("向宇项目测试招标");
            deliveryReceipt.setDeliveryReceiptCode("cscec-fh-2020070700007");
            deliveryReceipt.setOrderCode("cscec-dd-2020070700001");
            deliveryReceipt.setOrderName("向宇测试项目");
            deliveryReceipt.setSuplierName("noah_002");
            deliveryReceipt.setSource(3);
            deliveryReceipt.setStatus(2);
        }


        return deliveryReceipt;
    }


}
