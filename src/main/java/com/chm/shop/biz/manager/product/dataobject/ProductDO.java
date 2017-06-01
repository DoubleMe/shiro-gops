package com.chm.shop.biz.manager.product.dataobject;

import javax.persistence.*;

/**
 * Created by yuwen on 2017/4/30.
 */
@Entity
@Table(name = "t_product_info",schema = "商品信息表")
public class ProductDO {

    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String imageUrl;

    private String name;

    private String productDesc;

    private String cd;

    private int kc;

    private float price;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getProductDesc() {

        return productDesc;
    }

    public void setProductDesc(String productDesc) {

        this.productDesc = productDesc;
    }

    public float getPrice() {

        return price;
    }

    public void setPrice(float price) {

        this.price = price;
    }

    public String getImageUrl() {

        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {

        this.imageUrl = imageUrl;
    }

    public String getCd() {

        return cd;
    }

    public void setCd(String cd) {

        this.cd = cd;
    }

    public int getKc() {

        return kc;
    }

    public void setKc(int kc) {

        this.kc = kc;
    }
}
