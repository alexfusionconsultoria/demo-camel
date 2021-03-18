package br.com.fusionconsultoria.gs.democamel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.rest.RestBindingMode;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;

@Component
public class CamelRouter extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        rest("/api/").description("Teste REST Service")
                .id("api-route")
                .post("/bean")
                .produces(String.valueOf(MediaType.APPLICATION_JSON))
                .consumes(String.valueOf(MediaType.APPLICATION_JSON))
//                .get("/hello/{place}")
                .bindingMode(RestBindingMode.auto)
                .type(MyBean.class)
                .enableCORS(true)
//                .outType(OutBean.class)

                .to("direct:remoteService");

        rest("/say")
                .get("/hello").to("direct:hello")
//                .get("/bye").consumes("application/json").to("direct:bye")
//                .post("/bye").to("mock:update")
        ;


        from("direct:hello")
                .process(
                        new Processor() {
                            public void process(Exchange exchange) throws Exception {
                                System.out.println("Teste");
                            }
                        }
                )
                .transform().constant("Hello World");


    }
}
