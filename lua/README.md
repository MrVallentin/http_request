# http_request

*Wrapper for making HTTP requests in a single call*

Currently ported to:

- [Python](https://github.com/MrVallentin/http_request/tree/master/python)
- [Lua](https://github.com/MrVallentin/http_request/tree/master/lua)
- [PHP](https://github.com/MrVallentin/http_request/tree/master/php)
- [Java](https://github.com/MrVallentin/http_request/tree/master/java)
- [JavaScript](https://github.com/MrVallentin/http_request/tree/master/javascript)


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


#### License

This module is shared under the MIT license, and is therefore free to use, shared, distribute and modify.
See [LICENSE](https://github.com/MrVallentin/http_request/blob/master/LICENSE) for more details.


[http_request]: https://github.com/MrVallentin/http_request
