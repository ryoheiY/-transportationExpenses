package com.ryo.transportationexpensesapp.service;

import com.ryo.transportationexpensesapp.model.TransportationFormEntity;
import com.ryo.transportationexpensesapp.repository.TransportationFormEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * serviceの実装クラス
 */
@Service
public class TransportationFormServiceImpl implements TransportationFormService {
    /**
     * repository
     */
    TransportationFormEntityRepository repository;

    /**
     * コンストラクタ
     *
     * @param repository リポジトリ
     */
    @Autowired
    public TransportationFormServiceImpl(
            TransportationFormEntityRepository repository) {
        this.repository = repository;
    }

    /**
     * 指定範囲のユーザの交通費申請を取得する
     *
     * @param userId 　ユーザID
     * @param start  開始日付
     * @param end    　終了日付
     * @return 交通費申請
     */
    @Override
    public List<TransportationFormEntity> findAllByUserIdAndDepartureDateBetween(String userId, Date start, Date end) {
        return repository.findByDepartureDateBetweenAndUserId(start, end, userId);
    }

    /**
     * 指定範囲の交通費申請を取得する
     *
     * @param start 開始日付
     * @param end   　終了日付
     * @return 交通費申請
     */
    @Override
    public List<TransportationFormEntity> findAll(Date start, Date end) {
        return repository.findByDepartureDateBetween(start, end);
    }

    /**
     * 指定されたIDの交通費申請を取得する
     *
     * @param id PK
     * @return 交通費申請
     */
    @Override
    public TransportationFormEntity find(Long id) {
        Optional<TransportationFormEntity> data = repository.findById(id);
        return data.orElseThrow();
    }

    /**
     * 交通費申請をDBに保存する
     *
     * @param formData 交通費申請
     */
    @Override
    @Transactional
    public void save(List<TransportationFormEntity> formData) {
        repository.saveAll(formData);
    }

    /**
     * 指定された交通費申請を削除する
     *
     * @param id PK
     */
    @Override
    @Transactional
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
