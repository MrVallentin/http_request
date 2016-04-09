
// Author: Christian Vallentin <mail@vallentinsource.com>
// Website: http://vallentinsource.com
// Repository: https://github.com/MrVallentin/http_request
//
// Date Created: February 29, 2016
// Last Modified: March 01, 2016

function http_build_query(data)
{
	var data_type = typeof(data);
	
	if (data_type == "object")
	{
		var query = "";
		
		for (var key in data)
		{
			var value = data[key];
			var value_type = typeof(value);
			
			if (value instanceof Array)
			{
				var sub_query = "";
				
				for (var index in value)
				{
					if (sub_query.length > 0) { sub_query += "&"; }
					
					sub_query += encodeURIComponent(key) + "[]=" + encodeURIComponent(String(value[index]));
				}
				
				if (sub_query.length > 0)
				{
					if (query.length > 0) { query += "&"; }
					
					query += sub_query;
				}
			}
			else if (value_type == "object")
			{
				var sub_query = "";
				
				for (var sub_key in value)
				{
					if (sub_query.length > 0) { sub_query += "&"; }
					
					sub_query += encodeURIComponent(key) + "[" + encodeURIComponent(sub_key) + "]=" + encodeURIComponent(String(value[sub_key]));
				}
				
				if (sub_query.length > 0)
				{
					if (query.length > 0) { query += "&"; }
					
					query += sub_query;
				}
			}
			else
			{
				if (query.length > 0) { query += "&"; }
				
				query += encodeURIComponent(key) + "=" + encodeURIComponent(String(value));
			}
		}
		
		return query;
	}
	else if (data_type == "string")
	{
		return data;
	}
	else
	{
		return String(data);
	}
}

function http_request(request)
{
	request = request || {};
	request.method = request.method || "GET";
	request.data = request.data || "";
	
	if (typeof(request.data) == "object")
	{
		request.data = http_build_query(request.data);
		
		console.log(request.data);
	}
	
	var xhr = new XMLHttpRequest();
	
	if ("withCredentials" in xhr)
	{
		xhr.open(request.method, request.url, true);
	}
	else if (typeof(XDomainRequest) != "undefined")
	{
		xhr = new XDomainRequest();
		xhr.open(request.method, request.url);
	}
	
	xhr.setRequestHeader("X-Requested-With", "XMLHttpRequest");
	
	// xhr.setRequestHeader("X-HTTP-Method", request.method);
	// xhr.setRequestHeader("X-HTTP-Method-Override", request.method);
	
	if (request.data)
	{
		xhr.setRequestHeader("Content-type", "application/x-www-form-urlencoded");
	}
	
	xhr.onreadystatechange = function()
	{
		if (xhr.readyState > 3)
		{
			if (xhr.status === 200)
			{
				if (request.success)
				{
					request.success(xhr.responseText, xhr.status, xhr.statusText);
				}
			}
			else
			{
				if (request.error)
				{
					request.error(xhr.responseText, xhr.status, xhr.statusText);
				}
			}
		}
	}
	
	xhr.send(request.data);
}
