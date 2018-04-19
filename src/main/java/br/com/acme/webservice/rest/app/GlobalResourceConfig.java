package br.com.acme.webservice.rest.app;

import java.util.concurrent.TimeUnit;

import javax.ws.rs.ApplicationPath;

import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

import com.codahale.metrics.ConsoleReporter;
import com.codahale.metrics.MetricRegistry;
import com.codahale.metrics.jersey2.InstrumentedResourceMethodApplicationListener;

@ApplicationPath("/api/v1/*")
public class GlobalResourceConfig extends ResourceConfig{	
	    
	    public GlobalResourceConfig() {
	    	packages("br.com.acme.webservice.rest.resources","io.swagger.jaxrs.listing");	    	
	    	register(MultiPartFeature.class); //Multipart Provider
	    	register(GsonMessageBodyHandler.class); //Gson Provider
	    	register(CORSFilter.class);
	    	registerMetricsDropwizard();
	    }
	    
	    protected void registerMetricsDropwizard() {
	        final MetricRegistry metricRegistry = new MetricRegistry();
	        register(new InstrumentedResourceMethodApplicationListener(metricRegistry));
	        ConsoleReporter.forRegistry(metricRegistry).convertRatesTo(TimeUnit.SECONDS).convertDurationsTo(TimeUnit.MILLISECONDS).build().start(1, TimeUnit.MINUTES);
	    }
	
}
