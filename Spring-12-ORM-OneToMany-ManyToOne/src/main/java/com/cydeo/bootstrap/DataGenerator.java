package com.cydeo.bootstrap;

import com.cydeo.repository.PaymentRepository;
import org.springframework.boot.CommandLineRunner;

public class DataGenerator implements CommandLineRunner {
    private final PaymentRepository paymentRepository;

    public DataGenerator(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }

    @Override
    public void run(String... args) throws Exception {

    }
}
