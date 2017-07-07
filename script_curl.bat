curl -X POST -H "Content-Type: multipart/form-data" -F file=@README.md -F file=@gradlew -F data="string" http://localhost:8095/multi
