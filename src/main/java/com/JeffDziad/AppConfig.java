package com.JeffDziad;

import com.JeffDziad.classes.io.GUIInput;
import com.JeffDziad.classes.io.GUIOutput;
import com.JeffDziad.classes.readers.CSVReader;
import com.JeffDziad.classes.policies.FreeShippingPolicy;
import com.JeffDziad.interfaces.IDBReader;
import com.JeffDziad.interfaces.IInput;
import com.JeffDziad.interfaces.IOutput;
import com.JeffDziad.interfaces.IShippingPolicy;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.JeffDziad.classes")
public class AppConfig {

//    @Bean
//    public IShippingPolicy getShippingPolicy() {
//        return new FreeShippingPolicy();
//    }
//
    @Bean
    public IDBReader getDBReader() {
        return new CSVReader("../data.txt", 4);
    }

    @Bean
    public IInput getIInput() {
        return new GUIInput();
    }

    @Bean
    public IOutput getIOutput() {
        return new GUIOutput();
    }


}
