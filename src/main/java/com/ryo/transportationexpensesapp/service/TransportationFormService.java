package com.ryo.transportationexpensesapp.service;

import com.ryo.transportationexpensesapp.model.TransportationFormEntity;

import java.util.Date;
import java.util.List;

/**
 * serviceクラス
 */
public interface TransportationFormService {
    /**
     * 指定範囲のユーザの交通費申請を取得する
     *
     * @param userId 　ユーザID
     * @param start  　開始日付
     * @param end    　終了日付
     * @return 交通費申請
     */
    List<TransportationFormEntity> findAllByUserIdAndDepartureDateBetween(String userId, Date start, Date end);

    /**
     * 指定範囲の交通費申請を取得する
     *
     * @param start 開始日付
     * @param end   　終了日付
     * @return 交通費申請
     */
    List<TransportationFormEntity> findAll(Date start, Date end);

    /**
     * 指定されたIDの交通費申請を取得する
     *
     * @param id PK
     * @return 交通費申請
     */
    TransportationFormEntity find(Long id);

    /**
     * 交通費申請をDBに保存する
     *
     * @param formData 交通費申請
     */
    void save(List<TransportationFormEntity> formData);

    /**
     * 指定された交通費申請を削除する
     *
     * @param id PK
     */
    void deleteById(Long id);

}
