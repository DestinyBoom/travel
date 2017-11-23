package com.xawl.travel.service;

import com.xawl.travel.dao.TicketMapper;
import com.xawl.travel.pojo.Ticket;
import com.xawl.travel.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/11/22.
 */

@Service
public class TicketService {

    @Autowired
    private TicketMapper ticketMapper;

    public Result findTicketByBid(String bid) {
        if (bid == null || bid == "") {
            return Result.fail(300, "请给出对应商家ID");
        }
        try {
            List<Ticket> ticketImgList = ticketMapper.selectTicketByBid(bid);
            return Result.success(ticketImgList);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("查询失败");
        }
    }

    public Result addTicketByBid(Ticket ticket) {
        try {
            ticketMapper.insertSelective(ticket);
        } catch (Exception e) {
            e.printStackTrace();
            return Result.fail("添加失败");
        }
        return Result.success("添加成功");
    }

    public int deleteTicketByTid(String tid) {

        return ticketMapper.deleteByPrimaryKey(tid);
    }

    public int updateTicketByTid(Ticket ticket) {

        return ticketMapper.updateByPrimaryKeySelective(ticket);
    }
}
