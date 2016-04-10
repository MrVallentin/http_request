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


#### License

This module is shared under the MIT license, and is therefore free to use, shared, distribute and modify.
See [LICENSE](https://github.com/MrVallentin/http_request/blob/master/LICENSE) for more details.


[http_request]: https://github.com/MrVallentin/http_request
