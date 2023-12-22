package com.ryo.transportationexpensesapp.controller.admin;

import com.ryo.transportationexpensesapp.service.TransportationFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/admin")
public class TransportationExpensesAdminController {
    TransportationFormService transportationFormService;

    @Autowired
    public TransportationExpensesAdminController(TransportationFormService transportationFormService) {
        this.transportationFormService = transportationFormService;
    }

}
