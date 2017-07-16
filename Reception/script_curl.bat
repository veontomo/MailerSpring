
REM file paths are relative to a location from which this script is executed, not where it is located!

curl -X POST -H "Content-Type: multipart/form-data" -F files=@build.gradle -F files=@README.md -F data="{\"firstname\": \"john\", \"lastname\":\"Miller\"};type=application/json" http://localhost:8090/provider1/action1
