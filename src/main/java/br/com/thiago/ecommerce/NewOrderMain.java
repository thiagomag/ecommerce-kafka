package br.com.thiago.ecommerce;

import java.util.UUID;
import java.util.concurrent.ExecutionException;

public class NewOrderMain {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        try (var dispatcher = new KafkaDispatcher()) {
            var key = UUID.randomUUID().toString();
            var value = key + ",123,123";
            dispatcher.send("ECOMMERCE_NEW_ORDER", key, value);

            var email = "Welcome! We are processing you order";
            dispatcher.send("ECOMMERCE_SEND_EMAIL", key, email);
        }
    }


}
