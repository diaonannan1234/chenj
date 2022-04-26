package com.chen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class SumFactory {
   @Autowired private FirstFactoryRepository firstFactoryRepository;
   @Autowired private PlatFormHourRepository platFormHourRepository;
   @Autowired private FactoryResultRepository factoryResultRepository;
   private Map<String,PlatformHour> platMap;

   public void exportR(int year,int month){

       List<FirstFactory> firstFactoryList = firstFactoryRepository.findAll(year,month);
       if(platMap == null ){
         this.loadPlat();
       }
        List<FactoryResult> rs = new ArrayList();
        firstFactoryList.forEach(f -> {
            rs.add(conv(f));
        });
        factoryResultRepository.saveAll(rs);
   }

    FactoryResult conv(FirstFactory f){
        FactoryResult r = new FactoryResult(f);
        PlatformHour h = platMap.get(f.getDevice());

        r.sum(h);
        return r;
    }




    private void loadPlat(){
       List<PlatformHour> hours = platFormHourRepository.findAll();
       platMap = new HashMap<>(hours.size());
       for (PlatformHour h : hours){
           platMap.put(h.getDevice(),h);
       }
   }

}
