Project has 2 parts
# Selenium Framework Part
    ConfigReader is used to retrieve configuration from config.properties
    DriverSetup is used to create webdriver instance according to config.properties
    EnvConfiguration is model for config.properties so we are mapping configs to object.
    Helper is used for webelement utilities such as visibility, clickable
    Hooks is used for cucumber feature steps to run webdriver before steps.
# Selenium Test Scenarios Part
    # Resources
        apps folder is including apks which are used in mobile app testing
        capabilities folder is including mobile device properties
        features folder is including cucumber scenarios which need to be re-written according to BDD
    # test
        api folder is used for rest and httpuinit tests.
        devices is used for mapping appium device props to java object.
        karate folder is used karate testing, karate runs by using runner class but implementation is done in .feature 
        mobile_pages folder is used mobile app testing and includes page objects which are including elements and locators
        model folder is used for api testing and mapping to object from json response
        pages folder is including web page objects so elements and locators
        performance folder is including gatling and jmeter folders. Jmeter is implemented by using java 
        testscenarios folder is used for tests. Junit5 and testng are used for testing schema.
        
        