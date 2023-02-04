package com.JeffDziad;

import com.JeffDziad.classes.CSVReader;
import com.JeffDziad.classes.FreeShippingPolicy;
import com.JeffDziad.interfaces.IDBReader;
import com.JeffDziad.interfaces.IShippingPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.JeffDziad.classes")
public class AppConfig {

    @Bean
    public IShippingPolicy getShippingPolicy() {
        return new FreeShippingPolicy();
    }

    @Bean
    public IDBReader getDBReader() {
        return new CSVReader("../data.txt", 4);
    }

}
