echo OFF

REM curl -X POST -H "Content-Type: multipart/form-data" -F file=@README.md -F file=@gradlew -F data="string" http://localhost:8095/multi
REM curl -X POST -F file=@README.md -F file=@gradlew -F data="{\"firstname\": \"john\", \"lastname\":\"Miller\"}" http://localhost:8095/multi
curl -X POST -H "Content-Type: multipart/form-data" -F file=@README.md -F file=@gradlew -F data="{\"firstname\": \"john\", \"lastname\":\"Miller\"};type=application/json" http://localhost:8095/multi
REM curl -X POST -H "Content-Type: application/json" -d "{\"firstname\": \"john\", \"lastname\":\"Miller\"}" http://localhost:8095/customer
