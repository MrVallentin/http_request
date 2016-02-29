<?php

// Author: Vallentin <mail@vallentinsource.com>
// Website: http://vallentinsource.com
// Repository: https://github.com/MrVallentin/http_request
//
// Date Created: June 24, 2015
// Last Modified: August 06, 2015


function http_request($url, $data = null, $method = "GET", array $headers = array())
{
	$ch = curl_init();
	
	if ($method == null) { $method = "GET"; }
	$method = strtoupper($method);
	
	if ($method == "GET")
	{
		if (is_array($data) && !empty($data))
		{
			$query = http_build_query($data);
			
			if (strpos($url, "?") !== false) { $url .= "&"; }
			else { $url .= "?"; }
			
			$url .= $query;
		}
	}
	else // POST, DELETE, PUT, PATCH
	{
		if (is_array($data))
		{
			$data = http_build_query($data);
		}
		
		curl_setopt($ch, CURLOPT_POST, true);
		curl_setopt($ch, CURLOPT_POSTFIELDS, $data);
		
		curl_setopt($ch, CURLOPT_CUSTOMREQUEST, $method);
	}
	
	curl_setopt($ch, CURLOPT_URL, $url);
	curl_setopt($ch, CURLOPT_HEADER, false);
	
	if (!empty($headers))
	{
		curl_setopt($ch, CURLOPT_HTTPHEADER, $headers);
	}
	
	curl_setopt($ch, CURLOPT_SSL_VERIFYPEER, false); // Quick fix
	
	curl_setopt($ch, CURLOPT_RETURNTRANSFER, true);
	
	curl_setopt($ch, CURLOPT_FOLLOWLOCATION, true); // cURL follow redirects
	
	
	$error = null;
	$response = curl_exec($ch);
	
	if ($response === false)
	{
		$error = curl_error($ch);
	}
	
	curl_close($ch);
	
	if ($error !== null)
	{
		throw new Exception($error);
	}
	
	return $response;
}


function http_get($url, $data = null, array $headers = array())
{
	return http_request($url, $data, "GET", $headers);
}

function http_post($url, $data = null, array $headers = array())
{
	return http_request($url, $data, "POST", $headers);
}

function http_delete($url, $data = null, array $headers = array())
{
	return http_request($url, $data, "DELETE", $headers);
}

function http_put($url, $data = null, array $headers = array())
{
	return http_request($url, $data, "PUT", $headers);
}

function http_patch($url, $data = null, array $headers = array())
{
	return http_request($url, $data, "PATCH", $headers);
}


?>