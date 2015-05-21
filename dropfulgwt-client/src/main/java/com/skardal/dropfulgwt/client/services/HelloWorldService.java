package com.skardal.dropfulgwt.client.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import com.skardal.dropfulgwt.core.Saying;

public interface HelloWorldService extends RestService {
	@GET
	@Path("hello-world")
	void helloWorld(MethodCallback<Saying> callback);
}
