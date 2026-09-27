package pe.edu.cibertec.appgrupo7consumidor.rabbitmq;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import pe.edu.cibertec.appgrupo7consumidor.Service.FibonacciService;
import pe.edu.cibertec.appgrupo7consumidor.config.RabbitMqConfig;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Component
@RequiredArgsConstructor
@Slf4j
public class FibonacciConsumidor {
    private final FibonacciService fibonacciService;

    @RabbitListener(queues = RabbitMqConfig.QUEUE)

    public void recibirNumeros(String cadenaNumeros) throws InterruptedException{
        Integer[] integerArray = Stream.of(cadenaNumeros.split(";"))
                .map(String::trim)
                .map(Integer::parseInt)
                .toArray(Integer[]::new);


        List<Long> resultado = fibonacciService.calculateSequence(Arrays.asList(integerArray));

        Thread.sleep(20000);

        System.out.println("Fibonacci: " + resultado);


    }
}
