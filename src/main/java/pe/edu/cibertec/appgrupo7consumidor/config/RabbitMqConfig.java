package pe.edu.cibertec.appgrupo7consumidor.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqConfig {


    public static final String QUEUE = "Grupo7Queue";
    public static final String EXCHANGE = "Grupo7Exchange";
    public static final String ROUTING_KEY = "Grupo7Routing";

    @Bean
    public DirectExchange grupo7Exchange(){
        return new DirectExchange(EXCHANGE);
    }

    @Bean
    public Queue grupo7Queue(){
        return new Queue(QUEUE, true);
    }

    @Bean
    public Binding grupo7Binding(){
        return BindingBuilder.bind(grupo7Queue())
                .to(grupo7Exchange())
                .with(ROUTING_KEY);

    }
}
