package com.chm.shop.biz.manager.order.dataobject;

import javax.persistence.*;

/**
 * Created by chen-hongmin on 2017/5/25.
 */
@Entity
@Table(name = "t_order_info",schema = "订单详情表")
public class OrderDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String uuid;

    private String productId;

    private String num;

    private String price;

    private String total;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getUuid() {

        return uuid;
    }

    public void setUuid(String uuid) {

        this.uuid = uuid;
    }

    public String getProductId() {

        return productId;
    }

    public void setProductId(String productId) {

        this.productId = productId;
    }

    public String getNum() {

        return num;
    }

    public void setNum(String num) {

        this.num = num;
    }

    public String getPrice() {

        return price;
    }

    public void setPrice(String price) {

        this.price = price;
    }

    public String getTotal() {

        return total;
    }

    public void setTotal(String total) {

        this.total = total;
    }
}
