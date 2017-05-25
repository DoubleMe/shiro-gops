package com.chm.shop.biz.manager.product;

import com.chm.shop.biz.manager.product.dataobject.ProductDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by chen-hongmin on 2017/4/30.
 */
public interface ProductManager extends PagingAndSortingRepository<ProductDO,Long> {


    @Query(value = "select id,imageUrl,kc,cd,name,price,productDesc from t_product_info where name like %:name% limit :start,:limitNum",nativeQuery=true)
    List<ProductDO> query(@Param("name")String name,@Param("start")int start,@Param("limitNum")int size);
}
