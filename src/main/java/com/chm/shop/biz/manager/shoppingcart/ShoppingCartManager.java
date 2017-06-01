package com.chm.shop.biz.manager.shoppingcart;

import com.chm.shop.biz.manager.shoppingcart.dataobject.ShoppingCartDO;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by yuwen on 2017/5/25.
 */
public interface ShoppingCartManager extends PagingAndSortingRepository<ShoppingCartDO,Long> {


}
