package pluralsight.demo;

import java.util.Hashtable;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.sleuth.Span;
import org.springframework.cloud.sleuth.Tracer;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class PluralsightSpringcloudM5Dataservice2Application {

	public static void main(String[] args) {
		SpringApplication.run(PluralsightSpringcloudM5Dataservice2Application.class, args);
	}

	@Autowired
	private Tracer tracer;
	
	@RequestMapping(value="/customer/{cid}/vehicledetails", method=RequestMethod.GET)
	public @ResponseBody String getCustomerVehicleDetails(@PathVariable Integer cid) throws InterruptedException {

		String result;

		Span span = this.tracer.createSpan("lookup_vehicle");
		try {

			this.tracer.addTag("customer id", cid.toString());

			span.logEvent("Database query started");
			Thread.sleep(500);

			Hashtable<Integer, String> vehicles = new Hashtable<Integer, String>();
			vehicles.put(100, "Lincoln Continental; Plate SNUG30");
			vehicles.put(101, "Chevrolet Camaro; Plate R7TYR43");
			vehicles.put(102, "Volkswagen Beetle; Plate 6CVI3E2");

			result = vehicles.get(cid);

			span.logEvent("Database query completed");
		}
		finally {
			this.tracer.close(span);
		}
		return result;
	}
}
