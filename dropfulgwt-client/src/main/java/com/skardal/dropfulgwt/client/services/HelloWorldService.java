package com.skardal.dropfulgwt.client.services;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

import org.fusesource.restygwt.client.MethodCallback;
import org.fusesource.restygwt.client.RestService;

import com.google.common.base.Optional;
import com.skardal.dropfulgwt.core.Saying;

public interface HelloWorldService extends RestService {
	@GET
	@Path("hello-world")
	void helloWorld(MethodCallback<Saying> callback);

	@GET
	@Path("hello-world")
	void helloWorld(@QueryParam("name") String name, MethodCallback<Saying> callback);
}
