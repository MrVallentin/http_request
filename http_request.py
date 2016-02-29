#!/usr/bin/python

# Author: Vallentin <mail@vallentinsource.com>
# Website: http://vallentinsource.com
# Repository: https://github.com/MrVallentin/http_request
#
# Date Created: February 28, 2016
# Last Modified: February 29, 2016
# 
# Developed and tested with Python 3.5.1

import http.client, urllib.parse


def http_request(url, data = None, method = "GET", headers = {}):
	parsed = urllib.parse.urlparse(url)
	scheme, netloc, path = parsed.scheme, parsed.netloc, parsed.path
	
	if not method:
		method = "GET"
	method = method.upper()
	
	if not headers:
		headers = {}
	
	if data:
		data = urllib.parse.urlencode(data)
		#data = data.encode("utf-8")
	
	if method == "GET":
		if data:
			path += "?" + data
			data = None
	
	if not headers:
		headers = {}
	
	if data:
		headers["Content-Length"] = len(data)
		headers["Content-Type"] = "application/x-www-form-urlencoded"
	
	
	conn = None
	
	if scheme and scheme == "https":
		conn = http.client.HTTPSConnection(netloc)
	else:
		conn = http.client.HTTPConnection(netloc)
	
	conn.request(method, path, data, headers)
	res = conn.getresponse()
	
	res_status, res_reason = res.status, res.reason
	res_body = res.read()
	res_headers = res.getheaders()
	conn.close()
	
	res_body = res_body.decode("utf-8")
	
	
	return res_body, res_status, res_reason, res_headers


def http_head(url, data = None, headers = None):
	return http_request(url, data, "HEAD", headers)

def http_get(url, data = None, headers = None):
	return http_request(url, data, "GET", headers)

def http_post(url, data = None, headers = None):
	return http_request(url, data, "POST", headers)

def http_delete(url, data = None, headers = None):
	return http_request(url, data, "DELETE", headers)

def http_put(url, data = None, headers = None):
	return http_request(url, data, "PUT", headers)

def http_patch(url, data = None, headers = None):
	return http_request(url, data, "PATCH", headers)
