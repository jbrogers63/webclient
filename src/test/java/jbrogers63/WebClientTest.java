package jbrogers63;

import java.util.Map;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import okhttp3.mockwebserver.Dispatcher;
import okhttp3.mockwebserver.MockResponse;
import okhttp3.mockwebserver.MockWebServer;
import okhttp3.mockwebserver.RecordedRequest;

public class WebClientTest {

	private MockWebServer server = new MockWebServer();

	@BeforeEach
	public void setup() throws Exception {
		Dispatcher dispatcher = new Dispatcher() {
			@Override
			public MockResponse dispatch(RecordedRequest request) throws InterruptedException {
				switch (request.getPath()) {
					case "/good":
						return getMockResponse("OK", 200, Map.of());
					default:
						return new MockResponse().setResponseCode(404);
				}
			}
		};
		server.setDispatcher(dispatcher);
		server.start();
	}

	@AfterEach
	public void shutdown() throws Exception {
		server.shutdown();
	}

	@Test
	public void testPlainTextGetRequests() throws Exception {
		String url = server.url("/good").toString();
		WebClient client = new WebClient();
		String result = client.get(url, Map.of());

		Assertions.assertEquals("OK", result, "The response body did not match.");
	}

	private MockResponse getMockResponse(String body, int responseCode, Map<String, String> headers) {
		MockResponse response = new MockResponse()
				.setBody(body)
				.setResponseCode(responseCode);
		headers.forEach(response::addHeader);
		return response;
	}
}
