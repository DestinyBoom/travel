package com.xawl.travel.controller;

import com.xawl.travel.pojo.Ticket;
import com.xawl.travel.service.TicketService;
import com.xawl.travel.utils.CreateId;
import com.xawl.travel.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Administrator on 2017/11/22.
 */

@Controller
@RequestMapping("/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @ResponseBody
    @RequestMapping("/findTicketByBid.action")
    public Result findTicketByBid(@RequestParam("bid")String bid)throws Exception{

        Result result = ticketService.findTicketByBid(bid);
        return  result;
    }

    @ResponseBody
    @RequestMapping("/addTicketByBid.action")
    public Result addTicketByBid(Ticket ticket)throws Exception{

        String tid = CreateId.gitId();
        ticket.setTid(tid);
        ticket.setBid(ticket.getBid());
        ticket.setPrice(ticket.getPrice());
        ticket.setTname(ticket.getTname());
        ticket.setInfo(ticket.getInfo());
        Result result = ticketService.addTicketByBid(ticket);
        return  result;
    }

    @ResponseBody
    @RequestMapping("/deleteTicketByTid.action")
    public Result deleteTicketByTid(@RequestParam("tid")String tid){

        int del = ticketService.deleteTicketByTid(tid);
        if(del == 0){
            return Result.fail("删除失败");
        }else{
            return Result.success("删除成功");
        }
    }

    @ResponseBody
    @RequestMapping("/updateTicketByTid.action")
    public Result updateTicketByTid(Ticket ticket){

        ticket.setTid(ticket.getTid());
        ticket.setBid(ticket.getBid());
        ticket.setPrice(ticket.getPrice());
        ticket.setTname(ticket.getTname());
        ticket.setInfo(ticket.getInfo());
        int update = ticketService.updateTicketByTid(ticket);
        if(update == 0){
            return Result.fail("修改失败");
        }else{
            return Result.success("修改成功");
        }
    }

}
