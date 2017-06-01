package com.chm.shop.biz.manager.user;

import com.chm.shop.biz.manager.user.dataobject.UserDO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by yuwen on 2017/4/27.
 */
@Repository
public interface UserManager extends PagingAndSortingRepository<UserDO,Long>{

    UserDO findByLoginId(String loginId);
}
