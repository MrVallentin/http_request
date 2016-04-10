# http_request

*Wrapper for making HTTP requests in a single call*

Currently ported to:

- [Python](https://github.com/MrVallentin/http_request/tree/master/python)
- [Lua](https://github.com/MrVallentin/http_request/tree/master/lua)
- [PHP](https://github.com/MrVallentin/http_request/tree/master/php)
- [Java](https://github.com/MrVallentin/http_request/tree/master/java)
- [JavaScript](https://github.com/MrVallentin/http_request/tree/master/javascript)


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


#### License

This module is shared under the MIT license, and is therefore free to use, shared, distribute and modify.
See [LICENSE](https://github.com/MrVallentin/http_request/blob/master/LICENSE) for more details.


[http_request]: https://github.com/MrVallentin/http_request
