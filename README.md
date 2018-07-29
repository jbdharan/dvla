# 

Running the test

mvn integration-test -Pcucumber "-Dcucumber.options=--tags @dvla_excelreader,@dvla_datadriver --plugin html:target/cucumber/homeoficetest/ --plugin json:target/cucumber/homeoficetest/cucumber.json"

Input the files
/src/main/resources/filesinfolder/

The reports can be created under /target/reports directory

Browser - chrome
