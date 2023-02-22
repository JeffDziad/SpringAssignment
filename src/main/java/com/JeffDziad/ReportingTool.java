package com.JeffDziad;

import com.JeffDziad.classes.models.Sale;
import com.JeffDziad.interfaces.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ReportingTool {
    private ISalesReader reader;
    private IShippingPolicy policy;
    private IReportDisplayer reporter;

    @Autowired
    public ReportingTool(ISalesReader reader, IShippingPolicy policy, IReportDisplayer reporter) {
        this.reader = reader;
        this.policy = policy;
        this.reporter = reporter;

        generateReport();
    }

    public void generateReport() {
        List<Sale> sales = reader.getSales();
        for(Sale s: sales) {
            policy.applyShippingPolicy(s);
        }
        System.out.println("\n+-------------------------------+");
        System.out.println("| Generating Report...          |");
        System.out.println("+-------------------------------+\n");
        reporter.displaySalesReport(policy.getTitle(), sales);
    }

}
