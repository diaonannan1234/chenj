package com.chen;

import com.pig4cloud.plugin.excel.annotation.RequestExcel;
import com.pig4cloud.plugin.excel.annotation.ResponseExcel;
import com.pig4cloud.plugin.excel.annotation.Sheet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
public class ExcelWeb {

    @Autowired
    private FirstFactoryRepository firstFactoryRepository;

    @Autowired
    private PlatFormHourRepository platFormHourRepository;

    @Autowired FactoryResultRepository factoryResultRepository;

    @Autowired SumFactory sumFactory;

    @PostMapping("/first")
    public void first(@RequestExcel List<FirstFactoryExcel> dataList
            ,int year
            ,int month
            , BindingResult bindingResult) {
        // JSR 303 校验通用校验获取失败的数据
        //List<ErrorMessage> errorMessageList = (List<ErrorMessage>) bindingResult.getTarget();
        List<FirstFactory> factoryList = dataList.stream()
                .map(a -> a.conv(year,month))
                .collect(Collectors.toList());
        firstFactoryRepository.saveAll(factoryList);
    }

    @PostMapping("/sec")
    public void sec(@RequestExcel List<PlatformHourExcel> dataList
            ,int year
            ,int month
            ,BindingResult bindingResult) {
        // JSR 303 校验通用校验获取失败的数据
        //List<ErrorMessage> errorMessageList = (List<ErrorMessage>) bindingResult.getTarget();
        List<PlatformHour> factoryList = dataList.stream()
                .map(a -> a.conv(year,month))
                .collect(Collectors.toList());
       platFormHourRepository.saveAll(factoryList);
    }


    @GetMapping("/sum")
    public void sum(int year,int month){

        sumFactory.exportR(year,month);
    }

    @ResponseExcel(name = "test", sheets = @Sheet(sheetName = "testSheet1"))
    @GetMapping("/excel")
    public List<FactoryResult> excel(int year,int month) {

        //return factoryResultRepository.findAll();
        List<Object[]> fr = factoryResultRepository.findAllByGroup(year,month);
        List<FactoryResult> s =  fr.stream()
                  .map(ob -> new FactoryResult(ob))
                  .collect(Collectors.toList());
        return s;
    }

    @GetMapping("/delete")
    public void delete(){
        factoryResultRepository.deleteAll();
        platFormHourRepository.deleteAll();
        firstFactoryRepository.deleteAll();
    }

}
