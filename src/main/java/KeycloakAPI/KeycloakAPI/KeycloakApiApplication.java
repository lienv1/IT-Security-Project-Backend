package KeycloakAPI.KeycloakAPI;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

@SpringBootApplication
public class KeycloakApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(KeycloakApiApplication.class, args);
	}
	
	   @Bean
	    public CorsFilter corsFilter() {
	    	String localIP = "https://192.168.1.129";
			CorsConfiguration corsConfiguration = new CorsConfiguration();
			corsConfiguration.setAllowCredentials(true);
			//corsConfiguration.setAllowedOrigins(Arrays.asList("http://10.2.109.120:4200"));
			corsConfiguration.setAllowedOrigins(Arrays.asList(localIP, localIP+":4200","https://localhost:4200"));
			//corsConfiguration.setAllowedOriginPatterns(Arrays.asList("https://10.2.109.120"));
			corsConfiguration.setAllowedHeaders(Arrays.asList("Origin", "Access-Control-Allow-Origin", "Content-Type",
					"Accept", "Authorization", "Origin, Accept", "X-Requested-With",
					"Access-Control-Request-Method", "Access-Control-Request-Headers"));
			corsConfiguration.setExposedHeaders(Arrays.asList("Origin", "Content-Type", "Accept", "Authorization",
					"Access-Control-Allow-Origin", "Access-Control-Allow-Origin", "Access-Control-Allow-Credentials"));
			corsConfiguration.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS"));
			UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
			urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
			return new CorsFilter(urlBasedCorsConfigurationSource);
		}

}
