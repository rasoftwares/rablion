package com.ra.test.util;


import java.net.URI;

import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.HttpContext;
import org.springframework.http.HttpMethod;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

public class StatefullHttpComponentsClientHttpRequestFactory extends HttpComponentsClientHttpRequestFactory
{
private final HttpContext httpContext;

public StatefullHttpComponentsClientHttpRequestFactory(DefaultHttpClient httpClient, HttpContext httpContext)
{
	super();
	this.httpContext = httpContext;
}

@Override
protected HttpContext createHttpContext(HttpMethod httpMethod, URI uri)
{
return this.httpContext;
}
}
