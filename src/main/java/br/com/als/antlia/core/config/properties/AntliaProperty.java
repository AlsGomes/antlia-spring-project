package br.com.als.antlia.core.config.properties;

import javax.validation.constraints.NotNull;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import lombok.Getter;
import lombok.Setter;

@Validated
@ConfigurationProperties("antlia")
@Component
@Getter
@Setter
public class AntliaProperty {
	
	@NotNull
	private String allowedOrigin;

}
