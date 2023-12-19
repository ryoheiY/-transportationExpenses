package com.ryo.transportationexpensesapp.service;

import com.github.springtestdbunit.DbUnitTestExecutionListener;
import com.github.springtestdbunit.annotation.DatabaseSetup;
import com.github.springtestdbunit.annotation.DbUnitConfiguration;
import com.github.springtestdbunit.annotation.ExpectedDatabase;
import com.github.springtestdbunit.assertion.DatabaseAssertionMode;
import com.ryo.transportationexpensesapp.dataset.CsvDataSetLoader;
import com.ryo.transportationexpensesapp.model.TransportationFormEntity;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestExecutionListeners;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.support.DependencyInjectionTestExecutionListener;
import org.springframework.test.context.support.DirtiesContextTestExecutionListener;
import org.springframework.test.context.transaction.TransactionalTestExecutionListener;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@TestPropertySource(locations = "classpath:test.properties")
@SpringBootTest
@DbUnitConfiguration(dataSetLoader = CsvDataSetLoader.class)//CsvDataSetLoaderを利用する
@TestExecutionListeners({
        DependencyInjectionTestExecutionListener.class,
        DirtiesContextTestExecutionListener.class,
        TransactionalTestExecutionListener.class,
        DbUnitTestExecutionListener.class
})

public class TransportationFromServiceTest {

    private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    private final TransportationFormServiceImpl transportationFormService;
    Logger logger = LoggerFactory.getLogger(TransportationFromServiceTest.class);

    @Autowired
    public TransportationFromServiceTest(TransportationFormServiceImpl transportationFormService) {
        this.transportationFormService = transportationFormService;
    }

    @BeforeAll
    public static void setUp() {
        //
    }

    /**
     * findメソッドのテスト
     */
    @DisplayName("find method test")
    @Test
    @DatabaseSetup("/test-data/TransportationFormServiceTest/init/")
    @ExpectedDatabase(value = "/test-data/TransportationFormServiceTest/init/", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void testFind() throws ParseException {
        //シーケンスがうまく制御できないため、初期データを干渉しない位置に配置
        TransportationFormEntity entity = transportationFormService.find(50L);
        assertEquals("yamashita", entity.getUserId());
        assertEquals("山下", entity.getUserName());
        assertEquals("新宿", entity.getOrigin());
        assertEquals("目黒", entity.getDestination());
        assertFalse(entity.isOneWay());
        assertEquals(430, entity.getExpense());
        String inpDateStr1 = "2023-12-08 00:00:00";
        String inpDateStr2 = "2023-12-09 00:03:00";
        Date dateTime = format.parse(inpDateStr1);
        assertEquals(dateTime, entity.getDepartureDate());
        Date dateTime2 = format.parse(inpDateStr2);
        assertEquals(dateTime2, entity.getCreatedAt());
    }

    /**
     * saveメソッドのテスト
     */
    @DisplayName("save method test")
    @Test
    @DatabaseSetup("/test-data/TransportationFormServiceTest/init/")
    @ExpectedDatabase(value = "/test-data/TransportationFormServiceTest/after-save/", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void testSave() throws ParseException {
        List<TransportationFormEntity> list = new ArrayList<>();
        //データ1
        TransportationFormEntity entity = new TransportationFormEntity();
        entity.setUserId("yamashita");
        entity.setUserName("山下");
        entity.setOrigin("原宿");
        entity.setDestination("横浜");
        entity.setExpense(200);
        entity.setOneWay(true);
        String inpDateStr1 = "2023-12-11 00:00:00";
        String inpDateStr2 = "2023-12-13 00:03:00";
        entity.setDepartureDate(format.parse(inpDateStr1));
        entity.setCreatedAt(format.parse(inpDateStr2));
        entity.setDepartureSubNo(1);
        list.add(entity);
        //データ2
        TransportationFormEntity entity2 = new TransportationFormEntity();
        entity2.setUserId("yamashita");
        entity2.setUserName("山下");
        entity2.setOrigin("原宿");
        entity2.setDestination("新横浜");
        entity2.setExpense(230);
        entity2.setOneWay(false);
        inpDateStr1 = "2023-12-11 00:00:00";
        inpDateStr2 = "2023-12-13 00:03:10";
        entity2.setDepartureDate(format.parse(inpDateStr1));
        entity2.setCreatedAt(format.parse(inpDateStr2));
        entity2.setDepartureSubNo(2);
        list.add(entity2);
        transportationFormService.save(list);

        List<TransportationFormEntity> entities = transportationFormService.findTop10ByUserId("yamashita");
        assertEquals(4, entities.size());
    }

    /**
     * deleteメソッドのテスト
     */
    @DisplayName("delete method test")
    @Test
    @DatabaseSetup("/test-data/TransportationFormServiceTest/init/")
    @ExpectedDatabase(value = "/test-data/TransportationFormServiceTest/after-delete/", assertionMode = DatabaseAssertionMode.NON_STRICT_UNORDERED)
    public void testDelete() {
        transportationFormService.deleteById(50L);
    }
}
