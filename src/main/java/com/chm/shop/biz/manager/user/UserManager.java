package com.chm.shop.biz.manager.user;

import com.chm.shop.biz.manager.user.dataobject.UserDO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by chen-hongmin on 2017/4/27.
 */
@Repository
public interface UserManager extends CrudRepository<UserDO,Long>{

}
