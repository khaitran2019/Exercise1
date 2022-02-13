
set projectLocation=%~dp0
set reportPath=%projectLocation%allure-results

call allure serve %reportPath%

