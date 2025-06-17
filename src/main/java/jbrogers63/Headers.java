package jbrogers63;

public class Headers {

	// Header types commonly encountered
	public static final String ACCEPT = "Accept";
	public static final String ACCEPT_ENCODING = "Accept-Encoding";
	public static final String AUTHORIZATION = "Authorization";
	public static final String CACHE_CONTROL = "Cache-Control";
	public static final String CONNECTION = "Connection";
	public static final String CONTENT_TYPE = "Content-Type";
	public static final String CORRELATION_ID = "Correlation-ID";
	public static final String HOST = "Host";
	public static final String REFERRER = "Referer";
	public static final String USER_AGENT = "User-Agent";

	// Generally custom header types commonly encountered
	public static final String X_API_KEY = "X-API-Key";
	public static final String X_CLIENT_VERSION = "X-Client-Version";
	public static final String X_FORWARDED_FOR = "X-Forwarded-For";
	public static final String X_FORWARDED_HOST = "X-Forwarded-Host";
	public static final String X_FORWARDED_PROTO = "X-Forwarded-Proto";
	public static final String X_REQUEST_ID = "X-Request-ID";

	private Headers() {
	} // prevent instantiation
}
