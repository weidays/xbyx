package com.web.back.dao;

import java.util.List;

public interface UserDaO {
    
    
    //根据STAFF_CODE查询STAFF
    List getUserbyUserId(String userId);
}