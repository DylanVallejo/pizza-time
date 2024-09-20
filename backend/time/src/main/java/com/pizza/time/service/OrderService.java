package com.pizza.time.service;

import com.pizza.time.entity.Orders;
import com.pizza.time.exceptions.GeneralException;

public interface OrderService {

    Orders generateOrder(Orders order) throws GeneralException;

}
