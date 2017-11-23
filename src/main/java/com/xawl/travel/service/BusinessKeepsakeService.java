package com.xawl.travel.service;

import com.xawl.travel.dao.BusinessKeepsakeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/11/22.
 */

@Service
public class BusinessKeepsakeService {

    @Autowired
    private BusinessKeepsakeMapper businessKeepsakeMapper;

}
