package com.ryo.transportationexpensesapp.controller;

import com.ryo.transportationexpensesapp.model.TransportationFormEntity;
import com.ryo.transportationexpensesapp.service.TransportationFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class TransportationExpensesController {
    TransportationFormService transportationFormService;

    @Autowired
    public TransportationExpensesController(TransportationFormService transportationFormService) {
        this.transportationFormService = transportationFormService;
    }

    /**
     * 出発地、目的地、日付を外部APIに投げ、取得したJSONを返却する
     *
     * @return 費用
     */
    @GetMapping("/transportation/expense")
    public ResponseEntity<?> returnExpense() {
        return null;
    }

    /**
     * DBに交通費申請を保存する
     *
     * @param expense 交通費申請
     * @return ステータス
     */
    @PostMapping("/transportation/expense")
    public ResponseEntity<Map> saveExpense(
            @RequestBody TransportationFormEntity expense) {
        Map<String, Object> map = new HashMap<>();
        map.put("key1", "error1");
        map.put("key12", "error1");
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (expense != null) {
            //return new ResponseEntity<>(expense, HttpStatus.NO_CONTENT);
        }
        List<TransportationFormEntity> list = new ArrayList<>();
//        list.add(expense);
//        transportationFormService.save(list);
        return new ResponseEntity<>(map, HttpStatus.OK);
    }
//    @CrossOrigin(origins = "http://localhost:3000")
//    @PostMapping("/transportation/expense")
//    public ResponseEntity<Map<String, Object>> saveExpense(
//            @RequestParam(name = "expense") TransportationFormEntity expense) {
//        Map<String, Object> map = null;
//        if (expense != null) {
//            return new ResponseEntity<Map<String, Object>>(map, HttpStatus.NO_CONTENT);
//        }
//        List<TransportationFormEntity> list = new ArrayList<>();
//        list.add(expense);
//        transportationFormService.save(list);
//        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
//    }

    /**
     * 指定IDの交通費申請を削除する
     *
     * @param id id
     * @return ステータス
     */
    @DeleteMapping("/transportation/expense/{id}")
    public ResponseEntity<Map<String, Object>> deleteExpense(
            @PathVariable(name = "id") Long id
    ) {
        Map<String, Object> map = null;
        transportationFormService.deleteById(id);
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }

    /**
     * 指定範囲のユーザの交通費申請を取得する
     *
     * @return 交通費申請
     */
    @GetMapping("/transportation/expenses")
    public ResponseEntity<Map<String, Object>> getExpenseForYear(
            @RequestParam(name = "data") Map<String, Object> data
    ) {
        Map<String, Object> map = new HashMap<>();
        String userId = (String) data.get("user-id");
        Date start = (Date) data.get("start-date");
        Date end = (Date) data.get("end-date");
        List<TransportationFormEntity> list = transportationFormService.findAllByUserIdAndDepartureDateBetween(userId, start, end);
        map.put("data", list);
        return new ResponseEntity<Map<String, Object>>(map, HttpStatus.OK);
    }

}
