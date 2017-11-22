package com.xawl.travel.service;

import com.xawl.travel.dao.TicketMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/11/22.
 */

@Service
public class TicketService {

    @Autowired
    private TicketMapper ticketMapper;

}
