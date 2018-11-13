package pluralsightspringcloudm5zipkinserver.pluralsightspringcloudm5zipkinserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class PluralsightSpringcloudM5ZipkinserverApplication {

    public static void main(String[] args) {
        SpringApplication.run(PluralsightSpringcloudM5ZipkinserverApplication.class, args);
    }
}
