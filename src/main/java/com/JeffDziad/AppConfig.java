package com.JeffDziad;

import com.JeffDziad.classes.policies.FlatRateDomesticShippingPolicy;
import com.JeffDziad.classes.policies.FreeShippingOverXPolicy;
import com.JeffDziad.classes.policies.FreeShippingPolicy;
import com.JeffDziad.classes.readers.SalesCSVReader;
import com.JeffDziad.classes.reports.SalesReportByLocation;
import com.JeffDziad.classes.reports.SalesReportDetailed;
import com.JeffDziad.interfaces.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.JeffDziad")
public class AppConfig {

    @Bean
    public ISalesReader getSalesReader() {
        return new SalesCSVReader("src/main/java/com/JeffDziad/sales.txt");
    }

    @Bean
    public IShippingPolicy getShippingPolicy() {
        //return new FreeShippingPolicy();
        //return new FlatRateDomesticShippingPolicy(10, 15, "United States");
        return new FreeShippingOverXPolicy(100, 15);
    }

    @Bean
    public IReportDisplayer getReportGenerator() {
        //return new SalesReportByLocation();
        return new SalesReportDetailed();
    }

}
