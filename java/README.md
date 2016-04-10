# http_request

*Wrapper for making HTTP requests in a single call*

Currently ported to:

- [Python](https://github.com/MrVallentin/http_request/tree/master/python)
- [Lua](https://github.com/MrVallentin/http_request/tree/master/lua)
- [PHP](https://github.com/MrVallentin/http_request/tree/master/php)
- [Java](https://github.com/MrVallentin/http_request/tree/master/java)
- [JavaScript](https://github.com/MrVallentin/http_request/tree/master/javascript)


## Java

The Java wrapper uses the standard `java.io` and `java.net` packages.

```java
// All the following methods are found in com.vallentinsource.HTTPRequest

// Default parameters aren't supported in Java, but it was more visually pleasing
// to write the method once, than 4 times.

static String request(
		String url,
		String data = null,
		String method "GET",
		Map<String, String> headers = null
	) throws MalformedURLException, IOException

static String request(
		String url,
		Map<?, ?> data = null,
		String method "GET",
		Map<String, String> headers = null
	) throws MalformedURLException, IOException

// The following get() method, exists along with a
// post(), delete(), put() and patch().

static String get(
		String url,
		String data = null,
		Map<String, String> headers = null
	) throws MalformedURLException, IOException

static String get(
		String url,
		Map<?, ?> data = null,
		Map<String, String> headers = null
	) throws MalformedURLException, IOException

```


#### License

This module is shared under the MIT license, and is therefore free to use, shared, distribute and modify.
See [LICENSE](https://github.com/MrVallentin/http_request/blob/master/LICENSE) for more details.


[http_request]: https://github.com/MrVallentin/http_request
