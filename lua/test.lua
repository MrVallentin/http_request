
-- Author: Christian Vallentin <mail@vallentinsource.com>
-- Website: http://vallentinsource.com
-- Repository: https://github.com/MrVallentin/LuaOOP
--
-- Date Created: April 11, 2016
-- Last Modified: April 11, 2016
--
-- Developed and tested using Lua 5.1 and Lua 5.2

local http = require("http_request")


local url = "http://vallentinsource.com/globalip.php"

local response = http.get(url)

print("Global IP:", response.body)
