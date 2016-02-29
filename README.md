# http_request

*Wrapper for making HTTP requests in a single call*

Currently ported to:

- PHP
- Python
- Java
- Lua


## PHP

The PHP wrapper uses cURL, which was added (as a standard) in PHP 4.0.2.

*Throws Exception on error.*

```php
string http_request($url [, $data = null [, $method = "GET" [, array $headers = array()]]])

string http_get($url [, $data = null [, array $headers = array()]])
string http_post($url [, $data = null [, array $headers = array()]])
string http_delete($url [, $data = null [, array $headers = array()]])
string http_put($url [, $data = null [, array $headers = array()]])
string http_patch($url [, $data = null [, array $headers = array()]])
```


## Python

The Python wrapper uses http.client and urllib.parse, which are standard libraries in Python.

```python
from http_request import *

# The returned tuple contains (body, status, reason, headers)

tuple http_request(url, data = None, method = "GET", headers = {})

tuple http_head(url, data = None, headers = None)
tuple http_get(url, data = None, headers = None)
tuple http_post(url, data = None, headers = None)
tuple http_delete(url, data = None, headers = None)
tuple http_put(url, data = None, headers = None)
tuple http_post(url, data = None, headers = None)
```


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


## Lua

The Lua wrapper uses [LuaSocket](http://w3.impa.br/~diego/software/luasocket/http.html).

```lua
-- If redirect is set to true, then response locations will be followed.

table http_request(string url [, string body = "" [, string method = "GET" [, table headers = {} [, boolean redirect = true]]]])

table http_get(string url [, string body = "" [, table headers = {} [, boolean redirect = true]]])
table http_post(string url [, string body = "" [, table headers = {} [, boolean redirect = true]]])
table http_delete(string url [, string body = "" [, table headers = {} [, boolean redirect = true]]])
table http_put(string url [, string body = "" [, table headers = {} [, boolean redirect = true]]])
table http_patch(string url [, string body = "" [, table headers = {} [, boolean redirect = true]]])

-- The returned response table contains the following:
-- response.headers
-- response.body
-- response.status
-- response.code
```
