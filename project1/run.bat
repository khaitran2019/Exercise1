set projectLocation=%~dp0
cd %projectLocation%

call mvn clean test -Dsurefire.suiteXmlFiles=%projectLocation%run_tests\chrome_firefox_window.xml

call report.bat

