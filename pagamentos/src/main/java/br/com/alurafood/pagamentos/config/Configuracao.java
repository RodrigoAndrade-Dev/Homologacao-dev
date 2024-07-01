package br.com.alurafood.pagamentos.config;

import br.com.alurafood.pagamentos.HTTP.PedidoClient;
import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class Configuracao {

        @Bean
        public ModelMapper obterModelMapper() {
            return new ModelMapper();
        }


}
