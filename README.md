
## About The Project


The project is separated in specific packages according to functionality. Therefore, there is 
a package which contains data-related classes (data). The data package contains a generic class, 
which provides basic methods for reading and transforming the contents of the files into Java List instances.
There are model classes which are mapped to each row in the file (transformare method in GenericData).

Also, the project provides tests, which implement a specific basic AbstractTest class.

The project provides specific exceptions, which represent runtime exceptions, which will get triggered (thrown)
when a specific wrongful call happens (for instance calling a method which loads a Retailer instance with an invalid ID).

### Built With

* maven

## Running the project
Being a Maven project, any Java IDE with support for maven can run the project.
Running the Main class will trigger the tests.
After installing the project, make sure to edit the Run/Debug configurations (Application)
and search for the main class as in the photo shown below

![2a2b711c6d788adaa4a224926ae7599a](https://user-images.githubusercontent.com/92116819/143016533-2f717300-e5e4-4b6f-89b5-f002bb1a1145.png)

### Prerequisites

The init folder will contain the specific data files (.in files)

