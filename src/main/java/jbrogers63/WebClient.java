package jbrogers63;

import java.io.IOException;
import java.net.http.HttpClient;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Map;

public class WebClient {
	private final HttpClient client;

	public WebClient() {
		this.client = HttpClient.newHttpClient();
	}

	public HttpResponse<String> get(String url, Map<String, String> headers)
			throws IOException, InterruptedException {
		return sendWithBody(url, "", headers, "GET");
	}

	public HttpResponse<String> post(String url, String json, Map<String, String> headers)
			throws IOException, InterruptedException {
		return sendWithBody(url, json, headers, "POST");
	}

	public HttpResponse<String> patch(String url, String json, Map<String, String> headers)
			throws IOException, InterruptedException {
		return sendWithBody(url, json, headers, "PATCH");
	}

	public HttpResponse<String> put(String url, String json, Map<String, String> headers)
			throws IOException, InterruptedException {
		return sendWithBody(url, json, headers, "PUT");
	}

	public HttpResponse<String> delete(String url, Map<String, String> headers)
			throws IOException, InterruptedException {
		return sendWithBody(url, "", headers, "DELETE");
	}

	public HttpResponse<String> options(String url, Map<String, String> headers)
			throws IOException, InterruptedException {
		return sendWithBody(url, "", headers, "OPTIONS");
	}

	private HttpResponse<String> sendWithBody(String url, String body, Map<String, String> headers, String method)
			throws IOException, InterruptedException {
		HttpRequest.Builder builder = HttpRequest.newBuilder()
				.uri(URI.create(url));

		headers.forEach(builder::header);

		HttpRequest request = switch (method) {
			case "GET" -> builder.GET().build();
			case "DELETE" -> builder.DELETE().build();
			case "POST" -> builder.POST(BodyPublishers.ofString(body)).build();
			case "PUT" -> builder.PUT(BodyPublishers.ofString(body)).build();
			case "PATCH" -> builder.method("PATCH", BodyPublishers.ofString(body)).build();
			case "OPTIONS" -> builder.method("OPTIONS", BodyPublishers.ofString("")).build();
			default -> throw new IllegalArgumentException("Unsupported method: " + method);
		};
		return sendRequest(request);
	}

	private HttpResponse<String> sendRequest(HttpRequest request) throws IOException, InterruptedException {
		HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		return response;
	}

}
