curl -X POST -H "Content-Type: multipart/form-data" -F file=@build.gradle -F file=@script_curl.bat -F data="{\"firstname\": \"john\", \"lastname\":\"Miller\"};type=application/json" http://localhost:8090/provider1/action1
