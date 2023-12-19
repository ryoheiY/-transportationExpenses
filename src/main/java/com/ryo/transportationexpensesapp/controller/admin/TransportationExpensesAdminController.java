package com.ryo.transportationexpensesapp.controller.admin;

import com.ryo.transportationexpensesapp.model.TransportationFormEntity;
import com.ryo.transportationexpensesapp.service.TransportationFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController(value = "/admin")
public class TransportationExpensesAdminController {
    TransportationFormService transportationFormService;

    @Autowired
    public TransportationExpensesAdminController(TransportationFormService transportationFormService) {
        this.transportationFormService = transportationFormService;
    }

}
