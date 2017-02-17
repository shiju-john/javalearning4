
#MongoDB
##Configuration
*To install DB ina separate path <br>
`mongodb\bin>mongod.exe --dbpath "d:\set up\mongodb\data" `
<br> For checking whether the Mongo db properly installed*
`mongodb\bin>mongo.exe`

###Create Configuration File mongo.config
`##store data here
dbpath=D:\mongodb\data

##all output go here
logpath=D:\mongodb\log\mongo.log

##log read and write operations
diaglog=3'
