package com.xawl.travel.dao;

import com.xawl.travel.pojo.UserTicket;

public interface UserTicketMapper {
    int deleteByPrimaryKey(String code);

    int insert(UserTicket record);

    int insertSelective(UserTicket record);

    UserTicket selectByPrimaryKey(String code);

    int updateByPrimaryKeySelective(UserTicket record);

    int updateByPrimaryKey(UserTicket record);
}