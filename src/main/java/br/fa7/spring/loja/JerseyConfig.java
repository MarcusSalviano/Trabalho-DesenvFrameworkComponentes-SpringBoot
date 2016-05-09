package br.fa7.spring.loja;

import org.glassfish.jersey.server.ResourceConfig;
import org.springframework.context.annotation.Configuration;

import br.fa7.spring.loja.resources.ClienteResource;
import br.fa7.spring.loja.resources.EnderecoResource;

@Configuration
public class JerseyConfig extends ResourceConfig {

	public JerseyConfig() {
		register(ClienteResource.class);
		register(EnderecoResource.class);
	}
	
}
