# http_request

*Wrapper for making HTTP requests in a single call*

Currently ported to:

- [Python](https://github.com/MrVallentin/http_request/tree/master/python)
- [Lua](https://github.com/MrVallentin/http_request/tree/master/lua)
- [PHP](https://github.com/MrVallentin/http_request/tree/master/php)
- [Java](https://github.com/MrVallentin/http_request/tree/master/java)
- [JavaScript](https://github.com/MrVallentin/http_request/tree/master/javascript)


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


## Lua

The Lua wrapper uses [LuaSocket](http://w3.impa.br/~diego/software/luasocket/http.html).

```lua
local http = require("http_request")

-- If redirect is set to true, then response locations will be followed.

table http.request(string url [, string body = "" [, string method = "GET" [, table headers = {} [, boolean redirect = true]]]])

table http.get(string url [, string body = "" [, table headers = {} [, boolean redirect = true]]])
table http.post(string url [, string body = "" [, table headers = {} [, boolean redirect = true]]])
table http.delete(string url [, string body = "" [, table headers = {} [, boolean redirect = true]]])
table http.put(string url [, string body = "" [, table headers = {} [, boolean redirect = true]]])
table http.patch(string url [, string body = "" [, table headers = {} [, boolean redirect = true]]])

-- The returned response table contains the following:
-- response.headers
-- response.body
-- response.status
-- response.code
```


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


## JavaScript

*The following is an example of what can be done.*

```js
http_request({
	method: "POST",
	url: "http://example.com",
	data: {
		str: "Hello World!",
		num: 16,
		bool: true,
		arr: [ "a", "b", "c" ],
		obj: {
			"a": "b",
			"c": "d"
		}
	},
	success: function(body, code, status)
	{
		console.log("Success: " + code + " " + status);
		console.log(body);
	},
	error: function(body, code, status)
	{
		console.log("Error: " + code + " " + status);
		console.log(body);
	}
});
```


#### License

This module is shared under the MIT license, and is therefore free to use, shared, distribute and modify.
See [LICENSE](https://github.com/MrVallentin/http_request/blob/master/LICENSE) for more details.


[http_request]: https://github.com/MrVallentin/http_request
