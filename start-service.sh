
#Excecutes mock web service in the background
echo "launching weather webservice..............."
nohup java -jar wiremock-1.50-standalone.jar  --port=9999  > /dev/null 2>&1 &
echo "webservice launched"
