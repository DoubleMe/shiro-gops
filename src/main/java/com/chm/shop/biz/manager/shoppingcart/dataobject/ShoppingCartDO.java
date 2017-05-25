package com.chm.shop.biz.manager.shoppingcart.dataobject;

import javax.persistence.*;

/**
 * Created by chen-hongmin on 2017/5/25.
 */
@Entity
@Table(name = "t_shopping_cart",schema = "购物车")
public class ShoppingCartDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private long productId;

    private Long userId;


    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public long getProductId() {

        return productId;
    }

    public void setProductId(long productId) {

        this.productId = productId;
    }

    public Long getUserId() {

        return userId;
    }

    public void setUserId(Long userId) {

        this.userId = userId;
    }
}
