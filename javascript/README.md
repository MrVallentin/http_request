# http_request

*Wrapper for making HTTP requests in a single call*

Currently ported to:

- [Python](https://github.com/MrVallentin/http_request/tree/master/python)
- [Lua](https://github.com/MrVallentin/http_request/tree/master/lua)
- [PHP](https://github.com/MrVallentin/http_request/tree/master/php)
- [Java](https://github.com/MrVallentin/http_request/tree/master/java)
- [JavaScript](https://github.com/MrVallentin/http_request/tree/master/javascript)


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
