package com.JeffDziad;

import com.JeffDziad.interfaces.IDBReader;
import com.JeffDziad.interfaces.IInput;
import com.JeffDziad.interfaces.IOutput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderReporter {
    private IInput input;
    private IOutput output;
    private IDBReader data;

    @Autowired
    public OrderReporter(IInput input, IOutput output, IDBReader data) {
        this.input = input;
        this.output = output;
        this.data = data;

        output.out("Startup!", "Successfully loaded...");
    }
}
