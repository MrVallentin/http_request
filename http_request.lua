
-- Author: Vallentin <mail@vallentinsource.com>
-- Website: http://vallentinsource.com
-- Repository: https://github.com/MrVallentin/http_request
--
-- Date Created: December 14, 2015
-- Last Modified: December 14, 2015


local http = require("socket.http")
local ltn12 = require("ltn12")


-- http.TIMEOUT = 10
-- http.TIMEOUT = 0.001 -- no blocking


local function deepCopy(original)
	local copy
	
	if type(original) == "table" then
		copy = {}
		
		for k, v in next, original, nil do
			copy[deepCopy(k)] = deepCopy(v)
		end
		
		setmetatable(copy, deepCopy(getmetatable(original)))
	else
		copy = original
	end
	
	return copy
end


function http_request(url, body, method, headers, redirect)
	body = body or ""
	
	method = method or "GET"
	method = method:upper()
	
	headers = headers or {}
	headers = deepCopy(headers)
	
	redirect = redirect or true
	
	
	local request = {
		url = url,
		method = method,
		body = body,
		headers = headers,
	}
	
	
	if request.body then
		request.headers["content-length"] = request.body:len()
	end
	
	
	local result_table = {}
	
	if not request.sink then
		request.sink, result_table = ltn12.sink.table()
	end
	
	request.source = request.source or (request.body and ltn12.source.string(request.body))
	
	local response = {}
	response.code, response.headers, response.status = socket.skip(1, http.request(request))
	
	if not response.headers then
		response.headers = {}
	end
	
	if result_table and #result_table > 0 then
		response.body = table.concat(result_table)
	else
		-- response.status = "HTTP/1.1 404 Not Found"
		
		response.status = response.code
		response.code = 0
	end
	
	
	-- Follow redirect
	if redirect then
		-- if response.code == 302 and response.headers.location then
		if response.headers.location then
			return http_request(response.headers.location, body, method, headers, redirect)
		end
	end
	
	
	return response
end


function http_get(url, body, headers, redirect)
	return http_request(url, body, "GET", headers, redirect)
end


function http_post(url, body, headers, redirect)
	return http_request(url, body, "POST", headers, redirect)
end


function http_put(url, body, headers, redirect)
	return http_request(url, body, "PUT", headers, redirect)
end


function http_delete(url, body, headers, redirect)
	return http_request(url, body, "DELETE", headers, redirect)
end


function http_patch(url, body, headers, redirect)
	return http_request(url, body, "PATCH", headers, redirect)
end

